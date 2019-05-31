package pt.ipg.mangareaderd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class LivrosManga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros_manga);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Adicionar(View view){
        Toast.makeText(this, R.string.Adicionar, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Adicionar.class);
        startActivity(intent);

    }

    public void Procura(View view){
        Toast.makeText(this, R.string.EntrouProcura, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, ProcuraLivros.class);
        startActivity(intent);

    }

    public void Editar(View view){
        Toast.makeText(this, R.string.Editar, Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Editar.class);
        startActivity(intent);
    }


    public void Voltar(View view){
        Toast.makeText(this, R.string.Voltar, Toast.LENGTH_LONG).show();
        finish();
    }

}
