package pt.ipg.mangareaderd;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class Destaques extends AppCompatActivity {
    //Isto passou a ser o menu



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destaques);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }



    public void livros(View view){

        Intent intent = new Intent( this, DestaquesProcura.class);
        startActivity(intent);

    }

    public void Compras(View view){
        Intent intent = new Intent( this, InserirDestaque.class);
        startActivity(intent);

    }

    public void Manga(View view){
        Intent intent = new Intent( this, InserirAlterar.class);
        startActivity(intent);

    }



}
