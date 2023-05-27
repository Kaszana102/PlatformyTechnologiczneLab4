import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Department {
    @Getter
    @Id
    @GeneratedValue
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
