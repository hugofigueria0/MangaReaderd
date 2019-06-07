package pt.ipg.mangareaderd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class BDTabelaLivro implements BaseColumns {

    public static final String Nome_Tabela = "Livros";
    public static final String Livro = "Livro";
    public static final String Categoria= "Categoria";
    public static final String Autor = "Autor";
    public static final String Ano = "Ano";
    public static final String Pagina = "Pagina";
    private SQLiteDatabase db;



    public static final String[] TODAS_COLUNAS = new String[] { _ID, Livro, Autor, Categoria, Ano, Pagina};


    public BDTabelaLivro(SQLiteDatabase db){
        this.db = db;
    }

    public  void criar(){

        db.execSQL(
                "CREATE TABLE " + Nome_Tabela + "(" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Livro + "TEXT NOT NULL," +
                        Autor + "TEXT NOT NULL," +
                        Categoria + "TEXT NOT NULL," +
                        Ano + "INTEGER NOT NULL," +
                        Pagina + "INTEGER NOT NULL" +
                        ")"
        );

    }

    public Cursor query (String[]columns, String selection, String[]selectionArg, String groupBy, String having, String orderBy){
        return db.query(Nome_Tabela, columns, selection, selectionArg, groupBy, having, orderBy);
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
