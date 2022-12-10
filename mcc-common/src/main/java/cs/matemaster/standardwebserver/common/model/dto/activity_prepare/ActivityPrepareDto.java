package cs.matemaster.standardwebserver.common.model.dto.activity_prepare;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author matemaster
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Schema(name = "活动报备对象")
public class ActivityPrepareDto {
    @Schema(description = "活动报备名称")
    private String activityPrepareName;

    @Schema(description = "联系人")
    private String contactPerson;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8", shape = JsonFormat.Shape.STRING)
    private LocalDateTime createTime;

    @Schema(description = "直属领导")
    private String leader;

    @Schema(description = "活动报备类型")
    private int activityPrepareType;

    @Schema(description = "个性化内容")
    private String personalizedContent;
}