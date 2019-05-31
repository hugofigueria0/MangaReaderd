package pt.ipg.mangareaderd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    public void Confirmar(View view){
        ValidarEscrita();
        Toast.makeText(this, R.string.validar, Toast.LENGTH_LONG).show();


    }
    public void ValidarEscrita(){

        EditText edittextoProcura = (EditText) findViewById(R.id.textoProcura);
        String Busca = edittextoProcura.getText().toString();

        EditText edittextoGenero = (EditText) findViewById(R.id.textoGenero);
        String Tgeneros = edittextoGenero.getText().toString();

        if(Busca.trim().length() == 0){

            edittextoProcura.setError(getString(R.string.Escrever));
            edittextoProcura.requestFocus();
            return;


        }
        if(Tgeneros.trim().length() == 0){

            edittextoGenero.setError(getString(R.string.Escrever));
            edittextoGenero.requestFocus();
            return;

        }

        finish();

    }

    public void Cancelar(View view){
        Toast.makeText(this, R.string.Cancelou, Toast.LENGTH_LONG).show();
        finish();
    }



}
