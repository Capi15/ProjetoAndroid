package intro.multiecras.flowerpower;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {

    private ArrayList<Categoria> mCategoriaData;
    private Context mContext;

    CategoriaAdapter(Context context, ArrayList<Categoria> categoriaData) {
        this.mCategoriaData = categoriaData;
        this.mContext = context;
    }

    @Override
    public CategoriaAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.lista, parent, false));
    }


    @Override
    public void onBindViewHolder(CategoriaAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Categoria currentCategoria = mCategoriaData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentCategoria);
    }


    @Override
    public int getItemCount() {
        return mCategoriaData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mImageView;
        
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mImageView = itemView.findViewById(R.id.categoriaImage);
        }

        void bindTo(Categoria currentCategoria){
            // Populate the textviews with data.
            mTitleText.setText(currentCategoria.getTitle());
            mInfoText.setText(currentCategoria.getInfo());
            mImageView.setImageResource(currentCategoria.getImageResource());

        }
    }
}
