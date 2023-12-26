import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.builder.Gender;
import ucu.edu.ua.strategy.BirthdayMailStrategy;
import ucu.edu.ua.strategy.Client;
import ucu.edu.ua.strategy.GiftMailStrategy;
import ucu.edu.ua.strategy.MailCode;
import ucu.edu.ua.strategy.MailInfo;
import ucu.edu.ua.strategy.MailStrategy;

public class StrategyTest {

    public static Client client = new Client("Mariia", 21, Gender.FEMALE, "mariia.np@gmail.com");

    @Test
    public void clientTest() {
        Assertions.assertEquals(client.getId(), 0);
        Assertions.assertEquals(client.getName(), "Mariia");
        Assertions.assertNotEquals(client.getAge(), 19);
        Assertions.assertNotEquals(client.getSex(), Gender.MALE);
        Assertions.assertEquals(client.getEmail(), "mariia.np@gmail.com");


        Client clientSecond = new Client("Vika", 10, Gender.FEMALE, "VIKA.np@gmail.com");
        Assertions.assertEquals(clientSecond.getId(), 1);
    }


    @Test
    public void BirthdayStrategyTest() {
        BirthdayMailStrategy birthdayMail = new BirthdayMailStrategy();
        MailInfo mailInfo = new MailInfo(client, MailCode.BIRTHDAYMAIL);
        Assertions.assertInstanceOf(MailStrategy.class, birthdayMail);
        Assertions.assertEquals(birthdayMail.generateMailContent(mailInfo), 
                    "Dear " + mailInfo.getClient().getName() + ", enjoy our exclusive gift!");
    }

    @Test
    public void GiftStrategyTest() {
        GiftMailStrategy giftmail = new GiftMailStrategy();
        MailInfo mailInfo = new MailInfo(client, MailCode.GIFTMAIL);
        Assertions.assertInstanceOf(MailStrategy.class, giftmail);
        Assertions.assertEquals(giftmail.generateMailContent(mailInfo), 
                    "Happy Birthday, " + mailInfo.getClient().getName() + "!");
    }


}