package uz.isystem.telegram.bot.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import uz.isystem.telegram.bot.SendMassageGroup.SendGroup;
import uz.isystem.telegram.bot.model.BotUser;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.kurs.KursHome;
import uz.isystem.telegram.bot.repository.UserRepository;
import uz.isystem.telegram.bot.sendMessageBot.sendPhoto.SendMessagePhotoButtonKeyBoard;
import uz.isystem.telegram.bot.userList.UserList;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactController {
    @Autowired
    private UserRepository userRepository;



    private KursHome kursHome=new KursHome();
    private  SendMessagePhotoButtonKeyBoard sendMessagePhotoButtonKeyBoard=new SendMessagePhotoButtonKeyBoard();
    String kursHometext="bizng kurslar \n kjnb;kjdsnfb;sndfj;bsl;dfrgrgrgrjgqbiurbiubriuvvqbiurvuravuaruvbaurvbbs";
    File fileKursHome=new File("C:\\Users\\Isystem\\Documents\\Telegram Bot Isystem\\src\\main\\java\\uz\\isystem\\telegram\\bot\\photo\\photoBizHaqimizda\\trekir2.jpg");
    public SendPhoto kursHome(Message message){
        System.out.println(message.getContact().getPhoneNumber());
        System.out.println(message.getContact().getFirstName());
        System.out.println(message.getContact().getLastName());
        save(message);
        return sendMessagePhotoButtonKeyBoard.sendPhoto(message.getChatId(),kursHometext,fileKursHome,kursHome.kursHome());
    }
    public void save(Message message){
        System.out.println("save");
        BotUser botUser=new BotUser();
        botUser.setChatId(message.getContact().getUserId());
        botUser.setFirstName(message.getContact().getFirstName());
        botUser.setFirstName(message.getContact().getFirstName());
        botUser.setPhoneNumber(message.getContact().getPhoneNumber());
        botUser.setLocalDate(LocalDateTime.now());
        userRepository.save(botUser);
    }


    public ContactController(){

    }
}