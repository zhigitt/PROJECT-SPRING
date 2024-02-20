package java12.entity;

import jakarta.persistence.*;
import java12.entity.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_infos")
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "base_id", sequenceName = "userInfo_seq", allocationSize = 1)

public class UserInfo extends BaseEntityId {
    @Column(name = "full_name")
    private String fullName;
    private String biography;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;
}
