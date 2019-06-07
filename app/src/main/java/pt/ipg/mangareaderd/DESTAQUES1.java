package pt.ipg.mangareaderd;

import android.content.ContentValues;
import android.database.Cursor;

public class DESTAQUES1 {
    private long id;
    private String Nome;
    private String Categoria;
    private int Pagina;
    private int Ano;
    private String Autor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNome(){
        return Nome;
    }
    public void setNome(String Nome){
        this.Nome = Nome;

    }


    public String getCategoria(){

        return Categoria;
    }
    public void setCategoria(String Categoria){
        this.Categoria = Categoria;
    }


    public String getAutor(){
        return Autor;
    }
    public void setAutor(String Autor){
        this.Autor = Autor;

    }


    public int getAno(){
        return Ano;
    }
    public void setAno(int Ano){
        this.Ano = Ano;
    }

    public int getPagina(){
        return Pagina;
    }
    public void setPagina(int Pagina){
        this.Pagina = Pagina;

    }





    public ContentValues getContentValues(){
        ContentValues valores = new ContentValues();

        valores.put(BDTabelaLivro.Livro, Nome);
        valores.put(BDTabelaLivro.Autor, Autor);
        valores.put(BDTabelaLivro.Categoria,Categoria);
        valores.put(BDTabelaLivro.Pagina,Pagina);
        valores.put(BDTabelaLivro.Ano,Ano);
        return valores;
    }

    public static DESTAQUES1 fromCursor(Cursor cursor){
        DESTAQUES1 inserir = new DESTAQUES1();

        long id = cursor.getLong(
                cursor.getColumnIndex(BDTabelaLivro._ID));

        String Nome = cursor.getString( cursor.getColumnIndex(BDTabelaLivro.Livro));
        String Autor = cursor.getString( cursor.getColumnIndex(BDTabelaLivro.Autor));
        String Categoria = cursor.getString( cursor.getColumnIndex(BDTabelaLivro.Categoria));
        Integer Ano = cursor.getInt(cursor.getColumnIndex(BDTabelaLivro.Ano));
        Integer Pagina = cursor.getInt(cursor.getColumnIndex(BDTabelaLivro.Pagina));


        inserir.setId(id);
        inserir.setNome(Nome);
        inserir.setAutor(Autor);
        inserir.setCategoria(Categoria);
        inserir.setCategoria(String.valueOf(Ano));
        inserir.setPagina(Pagina);

        return inserir;


    }
}
