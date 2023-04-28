package uz.isystem.telegram.bot.replayKeyMarkup.keyBoardButtonUser.kurs;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KursHome {
    public ReplyKeyboardMarkup kursHome(){
        ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setInputFieldPlaceholder("Kurslardan brini tanlang !");

        List<KeyboardRow> list=new ArrayList<>();

        KeyboardRow faundation=new KeyboardRow();
        KeyboardRow profecioanl=new KeyboardRow();
        KeyboardRow kids=new KeyboardRow();
        KeyboardRow back=new KeyboardRow();

        KeyboardButton faundationB=new KeyboardButton("Faundation");
        KeyboardButton proficionalB=new KeyboardButton("Profecional");
        KeyboardButton kidsB=new KeyboardButton("Kids");
        KeyboardButton backB=new KeyboardButton("Back  ↩\uFE0F");

        faundation.add(faundationB);
        profecioanl.add(proficionalB);
        kids.add(kidsB);
        back.add(backB);

        list.add(faundation);
        list.add(profecioanl);
        list.add(kids);
        list.add(back);

        replyKeyboardMarkup.setKeyboard(list);
        return replyKeyboardMarkup;
    }
}
