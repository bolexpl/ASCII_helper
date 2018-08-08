package com.example.bolek.ascii_helper.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bolek.ascii_helper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HexFragment extends Fragment {
    EditText edit;
    TextView bin;
    TextView dec;

    public HexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hex, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edit = (EditText) getActivity().findViewById(R.id.hex);
        bin = (TextView) getActivity().findViewById(R.id.bin);
        dec = (TextView) getActivity().findViewById(R.id.dec);

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                change();
            }
        });
    }

    public void change() {
        String s = edit.getText().toString();
        if (s.equals("")) {
            bin.setText("Bin: 0");
            dec.setText("Dec: 0");
            return;
        }

        try {
            int x = Integer.decode("0x" + s);
            bin.setText("Bin: "+Integer.toBinaryString(x));
            dec.setText("Dec: "+Integer.toString(x));
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity().getApplicationContext(), "Niedozwolona liczba!", Toast.LENGTH_SHORT).show();
        }
    }
}
