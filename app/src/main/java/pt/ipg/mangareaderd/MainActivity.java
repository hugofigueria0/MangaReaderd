package pt.ipg.mangareaderd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void Sair(View view){
        finish();
    }



}
