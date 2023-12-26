import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.builder.Gender;
import ucu.edu.ua.builder.Student;
import ucu.edu.ua.builder.User;

public class BuilderTest {
    @Test
    public void testDzvinka() {
        Student Dzvinka = Student.builder().name("Dzvinka").age(19).gender(Gender.FEMALE).weight(55).height(190).height(170).mark(100).build();
        Assertions.assertEquals(Dzvinka.getName(), "Dzvinka");
        Assertions.assertEquals(Dzvinka.getAge(), 19);
        Assertions.assertEquals(Dzvinka.getGender(), Gender.FEMALE);
        Assertions.assertEquals(Dzvinka.getWeight(), 55);
        Assertions.assertEquals(Dzvinka.getHeight(), 170);
        Assertions.assertEquals(Dzvinka.getGrades().get(0), 100);
    }

    @Test
    public void testAndrii() {
        Student Andrii = Student.builder().name("Andrii").gender(Gender.MALE).weight(100).height(190).mark(100).mark(76).mark(12).build();
        Assertions.assertEquals(Andrii.getName(), "Andrii");
        Assertions.assertEquals(Andrii.getAge(), 0);
        Assertions.assertNotEquals(Andrii.getGender(), Gender.FEMALE);
        Assertions.assertEquals(Andrii.getWeight(), 100);
        Assertions.assertEquals(Andrii.getHeight(), 190);
        Assertions.assertEquals(Andrii.getGrades().get(0), 100);
        Assertions.assertEquals(Andrii.getGrades().get(2), 12);
    }

    @Test
    public void testUser() {
        User defaultUser = User.builder().build();
        Assertions.assertNull(defaultUser.getName());
        Assertions.assertEquals(defaultUser.getAge(), 0);
        Assertions.assertNull(defaultUser.getGender());
        Assertions.assertEquals(defaultUser.getWeight(), 0);
        Assertions.assertEquals(defaultUser.getHeight(), 0);
    }
    
}
