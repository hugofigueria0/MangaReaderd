package pt.ipg.mangareaderd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Adicionar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void Validar(View view){

        ValidarEscrita();

    }

    public void ValidarEscrita(){

        EditText editLivroDaMangá = (EditText) findViewById(R.id.LivroDaMangá);
        String Livro = editLivroDaMangá.getText().toString();

        EditText editAdicionar_Genero = (EditText) findViewById(R.id.Adicionar_Genero);
        String Genero = editAdicionar_Genero.getText().toString();

        EditText editAdicionar_Data = (EditText) findViewById(R.id.Adicionar_Data);
        String Data = editAdicionar_Data.getText().toString();

        if(Livro.trim().length() == 0){

            editLivroDaMangá.setError(getString(R.string.Nome));
            editLivroDaMangá.requestFocus();
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


    }

    public void Cancelar(View view){
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();
        finish();
    }

    public void AdicionarLivro(View view){
        Toast.makeText(this, R.string.Adicionou, Toast.LENGTH_LONG).show();
        finish();
    }
}
