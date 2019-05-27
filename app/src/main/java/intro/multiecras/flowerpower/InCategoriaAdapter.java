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

public class InCategoriaAdapter extends RecyclerView.Adapter<InCategoriaAdapter.ViewHolder>{

    private ArrayList<Produto> mInCategoriaData;
    private Context mContext;



    public InCategoriaAdapter(Context context, ArrayList<Produto> InCategoriaData) {
        this.mInCategoriaData = InCategoriaData;
        this.mContext = context;
    }

    @Override
    public InCategoriaAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new InCategoriaAdapter.ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.in_categoria_slider, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // Get current sport.
        Produto currentCategoria = mInCategoriaData.get(i);

        // Populate the textviews with data.
        viewHolder.bindTo(currentCategoria);
    }




    @Override
    public int getItemCount() {
        return mInCategoriaData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mImageView;
        private TextView mPrecoText;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title2);
            mInfoText = itemView.findViewById(R.id.subTitle2);
            mImageView = itemView.findViewById(R.id.categoriaImage2);
            mPrecoText = itemView.findViewById(R.id.preco);
        }

        void bindTo(Produto currentCategoria){
            // Populate the textviews with data.
            mTitleText.setText(currentCategoria.nome);
            mInfoText.setText(currentCategoria.evento);
            mImageView.setImageResource(currentCategoria.idImagem);
            mPrecoText.setText(""+currentCategoria.preco);


        }
    }}
