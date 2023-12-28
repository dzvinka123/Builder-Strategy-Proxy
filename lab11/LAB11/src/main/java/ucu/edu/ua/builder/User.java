package ucu.edu.ua.builder;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder @Getter @Setter
public class User {
    private String name;
    private int age;
    private Gender gender;
    private int weight;
    private int height;
}
