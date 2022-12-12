package cs.matemaster.tech.spring.dependency_injection;

import cs.matemaster.tech.spring.service.SysUserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
public class SysUserQueryFacadeImpl {

    private SysUserQueryService sysUserQueryService;

    /**
     * 构造器注入测试
     * private final SysUserQueryService sysUserQueryService;
     * public SysUserQueryFacadeImpl(SysUserQueryService SQLQueryServiceImpl) {
     *     this.sysUserQueryService = SQLQueryServiceImpl;
     * }
     */

    @Autowired
    public void setSQLQueryServiceImpl(SysUserQueryService cacheQueryServiceImpl) {
        this.sysUserQueryService = cacheQueryServiceImpl;
    }

    public void stdOut() {
        System.out.println(sysUserQueryService.getSysUserList());
    }

}
