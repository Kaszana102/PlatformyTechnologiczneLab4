import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Employee {
    @Getter
    @Id
    @GeneratedValue
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String surname;
    @Getter
    @Setter
    @ManyToOne
    private Department department;
}
