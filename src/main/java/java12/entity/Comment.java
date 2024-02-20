package java12.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@SequenceGenerator(name = "base_id", sequenceName = "comment_seq", allocationSize = 1)

public class Comment extends BaseEntityId{
    private String comment;
    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
