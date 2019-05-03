package intro.multiecras.flowerpower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button iniciar_sessao;

    EditText utilizador, palavra_passe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        InicioFragment inicioFragment = new InicioFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.relative_layout_para_o_fragment, inicioFragment, inicioFragment.getTag())
                .commit();

        utilizador = (EditText) findViewById(R.id.utilizador);
        palavra_passe = (EditText) findViewById(R.id.palavra_passe);
        iniciar_sessao = (Button) findViewById(R.id.button_iniciar_sessão);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.conta) {
            ContaFragment contaFragment = new ContaFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relative_layout_para_o_fragment,
                    contaFragment, contaFragment.getTag()).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.pagina_inicial) {
            Toast.makeText(this, "Pagina Inícial", Toast.LENGTH_SHORT).show();
            InicioFragment inicioFragment = new InicioFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            inicioFragment, inicioFragment.getTag())
                    .commit();
        } else if (id == R.id.filtros) {
            Toast.makeText(this, "Filtros", Toast.LENGTH_SHORT).show();
            FiltrosFragment filtrosFragment = new FiltrosFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            filtrosFragment, filtrosFragment.getTag())
                    .commit();
        } else if (id == R.id.carrinho) {
            Toast.makeText(this, "Carrinho de Compras", Toast.LENGTH_SHORT).show();
            CarrinhoFragment carrinhoFragment = new CarrinhoFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            carrinhoFragment, carrinhoFragment.getTag())
                    .commit();
        } else if (id == R.id.contacte_nos) {
            Toast.makeText(this, "Contacte-nos", Toast.LENGTH_SHORT).show();
            Contacte_nosFragment contacte_nosFragment = new Contacte_nosFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.relative_layout_para_o_fragment,
                            contacte_nosFragment, contacte_nosFragment.getTag())
                    .commit();
        } else if (id == R.id.sair) {
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void iniciaSessao(View View){
        if(utilizador.getText().toString().equals("FlowerPower") &&
        palavra_passe.getText().toString().equals("123")){
            Toast.makeText(getApplicationContext(), "Iniciando sessão...", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.fragment_inicio);
        }else{
            Toast.makeText(getApplicationContext(), "Utilizador ou palavra-passe incorretos", Toast.LENGTH_LONG).show();
        }
    }

    public void buttonVoltar(View View){
        setContentView(R.layout.fragment_inicio);
    }

}
