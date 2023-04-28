package uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.kurs;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class FaundationKeyBoardButton {

    public ReplyKeyboardMarkup faundationKeyButton(){
        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        List<KeyboardRow> list=new ArrayList<>();

        KeyboardRow java=new KeyboardRow();
        KeyboardRow python=new KeyboardRow();
        KeyboardRow back=new KeyboardRow();

        KeyboardButton javaB=new KeyboardButton();
        KeyboardButton pythonB=new KeyboardButton();
        KeyboardButton backB=new KeyboardButton();

        javaB.setText("Java \uD83D\uDCCC");
        pythonB.setText("Python \uD83D\uDCCC");
        backB.setText("ortga \uD83D\uDD19");

        java.add(javaB);
        python.add(pythonB);
        back.add(backB);


        list.add(java);
        list.add(python);
        list.add(back);
        replyKeyboardMarkup.setKeyboard(list);
        return replyKeyboardMarkup;
    }
}
