package database;

import java.util.List;

/**
 * Created by kets on 05.01.2018.
 */

public interface DBHelperInt {
    void insertIntoDB(String item);
    void deletItem(String item);
    List<String> getUpdatedList();
}
