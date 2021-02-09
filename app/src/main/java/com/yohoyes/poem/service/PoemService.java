package com.yohoyes.poem.service;

import com.yohoyes.poem.dao.PoemDao;
import com.yohoyes.poem.model.Poem;
import java.util.List;
import java.util.Random;

public class PoemService {
    PoemDao dao = new PoemDao();

    public void addAll(List<Poem> poemList) {
        dao.createDatabase();
        dao.addAll(poemList);
    }

    public Poem getRandomOne() {
        int random = getRandom();
        return dao.getOne(random);
    }

    private int getRandom() {
        int min = 0;
        int max = dao.count();
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }
}
