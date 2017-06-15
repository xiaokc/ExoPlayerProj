package com.android.cong.exoplayerproj.filtertaste.filters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by xiaokecong on 15/06/2017.
 */

public class ImageFilterFactory {
    public static Bitmap getFilterBmp(ImageFilterType filterType, Bitmap originBmp) {
        int width = originBmp.getWidth();
        int height = originBmp.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix colorMatrix = new ColorMatrix();

        switch (filterType) {
            case DEFAULT:
                return originBmp;
            case GRAY:
                colorMatrix = grayMatrix(colorMatrix);
                break;
            case NEGATIVE:
                colorMatrix = negativeMatrix(colorMatrix);
                break;
            case POLAROID:
                colorMatrix = polaroidMatrix(colorMatrix);
                break;
            case NOSTALGIA:
                colorMatrix = nostalgiaMatrix(colorMatrix);
                break;
            case RED:
                colorMatrix = redMatrix(colorMatrix);
                break;
            case GREEN:
                colorMatrix = greenMatrix(colorMatrix);
                break;
            case BLUE:
                colorMatrix = blueMatrix(colorMatrix);
                break;
            case YELLOW:
                colorMatrix = yellowMatrix(colorMatrix);
                break;
            case REPUBLICAN:
                colorMatrix = republicanMatrix(colorMatrix);
                break;
            case INVERSE:
                colorMatrix = inverseMatrix(colorMatrix);
                break;
            default:
                break;
        }

        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(filter);
        canvas.drawBitmap(originBmp, 0, 0, paint);
        return bitmap;
    }

    // 灰度
    private static ColorMatrix grayMatrix(ColorMatrix colorMatrix) {
        // 颜色矩阵饱和度设置为0即可
        colorMatrix.setSaturation(0);
        return colorMatrix;
    }

    // 底片风格
    private static ColorMatrix negativeMatrix(ColorMatrix colorMatrix) {
        float[] colorArr = {
                -1, 0, 0, 0, 255,
                0, -1, 0, 0, 255,
                0, 0, -1, 0, 255,
                0, 0, 0, 1, 0
        };
        colorMatrix.set(colorArr);
        return colorMatrix;
    }

    // 宝丽来彩色
    private static ColorMatrix polaroidMatrix(ColorMatrix colorMatrix) {
        float[] arr = {
                1.438f, -0.062f, -0.062f, 0, 0,
                -0.122f, 1.378f, -0.122f, 0, 0,
                -0.016f, -0.016f, 1.483f, 0, 0,
                -0.03f, 0.05f, -0.02f, 1, 0
        };

        colorMatrix.set(arr);
        return colorMatrix;
    }

    // 怀旧风
    private static ColorMatrix nostalgiaMatrix(ColorMatrix colorMatrix) {
        float[] arr = {
                0.393f,0.769f,0.189f,0,0,
                0.349f,0.686f,0.168f,0,0,
                0.272f,0.534f,0.131f,0,0,
                0,0,0,1,0
        };
        colorMatrix.set(arr);
        return colorMatrix;
    }

    // 泛红
    private static ColorMatrix redMatrix(ColorMatrix colorMatrix) {
        float[] arr = {
                2,0,0,0,0,
                0,1,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0
        };
        colorMatrix.set(arr);
        return colorMatrix;
    }

    // 泛绿(荧光绿)
    private static ColorMatrix greenMatrix(ColorMatrix colorMatrix) {
        float[] arr = {
                1,0,0,0,0,
                0,1.4f,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0
        };
        colorMatrix.set(arr);
        return colorMatrix;
    }

    // 泛蓝（宝石蓝）
    private static ColorMatrix blueMatrix(ColorMatrix colorMatrix) {
        float[] arr = {
                1,0,0,0,0,
                0,1,0,0,0,
                0,0,1.6f,0,0,
                0,0,0,1,0
        };
        colorMatrix.set(arr);
        return colorMatrix;
    }

    // 泛黄
    private static ColorMatrix yellowMatrix(ColorMatrix colorMatrix) {
        // 红色和绿色偏移量都加上100
        float[] colorArr = {
                1, 0, 0, 0, 100,
                0, 1, 0, 0, 100,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0
        };
        colorMatrix.set(colorArr);
        return colorMatrix;
    }

    // 民国风，与灰度图类似
    private static ColorMatrix republicanMatrix(ColorMatrix colorMatrix) {
        // 红色和绿色偏移量都加上100
        float[] colorArr = {
                0.33f, 0.59f, 0.11f, 0, 0,
                0.33f, 0.59f, 0.11f, 0, 0,
                0.33f, 0.59f, 0.11f, 0, 0,
                0, 0, 0, 1, 0
        };
        colorMatrix.set(colorArr);
        return colorMatrix;
    }

    // 反色风格，与底片风格类似
    private static ColorMatrix inverseMatrix(ColorMatrix colorMatrix) {
        float[] colorArr = {
                -1, 0, 0, 1, 1,
                0, -1, 0, 1, 1,
                0, 0, -1, 1, 1,
                0, 0, 0, 1, 0
        };
        colorMatrix.set(colorArr);
        return colorMatrix;
    }

}
