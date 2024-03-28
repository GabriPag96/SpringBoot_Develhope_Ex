package it.example.fileUploadAndDownloadEx.Controllers;

import it.example.fileUploadAndDownloadEx.DTO.ProfilePicDTO;
import it.example.fileUploadAndDownloadEx.Entities.Users;
import it.example.fileUploadAndDownloadEx.Services.UsersService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping("/new")
    public void create(@RequestBody Users user){
        usersService.newUser(user);
    }



    @GetMapping("/allUsers")
    public List<Users> getAll(){

        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getOneUser(@PathVariable Long id){

        return usersService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {

        usersService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public Users updateAnimal(@PathVariable Long id, @RequestParam Users user) throws Exception {

        return usersService.updateUser(id, user);
    }

    @GetMapping("/{id}/profile")
    public @ResponseBody byte[] getProfileImage(@PathVariable Long id, HttpServletResponse response) throws Exception{

        ProfilePicDTO profilePicDTO = usersService.downloadProfilePic(id);

        String fileName = Arrays.toString(profilePicDTO.getUser().getProfilePicture());
        if(fileName == null) throw  new Exception("User does not have a profile pic");

        String extension = FilenameUtils.getExtension(fileName);

        switch (extension){

            case ".gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case ".jpeg", ".jpg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case ".png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "\"");

        return profilePicDTO.getProfileImage();
    }

    @PostMapping("/{id}/profile")
    public Users uploadProfileImage(@PathVariable Long id, @RequestParam MultipartFile file) throws Exception{

        return usersService.uploadNewImage(id, file);
    }

    @PutMapping("/{id}/profile-pic")
    public void deleteProfilePic(@PathVariable Long id) throws Exception {

        usersService.removePic(id);
    }
}
