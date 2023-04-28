package uz.isystem.telegram.bot.kurController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.isystem.telegram.bot.model.BotUser;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.kurs.SetContact;
import uz.isystem.telegram.bot.repository.UserRepository;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageInlineKeyBoardButtonUser;
import uz.isystem.telegram.bot.userList.UserList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class KursService {
    private final SetContact setContact;
    @Autowired
    private UserRepository userRepository;
    private final SendMessageInlineKeyBoardButtonUser sendMessageInlineKeyBoardButtonUser;
    private final Message message;
    List<UserList> userLists;
    public KursService(Message message) {
        this.sendMessageInlineKeyBoardButtonUser=new SendMessageInlineKeyBoardButtonUser();
        this.setContact=new SetContact();
        this.userLists=new ArrayList<>();
        this.message = message;
    }
    String about="Bizdan royxatdan otishdan oldin tel raqmingizni qoldirishingi kerak \\n\" +\n" +
            "                \"Siz shartlarga rozimisiz ?";



    public SendMessage kursStart(){

        return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),about,setContact.setContact());
    }










}
