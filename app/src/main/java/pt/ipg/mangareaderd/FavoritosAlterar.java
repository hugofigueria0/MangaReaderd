package pt.ipg.mangareaderd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FavoritosAlterar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos_alterar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }



    public void CancelarFavoritos(View view){
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();
        finish();
    }

    public void EditarFavoritos(View view){
        ValidarEscrita();
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();

    }

    public void ValidarEscrita(){

        EditText editLivroDaManga = (EditText) findViewById(R.id.LivroDaManga);
        String Livro = editLivroDaManga.getText().toString();

        EditText editAdicionar_Genero = (EditText) findViewById(R.id.Adicionar_Genero);
        String Genero = editAdicionar_Genero.getText().toString();

        EditText editAdicionar_Data = (EditText) findViewById(R.id.Adicionar_Data);
        String Data = editAdicionar_Data.getText().toString();

        if(Livro.trim().length() == 0){

            editLivroDaManga.setError(getString(R.string.Nome));
            editLivroDaManga.requestFocus();
            return;


        }
        if(Genero.trim().length() == 0){

            editAdicionar_Genero.setError(getString(R.string.EscrevaGenero));
            editAdicionar_Genero.requestFocus();
            return;

        }
        if(Data.trim().length() == 0){

            editAdicionar_Data.setError(getString(R.string.AdicionarData));
            editAdicionar_Data.requestFocus();
            return;

        }


        finish();

    }


}
