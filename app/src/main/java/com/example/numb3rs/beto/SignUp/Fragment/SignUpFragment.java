package com.example.numb3rs.beto.SignUp.Fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.numb3rs.beto.R;
import com.example.numb3rs.beto.SignUp.binding.AutoClearedValue;
import com.example.numb3rs.beto.databinding.FragmentSignupBinding;

/**
 * Created by numb3rs on 5/24/18.
 */

public class SignUpFragment extends Fragment {


    AutoClearedValue<FragmentSignupBinding> binding;
    fragmentInteractionListener mListener;

    public static SignUpFragment newInstance() {

        Bundle args = new Bundle();

        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentSignupBinding fragmentSignupBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_signup, container, false);

        binding = new AutoClearedValue<>(this, fragmentSignupBinding);
        setUpViews();
        return  fragmentSignupBinding.getRoot();
     }

    private void setUpViews() {
        String beginText = "By signin up, you agree to our";
        String middletext = "Terms and condition ";
        String endtext = "and read \n our ";
        String bottomText = "Privacy Policy";

        binding.get().forgotPassword.setText(beginText + middletext + endtext + bottomText, TextView.BufferType.SPANNABLE);

        Spannable s = (Spannable) binding.get().forgotPassword.getText();
        int start = beginText.length();
        int middle = start + middletext.length();
        int end = middle + endtext.length();
        int bottom = end + bottomText.length();
        s.setSpan(new ForegroundColorSpan(Color.RED), start, bottom, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //listeners for Buttons
        binding.get().signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.getStartedSignUpClicked();
            }
        });

        binding.get().loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.loginClickedSignUp();
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  fragmentInteractionListener){
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
        void getStartedSignUpClicked();
        void loginClickedSignUp();

    }
}
