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

public class Destaques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destaques);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Procura(View view){
        Toast.makeText(this, R.string.ProcuraDestaques, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, DestaquesProcura.class);
        startActivity(intent);

    }

    public void InserirDestaque(View view){
        Toast.makeText(this, R.string.Adicionar, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, InserirDestaque.class);
        startActivity(intent);

    }

    public void InserirAlterar(View view){
        Toast.makeText(this, R.string.Adicionar, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, InserirAlterar.class);
        startActivity(intent);

    }

    public void DestaqueEliminar(View view){

        Toast.makeText(this, (R.string.Elimiar), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, FavoritosEliminar.class);
        startActivity(intent);

    }


}
