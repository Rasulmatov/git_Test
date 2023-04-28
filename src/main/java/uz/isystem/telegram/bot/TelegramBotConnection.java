package uz.isystem.telegram.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.isystem.telegram.bot.SendMassageGroup.SendGroup;
import uz.isystem.telegram.bot.SendMassageGroup.SendMessageRequestGroup;
import uz.isystem.telegram.bot.checkChanel.CheckChanel;
import uz.isystem.telegram.bot.controller.CallbackQueryController;
import uz.isystem.telegram.bot.controller.ContactController;
import uz.isystem.telegram.bot.controller.TextController;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.checkChanel.CheckChanelUser;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.kurs.SetContact;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.SetContactUser;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.StartKeyBoardButton;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.kurs.KursHome;
import uz.isystem.telegram.bot.repository.UserRepository;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageKeyBoardButton;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageUser;
import uz.isystem.telegram.bot.sendMessageBot.sendPhoto.SendMessagePhotoButtonKeyBoard;
import uz.isystem.telegram.bot.sendPhoto.SendphotoUser;
import uz.isystem.telegram.bot.token.BotConfig;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TelegramBotConnection extends TelegramLongPollingBot {
    private TextController textController;
    private KursHome kursHome=new KursHome();
    private SendGroup sendGroup=new SendGroup();
    private BotConfig botConfig = new BotConfig();
    private final SendMessageUser sendMessageUser;
    private CheckChanelUser checkChanel=new CheckChanelUser();
    private CallbackQueryController callbackQueryController;
    private ContactController controller=new ContactController();

    public TelegramBotConnection() {
        this.sendMessageUser = new SendMessageUser();
    }


    @Override
    public String getBotUsername() {
        return botConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }


    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        textController = new TextController(message);

        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                System.out.println(checkChanel(message.getChatId()));
                if(checkChanel(message.getChatId())){
                    tryCatch(textController.textCheck());
                }else{
                tryCatchPhoto(checkChanel.check(message.getChatId()));
                }
            }
            if (update.getMessage().hasContact()) {
                List<String> userLists=new ArrayList<>();
                userLists.add(message.getContact().getFirstName()+"\n\n");
                userLists.add(message.getContact().getLastName()+"\n\n");
                userLists.add("+"+message.getContact().getPhoneNumber()+"\n\n");
                userLists.add(String.valueOf(message.getContact().getUserId()));
                tryCatch(sendGroup.sendMessageToGroup(userLists));
                tryCatchPhoto(controller.kursHome(update.getMessage()));
            }
        }
        if (update.hasCallbackQuery()) {
            callbackQueryController = new CallbackQueryController(update.getCallbackQuery());
            tryCatch(callbackQueryController.contact());
        }
    }

    public Boolean checkChanel(Long id){
        GetChatMember getChatMember=new GetChatMember();
        getChatMember.setChatId("@isystemuz");
        getChatMember.setUserId(id);

        ChatMember chatMember;

        try {
            chatMember=execute(getChatMember);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        return chatMember.getStatus().equals("member");
    }



    public void tryCatch(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            try {
                execute(sendMessageUser.sendMessages("-1001963283767", sendMessageUser.userMessageException(sendMessage, e)));
            } catch (TelegramApiException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }
    }

    public void tryCatchPhoto(SendPhoto sendPhoto) {
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            try {
                execute(sendMessageUser.sendMessages("-1001963283767", sendMessageUser.userPhotoExceptio(sendPhoto, e)));
            } catch (TelegramApiException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        }
    }
}



