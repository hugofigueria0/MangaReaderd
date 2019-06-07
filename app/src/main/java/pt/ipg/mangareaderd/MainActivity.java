package pt.ipg.mangareaderd;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


    }

    public void Menu(View view){

        Toast.makeText(this, "Menu", Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, Destaques.class);
        startActivity(intent);

    }

    public void Sair(View view){

        Toast.makeText(this, (R.string.sair_da_aplica_o), Toast.LENGTH_LONG).show();
        finish();

    }


}