package ucu.edu.ua.strategy;

import java.util.HashMap;
import java.util.Map;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {
    public static final String API_KEY = System.getenv("MAILJET_API_KEY");
    public static final String API_SECRET = System.getenv("MAILJET_SECRET_KEY");
    private Map<MailCode, MailStrategy> contentGeneratorMap;

    public MailSender() {
        contentGeneratorMap = new HashMap<>();
        contentGeneratorMap.put(MailCode.BIRTHDAYMAIL, new BirthdayMailStrategy());
        contentGeneratorMap.put(MailCode.GIFTMAIL, new GiftMailStrategy());
    }
    public void sendMail(MailInfo mailInfo) {
        String name = mailInfo.getClient().getName();
        String email = mailInfo.getClient().getEmail();
        MailStrategy strategy = contentGeneratorMap.get(mailInfo.getMailCode());
        String content = strategy.generateMailContent(mailInfo);


        MailjetClient client;
        MailjetRequest request;
        MailjetResponse response;

        client = new MailjetClient(API_KEY, API_SECRET, new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource).property(Emailv31.MESSAGES, new JSONArray().put(new JSONObject()
                    .put(Emailv31.Message.FROM, new JSONObject().put("Email", "butynets.pn@ucu.edu.ua").put("Name", "Dzvinka"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject().put("Email", email).put("Name", name)))
                                .put(Emailv31.Message.SUBJECT, "Important message from Dzvinka Butynets!")
                                .put(Emailv31.Message.TEXTPART, content)));


        try {
            response = client.post(request);
            System.out.println("Response Status: " + response.getStatus());
            System.out.println("Response Data: " + response.getData());
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("Response Status: FAILED!");
      }
        // response = client.post(request);
        // System.out.println("Response Status: " + response.getStatus());
    }





    
}
