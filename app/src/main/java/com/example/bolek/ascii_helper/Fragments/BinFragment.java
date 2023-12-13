package com.example.bolek.ascii_helper.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bolek.ascii_helper.R;

import java.util.Locale;

public class BinFragment extends Fragment {

    TextView[] tv;
    TextView dec;
    TextView hex;

    public BinFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int[] id = {
                R.id.textView,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
                R.id.textView9,
                R.id.textView10,
                R.id.textView11,
                R.id.textView12,
                R.id.textView13,
                R.id.textView14,
                R.id.textView15,
                R.id.textView16
        };
        tv = new TextView[id.length];

        for (int i = 0; i < id.length; i++) {
            tv[i] = requireActivity().findViewById(id[i]);
            tv[i].setOnClickListener(this::onChange);
        }

        dec = view.findViewById(R.id.dec);
        hex = view.findViewById(R.id.hex);
    }

    private void onChange(View v) {
        TextView textView = (TextView) v;
        String s = textView.getText().toString();

        if (s.equals("1")) {
            textView.setText("0");
        } else {
            textView.setText("1");
        }

        calculate();
    }

    private void calculate(){
        StringBuilder s = new StringBuilder();
        for (TextView textView : tv) {
            s.append(textView.getText().toString());
        }

        int x = Integer.parseInt(s.toString(),2);
        dec.setText(String.format(Locale.getDefault(),"Dec: %d", x));
        hex.setText(String.format(Locale.getDefault(),"Hex: %h", x));
    }
}
