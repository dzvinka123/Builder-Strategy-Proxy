package ucu.edu.ua.strategy;

import lombok.Getter;
import lombok.Setter;
import ucu.edu.ua.builder.Gender;

public class Client {
    public static int counter = 0;

    @Getter @Setter
    private int id;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private int age;
    @Setter @Getter
    private Gender sex;
    @Setter @Getter
    private String email;


    public Client(String name, int age, Gender sex, String email) {
        this.id = calculateNumber();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public int calculateNumber(){
        return counter++;
    }

}
