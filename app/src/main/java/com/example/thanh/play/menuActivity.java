package com.example.thanh.play;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menuActivity extends MainActivity implements View.OnClickListener {

    ImageButton imageButton;
    Button btnPlay;
    Button btnBxh;
    int flag=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menugame);
        imageButton=findViewById(R.id.ibMenuSound);
        btnBxh=findViewById(R.id.btnBxh);
        btnPlay=findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);
        btnBxh.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPlay:
                Intent intent=new Intent(menuActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBxh:
                Intent intent1=new Intent(menuActivity.this,bxhActivity.class);
                startActivity(intent1);
                break;
            case R.id.ibMenuSound:
                mediaPlayer.stop();

                break;
        }
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Tính thoát game hả ????")
                .setCancelable(false)
                .setNegativeButton("Ừ, Cuộc sống mà bạn :))", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        menuActivity.this.finish();
                    }
                })
                .setPositiveButton("Nố nô nô nồ", null)
                .show();
    }
}
