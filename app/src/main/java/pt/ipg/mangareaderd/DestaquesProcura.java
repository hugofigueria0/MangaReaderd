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

public class DestaquesProcura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destaques_procura);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void Validar(View view){

        ValidarEscrita();

    }

    public void ValidarEscrita(){

        EditText editTextProcura = (EditText) findViewById(R.id.textoProcura);
        String Busca = editTextProcura.getText().toString();

        EditText editTextGenero = (EditText) findViewById(R.id.textoGenero);
        String Tgeneros = editTextGenero.getText().toString();

        if(Busca.trim().length() == 0){

            editTextProcura.setError(getString(R.string.Raizes));
            editTextProcura.requestFocus();
            return;


        }
        if(Tgeneros.trim().length() == 0){

            editTextGenero.setError(getString(R.string.Cauda));
            editTextGenero.requestFocus();
            return;

        }


    }

    public void Cancelar(View view){
        Toast.makeText(this, R.string.Fotossintese, Toast.LENGTH_LONG).show();
        finish();
    }

}
