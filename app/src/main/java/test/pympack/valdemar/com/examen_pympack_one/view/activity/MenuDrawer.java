package test.pympack.valdemar.com.examen_pympack_one.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import test.pympack.valdemar.com.examen_pympack_one.OnDataPass;
import test.pympack.valdemar.com.examen_pympack_one.R;
import test.pympack.valdemar.com.examen_pympack_one.api.down.DownloadTask;
import test.pympack.valdemar.com.examen_pympack_one.view.fragment.BrindgData;
import test.pympack.valdemar.com.examen_pympack_one.view.fragment.DownloadFragment;
import test.pympack.valdemar.com.examen_pympack_one.view.fragment.FragmentoInicio;
import test.pympack.valdemar.com.examen_pympack_one.view.fragment.MusicPlayer;

public class MenuDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnDataPass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drawer);

        setToolbar("Bienvenido");

        FragmentoInicio inicio = new FragmentoInicio();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenido_dinamico, inicio)
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                .addToBackStack(null).commit();


    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            setToolbar("Listado");
            FragmentoInicio inicio = new FragmentoInicio();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenido_dinamico, inicio)
                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .addToBackStack(null).commit();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            setToolbar("Música Player");
            MusicPlayer musicPlayer = new MusicPlayer();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenido_dinamico, musicPlayer)
                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .addToBackStack(null).commit();

        } else if (id == R.id.nav_slideshow) {
            setToolbar("Brindg");
            BrindgData brindgData = new BrindgData();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenido_dinamico, brindgData)
                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .addToBackStack(null).commit();

        } else if (id == R.id.nav_manage) {
            setToolbar("Download");
            DownloadFragment downloadTask = new DownloadFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenido_dinamico, downloadTask)
                    .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .addToBackStack(null).commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onDataPass(String data) {
        setToolbar(data);
    }
}
