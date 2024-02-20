package java12.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import java.awt.*;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

@SequenceGenerator(name = "base_id", sequenceName = "user_seq", allocationSize = 1)

public class User extends BaseEntityId {
    @Column(name = "user_name", unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;


    @OneToOne(mappedBy = "user")
    private Follower follower;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private UserInfo userInfo;

    @ManyToOne
    private Image image;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @OneToOne
    private Like like;

    @OneToMany(mappedBy = "user")
    private List<Post>  posts;

}
