package pt.ipg.mangareaderd;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {


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

}
