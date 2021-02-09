package com.yohoyes.poem.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.yohoyes.poem.MainActivity;
import com.yohoyes.poem.R;

public class SearchFragment extends Fragment {

    public static SearchFragment newInstance(int index) {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.search, container, false);
        Button searchBut = (Button)root.findViewById(R.id.search_but);

        searchBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast google = Toast.makeText(container.getContext(),
                        "Google",
                        Toast.LENGTH_SHORT);
                google.show();
            }
        });
        return root;
    }
}
