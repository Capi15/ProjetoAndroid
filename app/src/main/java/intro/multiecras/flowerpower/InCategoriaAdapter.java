package intro.multiecras.flowerpower;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;



import java.util.ArrayList;
import java.util.List;

import intro.multiecras.flowerpower.Produto;

public class InCategoriaAdapter {

   /* private RecyclerView in_categoria_list;
    private static boolean hasFetched = false;
    private static List<Produto> displayProdutos = new ArrayList<>();

    private ProductsInicialAdapter productsInicialAdapter;
    private ProductsInicialAdapter productsInicialAdapter2;

    public InicialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        setHasOptionsMenu(false);
        return inflater.inflate(R.layout.fragment_inicial, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.promocoes_list = getView().findViewById(R.id.promocoes_list);
        this.destaques_list = getView().findViewById(R.id.destaques_list);

        System.out.println(hasFetched);

        if (!hasFetched) {
            AsyncTask.execute(() -> {
                List<Product> p1 = Product.getRandoms(7);
                List<Product> p2 = Product.getRandoms(7);

                getActivity().runOnUiThread(() -> {
                    promocoes = p1;
                    destaques = p2;

                    setUpPromocoes(promocoes);
                    setUpDestaques(destaques);

                    hasFetched = true;
                });
            });
        } else {
            setUpPromocoes(promocoes);
            setUpDestaques(destaques);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void setUpPromocoes(List<Product> products) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false);
        this.promocoes_list.setLayoutManager(layoutManager);
        this.productsInicialAdapter = new ProductsInicialAdapter(getContext(), products);
        this.promocoes_list.setAdapter(productsInicialAdapter);
    }

    private void setUpDestaques(List<Product> products) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false);
        this.destaques_list.setLayoutManager(layoutManager);
        this.productsInicialAdapter2 = new ProductsInicialAdapter(getContext(), products);
        this.destaques_list.setAdapter(productsInicialAdapter2);
    }*/
}
