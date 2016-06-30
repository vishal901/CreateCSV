package com.example.vishal.createcsv;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Types.BoomType;
import com.nightonke.boommenu.Types.ButtonType;
import com.nightonke.boommenu.Types.PlaceType;
import com.nightonke.boommenu.Util;

import java.util.Random;

/**
 * Created by vishal on 30/06/2016.
 */
public class boomMenuDemo extends AppCompatActivity implements BoomMenuButton.OnClickListener, BoomMenuButton.OnSubButtonClickListener {
    private BoomMenuButton boomMenuButton;
    private boolean init = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        initViews();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // Use a param to record whether the boom button has been initialized
        // Because we don't need to init it again when onResume()
        if (init) return;
        init = true;

        initBoom();
    }

    private void initBoom() {

        int number = 9;
        Drawable[] drawables = new Drawable[number];
        int[] drawablesResource = new int[]{
                R.drawable.mark,
                R.drawable.refresh,
                R.drawable.copy,
                R.drawable.heart,
                R.drawable.info,
                R.drawable.like,
                R.drawable.record,
                R.drawable.search,
                R.drawable.settings
        };
        for (int i = 0; i < number; i++)
            drawables[i] = ContextCompat.getDrawable(this, drawablesResource[i]);

        String[] STRINGS = new String[]{
                "Mark",
                "Refresh",
                "Copy",
                "Heart",
                "Info",
                "Like",
                "Record",
                "Search",
                "Settings"
        };
        String[] strings = new String[number];
        for (int i = 0; i < number; i++)
            strings[i] = STRINGS[i];

        int[][] colors = new int[number][2];
        for (int i = 0; i < number; i++) {
            colors[i][1] = getRandomColor();
            colors[i][0] = Util.getInstance().getPressedColor(colors[i][1]);
        }


        new BoomMenuButton.Builder()
                .subButtons(drawables, colors, strings)
                .button(ButtonType.CIRCLE)
                .boom(BoomType.HORIZONTAL_THROW_2)
                .place(PlaceType.SHARE_9_1)
                .boomButtonShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .subButtonsShadow(Util.getInstance().dp2px(2), Util.getInstance().dp2px(2))
                .onSubButtonClick(this)
                .shareStyle(3f, getRandomColor(), getRandomColor())
                .init(boomMenuButton);


    }

    private void initViews() {

        boomMenuButton = (BoomMenuButton) findViewById(R.id.boom);

        boomMenuButton.setShareLineWidth(100 * 6f / 100);


    }


    public int getRandomColor() {
        Random random = new Random();
        int p = random.nextInt(Colors.length);
        return Color.parseColor(Colors[p]);
    }

    private String[] Colors = {
            "#F44336",
            "#E91E63",
            "#9C27B0",
            "#2196F3",
            "#03A9F4",
            "#00BCD4",
            "#009688",
            "#4CAF50",
            "#8BC34A",
            "#CDDC39",
            "#FFEB3B",
            "#FFC107",
            "#FF9800",
            "#FF5722",
            "#795548",
            "#9E9E9E",
            "#607D8B"};

    @Override
    public void onClick() {


    }

    @Override
    public void onClick(int buttonIndex) {

        switch (buttonIndex) {

            case 0:
                Toast.makeText(boomMenuDemo.this, "Mark!", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(boomMenuDemo.this, "Refresh!", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(boomMenuDemo.this, "copy!", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(boomMenuDemo.this, "hrart!", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(boomMenuDemo.this, "info!", Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(boomMenuDemo.this, "like!", Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(boomMenuDemo.this, "record!", Toast.LENGTH_SHORT).show();
                break;
            case 7:
                Toast.makeText(boomMenuDemo.this, "serch!", Toast.LENGTH_SHORT).show();
                break;
            case 8:
                Toast.makeText(boomMenuDemo.this, "settting!", Toast.LENGTH_SHORT).show();
                break;


        }

    }
}
