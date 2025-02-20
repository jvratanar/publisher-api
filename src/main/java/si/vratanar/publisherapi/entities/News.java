package si.vratanar.publisherapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq")
    @SequenceGenerator(name = "news_seq", sequenceName = "news_sequence", allocationSize = 1)
    private Long newsId;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 1000)
    @Column(length = 1000)
    private String summary;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    @Builder.Default
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "news_tag", joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tag> tags = new HashSet<>();

    @ManyToOne
    private NewsUser user;
}
