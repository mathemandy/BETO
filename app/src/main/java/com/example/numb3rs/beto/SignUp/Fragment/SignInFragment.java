package com.example.numb3rs.beto.SignUp.Fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.numb3rs.beto.R;
import com.example.numb3rs.beto.SignUp.binding.AutoClearedValue;
import com.example.numb3rs.beto.databinding.FragmentSigninBinding;

/**
 * Created by numb3rs on 5/24/18.
 */

public class SignInFragment  extends Fragment{


    AutoClearedValue<FragmentSigninBinding> binding;
    fragmentInteractionListener mListener;


    public static SignInFragment newInstance() {

        Bundle args = new Bundle();

        SignInFragment fragment = new SignInFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSigninBinding fragmentSigninBinding = DataBindingUtil.
                inflate(inflater, R.layout.fragment_signin, container, false);

        binding= new AutoClearedValue<>(this, fragmentSigninBinding);
        setupViews();
        return  fragmentSigninBinding.getRoot();
    }

    private void setupViews() {
        binding.get().gettingStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.getStartedClicked();

            }
        });

        binding.get().signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.signInClicked();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fragmentInteractionListener){
            mListener = (fragmentInteractionListener) context;
        } else {
            throw  new UnsupportedOperationException("Listener was not instantiated");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public  interface  fragmentInteractionListener{
        void getStartedClicked();
        void signInClicked();

    }

}
