package cs.matemaster.standardwebserver.authority.aop;

import cs.matemaster.standardwebserver.authority.config.AuthProperties;
import cs.matemaster.standardwebserver.authority.constant.AuthConstants;
import cs.matemaster.standardwebserver.authority.constant.MccErrorEnum;
import cs.matemaster.standardwebserver.authority.exception.AuthException;
import cs.matemaster.standardwebserver.authority.service.AuthServiceSupport;
import cs.matemaster.standardwebserver.common.model.dto.sys.SysUserDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import cs.matemaster.standardwebserver.common.util.SecurityUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author matemaster
 */

@Aspect
@Component
@AllArgsConstructor
public class AuthorityAspect {

    private AuthProperties webSystemConfig;
    private AuthServiceSupport authServiceSupport;

    @Pointcut("execution(* cs.matemaster.standardwebserver.controller.*.*(..))")
    public void auth() {
    }

    @Before(value = "auth() && (@within(authority) || @annotation(authority))", argNames = "joinPoint,authority")
    public void beforeExec(JoinPoint joinPoint, Authority authority) {

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
            String decrypt = SecurityUtil.RSAPrivateKeyDecryptAsHex(cipher, webSystemConfig.getRsaPrivateKey());
            SysUserDto deserialize = JsonUtil.deserialize(new String(Hex.decodeHex(decrypt), StandardCharsets.UTF_8), SysUserDto.class);
            request.setAttribute("LoginUser", deserialize);
        } catch (ExpiredJwtException expiredJwtException) {
            Claims expiredClaims = expiredJwtException.getClaims();
            String refreshToken = authServiceSupport.refreshToken(expiredClaims);
            response.setHeader("Authorization", refreshToken);
        } catch (DecoderException ignore) {

        }

    }
}
