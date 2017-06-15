package com.android.cong.exoplayerproj.filtertaste.filters;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

/**
 * Created by xiaokecong on 15/06/2017.
 */

public enum  ImageFilterType {
    DEFAULT,GRAY, NEGATIVE, POLAROID, NOSTALGIA, RED, GREEN, BLUE, YELLOW, REPUBLICAN, INVERSE;

    public static List<ImageFilterType> crateFilterList() {
        List<ImageFilterType> filterTypes = new ArrayList<>();

        filterTypes.add(DEFAULT);
        filterTypes.add(GRAY);
        filterTypes.add(NEGATIVE);
        filterTypes.add(POLAROID);
        filterTypes.add(NOSTALGIA);
        filterTypes.add(RED);
        filterTypes.add(GREEN);
        filterTypes.add(BLUE);
        filterTypes.add(YELLOW);
        filterTypes.add(REPUBLICAN);
        filterTypes.add(INVERSE);

        return filterTypes;
    }

    public static Bitmap getFilterBmp(ImageFilterType filterType, Bitmap originBmp) {
        return ImageFilterFactory.getFilterBmp(filterType,originBmp);
    }
}
