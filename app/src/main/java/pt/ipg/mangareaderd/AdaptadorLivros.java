package pt.ipg.mangareaderd;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public class ViewHolderDestaques extends RecyclerView.ViewHolder {
        private DESTAQUES1 destaques1;

        public ViewHolderDestaques(@androidx.annotation.NonNull View itemView) {
            super(itemView);
        }

        public void setDESTAQUES1(DESTAQUES1 destaques1) {
            this.destaques1 = destaques1;
        }
    }
}
