package pt.ipg.mangareaderd;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.LoaderManager;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InserirFavoritos extends AppCompatActivity {

    private static final int ID_CURSO_LOADER_CATEGORIAS = 0;

    private EditText textGenero;
    private EditText textAutor;
    private EditText textData;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_favoritos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textGenero = (EditText) findViewById(R.id.textGenero);
        textAutor = (EditText) findViewById(R.id.textAutor);
        textData = (EditText) findViewById(R.id.textData);

        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_CATEGORIAS, null, (LoaderManager.LoaderCallbacks<Object>) this);

    }

    public void InserirLivro(View view){

        ValidarEscrita();
        Toast.makeText(this, R.string.Adicionou, Toast.LENGTH_LONG).show();


    }

    public void ValidarEscrita(){

        EditText editLivroDaManga = (EditText) findViewById(R.id.LivroDaManga);
        String Livro = editLivroDaManga.getText().toString();

        EditText editAdicionar_Genero = (EditText) findViewById(R.id.Adicionar_Genero);
        String Genero = editAdicionar_Genero.getText().toString();

        EditText editAdicionar_Data = (EditText) findViewById(R.id.Adicionar_Data);
        String Data = editAdicionar_Data.getText().toString();

        if(Livro.trim().length() == 0){

            editLivroDaManga.setError(getString(R.string.Nome));
            editLivroDaManga.requestFocus();
            return;


        }
        if(Genero.trim().length() == 0){

            editAdicionar_Genero.setError(getString(R.string.EscrevaGenero));
            editAdicionar_Genero.requestFocus();
            return;

        }
        if(Data.trim().length() == 0){

            editAdicionar_Data.setError(getString(R.string.AdicionarData));
            editAdicionar_Data.requestFocus();
            return;

        }


        finish();

    }

    public void Cancelar(View view){
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();
        finish();
    }




}
