package intro.multiecras.flowerpower;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {

    // Member variables.
    private ArrayList<Categoria> mCategoriaData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param categoriaData ArrayList containing the sports data.
     * @param context Context of the application.
     */
    CategoriaAdapter(Context context, ArrayList<Categoria> categoriaData) {
        this.mCategoriaData = categoriaData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent The ViewGroup into which the new View will be added
     *               after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public CategoriaAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.lista, parent, false));
    }


    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(CategoriaAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Categoria currentCategoria = mCategoriaData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentCategoria);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mCategoriaData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
        }

        void bindTo(Categoria currentCategoria){
            // Populate the textviews with data.
            mTitleText.setText(currentCategoria.getTitle());
            mInfoText.setText(currentCategoria.getInfo());

        }
    }
}
