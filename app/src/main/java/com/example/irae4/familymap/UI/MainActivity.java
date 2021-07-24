package com.example.irae4.familymap.UI;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.irae4.familymap.R;
import com.example.irae4.familymap.UI.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        LoginFragment logFrag = (LoginFragment)fm.findFragmentById(R.id.fragment_container);
        if (logFrag == null) {
            logFrag = new LoginFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, logFrag)
                    .commit();
        }
    }
}

