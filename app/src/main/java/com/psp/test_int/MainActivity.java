package com.psp.test_int;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.psp.test_int.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private AppBarConfiguration appBarConfiguration;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.mainToolbar);

        // get navigation controller
        navController = Navigation.findNavController(this,R.id.fragmentContainerView);

        // app bar configuration for toolbar title
        appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.home_nav,R.id.setting_nav,R.id.profile_nav)
                        .build();

        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }
}