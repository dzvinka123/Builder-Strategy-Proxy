package ucu.edu.ua.strategy;

public class BirthdayMailStrategy implements MailStrategy{
    @Override
    public String generateMailContent(MailInfo mailInfo){
        return "Dear " + mailInfo.getClient().getName() + ", enjoy our exclusive gift!";
    }
}
