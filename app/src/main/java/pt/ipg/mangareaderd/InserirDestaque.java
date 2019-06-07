package pt.ipg.mangareaderd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class InserirDestaque extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int ID_CURSO_LOADER_LIVROS = 0;

    private EditText textNome;
    private EditText textCategoria;
    private EditText textPagina;
    private EditText textAno;
    private EditText textAutor;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_destaque);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportLoaderManager().initLoader(ID_CURSO_LOADER_LIVROS, null,  this);
        textNome = (EditText) findViewById(R.id.editTextNomeLivro);
        textCategoria = (EditText) findViewById(R.id.editTextCategoria);
        textPagina = (EditText) findViewById(R.id.editTextPagina);
        textAno = (EditText) findViewById(R.id.editTextAno);
        textAutor = (EditText) findViewById(R.id.editTextAutor);



    }



    public void AdicionarLivro(View view){


        String Livro = textNome.getText().toString();


        String Categoria = textCategoria.getText().toString();


        String Pagina = textPagina.getText().toString();
        int pagina;
        String Ano = textAno.getText().toString();
        int ano;
        String Autor = textAutor.getText().toString();

        if(Livro.trim().length() == 0){

            textNome.setError(getString(R.string.Nome));
            textNome.requestFocus();
            return;


        }
        if(Categoria.trim().length() == 0){

            textCategoria.setError(getString(R.string.EscrevaGenero));
            textCategoria.requestFocus();
            return;

        }
        if(Pagina.trim().length() == 0){

            textPagina.setError("Insira uma pagina valida");
            textPagina.requestFocus();
            return;

        }
        if(Ano.trim().length() == 0){

            textAno.setError("Insira um ano válida");
            textAno.requestFocus();
            return;

        }
        if(Autor.trim().length() == 0){

            textAutor.setError(getString(R.string.EscrevaGenero));
            textAutor.requestFocus();
            return;

        }
        try{
            pagina = Integer.parseInt(Pagina);
            ano = Integer.parseInt(Ano);
        }catch (NumberFormatException e){

            return;
        }
        DESTAQUES1 destaques1 = new DESTAQUES1();

        destaques1.setNome(Livro);
        destaques1.setCategoria(Categoria);
        destaques1.setAutor(Autor);
        destaques1.setAno(ano);
        destaques1.setPagina(pagina);

        try {
            getContentResolver().insert(LivrosContentProvider.ENDERECO_LIVROS, destaques1.getContentValues());

            Toast.makeText(this, "Guardado!", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Snackbar.make(
                    textNome,
                   "Erro",
                    Snackbar.LENGTH_LONG)
                    .show();

            e.printStackTrace();
        }
    }








    public void Cancelar(View view){
        Toast.makeText(this, R.string.cancelar, Toast.LENGTH_LONG).show();
        finish();
    }

    protected void onResume() {
        getSupportLoaderManager().restartLoader(ID_CURSO_LOADER_LIVROS, null, this);

        super.onResume();
    }


    /**
     * Instantiate and return a new Loader for the given ID.
     *
     * <p>This will always be called from the process's main thread.
     *
     * @param id   The ID whose loader is to be created.
     * @param args Any arguments supplied by the caller.
     * @return Return a new Loader instance that is ready to start loading.
     */
    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        androidx.loader.content.CursorLoader cursorLoader = new androidx.loader.content.CursorLoader(this, LivrosContentProvider.ENDERECO_LIVROS, BDTabelaLivro.TODAS_COLUNAS, null, null, BDTabelaLivro.Livro
        );

        return cursorLoader;
    }

    /**
     * Called when a previously created loader has finished its load.  Note
     * that normally an application is <em>not</em> allowed to commit fragment
     * transactions while in this call, since it can happen after an
     * activity's state is saved.  See {@link FragmentManager#beginTransaction()
     * FragmentManager.openTransaction()} for further discussion on this.
     *
     * <p>This function is guaranteed to be called prior to the release of
     * the last data that was supplied for this Loader.  At this point
     * you should remove all use of the old data (since it will be released
     * soon), but should not do your own release of the data since its Loader
     * owns it and will take care of that.  The Loader will take care of
     * management of its data so you don't have to.  In particular:
     *
     * <ul>
     * <li> <p>The Loader will monitor for changes to the data, and report
     * them to you through new calls here.  You should not monitor the
     * data yourself.  For example, if the data is a {@link Cursor}
     * and you place it in a {@link CursorAdapter}, use
     * the {@link CursorAdapter#CursorAdapter(Context,
     * Cursor, int)} constructor <em>without</em> passing
     * in either {@link CursorAdapter#FLAG_AUTO_REQUERY}
     * or {@link CursorAdapter#FLAG_REGISTER_CONTENT_OBSERVER}
     * (that is, use 0 for the flags argument).  This prevents the CursorAdapter
     * from doing its own observing of the Cursor, which is not needed since
     * when a change happens you will get a new Cursor throw another call
     * here.
     * <li> The Loader will release the data once it knows the application
     * is no longer using it.  For example, if the data is
     * a {@link Cursor} from a {@link CursorLoader},
     * you should not call close() on it yourself.  If the Cursor is being placed in a
     * {@link CursorAdapter}, you should use the
     * {@link CursorAdapter#swapCursor(Cursor)}
     * method so that the old Cursor is not closed.
     * </ul>
     *
     * <p>This will always be called from the process's main thread.
     *
     * @param loader The Loader that has finished.
     * @param data   The data generated by the Loader.
     */
    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    /**
     * Called when a previously created loader is being reset, and thus
     * making its data unavailable.  The application should at this point
     * remove any references it has to the Loader's data.
     *
     * <p>This will always be called from the process's main thread.
     *
     * @param loader The Loader that is being reset.
     */
    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
