package it.example.fileUploadAndDownloadEx.DTO;

import it.example.fileUploadAndDownloadEx.Entities.Users;
import lombok.Data;

@Data
public class ProfilePicDTO {

    private Users user;
    private byte[] profileImage;
}
