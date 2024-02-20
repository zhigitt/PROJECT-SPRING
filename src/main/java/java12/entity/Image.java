package java12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@SequenceGenerator(name = "base_id", sequenceName = "image_seq", allocationSize = 1)

public class Image extends BaseEntityId {
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "image")
    private List<User> users;

    @ManyToOne
    private Post post;
}
