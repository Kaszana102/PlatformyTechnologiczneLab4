import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Tower {
    @Id
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int height;
    @OneToMany (mappedBy = "tower")
    private List<Mage> mages;

}
