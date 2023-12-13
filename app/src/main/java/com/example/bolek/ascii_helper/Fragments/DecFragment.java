package com.example.bolek.ascii_helper.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.app.ShareCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bolek.ascii_helper.R;

import java.util.Objects;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edit = (EditText) view.findViewById(R.id.dec);
        bin = (TextView) view.findViewById(R.id.bin);
        hex = (TextView) view.findViewById(R.id.hex);

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
            bin.setText(getString(R.string.bin_0));
            hex.setText(getString(R.string.hex_0));
            return;
        }

        int x = Integer.parseInt(s);
        bin.setText(getString(R.string.bin_s, Integer.toBinaryString(x)));
        hex.setText(getString(R.string.hex_s, Integer.toHexString(x)));
    }
}
