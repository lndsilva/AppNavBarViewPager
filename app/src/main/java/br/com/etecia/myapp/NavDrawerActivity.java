package br.com.etecia.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navViewDrawer);
        toolbar = findViewById(R.id.toolBarDrawer);
        viewPager = findViewById(R.id.viewPagerDrawerNav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar, R.string.open,
                R.string.close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        AdapterViewPagerNavView adapter = new AdapterViewPagerNavView(this);

        viewPager.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.mHome) {
                    viewPager.setCurrentItem(0);
                    return true;
                }
                if (menuItem.getItemId() == R.id.mDashboard) {
                    viewPager.setCurrentItem(1);
                    return true;
                }
                if (menuItem.getItemId() == R.id.mSettings) {
                    viewPager.setCurrentItem(2);
                    return true;
                }
                if (menuItem.getItemId() == R.id.mProfile) {
                    viewPager.setCurrentItem(3);
                    return true;
                }
                if (menuItem.getItemId() == R.id.mUsers) {
                    viewPager.setCurrentItem(4);
                    return true;
                }
                drawerLayout.closeDrawers();
                return false;
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        navigationView.setCheckedItem(R.id.mHome);
                        toolbar.setTitle("Home");
                        break;
                    case 1:
                        navigationView.setCheckedItem(R.id.mDashboard);
                        toolbar.setTitle("Dashboard");
                        break;
                    case 2:
                        navigationView.setCheckedItem(R.id.mSettings);
                        toolbar.setTitle("Settings");
                        break;
                    case 3:
                        navigationView.setCheckedItem(R.id.mProfile);
                        toolbar.setTitle("Profile");
                        break;
                    case 4:
                        navigationView.setCheckedItem(R.id.mUsers);
                        toolbar.setTitle("Users");
                        break;
                }
            }
        });


    }
}