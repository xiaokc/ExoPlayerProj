package com.android.cong.exoplayerproj.filtertaste.activity;

import java.util.ArrayList;
import java.util.List;

import com.android.cong.exoplayerproj.R;
import com.android.cong.exoplayerproj.filtertaste.adapter.ImageFilterAdapter;
import com.android.cong.exoplayerproj.filtertaste.filters.ImageFilterType;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by xiaokecong on 15/06/2017.
 */

public class ImageActivity extends Activity {
    private ListView listView;
    private ImageView imageView;
    private ImageFilterAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        initView();
        initData();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.filter_lv);
        imageView = (ImageView) findViewById(R.id.filter_iv);
    }

    private void initData() {
        final List<ImageFilterType> list = ImageFilterType.crateFilterList();
        adapter = new ImageFilterAdapter(this,R.layout.filter_list_row_text,list);
        listView.setAdapter(adapter);

        final Bitmap originBmp = BitmapFactory.decodeResource(getResources(),R.drawable.test);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageBitmap(ImageFilterType.getFilterBmp(list.get(position),originBmp));
            }
        });
    }
}
