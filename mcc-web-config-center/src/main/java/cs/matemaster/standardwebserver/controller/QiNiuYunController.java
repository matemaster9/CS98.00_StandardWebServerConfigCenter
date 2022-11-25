package cs.matemaster.standardwebserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author matemaster
 */
@RestController
@RequestMapping("/qi-niu-yun")
@RequiredArgsConstructor
@Tag(name = "QiNiuYunController", description = "七牛云控制器")
public class QiNiuYunController {

    @Operation(summary = "上传文件")
    @PostMapping("uploadFile")
    public boolean uploadFile(MultipartFile file) {
        return true;
    }
}
