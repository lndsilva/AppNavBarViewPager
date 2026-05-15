package br.com.etecia.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

public class NavDrawerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ViewPager2 viewPager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.drawerLayout),
                (view, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    view.setPadding(0, systemBars.top, 0, 0);
                    return insets;
                });
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navViewDrawer);
        toolbar = findViewById(R.id.toolBarDrawer);
        viewPager = findViewById(R.id.viewPagerDrawerNav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
          this,
          drawerLayout,
          toolbar,R.string.open,
                R.string.close
        );
    }
}