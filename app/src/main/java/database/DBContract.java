package database;

import android.provider.BaseColumns;

/**
 * Created by kets on 13.09.2017.
 */

public class DBContract {
    public static final String DB_NAME = "MyBase";
    public static final int DB_VERSION = 1;

public class Entry implements BaseColumns {
    public static final String TABLE = "MyTable";
    public static final String COL_TITLE = "title";
}
}
