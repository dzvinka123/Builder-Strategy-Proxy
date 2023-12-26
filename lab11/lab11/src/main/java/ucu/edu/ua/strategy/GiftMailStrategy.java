package ucu.edu.ua.strategy;


public class GiftMailStrategy implements MailStrategy{
    @Override
    public String generateMailContent(MailInfo mailInfo) {
        return "Happy Birthday, " + mailInfo.getClient().getName() + "!";
    }
}
