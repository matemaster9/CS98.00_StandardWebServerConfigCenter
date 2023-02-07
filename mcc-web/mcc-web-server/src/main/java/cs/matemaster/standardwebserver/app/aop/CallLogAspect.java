package cs.matemaster.standardwebserver.app.aop;

import cs.matemaster.standardwebserver.app.persistence.CallLogMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@Aspect
@RequiredArgsConstructor
public class CallLogAspect {

    private final CallLogMapper callLogMapper;

//    @Pointcut("execution(* cs.matemaster.standardwebserver.controller.*.*(..))")
//    public void callLog() {
//
//    }
//
//    @Before(value = "callLog && (@within(CallLog) || @annotation(CallLog))", argNames = "joinPoint, callLog")
//    public void beforeAdvice(JoinPoint joinPoint, CallLog callLog) {
//
//    }
}
