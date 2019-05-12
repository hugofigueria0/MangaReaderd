package pt.ipg.mangareaderd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BDTabelaFavorito implements BaseColumns {

    public static final String Nome_Tabela = "NomeManga";
    public static final String Nome_Genero = "Genero";
    public static final String Nome_Autor = "Autor";
    public static final String Nome_Data = "Data";
    private SQLiteDatabase db;

    public BDTabelaFavorito (SQLiteDatabase db){
        this.db = db;
    }

    public  void criar(){

        db.execSQL(
                "CREATE TABLE " + Nome_Tabela + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Nome_Genero + "TEXT NOT NULL," +
                        Nome_Autor + "TEXT NOT NULL," +
                        Nome_Data + "TEXT NOT NULL" +
                        ")"
        );

    }

    public Cursor query (String[]columns, String selection, String[]selectionArg, String groupby, String having, String orderBy){
        return db.query(Nome_Tabela, columns, selection, selectionArg, groupby, having, orderBy);
    }

    public long insert (ContentValues values){
        return db.insert(Nome_Tabela, null, values);
    }

    public int update (ContentValues values, String whereClause, String []whereArgs){
        return db.update(Nome_Tabela, values, whereClause, whereArgs);
    }
    public int delete (String whereClause, String []whereArgs){
        return db.delete(Nome_Tabela, whereClause, whereArgs);

    }
}
