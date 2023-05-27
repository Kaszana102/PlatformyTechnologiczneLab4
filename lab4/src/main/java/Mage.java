import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@EqualsAndHashCode
@ToString
@Entity
public class Mage {
    @Id
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int level;
    @ManyToOne
    @Getter
    @Setter
    private Tower tower;
}
