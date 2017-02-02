package com.minichi.book;

import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.minichi.book.common.SharedResources;
import com.minichi.book.engine.BookEngine;
import com.minichi.book.tools.ImageHandler;

public class MainActivity extends FragmentActivity {

    private ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedResources.context = getApplicationContext();
        SharedResources.engine = BookEngine.getInstance();

        setContentView(R.layout.activity_main);
        backgroundImage = (ImageView) findViewById(R.id.background_image);

        SharedResources.activity = this;
        SharedResources.engine.start();

        hideActivityBar();

        setBackgroundImage();

        //setContentView(R.layout.start_menu_fragment);
    }

    /*@Override
    protected void onDestroy() {
    }

    @Override
    public void onBackPressed() {
    }*/

    private void hideActivityBar() {
        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

            getWindow().getDecorView().setSystemUiVisibility(flags);
    }

    private void setBackgroundImage() {
        Bitmap bitmap = ImageHandler.scaleResource(R.drawable.cow_background, ImageHandler.screenWidth(), ImageHandler.screenHeight());
        //bitmap = ImageHandler.crop(bitmap, ImageHandler.screenHeight(), ImageHandler.screenWidth());
        //bitmap = ImageHandler.scaleBitmap(bitmap, 2);
        backgroundImage.setImageBitmap(bitmap);
    }
}
