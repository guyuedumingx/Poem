package com.yohoyes.poem.dao;

import com.yohoyes.poem.model.Poem;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;
import java.util.List;

public class PoemDao {

    public void createDatabase() {
        Connector.getDatabase();
    }

    public void addAll(List<Poem> poemList) {
        for (Poem poem : poemList) {
            poem.save();
        }
    }

    public int count() {
        int poem = LitePal.count("poem");
        return poem;
    }

    public Poem getOne(int index) {
        List<Poem> poemList = LitePal.limit(1).offset(index).find(Poem.class);
        return poemList.get(0);
    }
}
