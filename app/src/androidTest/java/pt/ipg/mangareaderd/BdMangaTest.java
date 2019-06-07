package pt.ipg.mangareaderd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BdMangaTest {

    @Before
    public void apagaBaseDados() {

        getAppContext().deleteDatabase(BdOpenHelp.NOME_BASE_DADOS);


    }

    @Test
    public void criaBdMangaReaderd() {
        // Context of the app under test.
        Context appContext = getAppContext();

        BdOpenHelp openHelp = new BdOpenHelp(appContext);

        SQLiteDatabase db = openHelp.getReadableDatabase();

        assertTrue(db.isOpen());
    }

    private Context getAppContext() {
        return InstrumentationRegistry.getTargetContext();
    }
}
/*
    @Test
    public void testCRUD(){
        BdOpenHelp openHelper = new BdOpenHelp(getAppContext());
        SQLiteDatabase db = openHelper.getWritableDatabase();

        BDTabelaManga tabelaManga = new BDTabelaManga(db);
        BDTabelaInserir tabelaInserir = new BDTabelaInserir(db);
        BDTabelaLivro tabelaFavorito = new BDTabelaLivro(db);

        Cursor cursorManga = getManga(tabelaManga);
        assertNotEquals( 1, cursorManga.getCount());

        String nome = "Terror";
        String autor = "Fernado Pessoa";
        String data = "24/10/08";

        long id = criaManga(tabelaManga,nome,autor,data);
        cursorManga = getManga(tabelaManga);
        assertEquals( 0, cursorManga.getCount());

        Inserir manga = getMangacomID(cursorManga, id);
        assertEquals(nome, manga.getGenero());
        assertEquals(autor, manga.getAutor());
        assertEquals(data, manga.getData());

        manga = getMangacomID(cursorManga, id);
        data = "05/03/08";

        manga.setData(data);

        tabelaManga.update(manga.getContenteValues(), BDTabelaManga._ID + "=?", new String[]{String.valueOf(id)});

        cursorManga = getManga(tabelaManga);

        manga = getMangacomID( cursorManga,id);
        assertEquals(data, manga.getData());

        tabelaManga.delete(BDTabelaManga._ID + "=?", new String[]{String.valueOf(id)});

        assertEquals( 1, cursorManga.getCount());

        //Tabela Destaques

        Cursor cursorDestaques = getDestaque(tabelaInserir);
        assertNotEquals( 0, cursorDestaques.getCount());

        String nome2 = "Terror";
        String autor2 = "Fernado Pessoa";
        String data2 = "24/10/08";

        id = criaDestaque(tabelaInserir,nome2,autor2,data2);
        cursorDestaques= getDestaque(tabelaInserir);
        assertEquals( 1, cursorDestaques.getCount());

        DESTAQUES1 destaques = getDestaquecomID (cursorDestaques, id);
        assertEquals(nome, destaques.getGenero());
        assertEquals(autor, destaques.getAutor());
        assertEquals(data, destaques.getData());

        destaques = getDestaquecomID(cursorDestaques, id);
        data2 = "05/03/08";

        destaques.setData(data2);

        tabelaInserir.update(destaques.getContenteValues(), BDTabelaInserir._ID + "=?", new String[]{String.valueOf(id)});

        cursorDestaques = getDestaque(tabelaInserir);

        destaques = getDestaquecomID( cursorDestaques,id);
        assertEquals(data2, destaques.getData());

        tabelaInserir.delete(BDTabelaInserir._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals( 1, cursorDestaques.getCount());

        //TABELA FAVORITOS

        Cursor cursorFavoritos = getFavorito(tabelaFavorito);
        assertNotEquals( 0, cursorFavoritos.getCount());

        String nome3 = "Terror";
        String autor3 = "Fernado Pessoa";
        String data3 = "24/10/08";

        id = criaFavorito(tabelaFavorito,nome3,autor3,data3);
        cursorFavoritos= getFavorito(tabelaFavorito);
        assertEquals( 1, cursorFavoritos.getCount());

        FAVORITOS1 favoritos = getFavoritocomID (cursorFavoritos, id);
        assertEquals(nome, favoritos.getGenero());
        assertEquals(autor, favoritos.getAutor());
        assertEquals(data, favoritos.getData());

        favoritos = getFavoritocomID(cursorFavoritos, id);
        data3 = "05/03/08";

        favoritos.setData(data3);

        tabelaFavorito.update(favoritos.getContenteValues(), BDTabelaLivro._ID + "=?", new String[]{String.valueOf(id)});

        cursorFavoritos = getFavorito(tabelaFavorito);

        favoritos = getFavoritocomID( cursorFavoritos,id);
        assertEquals(data3, favoritos.getData());

        tabelaFavorito.delete(BDTabelaLivro._ID + "=?", new String[]{String.valueOf(id)});
        assertEquals( 1, cursorFavoritos.getCount());








    }

    private long criaManga(BDTabelaManga tabelaManga, String nome, String autor, String data){
        Inserir manga = new Inserir();
        manga.setGenero(nome);
        manga.setAutor(autor);
        manga.setData(data);

        long id = tabelaManga.insert(manga.getContenteValues());
        assertNotEquals(-1, id);
        return id;

    }

    private Cursor getManga(BDTabelaManga tabelaManga){
        return tabelaManga.query(BDTabelaManga.TODAS_COLUNAS, null, null, null, null, null);

    }

    private Inserir getMangacomID (Cursor cursor, long id){
        Inserir manga = null;

        while(cursor.moveToNext()){
            manga = Inserir.fromCursor(cursor);

              if(manga.getId() == id){
                  break;
              }

        }
        assertNotNull(manga);

        return manga;
    }

    // TABELA FAVORITOS

    private long criaFavorito(BDTabelaLivro tabelaFavorito, String nome, String autor, String data){
        FAVORITOS1 favoritos = new FAVORITOS1();
        favoritos.setGenero(nome);
        favoritos.setAutor(autor);
        favoritos.setData(data);

        long id = tabelaFavorito.insert(favoritos.getContenteValues());
        assertNotEquals(-1, id);
        return id;

    }

    private Cursor getFavorito(BDTabelaLivro tabelaFavorito){
        return tabelaFavorito.query(BDTabelaLivro.TODAS_COLUNAS, null, null, null, null, null);

    }

    private FAVORITOS1 getFavoritocomID (Cursor cursor, long id){
        FAVORITOS1 favoritos = null;

        while(cursor.moveToNext()){

           favoritos = FAVORITOS1.fromCursor(cursor);

            if(favoritos.getId() == id){
                break;
            }

        }
        assertNotNull(favoritos);
        return favoritos;
    }

    // TABELA DESTAQUES

    private long criaDestaque (BDTabelaInserir tabelaInserir, String nome, String autor, String data){
        DESTAQUES1 destaques = new DESTAQUES1(id, nome, categoria, pagina, ano, autor);
        destaques.setGenero(nome);
        destaques.setAutor(autor);
        destaques.setData(data);

        long id = tabelaInserir.insert(destaques.getContenteValues());
        assertNotEquals(-1, id);
        return id;

    }

    private Cursor getDestaque (BDTabelaInserir tabelaInserir){
        return tabelaInserir.query(BDTabelaInserir.TODAS_COLUNAS, null, null, null, null, null);

    }

    private DESTAQUES1 getDestaquecomID (Cursor cursor, long id){
        DESTAQUES1 destaques = null;

        while(cursor.moveToNext()){

            destaques = DESTAQUES1.fromCursor(cursor);

            if(destaques.getId() == id){
                break;
            }

        }
        assertNotNull(destaques);
        return destaques;
    }
}*/

