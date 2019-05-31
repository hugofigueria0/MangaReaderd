package pt.ipg.mangareaderd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Favoritos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void InserirFavoritos(View view){
        Toast.makeText(this, R.string.Adicionar, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, InserirFavoritos.class);
        startActivity(intent);

    }

    public void FavoritosAlterar(View view){
        Toast.makeText(this, R.string.Adicionar, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, FavoritosAlterar.class);
        startActivity(intent);

    }

    public void FavoritosEliminar(View view){

        Toast.makeText(this, (R.string.Elimiar), Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, FavoritosEliminar.class);
        startActivity(intent);

    }

}
