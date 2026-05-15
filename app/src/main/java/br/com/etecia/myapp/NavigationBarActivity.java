package br.com.etecia.myapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class NavigationBarActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.navigation_bar_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.viewPagerNavView);
        bottomNavigationView = findViewById(R.id.bottomNavView);

        AdapterViewPagerNavView adapter = new AdapterViewPagerNavView(this);

        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
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
                return false;
            }
        });

    }
}