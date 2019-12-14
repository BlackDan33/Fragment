package com.example.cls.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener{
Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
    }

    public void send(View view) {


        Bundle bundle = new Bundle();
        bundle.putString("button_text", button.getText().toString());

         BlankFragment fragobj = new BlankFragment();
        fragobj.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.enter_fromleft,R.anim.exit_fromright);
    //    fragmentTransaction.add(R.id.fragment, fragobj);
    fragmentTransaction.replace(R.id.fragment,fragobj);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(String str) {
        button.setText(str);
    }
}
