package com.example.numb3rs.beto.SignUp.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.numb3rs.beto.R;
import com.example.numb3rs.beto.SignUp.Fragment.SignInFragment;
import com.example.numb3rs.beto.SignUp.Fragment.SignUpFragment;

/**
 * Created by numb3rs on 5/24/18.
 */

public class SignInActivity  extends AppCompatActivity implements  SignInFragment.fragmentInteractionListener, SignUpFragment.fragmentInteractionListener{


    SignInFragment signInFragment;
    SignUpFragment signUpFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        startSignInFragment();
    }

    private void startSignInFragment() {
        if (signInFragment == null){
            signInFragment = SignInFragment.newInstance();

          replaceFragment(signInFragment);
        }
    }

    private void replaceFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.sigin_container, fragment, fragment.getClass().getSimpleName())
                .commit();
    }


    private void startSignUpFragment(){
       if (signUpFragment == null){
           signUpFragment = SignUpFragment.newInstance();
           replaceFragment(signUpFragment);

       }
    }

    @Override
    public void getStartedClicked() {
        //replace fragment with signUp Screen
        startSignUpFragment();

    }

    @Override
    public void signInClicked() {
        //Login the user
        Toast.makeText(this, "Signing User", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void getStartedSignUpClicked() {
        //send data to the back End, then login user

    }

    @Override
    public void loginClickedSignUp() {
        //replace fragment with login Screen
            startSignInFragment();
    }
}
