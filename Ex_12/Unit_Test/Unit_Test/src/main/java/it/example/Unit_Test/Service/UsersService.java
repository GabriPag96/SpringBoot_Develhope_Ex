package it.example.Unit_Test.Service;

import it.example.Unit_Test.Entity.Users;
import it.example.Unit_Test.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Users createUsers(Users users){ return usersRepository.saveAndFlush(users); }

    public List<Users> getAllUsers() { return usersRepository.findAll(); }

    public Users getOneUsers(Long id){ return usersRepository.findById(id).orElse(null); }

    public Users updateUsers(Long id, Users users){

        Users changedUsers = usersRepository.findById(id).orElse(null);

        if (changedUsers != null){

//            usersRepository.delete(changedUsers);
            return usersRepository.save(users);

        }else { return null; }
    }

    public void deleteUsersById(Long id){ usersRepository.deleteById(id); }
}
