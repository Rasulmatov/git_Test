package uz.isystem.telegram.bot.controller;

import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import uz.isystem.telegram.bot.kurController.KursService;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.InlineKeyboardButtonUser;
import uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.bizHaqimizda.UmumiyInline;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.BizHaqimizdaKeyboardButton;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.StartKeyBoardButton;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.kurs.FaundationKeyBoardButton;
import uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.kurs.KursHome;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageInlineKeyBoardButtonUser;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageKeyBoardButton;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageUser;
import uz.isystem.telegram.bot.sendPhoto.SendphotoUser;

@Controller
public class TextController {
    private final Message message;
    private final KursHome kursHome;
    private final KursService kursService;
    private final UmumiyInline umumiyInline;
    private final SendphotoUser sendphotoUser;
    private final SendMessageUser sendMessageUser;
    private final StartKeyBoardButton startKeyBoardButton;
    private final FaundationKeyBoardButton faundationKeyBoardButton;
    private final InlineKeyboardButtonUser inlineKeyboardButtonUser;
    private final SendMessageKeyBoardButton sendMessageKeyBoardButton;
    private final BizHaqimizdaKeyboardButton bizHaqimizdaKeyboardButton;
    private final SendMessageInlineKeyBoardButtonUser sendMessageInlineKeyBoardButtonUser;
    public TextController(Message message) {
        this.message = message;
        this.kursHome=new KursHome();
        this.umumiyInline=new UmumiyInline();
        this.sendphotoUser=new SendphotoUser();
        this.kursService =new KursService(message);
        this.sendMessageUser=new SendMessageUser();
        this.faundationKeyBoardButton=new FaundationKeyBoardButton();
        this.startKeyBoardButton=new StartKeyBoardButton();
        this.sendMessageKeyBoardButton=new SendMessageKeyBoardButton();
        this.bizHaqimizdaKeyboardButton=new BizHaqimizdaKeyboardButton();
        this.inlineKeyboardButtonUser=new InlineKeyboardButtonUser();
        this.sendMessageInlineKeyBoardButtonUser=new SendMessageInlineKeyBoardButtonUser();


    }
    private String start="Yaxyo Text tezroq yozing \uD83D\uDE04\uD83D\uDE04\uD83D\uDE04\uD83D\uDE04";

    String ex="java.lang.NullPointerException: Cannot invoke \"uz.isystem.telegram.bot.repository.UserRepository.save(Object)\" because \"this.userRepository\" is null\n" +
            "tat uz.isystem.telegram.bot.controller.ContactController.save(ContactController.java:45) ~[classes/:na]\n" +
            "tat uz.isystem.telegram.bot.controller.ContactController.kursHome(ContactController.java:35) ~[classes/:na]\n" +
            "tat uz.isystem.telegram.bot.TelegramBotConnection.onUpdateReceived(TelegramBotConnection.java:62) ~[classes/:na]\n" +
            "tat java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]\n" +
            "tat org.telegram.telegrambots.meta.generics.LongPollingBot.onUpdatesReceived(LongPollingBot.java:27) ~[telegrambots-meta-6.5.0.jar:na]\n" +
            "tat org.telegram.telegrambots.updatesreceivers.DefaultBotSession$HandlerThread.run(DefaultBotSession.java:312) ~[telegrambots-6.5.0.jar:na]";

    private static String status;
    public SendMessage textCheck(){
        if (message.getText().equals("/start")) {
            return sendMessageKeyBoardButton.sendButton(message.getChatId(), start, startKeyBoardButton.start());
        }
        if (message.getText().equals("Biz Haqimizda \uD83D\uDCD4")){
            System.out.println("biz haqimizda keldi");
            return sendMessageKeyBoardButton.sendButton(message.getChatId(),start,bizHaqimizdaKeyboardButton.bizHaqimizda());
        }
        if (message.getText().equals("Ijtimoiy tarmoqlarimiz \uD83C\uDF0D")){
            System.out.println("Ijtimoiy ga keldi");
            return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),"Bizni Kuzating jgvkjvckjgcvkjgcjkcgj,c,gc,ljgc,jgcjcj,gck,cgj",inlineKeyboardButtonUser.getInllineButton());
        }
        if (message.getText().equals("Umumiy Ma'lumot  \uD83D\uDCF0")){
            System.out.println("Umumiyga keldi "+status);
            return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),"ksdbhgvkjsbdkjgvbsd.jlblsjdebhlsbnljsbnefgxcfgtmnxcfgtmjlsjbnsljedbnl",umumiyInline.umumiyAbout());
        }
        if (message.getText().equals("Afzalliklar  \uD83D\uDCCC")){
            return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),"ksdbhgvkjsbdkjgvbsd.jlblsjdebhlsbnljfgmxfgmxfgsbnejlsjbnsljedbnl",umumiyInline.umumiyAbout());
        }
        if (message.getText().equals("Yutiqlar  \uD83D\uDCC8")){
            return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),"ksdbhgvkjsbdkjgvbsd.jlblsjdebhlsbnljxfgmxfgmxfgmxfgmxfgmxfgmfgmxfgmxfgmxfgmxfgmxfgmsbnejlsjbnsljedbnl",umumiyInline.umumiyAbout());
        }
        if (message.getText().equals("Ijtimoiy tarmoqlarimiz \uD83C\uDF0D")){
            return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),"ksdbhgvkjsbdkjgvbsd.jlblsjdebhlsbnljsbnejlxgfmxfgmxfgmfgmsjbnsljedbnl",umumiyInline.umumiyAbout());
        }
        if (message.getText().equals("Back  ↩\uFE0F")){
            return sendMessageKeyBoardButton.sendButton(message.getChatId(),"Siz asosiy sahifaga o'tdingiz \uD83C\uDFE0", startKeyBoardButton.start());
        }
        //filtr qoyish kerak kontact oldin jonatgan bolsa kursHomega otish
        if (message.getText().equals("Kurslar  \uD83D\uDCBB")){
            return kursService.kursStart();
        }
        if(message.getText().equals("Faundation")){
            return sendMessageKeyBoardButton.sendButton(message.getChatId(),"Faundation",faundationKeyBoardButton.faundationKeyButton());
        }
        if (message.getText().equals("ortga \uD83D\uDD19")){
            return sendMessageKeyBoardButton.sendButton(message.getChatId(),"siz ortga qatdingiz",kursHome.kursHome());
        }
        return sendMessageInlineKeyBoardButtonUser.sendInlineButton(message.getChatId(),"Siz Belgilanmagan Byruq Kritdingiz !!!\n\n\n Bizni ijtiomoiy sahifalaimizni kuzating ",inlineKeyboardButtonUser.getInllineButton());
    }
}
