package com.example.weathertimeandroid.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;


// import fragmentmanager and fragment transaction



import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.weathertimeandroid.R;
import com.example.weathertimeandroid.utilities.FragmentHelper;
import com.example.weathertimeandroid.utilities.SharedPreferencesHelper;


public class AddCityDialogFragment extends DialogFragment {

    Context context;

    public static AddCityDialogFragment newInstance() {
        Bundle args = new Bundle();

        AddCityDialogFragment fragment = new AddCityDialogFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Please set a location").setMessage("Example: Paris, France or 95864");

        // Set up the input
        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("ADD CITY",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String location = input.getText().toString();
                SharedPreferencesHelper.CreateCityInSharedPrefs(getActivity(), location);
                FragmentHelper.pushToFragmentManager(getFragmentManager(), R.id.activity_main, new ForecastMasterFragment());
            }
        });


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = getActivity();
    }

    public boolean isActive() {
        return isAdded() && !isDetached() && !isRemoving();
    }
}
