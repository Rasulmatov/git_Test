package uz.isystem.telegram.bot.sendMessageBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import uz.isystem.telegram.bot.model.BotUser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SendMessageUser {
    public SendMessage sendMessages(String chatId,String text){
        SendMessage sendMessage=new SendMessage();
        sendMessage.setText(text);
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    public String userMessageException(SendMessage user,Exception e){
        String about=
              "_________SendMessageException________ \n" +
                        "ChatId: " + " @E"+user.getChatId() +"\n" +
                        "Text: " + user.getText() + "\n" +
                        "Exception : " +e.getMessage()+"\n\n\n"+
                        "Date: "+ LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() +"\n" +
                        "______________________";
        return about;
    }
    public String userPhotoExceptio(SendPhoto user, Exception e){
        String about=
                "_________SendPhotoExceptio_______\n\n" +
                        "ChatId: " +" @E" +user.getChatId() +"\n" +
                        "Caption: "+user.getCaption()+ "\n"+
                        "Exception : " +e.getMessage()+"\n\n\n"+
                        "Date: "+ LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() +"\n" +
                        "_______________________________";
        return about;
    }
}
