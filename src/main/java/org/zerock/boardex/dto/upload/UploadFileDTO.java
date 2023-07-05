package org.zerock.boardex.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadFileDTO {
    //MultipartFile: 스프링 프레임워크에서 제공해주는 api
    private List<MultipartFile> files;
}
