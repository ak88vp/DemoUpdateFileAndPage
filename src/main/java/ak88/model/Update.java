package ak88.model;

import org.springframework.web.multipart.MultipartFile;

public class Update {
    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Update() {
    }

    public Update(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
