package cs.matemaster.standardwebserver.aop.auth;

import cs.matemaster.standardwebserver.authority.util.JsonWebTokenUtil;
import cs.matemaster.standardwebserver.common.model.dto.sys.EncryptedSysUser;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.config.WebSystemConfig;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author matemaster
 */
@Aspect
@Component
@AllArgsConstructor
public class AuthorityAspect {

    private WebSystemConfig webSystemConfig;
    private AuthServiceSupport authServiceSupport;

    @Pointcut("execution(* cs.matemaster.standardwebserver.controller.*.*(..))")
    public void auth() {
    }

    @Before(value = "auth() && @annotation(authority)", argNames = "joinPoint,authority")
    public void beforeExec(ProceedingJoinPoint joinPoint, Authority authority) {
        Signature signature = joinPoint.getSignature();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (requestAttributes != null) {
            HttpServletRequest request = requestAttributes.getRequest();
            String authorization = (String) request.getAttribute("Authorization");
            Claims claims = JsonWebTokenUtil.getClaims(authorization);
            String encryptedSysUserStr = claims.get("EncryptedSysUser", String.class);
            String decrypt = SecurityUtil.RSAPrivateKeyDecrypt(encryptedSysUserStr, webSystemConfig.getRsaPrivateKey());
            EncryptedSysUser encryptedSysUser = JsonUtil.deserialize(decrypt, EncryptedSysUser.class);
            SysUserDto sysUser = decryptSysUser(encryptedSysUser);
            if (authServiceSupport.isValidSysUser(sysUser)) {

            }
        }
    }


    private SysUserDto decryptSysUser(EncryptedSysUser encryptedSysUser) {
        String account = SecurityUtil.RSAPrivateKeyDecrypt(encryptedSysUser.getEncryptedAccount(), webSystemConfig.getRsaPrivateKey());
        String password = SecurityUtil.RSAPrivateKeyDecrypt(encryptedSysUser.getEncryptedPassword(), webSystemConfig.getRsaPrivateKey());

        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setAccount(account);
        sysUserDto.setPassword(password);
        return sysUserDto;
    }
}
