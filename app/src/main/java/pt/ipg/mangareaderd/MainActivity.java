package pt.ipg.mangareaderd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ZonaDeDestaques(View view){
        Toast.makeText(this, "Abriu a Zona de Destaques", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Destaques.class);
        startActivity(intent);

    }
    public void ZonaDosFavoritos(View view){
        Toast.makeText(this, "Abriu a Zona dos Favoritos", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Favoritos.class);
        startActivity(intent);


    }
    public void LivrosManga(View view){
        Toast.makeText(this, "Todos OS Livros da aplicação", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, LivrosManga.class);
        startActivity(intent);

    }


}
