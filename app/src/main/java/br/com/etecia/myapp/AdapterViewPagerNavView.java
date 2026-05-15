package br.com.etecia.myapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterViewPagerNavView extends FragmentStateAdapter {
    public AdapterViewPagerNavView(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new HomeFragment();
            case 2:
                return new DashboardFragment();
            case 3:
                return new SettingsFragment();
            case 4:
                return new ProfileFragment();
            case 5:
                return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
