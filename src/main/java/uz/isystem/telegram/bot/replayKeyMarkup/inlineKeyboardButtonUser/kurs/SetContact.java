package uz.isystem.telegram.bot.replayKeyMarkup.inlineKeyboardButtonUser.kurs;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class SetContact {

    public InlineKeyboardMarkup setContact(){
        InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> lists=new ArrayList<>();

        List<InlineKeyboardButton> ha=new ArrayList<>();
        List<InlineKeyboardButton> yoq=new ArrayList<>();

        InlineKeyboardButton contactHa=new InlineKeyboardButton();
        contactHa.setCallbackData("roziman");
        contactHa.setText("Ha roziman");

        InlineKeyboardButton contactYoq=new InlineKeyboardButton();
        contactYoq.setCallbackData("rozi_emasman");
        contactYoq.setText("Yoq");

        ha.add(contactHa);
        yoq.add(contactYoq);

        lists.add(ha);
        lists.add(yoq);

        inlineKeyboardMarkup.setKeyboard(lists);
        return inlineKeyboardMarkup;
    }

}
