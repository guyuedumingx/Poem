package com.yohoyes.poem.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yohoyes.poem.R;
import com.yohoyes.poem.model.Poem;
import com.yohoyes.poem.service.PoemService;
import java.util.ArrayList;
import java.util.List;

public class FindFragment extends Fragment {
    private RecyclerView recycler;
    private List<Poem> poems = new ArrayList<>();

    public static FindFragment newInstance(int index) {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, final ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.find, container, false);
        initPoems();
        recycler = root.findViewById(R.id.recycle) ;

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        RecyclerCardAdapter adapter = new RecyclerCardAdapter(poems, getContext());
        recycler.setAdapter(adapter);
        return root;
    }

    private void initPoems() {
        PoemService service = new PoemService();
         for (int i=0; i< 20; i++) {
            poems.add(service.getRandomOne());
         }
    }
}
