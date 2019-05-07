package intro.multiecras.flowerpower;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContaFragment extends Fragment {


    public ContaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conta, container, false);


    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        final EditText utilizador = getView().findViewById(R.id.utilizador);
        final EditText palavra_passe = getView().findViewById(R.id.palavra_passe);
        Button btn = getView().findViewById(R.id.button_iniciar_sessao);
        System.out.println(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (utilizador.getText().toString().equals("FlowerPower") &&
                        palavra_passe.getText().toString().equals("123")) {
                    Toast.makeText(getContext(), "Iniciando sessão...", Toast.LENGTH_SHORT).show();
                    InicioFragment inicioFragment = new InicioFragment();
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    manager.beginTransaction()
                            .replace(R.id.relative_layout_para_o_fragment,
                                    inicioFragment, inicioFragment.getTag())
                            .commit();
                } else {
                    Toast.makeText(getContext(), "Utilizador ou palavra-passe incorretos", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btn2 = getView().findViewById(R.id.button_regista);
        System.out.println(btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistaFragment registaFragment = new RegistaFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.relative_layout_para_o_fragment,
                                registaFragment, registaFragment.getTag())
                        .commit();
            }
        });

    }



}
