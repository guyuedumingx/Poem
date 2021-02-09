package com.yohoyes.poem.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yohoyes.poem.R;
import com.yohoyes.poem.model.Poem;

import java.util.List;

public class RecyclerCardAdapter extends RecyclerView.Adapter {
    private List<Poem> lists;
    private Context context;

    public RecyclerCardAdapter(List<Poem> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    class PoemHolder extends RecyclerView.ViewHolder {
        private TextView title, writer, content;

        public PoemHolder(View view) {
            super(view);
            title = (TextView)view.findViewById(R.id.poem_title);
            writer = (TextView)view.findViewById(R.id.poem_writer);
            content = (TextView)view.findViewById(R.id.poem_content);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PoemHolder holder = new PoemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PoemHolder)holder).writer.setText(lists.get(position).getWriter());
        ((PoemHolder)holder).content.setText(lists.get(position).getContent());
        ((PoemHolder)holder).title.setText(lists.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
