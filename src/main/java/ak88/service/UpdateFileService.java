package ak88.service;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UpdateFileService {
    public void UpdateFile(MultipartFile multipartFile) throws IOException {
        String folderUpload = "/D:/module4/ProductJPA/src/main/webapp/updateFile/";
        String fileName = multipartFile.getOriginalFilename();
        FileCopyUtils.copy(multipartFile.getBytes(),new File(folderUpload+fileName));
    }
}
