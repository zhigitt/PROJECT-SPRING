package java12.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "followers")
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "base_id", sequenceName = "follower_seq", allocationSize = 1)

public class Follower extends BaseEntityId {
    @ElementCollection
    private List<Long> subscribers;
    @ElementCollection
    private List<Long> subscriptions;

    @OneToOne
    private User user;
}
