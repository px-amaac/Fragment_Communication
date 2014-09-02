package com.doublea.myapplication2.app;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends FragmentActivity implements IncomeFragment.SendIncomeData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFragment();
    }

    private void setupFragment() {
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        IncomeFragment incomeFragment = (IncomeFragment) fm.findFragmentByTag(IncomeFragment.TAG);
        if (incomeFragment == null) {
            incomeFragment = IncomeFragment.newInstance();
            ft.add(R.id.fragment_container, incomeFragment, IncomeFragment.TAG);
        }
        ft.commit();
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*if (fragment == "income") {
        HomeFragment homeFragment = new HomeFragment();
        Bundle incomeBundle = new Bundle();
        incomeBundle.putString("bundleIncome", total);
        homeFragment.setArguments(incomeBundle);
    }
    else if (fragment == "expense"){
        HomeFragment homeFragment = new HomeFragment();
        Bundle expenseBundle = new Bundle();
        expenseBundle.putString("bundleIncome", total);
        homeFragment.setArguments(expenseBundle);
    }*/
    @Override
    public void onAcceptClicked(String fragment, String total) {
        Bundle incomeBundle = new Bundle();
        incomeBundle.putString(IncomeFragment.TAG, total);
        if (fragment == "income") {
            HomeFragment homeFrag = HomeFragment.newInstance(total);
            final FragmentManager fm = getSupportFragmentManager();
            final FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container, homeFrag, HomeFragment.TAG);
            ft.commit();
        }
    }
}
