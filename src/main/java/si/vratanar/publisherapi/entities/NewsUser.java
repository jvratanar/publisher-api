package si.vratanar.publisherapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class NewsUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_user_seq")
    @SequenceGenerator(name = "news_user_seq", sequenceName = "news_user_sequence", allocationSize = 1)
    private Long newsUserId;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(length = 30)
    private String username;

    @NotNull
    @NotBlank
    @Email
    @Size(max = 50)
    @Column(length = 50)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(length = 50)
    private String password;

    @Size(max = 50)
    @Column(length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(length = 50)
    private String lastName;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "news_user_user_role", joinColumns = @JoinColumn(name = "news_user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id"))
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<News> news = new HashSet<>();
}
