package ucu.edu.ua.strategy;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class MailBox {
    private List<MailInfo> infos = new ArrayList<>();
    private MailSender sender;

    public void addMailInfo(MailInfo mailInfo){
        infos.add(mailInfo);
    }

    public void sendAll() {
        for (MailInfo mail : infos) {
            sender.sendMail(mail);
        }
        infos.clear();
    }

}