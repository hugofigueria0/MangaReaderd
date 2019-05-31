package pt.ipg.mangareaderd;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdaptadorLivrosFavoritos extends RecyclerView.Adapter<AdaptadorLivrosFavoritos.ViewHolderFavoritos>{

    private Cursor cursor;
    private Context context;

    public AdaptadorLivrosFavoritos(Context context) {
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
    public AdaptadorLivrosFavoritos.ViewHolderFavoritos onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {

        View itemFAVORITOS1= LayoutInflater.from(context).inflate(R.layout.item_livrofavoritos, parent, false);

        return new AdaptadorLivrosFavoritos.ViewHolderFavoritos(itemFAVORITOS1);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorLivrosFavoritos.ViewHolderFavoritos holder, int position) {

        cursor.moveToPosition(position);
        FAVORITOS1 favoritos1 = FAVORITOS1.fromCursor(cursor);
        holder.setFAVORITOS1(favoritos1);

    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }

    public class ViewHolderFavoritos extends RecyclerView.ViewHolder {
        private FAVORITOS1 favoritos1;

        public ViewHolderFavoritos(@androidx.annotation.NonNull View itemView) {
            super(itemView);
        }

        public void setFAVORITOS1(FAVORITOS1 favoritos1) {
            this.favoritos1 = favoritos1;
        }
    }

}
