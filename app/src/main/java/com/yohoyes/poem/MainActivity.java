package com.yohoyes.poem;

import android.content.res.AssetManager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.yohoyes.poem.ui.main.SectionsPagerAdapter;
import com.yohoyes.poem.util.ReadPoem;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
//        readPoems();
    }

    public void readPoems() {
        try {
            AssetManager assets = super.getAssets();
            String[] list = assets.list("");
            InputStream open = assets.open(list[0]);
            ReadPoem.readPoems(open);

//            for (String item : list) {
//                if(item.endsWith("json")) {
//                    InputStream open = assets.open(item);
//                    poemList.addAll(ReadPoem.readPoems(open));
//                }
//            }

            Toast.makeText(MainActivity.this, "诗词加载完成", Toast.LENGTH_SHORT);
        }catch (IOException e) {
            Log.d("input", "onCreate: ."+e.getMessage());
        }
    }

}