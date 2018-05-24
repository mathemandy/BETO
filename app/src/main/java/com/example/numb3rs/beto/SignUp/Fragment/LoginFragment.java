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
import com.example.numb3rs.beto.databinding.FragmentLoginBinding;

/**
 * Created by numb3rs on 5/24/18.
 */

public class LoginFragment extends Fragment {

    private static final String TAG = LoginFragment.class.getSimpleName();


    AutoClearedValue<FragmentLoginBinding> binding;
    fragmentInteractionListener mListener;


    public LoginFragment() {
    }

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding fragmentLoginBinding = DataBindingUtil.
                inflate(inflater, R.layout.fragment_login, container, false);

        binding = new AutoClearedValue<>(this, fragmentLoginBinding);

        setupViews();
        return fragmentLoginBinding.getRoot();
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

    private void setupViews() {


        //set the color to the description text
        String beginText = getString(R.string.company_description_begin);
        String endText = " In One Place.";

        binding.get().appDescription.setText(beginText + endText, TextView.BufferType.SPANNABLE);
        Spannable s = (Spannable) binding.get().appDescription.getText();
        int start = beginText.length();
        int end = start + endText.length();
        s.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        //set Listener for SignInButtonClicked
        binding.get().textviewSignIn
                .setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            mListener.signInButtonClicked();
                                                            }
                                                        }

        );
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public  interface  fragmentInteractionListener{
        void signInButtonClicked();

  }
}
