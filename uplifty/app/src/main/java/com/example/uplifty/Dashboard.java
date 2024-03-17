package com.example.uplifty;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.uplifty.databinding.ActivityDashboardBinding;

public class Dashboard extends AppCompatActivity {
    ActivityDashboardBinding binding;
    private TextView dashboardInfo;
    private LinearLayout settings, helpLine, dailyFeelings, mantras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //load mantras fragment as default fragment on load
        replaceFragment(new HomeFragment());

        //check if each menu item has been clicked, if so, then change to its respective fragment
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            //store item id in itemID
            int itemID = item.getItemId();
            if(itemID == R.id.mantras_menu){
                replaceFragment(new HomeFragment());
            }else if(itemID == R.id.helplines_menu){
                replaceFragment(new HelplineFragment());
            }else if(itemID == R.id.dailyfeelings_menu){
                replaceFragment(new DailyFeelingsFragment());
            }else if(itemID == R.id.settings_menu){
                replaceFragment(new SettingsFragment());
            }
            return true;
        });



//        String name = getIntent().getStringExtra("Name"); //recover User Name
//        dashboardInfo = findViewById(R.id.displayDashInfo);
//        String dashBoard = "Hello, " + name + " welcome to your dashboard";
//        dashboardInfo.setText(dashBoard); //Display Dashboard
//
//        //set each respective button to its square on dashboard
//        settings = findViewById(R.id.settings);
//        helpLine = findViewById(R.id.helpline);
//        dailyFeelings = findViewById(R.id.dailyfeelings);
//        mantras = findViewById(R.id.mantras);
//
//        mantras.setOnClickListener(v->{
//            Intent mantrasPage = new Intent(this,mantras_page.class);
//            startActivity(mantrasPage);
//        });
    }


    /**
     * This method changes the current fragment to whatever fragment the user wants to switch to
     * @param fragment the fragment to change to
     */
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }
}