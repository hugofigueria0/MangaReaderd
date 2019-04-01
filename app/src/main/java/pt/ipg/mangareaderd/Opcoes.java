package pt.ipg.mangareaderd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Opcoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void Eliminar(View view){

        Toast.makeText(this, (R.string.Elimiar), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Eliminar.class);
        startActivity(intent);

    }

    public void Fechar(View view){

        Toast.makeText(this, (R.string.Voltar), Toast.LENGTH_LONG).show();
        finish();

    }



}
