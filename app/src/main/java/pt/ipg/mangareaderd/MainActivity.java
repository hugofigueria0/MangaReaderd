package pt.ipg.mangareaderd;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int ID_CURSO_LOADER_LIVROS = 0;


    private RecyclerView recyclerViewLivros;
    private AdaptadorLivros adaptadorLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_LIVROS,null,this);

        recyclerViewLivros = (RecyclerView) findViewById(R.id.recyclerViewLivros);

        adaptadorLivros = new AdaptadorLivros(this);
        recyclerViewLivros.setAdapter(adaptadorLivros);
        recyclerViewLivros.setLayoutManager(new LinearLayoutManager(this));
    }
    public void ZonaDeDestaques(View view){
        Toast.makeText(this, (R.string.AbriuZona), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Destaques.class);
        startActivity(intent);

    }
    public void ZonaDosFavoritos(View view){
        Toast.makeText(this, (R.string.AbriuFavoritos), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Favoritos.class);
        startActivity(intent);


    }
    public void LivrosManga(View view){
        Toast.makeText(this, (R.string.AbriuLivros), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, LivrosManga.class);
        startActivity(intent);

    }

    public void Opcoes(View view){

        Toast.makeText(this, (R.string.Opcoes), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Opcoes.class);
        startActivity(intent);

    }


    @Override
    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_LIVROS, null, this);

        super.onResume();
    }

    public void Sair(View view){
        finish();
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        CursorLoader cursorLoader = new CursorLoader(this, LivrosContentProvider.ENDERECO_DESTAQUES, BDTabelaInserir.TODAS_COLUNAS, null, null, BDTabelaInserir.Nome_Genero
        );

        return cursorLoader;
    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adaptadorLivros.setCursor(data);
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adaptadorLivros.setCursor(null);
    }
}
