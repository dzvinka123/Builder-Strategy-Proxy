package ucu.edu.ua.builder;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder @Getter @Setter @ToString
public class Student extends User {
    @Singular("mark")
    private List<Integer> grades;
}
