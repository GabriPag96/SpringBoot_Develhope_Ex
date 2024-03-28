package it.example.fileUploadAndDownloadEx.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(indexes = {
        @Index(unique = true, name = "email_idx", columnList = "email")
})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(nullable = true)
    private byte[] profilePicture;

}
