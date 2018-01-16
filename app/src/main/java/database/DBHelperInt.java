package database;

import java.util.List;

import ru.example.kets.funnyapp.Message;

/**
 * Created by kets on 05.01.2018.
 */

public interface DBHelperInt {
    void insertIntoDB(Message message);
    void deletItem(String title);
    List<Message> getUpdatedList();
}
