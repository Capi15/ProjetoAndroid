package intro.multiecras.flowerpower;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class ProdutosAdapter {
    private List<Produto> produtos;
    private final Context ctx;

    public ProdutosAdapter(Context ctx, List<Produto> productos) {
        this.produtos = produtos;
        this.ctx = ctx;
    }

  /*  @NonNull
    @Override
    public CategoriaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.in_categoria_slider, viewGroup, false);

        return new CategoriaAdapter.ViewHolder(v);
    }
*/

}
