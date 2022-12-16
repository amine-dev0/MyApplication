package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    public static final String DBNAME = "Log.db";
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageInBytes;

    private static String createTableQuery = "Create table LoginUser (username TEXT " +
            ",age TEXT " +
            ",email TEXT " +
            ",password TEXT " +
            ",image BLOB)";



    public DBHelper(Context context) {

        super(context, "Log.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL (createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists LoginUser");
    }

    public void insertData(ModelClass modelClass){

        SQLiteDatabase Mydb = this.getWritableDatabase();
        Bitmap imageToStoreBitmap = modelClass.getProfileImage();

        byteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress (Bitmap.CompressFormat.JPEG,100, byteArrayOutputStream);

        imageInBytes = byteArrayOutputStream.toByteArray();

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", modelClass.getUsername());
        contentValues.put("age", modelClass.getAge());
        contentValues.put("email", modelClass.getEmail());
        contentValues.put("password", modelClass.getPassword());
        contentValues.put("image",imageInBytes);
        long checkIfQueryRun = Mydb.insert("LoginUser",null, contentValues);
        if (checkIfQueryRun != -1){
            Toast.makeText(context.getApplicationContext(),"table added successfully", Toast.LENGTH_SHORT).show();
            Mydb.close();
        }
        else {
            Toast.makeText(context.getApplicationContext(),"fail to add", Toast.LENGTH_SHORT).show();
        }

    }


    public Cursor getUser() {
        SQLiteDatabase Mydb = this.getReadableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from LoginUser",null);
        return cursor;
    }




    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from LoginUser where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from LoginUser where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


}

