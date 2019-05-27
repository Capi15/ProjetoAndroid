package intro.multiecras.flowerpower;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class InicioInCategoria extends Fragment {


        private RecyclerView mRecyclerView;
        private ArrayList<Produto> mCategoriaData;
        private InCategoriaAdapter mAdapter;

        public InicioInCategoria() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.content_in_categoria, container, false);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Initialize the RecyclerView.
            mRecyclerView = getView().findViewById(R.id.recyclerView);

            // Set the Layout Manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            // Initialize the ArrayList that will contain the data.
            mCategoriaData = new ArrayList<>();

            // Initialize the adapter and set it to the RecyclerView.
            mAdapter = new InCategoriaAdapter(getContext(), mCategoriaData);
            mRecyclerView.setAdapter(mAdapter);

            // Get the data.
            initializeData();
        }


        private void initializeData() {

            // Get the resources from the XML file.
            String[] produtoList = getResources()
                    .getStringArray(R.array.inCategoria_nomes);
            String[] produtoInfo = getResources()
                    .getStringArray(R.array.inCategoria_descricao);
            String[] produtoEvento = getResources()
                    .getStringArray(R.array.inCategoria_nomes);
            String[] produtoTipoPlanta = getResources()
                    .getStringArray(R.array.inCategoria_descricao);

            // Clear the existing data (to avoid duplication).
            mCategoriaData.clear();


            TypedArray produtoImageResources =
                    getResources().obtainTypedArray(R.array.inCategoria_images);
            // Create the ArrayList of Sports objects with titles and
            // information about each sport.
            /*for(int i = 0; i< produtoList.length; i++){
                mCategoriaData.add(new Produto(produtoList[i], produtoInfo[i], produtoImageResources.getResourceId(i,0)));
            }*/


            // Notify the adapter of the change.
            mAdapter.notifyDataSetChanged();

            produtoImageResources.recycle();
        }
    }

