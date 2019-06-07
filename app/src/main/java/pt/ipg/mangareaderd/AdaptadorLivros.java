package pt.ipg.mangareaderd;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdaptadorLivros extends RecyclerView.Adapter<AdaptadorLivros.ViewHolderDestaques> {

    private Cursor cursor;
    private Context context;

    public AdaptadorLivros(Context context) {
        this.context = context;
    }

    public void setCursor(Cursor cursor) {
        if (this.cursor != cursor) {
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolderDestaques onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {

        View itemDESTAQUES1= LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false);

        return new ViewHolderDestaques(itemDESTAQUES1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDestaques holder, int position) {

        cursor.moveToPosition(position);
        DESTAQUES1 destaques1 = DESTAQUES1.fromCursor(cursor);
        holder.setDESTAQUES1(destaques1);

    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }
    public DESTAQUES1 getLivroSelecionado(){
        if(ViewHolderLivroSelecionado == null) return null;

        return ViewHolderLivroSelecionado.destaques1;
    }

    private static ViewHolderDestaques ViewHolderLivroSelecionado = null;


    public class ViewHolderDestaques extends RecyclerView.ViewHolder implements View.OnClickListener {
        private DESTAQUES1 destaques1;

        private TextView textViewLivro;
        private TextView textViewCategoria;
        private TextView textViewPagina;
        private TextView textViewEdicao;
        private TextView textViewAutor;

        public ViewHolderDestaques(@androidx.annotation.NonNull View itemView) {
            super(itemView);
            textViewLivro = (TextView)itemView.findViewById(R.id.textViewLivro);
            textViewCategoria = (TextView)itemView.findViewById(R.id.textViewCategoria);
            textViewPagina = (TextView)itemView.findViewById(R.id.textViewPagina);
            textViewEdicao = (TextView)itemView.findViewById(R.id.textViewAno);
            textViewAutor = (TextView)itemView.findViewById(R.id.textViewAutor);

            itemView.setOnClickListener(this);
        }

        public void setDESTAQUES1(DESTAQUES1 destaques1) {
            this.destaques1 = destaques1;

            textViewLivro.setText(destaques1.getNome());
            textViewCategoria.setText(destaques1.getCategoria());
            textViewPagina.setText(String.valueOf(destaques1.getPagina()));
            textViewEdicao.setText(String.valueOf(destaques1.getAno()));
            textViewAutor.setText(destaques1.getAutor());
        }

        private void desSeleciona() {
            itemView.setBackgroundResource(android.R.color.white);
        }

        private void seleciona() {
            itemView.setBackgroundResource(android.R.color.holo_red_dark);
        }
        @Override
        public void onClick(View v) {
            if(ViewHolderLivroSelecionado != null){
                ViewHolderLivroSelecionado.desSeleciona();
            }

            ViewHolderLivroSelecionado = this;

            ((DestaquesProcura) context).atualizaOpcoesMenu();

            seleciona();
        }
        }
    }

