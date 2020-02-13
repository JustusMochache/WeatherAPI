package com.example.weathertimeandroid.utilities;




import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.weathertimeandroid.fragments.ForecastMasterFragment;

public class FragmentHelper {

    /**
     * Pushes a new fragment on to the fragment manager stack.
     *  @param fragmentManager Pass in the FragmentManager so that it can do the necessary work.
     * @param target Id of the content frame to be targeted.
     * @param fragment Fragment to be pushed onto the stack.
     *
     */
    public static void pushToFragmentManager(FragmentManager fragmentManager, int target, ForecastMasterFragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction().replace(target, fragment);

        if (transaction.addToBackStack(null)==null){
            transaction.commit();
        }


    }
}





