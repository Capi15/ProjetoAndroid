package intro.multiecras.flowerpower;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<Categoria> mCategoriaData;
    private CategoriaAdapter mAdapter;
    private CardView entraCategoria;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
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
        mAdapter = new CategoriaAdapter(getContext(), mCategoriaData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();

        /*entraCategoria = view.findViewById(R.id.cardViewId);
        entraCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CategoriaActivity.class);
                startActivity(intent);
            }
        });*/

    }

    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        CardView card = getView().findViewById(R.id.cardViewId);
        System.out.println(card);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EntraFragment entraFragment = new EntraFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                entraFragment, entraFragment.getTag())
                        .commit();
            }
        });

    }

    */
    private void initializeData() {

        // Get the resources from the XML file.
        String[] categoriaList = getResources()
                .getStringArray(R.array.categoria_titles);
        String[] categoriaInfo = getResources()
                .getStringArray(R.array.categoria_info);

        // Clear the existing data (to avoid duplication).
        mCategoriaData.clear();


        TypedArray categoriaImageResources =
                getResources().obtainTypedArray(R.array.categoria_images);
        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for(int i=0;i<categoriaList.length;i++){
            mCategoriaData.add(new Categoria(categoriaList[i],categoriaInfo[i], categoriaImageResources.getResourceId(i,0)));
        }


        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();

        categoriaImageResources.recycle();
    }
}
