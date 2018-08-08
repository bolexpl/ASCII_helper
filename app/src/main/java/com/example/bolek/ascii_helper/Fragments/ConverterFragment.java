package com.example.bolek.ascii_helper.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.bolek.ascii_helper.R;
import com.example.bolek.ascii_helper.Tools;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConverterFragment extends Fragment {


    public ConverterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_converter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText e = (EditText) getActivity().findViewById(R.id.editText);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                onChange();
            }
        });
    }


    public void onChange() {
        EditText e = (EditText) getActivity().findViewById(R.id.editText);
        String s = e.getText().toString();
        TableLayout table = (TableLayout) getActivity().findViewById(R.id.table);
        TextView tv;
        TableRow tr;

        table.removeAllViews();

        tr = (TableRow) getActivity().getLayoutInflater().inflate(R.layout.table_row, null, false);
        tv = (TextView) tr.findViewById(R.id.znak);
        tv.setText("Znak");
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        tv = (TextView) tr.findViewById(R.id.dec);
        tv.setText("Dec");
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        tv = (TextView) tr.findViewById(R.id.hex);
        tv.setText("Hex");
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        tv = (TextView) tr.findViewById(R.id.bin);
        tv.setText("Bin");
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        table.addView(tr);

        for (int i = 0; i < s.length(); i++) {
            tr = (TableRow) getActivity().getLayoutInflater().inflate(R.layout.table_row, null, false);
            tv = (TextView) tr.findViewById(R.id.znak);
            if (s.charAt(i) == 32) {
                tv.setText("spacja");
            } else if (s.charAt(i) == 9) {
                tv.setText("tabulacja");
            } else {
                tv.setText(String.valueOf(s.charAt(i)));
            }
            tv = (TextView) tr.findViewById(R.id.dec);
            tv.setText(Integer.toString((int) s.charAt(i)));
            tv = (TextView) tr.findViewById(R.id.hex);
            tv.setText(Integer.toHexString((int) s.charAt(i)));
            tv = (TextView) tr.findViewById(R.id.bin);
            tv.setText(Tools.toBin(s.charAt(i)));
            table.addView(tr);
        }
    }
}
