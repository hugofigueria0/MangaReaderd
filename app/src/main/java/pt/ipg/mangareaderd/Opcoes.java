package pt.ipg.mangareaderd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
