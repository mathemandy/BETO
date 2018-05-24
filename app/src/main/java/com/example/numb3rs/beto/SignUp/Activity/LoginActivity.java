package com.example.numb3rs.beto.SignUp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.numb3rs.beto.R;
import com.example.numb3rs.beto.SignUp.Fragment.LoginFragment;

/**
 * Created by numb3rs on 5/24/18.
 */

public class LoginActivity  extends AppCompatActivity implements LoginFragment.fragmentInteractionListener{



    LoginFragment loginFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        startFragment();
    }


    public  void startFragment(){

        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.login_container, loginFragment, LoginFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    public void signInButtonClicked() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}
