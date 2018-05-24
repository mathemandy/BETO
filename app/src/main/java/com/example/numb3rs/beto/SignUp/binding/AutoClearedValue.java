package com.example.numb3rs.beto.SignUp.binding;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by numb3rs on 5/24/18.
 */

public class AutoClearedValue<T> {
    private T value;

    public AutoClearedValue(final Fragment fragment, T value) {
        final FragmentManager fragmentManager = fragment.getFragmentManager();
        fragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentViewDestroyed(FragmentManager fm, Fragment f) {

                if (f == fragment){
                    AutoClearedValue.this.value = null;
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                }
            }
        }, false);

        this.value = value;
    }

    public  T get() {
        return value;
    }
}
