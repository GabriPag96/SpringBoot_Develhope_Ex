package it.example.fileUploadAndDownloadEx.Repositories;

import it.example.fileUploadAndDownloadEx.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
