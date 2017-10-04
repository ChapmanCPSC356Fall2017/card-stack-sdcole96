package com.example.dcole.cardstack;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity
{
    public TextView tvTop;
    public TextView tvBot;

    public ImageView ivTop;
    public ImageView ivMid;
    public ImageView ivBot;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativelayout);


        tvTop = (TextView) findViewById(R.id.topLeftNumber);
        tvBot = (TextView) findViewById(R.id.bottomRightNumber);

        ivTop = (ImageView) findViewById(R.id.topLeftSuit);
        ivMid = (ImageView) findViewById(R.id.middleSuit);
        ivBot = (ImageView) findViewById(R.id.bottomRightSuit);


        final Stack<Card> deck = new Stack<>();
        for(int i = 1;i <= 4; ++i)
        {
            for(int j = 1; j<=13; ++j)
            {
                Card c = new Card(j,i);
                deck.push(c);
            }
        }
        Collections.shuffle(deck);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.mainLayout);
        layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!deck.isEmpty()) {
                    Card current = deck.pop();
                    String text;

                    //changes text
                    int rank = current.getRank();
                    switch (rank) {
                        case 1: {
                            text = "A";
                            break;
                        }
                        case 11: {
                            text = "J";
                            break;
                        }
                        case 12: {
                            text = "Q";
                            break;
                        }
                        case 13: {
                            text = "K";
                            break;
                        }
                        default: {
                            text = Integer.toString(rank);
                        }
                    }
                    tvTop.setText(text);
                    tvBot.setText(text);

                    //changes images
                    switch(current.getSuit())
                    {
                        case 1:
                        {
                            ivTop.setImageResource(R.drawable.diamond);
                            ivMid.setImageResource(R.drawable.diamond);
                            ivBot.setImageResource(R.drawable.diamond);
                            tvTop.setTextColor(Color.RED);
                            tvBot.setTextColor(Color.RED);
                            break;
                        }
                        case 2:
                        {
                            ivTop.setImageResource(R.drawable.clubs);
                            ivMid.setImageResource(R.drawable.clubs);
                            ivBot.setImageResource(R.drawable.clubs);
                            tvTop.setTextColor(Color.BLACK);
                            tvBot.setTextColor(Color.BLACK);
                            break;
                        }
                        case 3:
                        {
                            ivTop.setImageResource(R.drawable.redheart);
                            ivMid.setImageResource(R.drawable.redheart);
                            ivBot.setImageResource(R.drawable.redheart);
                            tvTop.setTextColor(Color.RED);
                            tvBot.setTextColor(Color.RED);
                            break;
                        }
                        case 4:
                        {
                            ivTop.setImageResource(R.drawable.spade);
                            ivMid.setImageResource(R.drawable.spade);
                            ivBot.setImageResource(R.drawable.spade);
                            tvTop.setTextColor(Color.BLACK);
                            tvBot.setTextColor(Color.BLACK);
                            break;
                        }
                    }
                }
                else
                {
                    finish();
                }
            }
            });

    }
}
