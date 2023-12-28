package ucu.edu.ua.strategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Setter @Getter
public class MailInfo {
    private Client client;
    private MailCode mailCode;

}