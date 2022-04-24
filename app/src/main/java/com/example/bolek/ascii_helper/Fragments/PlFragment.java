package com.example.bolek.ascii_helper.Fragments;


import android.os.Bundle;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class PlFragment extends Fragment {


    public PlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_table, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TableLayout table = (TableLayout) getActivity().findViewById(R.id.table);
        TextView tv;
        TableRow tr;

        char[] val = {'Ą', 'Ć', 'Ę', 'Ł', 'Ń', 'Ó', 'Ś'};
        char[] val2 = {'ą', 'ć', 'ę', 'ł', 'ń', 'ó', 'ś'};

        for (char c : val) {
            tr = (TableRow) getActivity().getLayoutInflater().inflate(R.layout.table_row, null, false);
            tv = (TextView) tr.findViewById(R.id.znak);
            tv.setText(String.valueOf(c));
            tv = (TextView) tr.findViewById(R.id.dec);
            tv.setText(Integer.toString((int) c));
            tv = (TextView) tr.findViewById(R.id.hex);
            tv.setText(Integer.toHexString((int) c));
            tv = (TextView) tr.findViewById(R.id.bin);
            tv.setText(Tools.toBin((int) c));
            table.addView(tr);
        }

        for (char c : val2) {
            tr = (TableRow) getActivity().getLayoutInflater().inflate(R.layout.table_row, null, false);
            tv = (TextView) tr.findViewById(R.id.znak);
            tv.setText(String.valueOf(c));
            tv = (TextView) tr.findViewById(R.id.dec);
            tv.setText(Integer.toString((int) c));
            tv = (TextView) tr.findViewById(R.id.hex);
            tv.setText(Integer.toHexString((int) c));
            tv = (TextView) tr.findViewById(R.id.bin);
            tv.setText(Tools.toBin(c));
            table.addView(tr);
        }
    }
}
