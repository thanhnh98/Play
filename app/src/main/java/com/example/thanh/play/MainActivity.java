package com.example.thanh.play;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Button
    Button tmp1;
    Button tmp2;
    Button rs;
    Button hint;
    Button arBtn[][]=new Button[7][7];
    Button btnMenuMain;
    //Int
    int arID[][]=new int[7][7];
    int id1,id2;
    int check;
    final int time=300;
    int timeBlock=700;
    int soLanThaoTac=0;
    int win=0;
    int playTime=time;
    int hintTimes=1;
    int score=0;
    int bonusScore=0;
    int player=0;
    //SharedPreferences
    SharedPreferences sharedPreferences;
    //Layout
    RelativeLayout relativeLayout;
    //Timer
    Timer playTimer;
    //Handler
    Handler handler,handler2,handlerplayTime,handlerhint,handlerhint2;
    //EditText
    EditText etCustomTime;
    //String
    String small_icon;

    //MediaPlayer
    MediaPlayer mediaPlayer,mpClick,mpAccept,mpTimeOut,mpEndGame,mpWinGame;

    //ToggleButton
    ToggleButton toggleButton;

    //TextView
    TextView txtPlayTime,txtscore;
    TextView txtcountHint;
    TextView tvKQ,tvFinalScore,tvbonusScore;
    //Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //Set Âm Thanh
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.nhac);
        mpClick=mediaPlayer.create(MainActivity.this,R.raw.click);
        mpAccept=mediaPlayer.create(MainActivity.this,R.raw.accept);
        mpTimeOut=mediaPlayer.create(MainActivity.this,R.raw.timeout);
        mpEndGame=mediaPlayer.create(MainActivity.this,R.raw.endgame);
        mpWinGame=mediaPlayer.create(MainActivity.this,R.raw.wingame);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        //Fragment
        //Gán Biến
        toggleButton=findViewById(R.id.sound);
        txtPlayTime=findViewById(R.id.txtplayTime);
        rs=findViewById(R.id.reset);
        hint=findViewById(R.id.hint);
        txtscore=findViewById(R.id.score);
        etCustomTime=findViewById(R.id.customTime);
        txtcountHint=findViewById(R.id.countHint);
        relativeLayout=findViewById(R.id.scoreBoard);
        tvKQ=findViewById(R.id.tvKQ);
        tvFinalScore=findViewById(R.id.finalScore);
        tvbonusScore=findViewById(R.id.bonusScore);
        check=1;
        small_icon="?";

        //Set sự kiện custom
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(toggleButton.isChecked()){
                    mediaPlayer.stop();
                    toggleButton.setBackground(getResources().getDrawable(R.drawable.volumeoff));
                }
                else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.nhac);
                    mediaPlayer.start();
                    toggleButton.setBackground(getResources().getDrawable(R.drawable.volume));
                }
            }
        });
        rs.setOnClickListener(this);
        hint.setOnClickListener(this);
        //Tạo mảng lưu Button
        arBtn[0][0]=findViewById(R.id.b00);
        arBtn[0][1]=findViewById(R.id.b01);
        arBtn[0][2]=findViewById(R.id.b02);
        arBtn[0][3]=findViewById(R.id.b03);
        arBtn[0][4]=findViewById(R.id.b04);
        arBtn[0][5]=findViewById(R.id.b05);
        arBtn[0][6]=findViewById(R.id.b06);
        arBtn[1][0]=findViewById(R.id.b10);
        arBtn[1][1]=findViewById(R.id.b11);
        arBtn[1][2]=findViewById(R.id.b12);
        arBtn[1][3]=findViewById(R.id.b13);
        arBtn[1][4]=findViewById(R.id.b14);
        arBtn[1][5]=findViewById(R.id.b15);
        arBtn[1][6]=findViewById(R.id.b16);
        arBtn[2][0]=findViewById(R.id.b20);
        arBtn[2][1]=findViewById(R.id.b21);
        arBtn[2][2]=findViewById(R.id.b22);
        arBtn[2][3]=findViewById(R.id.b23);
        arBtn[2][4]=findViewById(R.id.b24);
        arBtn[2][5]=findViewById(R.id.b25);
        arBtn[2][6]=findViewById(R.id.b26);
        arBtn[3][0]=findViewById(R.id.b30);
        arBtn[3][1]=findViewById(R.id.b31);
        arBtn[3][2]=findViewById(R.id.b32);
        arBtn[3][3]=findViewById(R.id.b33);
        arBtn[3][4]=findViewById(R.id.b34);
        arBtn[3][5]=findViewById(R.id.b35);
        arBtn[3][6]=findViewById(R.id.b36);
        arBtn[4][0]=findViewById(R.id.b40);
        arBtn[4][1]=findViewById(R.id.b41);
        arBtn[4][2]=findViewById(R.id.b42);
        arBtn[4][3]=findViewById(R.id.b43);
        arBtn[4][4]=findViewById(R.id.b44);
        arBtn[4][5]=findViewById(R.id.b45);
        arBtn[4][6]=findViewById(R.id.b46);
        arBtn[5][0]=findViewById(R.id.b50);
        arBtn[5][1]=findViewById(R.id.b51);
        arBtn[5][2]=findViewById(R.id.b52);
        arBtn[5][3]=findViewById(R.id.b53);
        arBtn[5][4]=findViewById(R.id.b54);
        arBtn[5][5]=findViewById(R.id.b55);
        arBtn[5][6]=findViewById(R.id.b56);
        arBtn[6][0]=findViewById(R.id.b60);
        arBtn[6][1]=findViewById(R.id.b61);
        arBtn[6][2]=findViewById(R.id.b62);
        arBtn[6][3]=findViewById(R.id.b63);
        arBtn[6][4]=findViewById(R.id.b64);
        arBtn[6][5]=findViewById(R.id.b65);
        arBtn[6][6]=findViewById(R.id.b66);
        //Tạo mảng ID
        arID[0][0]=R.id.b00;
        arID[0][1]=R.id.b01;
        arID[0][2]=R.id.b02;
        arID[0][3]=R.id.b03;
        arID[0][4]=R.id.b04;
        arID[0][5]=R.id.b05;
        arID[0][6]=R.id.b06;
        arID[1][0]=R.id.b10;
        arID[1][1]=R.id.b11;
        arID[1][2]=R.id.b12;
        arID[1][3]=R.id.b13;
        arID[1][4]=R.id.b14;
        arID[1][5]=R.id.b15;
        arID[1][6]=R.id.b16;
        arID[2][0]=R.id.b20;
        arID[2][1]=R.id.b21;
        arID[2][2]=R.id.b22;
        arID[2][3]=R.id.b23;
        arID[2][4]=R.id.b24;
        arID[2][5]=R.id.b25;
        arID[2][6]=R.id.b26;
        arID[3][0]=R.id.b30;
        arID[3][1]=R.id.b31;
        arID[3][2]=R.id.b32;
        arID[3][3]=R.id.b33;
        arID[3][4]=R.id.b34;
        arID[3][5]=R.id.b35;
        arID[3][6]=R.id.b36;
        arID[4][0]=R.id.b40;
        arID[4][1]=R.id.b41;
        arID[4][2]=R.id.b42;
        arID[4][3]=R.id.b43;
        arID[4][4]=R.id.b44;
        arID[4][5]=R.id.b45;
        arID[4][6]=R.id.b46;
        arID[5][0]=R.id.b50;
        arID[5][1]=R.id.b51;
        arID[5][2]=R.id.b52;
        arID[5][3]=R.id.b53;
        arID[5][4]=R.id.b54;
        arID[5][5]=R.id.b55;
        arID[5][6]=R.id.b56;
        arID[6][0]=R.id.b60;
        arID[6][1]=R.id.b61;
        arID[6][2]=R.id.b62;
        arID[6][3]=R.id.b63;
        arID[6][4]=R.id.b64;
        arID[6][5]=R.id.b65;
        arID[6][6]=R.id.b66;

        //Tạo ký tự trên button
        createTable();
        //Tạo Hint
        createHint();
        //Set sự kiện
        createOnClick();
        //Set thời gian
        createTime();
        //Tạo hình ảnh item game
        createGameItem();
        //Tắt bảng score
        relativeLayout.setVisibility(View.INVISIBLE);
        //Tạo sharedpreferences


        sharedPreferences=getSharedPreferences("BXH",Context.MODE_PRIVATE);
        /*SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.commit();*/
        String key=sharedPreferences.getString("key","");

        player=(key=="")?0:Integer.parseInt(key);
    }


    //Sự kiện Vào game
    @Override
    public void onClick(View view) {
        mpClick.start();
        //reset
        if (view.getId() == R.id.reset) reset();

        //hint
        if(view.getId()==R.id.hint){
            if(hintTimes>0) {
                clearTable();
                hintTimes -= 1;
                handlerhint=new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        createTable();
                    }
                };
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handlerhint.sendEmptyMessage(0);
                    }
                },1300);
            }
            txtcountHint.setText(String.valueOf(hintTimes).toString());
        }

        //Win game
        if (win == 23) {
            clearTable();
            mediaPlayer.stop();
            mpEndGame.stop();
            mpTimeOut.stop();
            bonusScore=playTime;
            playTime = 0;
            mpWinGame.start();
            playTimer.cancel();
            block();
            winGame();
            putBXH(tongDiem());


        } else
            for (int i = 0; i < 7; ++i) {
                for (int j = 0; j < 7; ++j) {
                    if (view.getId() == arID[i][j]) {
                        if(arBtn[i][j].getHint()=="+1"){//Tạo số lần hint
                            hintTimes+=1;
                            txtcountHint.setText(String.valueOf(hintTimes).toString());
                            arBtn[i][j].setText("");
                            final int a=i;
                            final int b=j;
                            handlerhint2=new Handler(){
                                @Override
                                public void handleMessage(Message msg) {
                                    super.handleMessage(msg);
                                    arBtn[a][b].setVisibility(View.INVISIBLE);
                                    arBtn[a][b].setEnabled(false);
                                }
                            };
                            new Timer().schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    handlerhint2.sendEmptyMessage(0);
                                }
                            },700);
                            continue;
                        }
                        if (check == 1) {
                            tmp1 = findViewById(arID[i][j]);
                            id1 = arID[i][j];
                            tmp1.setText("");
                            tmp1.setEnabled(false);
                            check = 2;
                            //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                        } else if (check == 2) {
                            controlBoard();
                            //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                            tmp2 = findViewById(arID[i][j]);
                            id2 = arID[i][j];
                            if (tmp1.getHint() == tmp2.getHint()) {
                                score+=5;
                                txtscore.setText(String.valueOf(score).toString());
                                //checkpoint
                                win += 1;
                                mpAccept.start();

                                tmp2.setText("");
                                tmp2.setEnabled(false);
                                handler = new Handler() {
                                    @Override
                                    public void handleMessage(Message msg) {
                                        super.handleMessage(msg);
                                        Button btn1, btn2;
                                        btn1 = findViewById(id1);
                                        btn2 = findViewById(id2);
                                        btn1.setVisibility(View.INVISIBLE);
                                        btn2.setVisibility(View.INVISIBLE);
                                        check = 1;
                                    }
                                };

                                new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        // this code will be executed after 10 minutes
                                        handler.sendEmptyMessage(0);
                                    }
                                }, time);

                            } else {
                                tmp2.setText("");
                                tmp2.setEnabled(false);
                                handler = new Handler() {
                                    @Override
                                    public void handleMessage(Message msg) {
                                        super.handleMessage(msg);
                                        tmp1.setText(small_icon);
                                        tmp2.setText(small_icon);
                                        tmp1.setEnabled(true);
                                        tmp2.setEnabled(true);
                                        tmp1 = null;
                                        tmp2 = null;
                                        check = 1;
                                    }
                                };

                                new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        // this code will be executed after 10 minutes
                                        handler.sendEmptyMessage(0);
                                    }
                                }, time);
                            }
                        }
                        break;
                    }
                }
            }
    }

    //Reset
    public void reset(){

        new AlertDialog.Builder(this)
                .setMessage("Tạo mới game ??")
                .setCancelable(false)
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        for(int i=0;i<7;++i){
                            for(int j=0;j<7;++j){
                                arBtn[i][j].setText(small_icon);
                                arBtn[i][j].setEnabled(true);
                                arBtn[i][j].setVisibility(View.VISIBLE);
                            }
                        }
                        mediaPlayer.start();
                        playTimer.cancel();
                        if(etCustomTime.getText().toString().length()>0){
                            playTime=Integer.parseInt(etCustomTime.getText().toString())*60;
                        }
                        else playTime=time;
                        win=0;
                        hintTimes=2;
                        txtcountHint.setText(String.valueOf(hintTimes).toString());
                        score=0;
                        txtscore.setText(String.valueOf(score).toString());
                        createTable();
                        createHint();
                        createTime();

                        unBlock();
                        relativeLayout.setVisibility(View.INVISIBLE);
                    }
                })
                .setPositiveButton("No", null)
                .show();

    }
    //Block
    public void block(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setOnClickListener(null);
            }
        }
        hint.setOnClickListener(null);
    }
    //unBlock
    public void unBlock(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setOnClickListener(MainActivity.this);
            }
        }
        hint.setOnClickListener(MainActivity.this);
    }
    //Lỗi bấm 3 số
    public void controlBoard(){
            block();
           // Toast.makeText(MainActivity.this, "Block", Toast.LENGTH_SHORT).show();
            handler2 = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    unBlock();
                   // Toast.makeText(MainActivity.this, "unlock", Toast.LENGTH_SHORT).show();
                }
            };
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler2.sendEmptyMessage(0);
                }
            }, timeBlock);

    }

    public void createTime(){
        handlerplayTime=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what>=0){
                    String res="";
                    int m,s;
                    m=playTime/60;
                    s=playTime%60;
                    if(s<10)
                        res=String.valueOf(m).toString()+":0"+String.valueOf(s).toString();
                    else res=String.valueOf(m).toString()+":"+String.valueOf(s).toString();
                    if(m==0&&s<10&&s>0){
                        mpTimeOut.start();
                    }
                    txtPlayTime.setText(res);
                    playTime-=1;
                }
                //End Game
                if (msg.what==0&&win<24){
                    Toast.makeText(MainActivity.this,"Xong film",Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mpEndGame.start();
                    clearTable();
                    block();
                    loseGame();
                    putBXH(tongDiem());
                }
            }
        };
        playTimer = new Timer();
        playTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerplayTime.sendEmptyMessage(playTime);
            }
        },1000, 1000);
    }
    public void createTable(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setText(small_icon);
            }
        }
    }
    //Kết quả game
    public int tongDiem(){
        bonusScore+=1;
        return win*5+bonusScore;
    }
    public void winGame(){
        relativeLayout.setVisibility(View.VISIBLE);
        tvKQ.setText("Chiến Thắng");
        tvFinalScore.setText(String.valueOf(tongDiem()).toString());
        tvbonusScore.setText("(+"+String.valueOf(bonusScore).toString()+")");

    }
    public void loseGame(){
        relativeLayout.setVisibility(View.VISIBLE);
        tvKQ.setText("Thất Bại");
        tvFinalScore.setText(String.valueOf(tongDiem()).toString());
        tvbonusScore.setText("(+"+String.valueOf(bonusScore).toString()+")");

    }
    public void clearTable(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setText("");
            }
        }
    }
    public void createHint(){
        String startValues="+1";
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setHint(startValues);
            }
        }
        Random rand=new Random();
        for(int i=1;i<=24;++i){
            int x=rand.nextInt(7);
            int y=rand.nextInt(7);
            while(arBtn[x][y].getHint()!=startValues){
                x=rand.nextInt(7);
                y=rand.nextInt(7);
            }
            arBtn[x][y].setHint(String.valueOf(i).toString());
            while(arBtn[x][y].getHint()!=startValues){
                x=rand.nextInt(7);
                y=rand.nextInt(7);
            }
            arBtn[x][y].setHint(String.valueOf(i).toString());
        }
    }

    public void createOnClick(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setOnClickListener(MainActivity.this);
            }
        }
    }

    public void createGameItem(){
        for(int i=0;i<7;++i){
            for(int j=0;j<7;++j){
                arBtn[i][j].setHintTextColor(getResources().getColor(R.color.hintcolor));
                arBtn[i][j].setBackground(ContextCompat.getDrawable(MainActivity.this,R.drawable.custom_gameitem));
                arBtn[i][j].setText(small_icon);
                arBtn[i][j].setTextColor(getResources().getColor(R.color.mauhong));
                arBtn[i][j].setTextSize(20);
            }
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Trở về menu ??")
                .setCancelable(false)
                .setNegativeButton("Ừ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("key",String.valueOf(player).toString());
                        editor.commit();
                        MainActivity.this.finish();
                    }
                })
                .setPositiveButton("Nố nô nô nồ", null)
                .show();
    }
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mpTimeOut.stop();
        mpEndGame.stop();
        mpWinGame.stop();
        mpClick.stop();
        mpAccept.stop();
    }

    public void putBXH(int point){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(String.valueOf(player).toString(),String.valueOf(point).toString());
        editor.commit();
        player++;
    }

}

