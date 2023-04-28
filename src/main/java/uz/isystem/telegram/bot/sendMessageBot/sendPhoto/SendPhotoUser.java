package uz.isystem.telegram.bot.sendMessageBot.sendPhoto;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

public class SendPhotoUser {

    public SendPhoto sendPhoto1(File file, Long id, String text){
        SendPhoto sendPhoto1= new SendPhoto();
        InputFile inputFile=new InputFile(file);
        sendPhoto1.setChatId(id);
        sendPhoto1.setPhoto(inputFile);
        sendPhoto1.setCaption(text);
        return sendPhoto1;
    }
}
