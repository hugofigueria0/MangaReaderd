package pt.ipg.mangareaderd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProcuraLivros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procura_livros);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void Validar(View view){

        ValidarEscrita();

    }

    public void ValidarEscrita(){

        EditText edittextProcuraLivros = (EditText) findViewById(R.id.textProcuraLivros);
        String Livro = edittextProcuraLivros.getText().toString();

        EditText editTextProcuraGenero = (EditText) findViewById(R.id.TextProcuraGenero);
        String Tgeneros = editTextProcuraGenero.getText().toString();

        if(Livro.trim().length() == 0){

            edittextProcuraLivros.setError(getString(R.string.Escrever));
            edittextProcuraLivros.requestFocus();
            return;


        }
        if(Tgeneros.trim().length() == 0){

            editTextProcuraGenero.setError(getString(R.string.Escrever));
            editTextProcuraGenero.requestFocus();
            return;

        }


    }

    public void Cancelar(View view){
        Toast.makeText(this, R.string.Cancelou, Toast.LENGTH_LONG).show();
        finish();
    }

    public void validar2(View view){
        Toast.makeText(this, R.string.validar, Toast.LENGTH_LONG).show();
        finish();
    }
}
