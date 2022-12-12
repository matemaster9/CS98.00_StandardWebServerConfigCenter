package cs.matemaster.tech.spring.service.impl;

import cs.matemaster.tech.spring.service.SysUserQueryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author matemaster
 */
@Service
public class CacheQueryServiceImpl implements SysUserQueryService {

    @Override
    public List<String> getSysUserList() {
        return Collections.singletonList("CacheQueryServiceImpl");
    }
}
