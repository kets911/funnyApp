package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ru.example.kets.funnyapp.Message;

/**
 * Created by kets on 13.09.2017.
 */

public class DBHelper extends SQLiteOpenHelper implements DBHelperInt{
    public DBHelper(Context context) {
        super(context, DBContract.DB_NAME, null, DBContract.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +DBContract.Entry.TABLE + " ( "+ DBContract.Entry._ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " +DBContract.Entry.COL_TITLE+ " TEXT NOT NULL, "
                + DBContract.Entry.COL_MESSAGE + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.Entry.TABLE);
        onCreate(db);
    }
    public void insertIntoDB(Message message){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBContract.Entry.COL_TITLE, message.getTitle());
        cv.put(DBContract.Entry.COL_MESSAGE, message.getText());
        db.insertWithOnConflict(DBContract.Entry.TABLE, null, cv, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    @Override
    public void deletItem(String title) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(DBContract.Entry.TABLE, DBContract.Entry.COL_TITLE + " = ? ", new String[] {title});
        db.close();
    }

    @Override
    public List<Message> getUpdatedList() {
        List<Message> messages = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(DBContract.Entry.TABLE, new String[] {DBContract.Entry._ID, DBContract.Entry.COL_TITLE, DBContract.Entry.COL_MESSAGE}, null, null, null, null, null);
        while (cursor.moveToNext()){
            Message msg = new Message();
            int titleIdx = cursor.getColumnIndex(DBContract.Entry.COL_TITLE);
            int messageIdx = cursor.getColumnIndex(DBContract.Entry.COL_MESSAGE);
            msg.setTitle(cursor.getString(titleIdx));
            msg.setText(cursor.getString(messageIdx));
            messages.add(msg);
        }
        cursor.close();
        db.close();
        return messages;
    }

}
