package com.example.bolek.ascii_helper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bolek.ascii_helper.R;

public class DecFragment extends Fragment {
    EditText edit;
    TextView bin;
    TextView hex;

    public DecFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dec, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edit = (EditText) getActivity().findViewById(R.id.dec);
        bin = (TextView) getActivity().findViewById(R.id.bin);
        hex = (TextView) getActivity().findViewById(R.id.hex);

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

    private void change() {
        String s = edit.getText().toString();
        if (s.equals("")) {
            bin.setText("Bin: 0");
            hex.setText("Hex: 0");
            return;
        }

        int x = Integer.parseInt(s);
        bin.setText("Bin: "+Integer.toBinaryString(x));
        hex.setText("Hex: "+Integer.toHexString(x));
    }
}
