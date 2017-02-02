package com.minichi.book.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

import com.minichi.book.common.SharedResources;

/**
 * Created by Niklas.bjernekull on 2017-01-27.
 */

public class ImageHandler {

    public static int px(int dp) {
        return (int) (SharedResources.context.getResources().getDisplayMetrics().density * dp);
    }

    public static int screenWidth() {
        return SharedResources.context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int screenHeight() {
        return SharedResources.context.getResources().getDisplayMetrics().heightPixels;
    }

    public static Bitmap scaleResource(int resource, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(SharedResources.context.getResources(), resource);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(SharedResources.context.getResources(), resource, options);
    }

    /**
     * Scales a bitmap by the specified factor
     */
    public static Bitmap scaleBitmap(Bitmap image, int factor) {
        // convert to bitmap and get the center
        int widthPixels = image.getWidth() / factor;
        int heightPixels = image.getHeight() / factor;
        return ThumbnailUtils.extractThumbnail(image, widthPixels, heightPixels);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee a final image with both dimensions larger than or
            // equal to the requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}
