package uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.isystem.telegram.bot.sendMessageBot.SendMessageKeyBoardButton;

import java.util.ArrayList;
import java.util.List;

public class SetContactUser {
private final SendMessageKeyBoardButton sendMessageKeyBoardButton;

    public SetContactUser() {
        this.sendMessageKeyBoardButton = new  SendMessageKeyBoardButton();
    }

    public ReplyKeyboardMarkup contact(){
        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> list=new ArrayList<>();

        KeyboardRow contact=new KeyboardRow();
        KeyboardButton cont=new KeyboardButton();
        cont.setText("Share Contact");
        cont.setRequestContact(true);

        contact.add(cont);


        list.add(contact);
        replyKeyboardMarkup.setKeyboard(list);
        return replyKeyboardMarkup;
    }
}
