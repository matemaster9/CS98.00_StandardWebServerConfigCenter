package cs.matemaster.standardwebserver.common.model.dto.activity_prepare;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author matemaster
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Schema(name = "活动报备负责人")
public class ActivityPreparePrincipalDto {
    private String dev;
    private String operation;
    private String wellKnownPeople;
}
