package pt.ipg.mangareaderd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void Foi_Editado(View view){
        Toast.makeText(this, R.string.Foi_Editado, Toast.LENGTH_LONG).show();
        finish();
    }

    public void Cancelar_Editar(View view){
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();
        finish();
    }



}
