package com.example.thanh.play;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class bxhActivity extends AppCompatActivity implements View.OnClickListener{
    TextView bxh[]=new TextView[6];
    int sorted[]=new int[10000];

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bxh_layout);
        sharedPreferences= getSharedPreferences("BXH", Context.MODE_PRIVATE);
            bxh[0] = ((TextView) findViewById(R.id.score0));
            bxh[1] = ((TextView) findViewById(R.id.score1));
            bxh[2] = ((TextView) findViewById(R.id.score2));
            bxh[3] = ((TextView) findViewById(R.id.score3));
            bxh[4] = ((TextView) findViewById(R.id.score4));
            bxh[5] = ((TextView) findViewById(R.id.score5));
            int tmp=0;
        if (sharedPreferences.getString("0","")!="") {
            while(sharedPreferences.getString(String.valueOf(tmp).toString(),"")!=""){
                sorted[tmp]=Integer.parseInt(sharedPreferences.getString(String.valueOf(tmp).toString(),""));
                tmp++;
            }
            Arrays.sort(sorted);
            for (int i = 0; i < bxh.length; ++i) {
                if(sorted.length-i-1>=0)
                bxh[i].setText(String.valueOf(sorted[sorted.length-i-1]));
            }
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(bxhActivity.this,menuActivity.class);
        startActivity(intent);
        finish();
    }
}
