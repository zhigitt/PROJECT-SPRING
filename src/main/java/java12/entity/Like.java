package java12.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "likes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@SequenceGenerator(name = "base_id", sequenceName = "likes_seq", allocationSize = 1)

public class Like extends BaseEntityId {
    @Column(name = "is_like")
    private boolean isLike;

    @OneToOne
    private User user;

    @ManyToOne
    private Post post;
}
