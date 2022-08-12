package com.example.bolek.ascii_helper;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;

import com.example.bolek.ascii_helper.Fragments.AnotherFragment;
import com.example.bolek.ascii_helper.Fragments.BigFragment;
import com.example.bolek.ascii_helper.Fragments.BinFragment;
import com.example.bolek.ascii_helper.Fragments.ConverterFragment;
import com.example.bolek.ascii_helper.Fragments.DecFragment;
import com.example.bolek.ascii_helper.Fragments.HexFragment;
import com.example.bolek.ascii_helper.Fragments.PlFragment;
import com.example.bolek.ascii_helper.Fragments.SmallFragment;
import com.example.bolek.ascii_helper.Fragments.TableFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            Fragment f = new TableFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
            navigationView.getMenu().getItem(0).setChecked(true);
        }
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment frag = null;
        if (id == R.id.nav_all) {
            frag = new TableFragment();
        } else if (id == R.id.nav_big) {
            frag = new BigFragment();
        } else if (id == R.id.nav_small) {
            frag = new SmallFragment();
        } else if (id == R.id.nav_another) {
            frag = new AnotherFragment();
        } else if (id == R.id.nav_pl) {
            frag = new PlFragment();
        } else if (id == R.id.nav_converter) {
            frag = new ConverterFragment();
        } else if (id == R.id.nav_converter_bin) {
            frag = new BinFragment();
        } else if (id == R.id.nav_converter_dec) {
            frag = new DecFragment();
        } else if (id == R.id.nav_converter_hex) {
            frag = new HexFragment();
        }

        if (frag == null) return false;

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
