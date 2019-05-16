package pt.ipg.mangareaderd;

import android.content.ContentValues;
import android.database.Cursor;

public class FAVORITOS1 {
    private long id;
    private String Genero;
    private String Autor;
    private String Data;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public ContentValues getContenteValues(){
        ContentValues valores = new ContentValues();

        valores.put(BDTabelaInserir.Nome_Genero,Genero);
        valores.put(BDTabelaInserir.Nome_Autor,Autor);
        valores.put(BDTabelaInserir.Nome_Data,Data);
        return valores;
    }

    public static FAVORITOS1 fromCursor(Cursor cursor){
        FAVORITOS1 inserir = new FAVORITOS1();

        long id = cursor.getLong(
                cursor.getColumnIndex(BDTabelaInserir._ID));

        String genero = cursor.getString( cursor.getColumnIndex(BDTabelaInserir.Nome_Genero));
        String Autor = cursor.getString( cursor.getColumnIndex(BDTabelaInserir.Nome_Autor));
        String Data = cursor.getString( cursor.getColumnIndex(BDTabelaInserir.Nome_Data));

        inserir.setId(id);
        inserir.setGenero(genero);
        inserir.setAutor(Autor);
        inserir.setData(Data);

        return inserir;


    }
}
