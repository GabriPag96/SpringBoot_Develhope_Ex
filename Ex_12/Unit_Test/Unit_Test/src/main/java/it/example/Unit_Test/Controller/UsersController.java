package it.example.Unit_Test.Controller;

import it.example.Unit_Test.Entity.Users;
import it.example.Unit_Test.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/new")
    public @ResponseBody Users createUsers(@RequestBody Users users){ return usersService.createUsers(users); }

    @GetMapping("/all")
    public @ResponseBody List<Users> getAllUsers(){ return usersService.getAllUsers(); }

    @GetMapping("/{id}")
    public @ResponseBody Users getOneUsers(@PathVariable Long id){ return usersService.getOneUsers(id); }

    @PutMapping("/update/{id}")
    public @ResponseBody Users updateUsers(@PathVariable Long id, @RequestBody Users users){ return usersService.updateUsers(id, users); }

    @DeleteMapping("/delete/{id}")
    public void deleteUsers(@PathVariable Long id){ usersService.deleteUsersById(id); }

}
