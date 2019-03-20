package OpenHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper {


    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table user(userID integer primary key autoincrement, name text" +
                ", email text, pass text, age text, address text, weight text, height text" +
                ", sex text, allergy text )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void abrir(){
        this.getWritableDatabase();
    }

    public void cerrar(){
        this.close();
    }

    public void insertarReg(String name, String email, String pass, String age, String address, String weight
            , String height, String sex, String allergy){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("pass", pass);
        values.put("age", age);
        values.put("address", address);
        values.put("weight", weight);
        values.put("height", height);
        values.put("sex", sex);
        values.put("allergy", allergy);
        this.getWritableDatabase().insert("user", null , values);
    }

    public Cursor ValidacionLogin (String user, String pass) throws SQLException {
        Cursor mcursor = null;
        mcursor=this.getReadableDatabase().query("user", new String[]{"userId", "name", "email"
                        , "pass", "age", "address", "weight", "height", "sex", "allergy"}
                , "email like '"+user+"' and pass like '"+pass+"'",null
                ,null,null,null);
        return mcursor;
    }

    public String[] leerBd(Cursor c){

        String[] result = new String[12];
        String name="", email="", pass="", age="", address="", weight="0", height = "0", sex="", allergy="";
        int in, iw, ih, ie, ip, ia, iad, is, ial;
        in = c.getColumnIndex("name");
        ie = c.getColumnIndex("email");
        ip = c.getColumnIndex("pass");
        ia = c.getColumnIndex("age");
        iad = c.getColumnIndex("address");
        iw = c.getColumnIndex("weight");
        ih = c.getColumnIndex("height");
        is = c.getColumnIndex("sex");
        ial = c.getColumnIndex("allergy");


        if (c.moveToFirst()){
                name = c.getString(in);
                email = c.getString(ie);
                pass = c.getString(ip);
                age = c.getString(ia);
                address = c.getString(iad);
                weight = c.getString(iw);
                height = c.getString(ih);
                sex = c.getString(is);
                allergy = c.getString(ial);
        }
        c.close();

        double peso = Double.parseDouble(weight);
        double altura = Double.parseDouble(height);

        Double cuadrado = (Double) Math.pow(altura,2);
        Double imc = peso/cuadrado;
        String estado ="";
        if (imc<=18){
            estado = "Bajo peso";
        }else if (18<imc && imc<25){
            estado = "Peso saludable";
        }else if (25<=imc && imc <30){
            estado = "Sobrepeso";
        }else {
            estado = "Obesidad";
        }
        String imcString = Double.toString(imc);

        result[1] = name;
        result[2] = email;
        result[3] = pass;
        result[4] = age;
        result[5] = address;
        result[6] = weight;
        result[7] = height;
        result[8] = sex;
        result[9] = allergy;
        result[10] = imcString;
        result[11] = estado;

        return result;
    }


}