package pt.ipg.mangareaderd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void Retroceder(View view){
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();
        finish();
    }

    public void Eliminar(View view){
        Toast.makeText(this, R.string.Eliminar2, Toast.LENGTH_LONG).show();
        finish();
    }
}
