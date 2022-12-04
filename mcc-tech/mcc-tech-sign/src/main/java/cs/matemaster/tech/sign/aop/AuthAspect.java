package cs.matemaster.tech.sign.aop;

import cs.matemaster.tech.sign.service.JsonWebTokenSupport;
import cs.matemaster.tech.sign.service.SignatureService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author matemaster
 */
@Aspect
@Component
@AllArgsConstructor
public class AuthAspect {

    private SignatureService signatureService;

    private JsonWebTokenSupport jsonWebTokenSupport;

    @Pointcut(value = "execution(* cs.matemaster.standardwebserver.controller.*.*(..)) ")
    public void pointcut() {
    }

    @Before(value = "pointcut()&& (@within(auth) || @annotation(auth))")
    public void before(JoinPoint joinPoint, Auth auth) {
        if (auth == null || auth.value().equals("No Login")) {
            return;
        }

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();

        if (response == null) {
            throw new RuntimeException();
        }

        String authorization = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = jsonWebTokenSupport.verify(authorization);
        } catch (ExpiredJwtException expired) {
            Claims claims = expired.getClaims();
            String renewToken = signatureService.renewToken(claims);
            request.setAttribute("Authorization", renewToken);
        }
    }

}
