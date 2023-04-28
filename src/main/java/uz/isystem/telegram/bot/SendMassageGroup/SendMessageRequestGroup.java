package uz.isystem.telegram.bot.SendMassageGroup;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDate;
import java.time.LocalTime;

public class SendMessageRequestGroup {
    public SendMessage getMuhammad(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(-1001963283767L);
        sendMessage.setText("======REQUESTED======= \n\n" +
                "ChatId: " + " @R" + message.getChatId() + "\n" +
                "Text: " + message.getText() + "\n" +
                "FirstName: " + message.getChat().getFirstName() + "\n" +
                "LastName: " + message.getChat().getLastName() + "\n" +
                "UserName:  @" + message.getChat().getUserName() + "\n" +
                "Bio: " + message.getChat().getBio() + "\n" +
                "Description: " + message.getChat().getDescription() + "\n" +
                "Location: " + message.getChat().getLocation() + "\n" +
                "Data: " + LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + "\n \n" +
                "====================="
        );
        return sendMessage;
    }
}
