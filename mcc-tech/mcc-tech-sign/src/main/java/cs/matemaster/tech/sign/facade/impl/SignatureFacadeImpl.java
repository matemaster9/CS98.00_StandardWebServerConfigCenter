package cs.matemaster.tech.sign.facade.impl;

import cs.matemaster.tech.sign.facade.SignatureFacade;
import cs.matemaster.tech.sign.model.SysUserDto;
import cs.matemaster.tech.sign.service.SignatureService;
import cs.matemaster.tech.sign.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author matemaster
 */
@Component
@AllArgsConstructor
public class SignatureFacadeImpl implements SignatureFacade {

    private SysUserService sysUserService;

    private SignatureService signatureService;


    @Override
    public String getToken(SysUserDto sysUserDto) {

        sysUserService.validate(sysUserDto);

        return signatureService.issueToken(sysUserDto);
    }
}
