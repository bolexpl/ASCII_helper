package com.example.bolek.ascii_helper.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.bolek.ascii_helper.R;
import com.example.bolek.ascii_helper.Tools;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class SmallFragment extends Fragment {

    public SmallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TableLayout table = (TableLayout) view.findViewById(R.id.table);
        TextView tv;
        TableRow tr;

        for (int i = 97; i <= 122; i++) {
            tr = (TableRow) requireActivity().getLayoutInflater().inflate(R.layout.table_row, (ViewGroup) table, false);
            tv = (TextView) tr.findViewById(R.id.znak);
            tv.setText(String.valueOf((char) i));
            tv = (TextView) tr.findViewById(R.id.dec);
            tv.setText(String.format(Locale.getDefault(),"%d", i));
            tv = (TextView) tr.findViewById(R.id.hex);
            tv.setText(Integer.toHexString(i));
            tv = (TextView) tr.findViewById(R.id.bin);
            tv.setText(Tools.toBin(i));
            table.addView(tr);
        }
    }
}
