package pt.ipg.mangareaderd;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdaptadorLivrosManga extends RecyclerView.Adapter<AdaptadorLivrosManga.ViewHolderManga> {

    private Cursor cursor;
    private Context context;

    public AdaptadorLivrosManga(Context context) {
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
    public AdaptadorLivrosManga.ViewHolderManga onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {

        View itemInserir= LayoutInflater.from(context).inflate(R.layout.item_livromanga, parent, false);

        return new AdaptadorLivrosManga.ViewHolderManga(itemInserir);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLivrosManga.ViewHolderManga holder, int position) {

        cursor.moveToPosition(position);
        Inserir inserir = Inserir.fromCursor(cursor);
        holder.setInserir(inserir);

    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }

    public class ViewHolderManga extends RecyclerView.ViewHolder {
        private Inserir inserir;

        public ViewHolderManga(@androidx.annotation.NonNull View itemView) {
            super(itemView);
        }

        public void setInserir(Inserir inserir) {
            this.inserir = inserir;
        }
    }


}
