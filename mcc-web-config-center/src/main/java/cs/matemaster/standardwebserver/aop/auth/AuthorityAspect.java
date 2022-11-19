package cs.matemaster.standardwebserver.aop.auth;

import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import cs.matemaster.standardwebserver.config.WebSystemConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
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
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

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

        if (Objects.isNull(requestAttributes)) {
            return;
        }

        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        if (response == null) {
            throw new AuthException(MccErrorEnum.MCC_TOKEN_INVALID);
        }

        try {
            String jwt = request.getHeader("Authorization");
            Claims claims = authServiceSupport.getClaims(jwt);
            String cipher = claims.get(AuthConstants.CipherUser, String.class);
            String decrypt = SecurityUtil.RSAPrivateKeyDecrypt(cipher, webSystemConfig.getRsaPrivateKey());
            SysUserDto deserialize = JsonUtil.deserialize(decrypt, SysUserDto.class);
            request.setAttribute("LoginUser", deserialize);
        } catch (ExpiredJwtException expiredJwtException) {
            Claims expiredClaims = expiredJwtException.getClaims();
            String refreshToken = authServiceSupport.refreshToken(expiredClaims);
            response.setHeader("Authorization", refreshToken);
        }

    }
}
