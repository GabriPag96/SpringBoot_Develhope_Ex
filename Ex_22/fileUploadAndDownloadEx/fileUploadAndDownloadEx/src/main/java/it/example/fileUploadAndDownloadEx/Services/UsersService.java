package it.example.fileUploadAndDownloadEx.Services;

import it.example.fileUploadAndDownloadEx.DTO.ProfilePicDTO;
import it.example.fileUploadAndDownloadEx.Entities.Users;
import it.example.fileUploadAndDownloadEx.Repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    FileStorageService fileStorageService;

    public Users newUser(Users user){

        return usersRepository.save(user);
    }

    public List<Users> getAllUsers(){

        return usersRepository.findAll();
    }

    public Users getUserById(Long id){

        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) throws Exception{
        if (id.equals(null)){

            throw new Exception("Id not found");

        }else usersRepository.deleteById(id);

    }

    public Users updateUser(Long id, Users user) throws Exception{

        Users updatedUser = usersRepository.findById(id).orElse(null);

        if(updatedUser == null) throw new Exception("User not found");

        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());

        return usersRepository.save(updatedUser);
    }

    public Users uploadNewImage(Long id, MultipartFile file) throws Exception {

        Users user = usersRepository.findById(id).orElse(null);

        if(user == null) throw new Exception("User not found");
        if(user.getProfilePicture() != null){
            fileStorageService.removeFile(Arrays.toString(user.getProfilePicture()));
        }

        String fileName = fileStorageService.upload(file);

        user.setProfilePicture(fileName.getBytes());
        return usersRepository.save(user);
    }

    public ProfilePicDTO downloadProfilePic(Long id) throws Exception {
        Users user = usersRepository.findById(id).orElse(null);
        if(user == null) throw new Exception("User not found");

        ProfilePicDTO dto = new ProfilePicDTO();
        dto.setUser(user);
        if(user.getProfilePicture() == null) return dto;

        byte[] profilePictureBytes = fileStorageService.download(Arrays.toString(user.getProfilePicture()));
        dto.setProfileImage(profilePictureBytes);

        return dto;
    }

    public void removePic(Long id) throws Exception {
        Users user = usersRepository.findById(id).orElse(null);
        if(user == null) throw new Exception("User not found");

        if(user.getProfilePicture() != null){
            fileStorageService.removeFile(Arrays.toString(user.getProfilePicture()));
        }
        usersRepository.deleteById(id);
    }

}
