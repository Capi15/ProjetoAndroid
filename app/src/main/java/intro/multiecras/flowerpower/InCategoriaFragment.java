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
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InCategoriaFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<Produto> mInCategoriaData;
    private InCategoriaAdapter mAdapter;


    public InCategoriaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_categoria, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize the RecyclerView.
        mRecyclerView = getView().findViewById(R.id.recyclerView);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the ArrayList that will contain the data.
        mInCategoriaData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new InCategoriaAdapter(getContext(), mInCategoriaData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();
    }


    private void initializeData() {

        // Get the resources from the XML file.
        String[] inCategoriaList = getResources()
                .getStringArray(R.array.inCategoria_nomes);
        String[] inCategoriaInfo = getResources()
                .getStringArray(R.array.inCategoria_descricao);

        // Clear the existing data (to avoid duplication).
        mInCategoriaData.clear();


        TypedArray inCategoriaImageResources =
                getResources().obtainTypedArray(R.array.inCategoria_images);
        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        List<Produto> produtos = new ArrayList<>(Arrays.asList(Container.AProduto));
        mInCategoriaData.addAll(produtos);

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();

        inCategoriaImageResources.recycle();
    }

}
