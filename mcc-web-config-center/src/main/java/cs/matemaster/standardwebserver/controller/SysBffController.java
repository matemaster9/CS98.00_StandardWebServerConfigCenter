package cs.matemaster.standardwebserver.controller;

import cs.matemaster.standardwebserver.authority.aop.Authority;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author matemaster
 */
@Slf4j
@RestController
@RequestMapping("/system-bff")
@AllArgsConstructor
@Authority
public class SysBffController {

    @GetMapping("test")
    public void test() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Object loginUser = request.getAttribute("LoginUser");
        log.info(loginUser.toString());
    }
}
