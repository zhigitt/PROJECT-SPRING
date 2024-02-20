package java12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@SequenceGenerator(name = "base_id", sequenceName = "post_seq", allocationSize = 1)

public class Post extends BaseEntityId {
    private String title;
    private String description;
    @Column(name = "created_at")
    private LocalDate createdAt;

    @Transient
    private String imageUrl;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "post")
    private List<Image> images;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;

    @ManyToOne
    private User user;
}
