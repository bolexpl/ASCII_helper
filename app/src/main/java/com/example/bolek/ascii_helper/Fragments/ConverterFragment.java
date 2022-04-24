package com.example.bolek.ascii_helper.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.res.ResourcesCompat;
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

import java.util.Locale;
import java.util.Objects;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText e = requireActivity().findViewById(R.id.editText);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                onChange(view);
            }
        });
    }


    public void onChange(@NonNull View view) {
        EditText e = requireActivity().findViewById(R.id.editText);
        String s = e.getText().toString();
        TableLayout table = requireActivity().findViewById(R.id.table);
        TextView tv;
        TableRow tr;

        table.removeAllViews();

        tr = (TableRow) requireActivity().getLayoutInflater().inflate(R.layout.table_row, (ViewGroup) view, false);
        tv = tr.findViewById(R.id.znak);
        tv.setText(R.string.char_str);
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        tv = tr.findViewById(R.id.dec);
        tv.setText(R.string.dec);
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        tv = tr.findViewById(R.id.hex);
        tv.setText(R.string.hex);
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        tv = tr.findViewById(R.id.bin);
        tv.setText(R.string.bin);
        tv.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.border_head, null));
        table.addView(tr);

        for (int i = 0; i < s.length(); i++) {
            tr = (TableRow) requireActivity().getLayoutInflater()
                    .inflate(R.layout.table_row, (ViewGroup) view, false);
            tv = tr.findViewById(R.id.znak);
            if (s.charAt(i) == 32) {
                tv.setText(R.string.space);
            } else if (s.charAt(i) == 9) {
                tv.setText(R.string.tab);
            } else {
                tv.setText(String.valueOf(s.charAt(i)));
            }
            tv = tr.findViewById(R.id.dec);
            tv.setText(String.format(Locale.getDefault(),"%c", s.charAt(i)));
//            tv.setText(Integer.toString((int) s.charAt(i)));
            tv = tr.findViewById(R.id.hex);
            tv.setText(Integer.toHexString(s.charAt(i)));
            tv = tr.findViewById(R.id.bin);
            tv.setText(Tools.toBin(s.charAt(i)));
            table.addView(tr);
        }
    }
}
