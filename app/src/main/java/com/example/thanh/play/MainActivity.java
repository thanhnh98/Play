package com.example.thanh.play;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button s00;
    Button s01;
    Button s02;
    Button s03;
    Button s04;
    Button s05;
    Button s06;
    Button s10;
    Button s11;
    Button s12;
    Button s13;
    Button s14;
    Button s15;
    Button s16;
    Button s20;
    Button s21;
    Button s22;
    Button s23;
    Button s24;
    Button s25;
    Button s26;
    Button s30;
    Button s31;
    Button s32;
    Button s33;
    Button s34;
    Button s35;
    Button s36;
    Button s40;
    Button s41;
    Button s42;
    Button s43;
    Button s44;
    Button s45;
    Button s46;
    Button s50;
    Button s51;
    Button s52;
    Button s53;
    Button s54;
    Button s55;
    Button s56;
    Button s60;
    Button s61;
    Button s62;
    Button s63;
    Button s64;
    Button s65;
    Button s66;

    Button arBtn[][]=new Button[7][7];
    Button tmp1;
    Button tmp2;
    int id1,id2;
    int check;
    int time=600;
    int timeBlock=700;
    Handler handler,handler2,handlerplayTime;
    String small_icon;
    int soLanThaoTac=0;
    MediaPlayer mediaPlayer,mpClick,mpAccept,mpTimeOut,mpEndGame,mpWinGame;
    int win=0;
    Button rs;
    ToggleButton toggleButton;
    int playTime=20;
    TextView txtPlayTime;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
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
        toggleButton=findViewById(R.id.sound);
        txtPlayTime=findViewById(R.id.txtplayTime);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(toggleButton.isChecked()){
                    mediaPlayer.stop();
                }
                else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.nhac);
                    mediaPlayer.start();
                }
            }
        });
        small_icon="*";
        //Set thời gian
        createTime();
        //Tìm button
        //Gán biến
        check=1;
        rs=findViewById(R.id.reset);
        rs.setOnClickListener(this);
        s00=findViewById(R.id.b00);
        s01=findViewById(R.id.b01);
        s02=findViewById(R.id.b02);
        s03=findViewById(R.id.b03);
        s04=findViewById(R.id.b04);
        s05=findViewById(R.id.b05);
        s06=findViewById(R.id.b06);
        s10=findViewById(R.id.b10);
        s11=findViewById(R.id.b11);
        s12=findViewById(R.id.b12);
        s13=findViewById(R.id.b13);
        s14=findViewById(R.id.b14);
        s15=findViewById(R.id.b15);
        s16=findViewById(R.id.b16);
        s20=findViewById(R.id.b20);
        s21=findViewById(R.id.b21);
        s22=findViewById(R.id.b22);
        s23=findViewById(R.id.b23);
        s24=findViewById(R.id.b24);
        s25=findViewById(R.id.b25);
        s26=findViewById(R.id.b26);
        s30=findViewById(R.id.b30);
        s31=findViewById(R.id.b31);
        s32=findViewById(R.id.b32);
        s33=findViewById(R.id.b33);
        s34=findViewById(R.id.b34);
        s35=findViewById(R.id.b35);
        s36=findViewById(R.id.b36);
        s40=findViewById(R.id.b40);
        s41=findViewById(R.id.b41);
        s42=findViewById(R.id.b42);
        s43=findViewById(R.id.b43);
        s44=findViewById(R.id.b44);
        s45=findViewById(R.id.b45);
        s46=findViewById(R.id.b46);
        s50=findViewById(R.id.b50);
        s51=findViewById(R.id.b51);
        s52=findViewById(R.id.b52);
        s53=findViewById(R.id.b53);
        s54=findViewById(R.id.b54);
        s55=findViewById(R.id.b55);
        s56=findViewById(R.id.b56);
        s60=findViewById(R.id.b60);
        s61=findViewById(R.id.b61);
        s62=findViewById(R.id.b62);
        s63=findViewById(R.id.b63);
        s64=findViewById(R.id.b64);
        s65=findViewById(R.id.b65);
        s66=findViewById(R.id.b66);

        //Tạo mảng lưu trữ
        


        //Tạo biểu tượng ban đầu
        s00.setText(small_icon);
        s01.setText(small_icon);
        s02.setText(small_icon);
        s03.setText(small_icon);
        s04.setText(small_icon);
        s05.setText(small_icon);
        s06.setText(small_icon);
        s10.setText(small_icon);
        s11.setText(small_icon);
        s12.setText(small_icon);
        s13.setText(small_icon);
        s14.setText(small_icon);
        s15.setText(small_icon);
        s16.setText(small_icon);
        s20.setText(small_icon);
        s21.setText(small_icon);
        s22.setText(small_icon);
        s23.setText(small_icon);
        s24.setText(small_icon);
        s25.setText(small_icon);
        s26.setText(small_icon);
        s30.setText(small_icon);
        s31.setText(small_icon);
        s32.setText(small_icon);
        s33.setText(small_icon);
        s34.setText(small_icon);
        s35.setText(small_icon);
        s36.setText(small_icon);
        s40.setText(small_icon);
        s41.setText(small_icon);
        s42.setText(small_icon);
        s43.setText(small_icon);
        s44.setText(small_icon);
        s45.setText(small_icon);
        s46.setText(small_icon);
        s50.setText(small_icon);
        s51.setText(small_icon);
        s52.setText(small_icon);
        s53.setText(small_icon);
        s54.setText(small_icon);
        s55.setText(small_icon);
        s56.setText(small_icon);
        s60.setText(small_icon);
        s61.setText(small_icon);
        s62.setText(small_icon);
        s63.setText(small_icon);
        s64.setText(small_icon);
        s65.setText(small_icon);
        s66.setText(small_icon);




        //Tạo giá trị
        s00.setHint("3");
        s01.setHint("13");
        s02.setHint("6");
        s03.setHint("24");
        s04.setHint("12");
        s05.setHint("15");
        s06.setHint("17");
        s10.setHint("12");
        s11.setHint("19");
        s12.setHint("16");
        s13.setHint("7");
        s14.setHint("14");
        s15.setHint("11");
        s16.setHint("21");
        s20.setHint("7");
        s21.setHint("14");
        s22.setHint("10");
        s23.setHint("17");
        s24.setHint("18");
        s25.setHint("8");
        s26.setHint("2");
        s30.setHint("10");
        s31.setHint("13");
        s32.setHint("15");
        s33.setHint("5");
        s34.setHint("21");
        s35.setHint("8");
        s36.setHint("1");
        s40.setHint("1");
        s41.setHint("9");
        s42.setHint("22");
        s43.setHint("5");
        s44.setHint("19");
        s45.setHint("18");
        s46.setHint("4");
        s50.setHint("22");
        s51.setHint("4");
        s52.setHint("16");
        s53.setHint("9");
        s54.setHint("20");
        s55.setHint("2");
        s56.setHint("11");
        s60.setHint("23");
        s61.setHint("20");
        s62.setHint("0");
        s63.setHint("6");
        s64.setHint("3");
        s65.setHint("24");
        s66.setHint("23");


        //Set sự kiện
        s00.setOnClickListener(this);
        s01.setOnClickListener(this);
        s02.setOnClickListener(this);
        s03.setOnClickListener(this);
        s04.setOnClickListener(this);
        s05.setOnClickListener(this);
        s06.setOnClickListener(this);
        s10.setOnClickListener(this);
        s11.setOnClickListener(this);
        s12.setOnClickListener(this);
        s13.setOnClickListener(this);
        s14.setOnClickListener(this);
        s15.setOnClickListener(this);
        s16.setOnClickListener(this);
        s20.setOnClickListener(this);
        s21.setOnClickListener(this);
        s22.setOnClickListener(this);
        s23.setOnClickListener(this);
        s24.setOnClickListener(this);
        s25.setOnClickListener(this);
        s26.setOnClickListener(this);
        s30.setOnClickListener(this);
        s31.setOnClickListener(this);
        s32.setOnClickListener(this);
        s33.setOnClickListener(this);
        s34.setOnClickListener(this);
        s35.setOnClickListener(this);
        s36.setOnClickListener(this);
        s40.setOnClickListener(this);
        s41.setOnClickListener(this);
        s42.setOnClickListener(this);
        s43.setOnClickListener(this);
        s44.setOnClickListener(this);
        s45.setOnClickListener(this);
        s46.setOnClickListener(this);
        s50.setOnClickListener(this);
        s51.setOnClickListener(this);
        s52.setOnClickListener(this);
        s53.setOnClickListener(this);
        s54.setOnClickListener(this);
        s55.setOnClickListener(this);
        s56.setOnClickListener(this);
        s60.setOnClickListener(this);
        s61.setOnClickListener(this);
        s62.setOnClickListener(this);
        s63.setOnClickListener(this);
        s64.setOnClickListener(this);
        s65.setOnClickListener(this);
        s66.setOnClickListener(this);

        //Khởi tạo giá trị



    }
    Button btnCase;
    int demThaoTac=0;
    //Sự kiện
    @Override
    public void onClick(View view) {
        mpClick.start();
        //Win game
         if(win==1){
             Toast.makeText(MainActivity.this,"Win",Toast.LENGTH_SHORT).show();
             mediaPlayer.stop();
             mpEndGame.stop();
             mpTimeOut.stop();
             playTime=0;
             mpWinGame.start();



         }
         else

             switch (view.getId()){
                 case R.id.b00:


                     if(check==1){
                         tmp1=findViewById(R.id.b00);
                         id1=R.id.b00;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b00);
                         id2=R.id.b00;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b01:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b01);
                         id1=R.id.b01;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b01);
                         id2=R.id.b01;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b02:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b02);
                         id1=R.id.b02;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b02);
                         id2=R.id.b02;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;


                 case R.id.b03:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b03);
                         id1=R.id.b03;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b03);
                         id2=R.id.b03;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b04:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b04);
                         id1=R.id.b04;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b04);
                         id2=R.id.b04;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b05:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b05);
                         id1=R.id.b05;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b05);
                         id2=R.id.b05;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b06:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b06);
                         id1=R.id.b06;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b06);
                         id2=R.id.b06;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;


                 case R.id.b10:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b10);
                         id1=R.id.b10;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b10);
                         id2=R.id.b10;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, 700);
                         }
                     }
                     break;
                 case R.id.b11:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b11);
                         id1=R.id.b11;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b11);
                         id2=R.id.b11;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b12:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b12);
                         id1=R.id.b12;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b12);
                         id2=R.id.b12;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b13:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b13);
                         id1=R.id.b13;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b13);
                         id2=R.id.b13;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b14:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b14);
                         id1=R.id.b14;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b14);
                         id2=R.id.b14;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b15:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b15);
                         id1=R.id.b15;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b15);
                         id2=R.id.b15;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;


                 case R.id.b16:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b16);
                         id1=R.id.b16;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b16);
                         id2=R.id.b16;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b20:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b20);
                         id1=R.id.b20;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b20);
                         id2=R.id.b20;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b21:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b21);
                         id1=R.id.b21;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b21);
                         id2=R.id.b21;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b22:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b22);
                         id1=R.id.b22;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b22);
                         id2=R.id.b22;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b23:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b23);
                         id1=R.id.b23;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b23);
                         id2=R.id.b23;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b24:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b24);
                         id1=R.id.b24;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b24);
                         id2=R.id.b24;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b25:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b25);
                         id1=R.id.b25;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b25);
                         id2=R.id.b25;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b26:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b26);
                         id1=R.id.b26;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b26);
                         id2=R.id.b26;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b30:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b30);
                         id1=R.id.b30;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b30);
                         id2=R.id.b30;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b31:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b31);
                         id1=R.id.b31;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b31);
                         id2=R.id.b31;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b32:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b32);
                         id1=R.id.b32;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b32);
                         id2=R.id.b32;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b33:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b33);
                         id1=R.id.b33;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b33);
                         id2=R.id.b33;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b34:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b34);
                         id1=R.id.b34;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b34);
                         id2=R.id.b34;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b35:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b35);
                         id1=R.id.b35;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b35);
                         id2=R.id.b35;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b36:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b36);
                         id1=R.id.b36;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b36);
                         id2=R.id.b36;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b40:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b40);
                         id1=R.id.b40;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b40);
                         id2=R.id.b40;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b41:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b41);
                         id1=R.id.b41;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b41);
                         id2=R.id.b41;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;
                 case R.id.b42:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b42);
                         id1=R.id.b42;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b42);
                         id2=R.id.b42;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b43:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b43);
                         id1=R.id.b43;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b43);
                         id2=R.id.b43;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b44:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b44);
                         id1=R.id.b44;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b44);
                         id2=R.id.b44;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b45:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b45);
                         id1=R.id.b45;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b45);
                         id2=R.id.b45;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b46:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b46);
                         id1=R.id.b46;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b46);
                         id2=R.id.b46;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b50:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b50);
                         id1=R.id.b50;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b50);
                         id2=R.id.b50;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b51:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b51);
                         id1=R.id.b51;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b51);
                         id2=R.id.b51;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b52:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b52);
                         id1=R.id.b52;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b52);
                         id2=R.id.b52;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b53:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b53);
                         id1=R.id.b53;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b53);
                         id2=R.id.b53;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b54:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b54);
                         id1=R.id.b54;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b54);
                         id2=R.id.b54;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b55:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b55);
                         id1=R.id.b55;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b55);
                         id2=R.id.b55;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b56:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b56);
                         id1=R.id.b56;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b56);
                         id2=R.id.b56;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b60:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b60);
                         id1=R.id.b60;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b60);
                         id2=R.id.b60;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b61:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b61);
                         id1=R.id.b61;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b61);
                         id2=R.id.b61;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b62:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b62);
                         id1=R.id.b62;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b62);
                         id2=R.id.b62;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b63:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b63);
                         id1=R.id.b63;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b63);
                         id2=R.id.b63;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b64:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b64);
                         id1=R.id.b64;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b64);
                         id2=R.id.b64;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b65:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b65);
                         id1=R.id.b65;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b65);
                         id2=R.id.b65;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;

                 case R.id.b66:
                     //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                     if(check==1){
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp1=findViewById(R.id.b66);
                         id1=R.id.b66;
                         tmp1.setText("");
                         tmp1.setEnabled(false);
                         check=2;
                     }
                     else if(check==2){ controlBoard();
                         //Toast.makeText(MainActivity.this,String.valueOf(check).toString(),Toast.LENGTH_SHORT).show();
                         tmp2=findViewById(R.id.b66);
                         id2=R.id.b66;
                         if(tmp1.getHint()==tmp2.getHint()){win+=1;mpAccept.start();

                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     Button btn1,btn2;
                                     btn1=findViewById(id1);
                                     btn2=findViewById(id2);
                                     btn1.setVisibility(View.INVISIBLE);
                                     btn2.setVisibility(View.INVISIBLE);
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);

                         }
                         else {
                             tmp2.setText("");
                             tmp2.setEnabled(false);
                             handler=new Handler(){
                                 @Override
                                 public void handleMessage(Message msg) {
                                     super.handleMessage(msg);
                                     tmp1.setText(small_icon);
                                     tmp2.setText(small_icon);
                                     tmp1.setEnabled(true);
                                     tmp2.setEnabled(true);
                                     tmp1=null;
                                     tmp2=null;
                                     check=1;
                                 }
                             };

                             new Timer().schedule(new TimerTask() {
                                 @Override    public void run() {
                                     // this code will be executed after 10 minutes
                                     handler.sendEmptyMessage(0);
                                 }
                             }, time);
                         }
                     }
                     break;


                 case R.id.reset:
                     Intent intent = new Intent(MainActivity.this,MainActivity.class);

                     startActivity(intent);

                     finish();
                     break;

                 default:
                     break;







             }

    }


    public void reset(){
        s00.setText(small_icon);
        s01.setText(small_icon);
        s02.setText(small_icon);
        s03.setText(small_icon);
        s04.setText(small_icon);
        s05.setText(small_icon);
        s06.setText(small_icon);
        s10.setText(small_icon);
        s11.setText(small_icon);
        s12.setText(small_icon);
        s13.setText(small_icon);
        s14.setText(small_icon);
        s15.setText(small_icon);
        s16.setText(small_icon);
        s20.setText(small_icon);
        s21.setText(small_icon);
        s22.setText(small_icon);
        s23.setText(small_icon);
        s24.setText(small_icon);
        s25.setText(small_icon);
        s26.setText(small_icon);
        s30.setText(small_icon);
        s31.setText(small_icon);
        s32.setText(small_icon);
        s33.setText(small_icon);
        s34.setText(small_icon);
        s35.setText(small_icon);
        s36.setText(small_icon);
        s40.setText(small_icon);
        s41.setText(small_icon);
        s42.setText(small_icon);
        s43.setText(small_icon);
        s44.setText(small_icon);
        s45.setText(small_icon);
        s46.setText(small_icon);
        s50.setText(small_icon);
        s51.setText(small_icon);
        s52.setText(small_icon);
        s53.setText(small_icon);
        s54.setText(small_icon);
        s55.setText(small_icon);
        s56.setText(small_icon);
        s60.setText(small_icon);
        s61.setText(small_icon);
        s62.setText(small_icon);
        s63.setText(small_icon);
        s64.setText(small_icon);
        s65.setText(small_icon);
        s66.setText(small_icon);

        s00.setVisibility(View.VISIBLE);
        s01.setVisibility(View.VISIBLE);
        s02.setVisibility(View.VISIBLE);
        s03.setVisibility(View.VISIBLE);
        s04.setVisibility(View.VISIBLE);
        s05.setVisibility(View.VISIBLE);
        s06.setVisibility(View.VISIBLE);
        s10.setVisibility(View.VISIBLE);
        s11.setVisibility(View.VISIBLE);
        s12.setVisibility(View.VISIBLE);
        s13.setVisibility(View.VISIBLE);
        s14.setVisibility(View.VISIBLE);
        s15.setVisibility(View.VISIBLE);
        s16.setVisibility(View.VISIBLE);
        s20.setVisibility(View.VISIBLE);
        s21.setVisibility(View.VISIBLE);
        s22.setVisibility(View.VISIBLE);
        s23.setVisibility(View.VISIBLE);
        s24.setVisibility(View.VISIBLE);
        s25.setVisibility(View.VISIBLE);
        s26.setVisibility(View.VISIBLE);
        s30.setVisibility(View.VISIBLE);
        s31.setVisibility(View.VISIBLE);
        s32.setVisibility(View.VISIBLE);
        s33.setVisibility(View.VISIBLE);
        s34.setVisibility(View.VISIBLE);
        s35.setVisibility(View.VISIBLE);
        s36.setVisibility(View.VISIBLE);
        s40.setVisibility(View.VISIBLE);
        s41.setVisibility(View.VISIBLE);
        s42.setVisibility(View.VISIBLE);
        s43.setVisibility(View.VISIBLE);
        s44.setVisibility(View.VISIBLE);
        s45.setVisibility(View.VISIBLE);
        s46.setVisibility(View.VISIBLE);
        s50.setVisibility(View.VISIBLE);
        s51.setVisibility(View.VISIBLE);
        s52.setVisibility(View.VISIBLE);
        s53.setVisibility(View.VISIBLE);
        s54.setVisibility(View.VISIBLE);
        s55.setVisibility(View.VISIBLE);
        s56.setVisibility(View.VISIBLE);
        s60.setVisibility(View.VISIBLE);
        s61.setVisibility(View.VISIBLE);
        s62.setVisibility(View.VISIBLE);
        s63.setVisibility(View.VISIBLE);
        s64.setVisibility(View.VISIBLE);
        s65.setVisibility(View.VISIBLE);
        s66.setVisibility(View.VISIBLE);

        s00.setEnabled(true);
        s01.setEnabled(true);
        s02.setEnabled(true);
        s03.setEnabled(true);
        s04.setEnabled(true);
        s05.setEnabled(true);
        s06.setEnabled(true);
        s10.setEnabled(true);
        s11.setEnabled(true);
        s12.setEnabled(true);
        s13.setEnabled(true);
        s14.setEnabled(true);
        s15.setEnabled(true);
        s16.setEnabled(true);
        s20.setEnabled(true);
        s21.setEnabled(true);
        s22.setEnabled(true);
        s23.setEnabled(true);
        s24.setEnabled(true);
        s25.setEnabled(true);
        s26.setEnabled(true);
        s30.setEnabled(true);
        s31.setEnabled(true);
        s32.setEnabled(true);
        s33.setEnabled(true);
        s34.setEnabled(true);
        s35.setEnabled(true);
        s36.setEnabled(true);
        s40.setEnabled(true);
        s41.setEnabled(true);
        s42.setEnabled(true);
        s43.setEnabled(true);
        s44.setEnabled(true);
        s45.setEnabled(true);
        s46.setEnabled(true);
        s50.setEnabled(true);
        s51.setEnabled(true);
        s52.setEnabled(true);
        s53.setEnabled(true);
        s54.setEnabled(true);
        s55.setEnabled(true);
        s56.setEnabled(true);
        s60.setEnabled(true);
        s61.setEnabled(true);
        s62.setEnabled(true);
        s63.setEnabled(true);
        s64.setEnabled(true);
        s65.setEnabled(true);
        s66.setEnabled(true);

        win=0;


    }
    public void block(){
        s00.setOnClickListener(null);
        s01.setOnClickListener(null);
        s02.setOnClickListener(null);
        s03.setOnClickListener(null);
        s04.setOnClickListener(null);
        s05.setOnClickListener(null);
        s06.setOnClickListener(null);
        s10.setOnClickListener(null);
        s11.setOnClickListener(null);
        s12.setOnClickListener(null);
        s13.setOnClickListener(null);
        s14.setOnClickListener(null);
        s15.setOnClickListener(null);
        s16.setOnClickListener(null);
        s20.setOnClickListener(null);
        s21.setOnClickListener(null);
        s22.setOnClickListener(null);
        s23.setOnClickListener(null);
        s24.setOnClickListener(null);
        s25.setOnClickListener(null);
        s26.setOnClickListener(null);
        s30.setOnClickListener(null);
        s31.setOnClickListener(null);
        s32.setOnClickListener(null);
        s33.setOnClickListener(null);
        s34.setOnClickListener(null);
        s35.setOnClickListener(null);
        s36.setOnClickListener(null);
        s40.setOnClickListener(null);
        s41.setOnClickListener(null);
        s42.setOnClickListener(null);
        s43.setOnClickListener(null);
        s44.setOnClickListener(null);
        s45.setOnClickListener(null);
        s46.setOnClickListener(null);
        s50.setOnClickListener(null);
        s51.setOnClickListener(null);
        s52.setOnClickListener(null);
        s53.setOnClickListener(null);
        s54.setOnClickListener(null);
        s55.setOnClickListener(null);
        s56.setOnClickListener(null);
        s60.setOnClickListener(null);
        s61.setOnClickListener(null);
        s62.setOnClickListener(null);
        s63.setOnClickListener(null);
        s64.setOnClickListener(null);
        s65.setOnClickListener(null);
        s66.setOnClickListener(null);




    }
    public void unBlock(){
        s00.setOnClickListener(MainActivity.this);
        s01.setOnClickListener(MainActivity.this);
        s02.setOnClickListener(MainActivity.this);
        s03.setOnClickListener(MainActivity.this);
        s04.setOnClickListener(MainActivity.this);
        s05.setOnClickListener(MainActivity.this);
        s06.setOnClickListener(MainActivity.this);
        s10.setOnClickListener(MainActivity.this);
        s11.setOnClickListener(MainActivity.this);
        s12.setOnClickListener(MainActivity.this);
        s13.setOnClickListener(MainActivity.this);
        s14.setOnClickListener(MainActivity.this);
        s15.setOnClickListener(MainActivity.this);
        s16.setOnClickListener(MainActivity.this);
        s20.setOnClickListener(MainActivity.this);
        s21.setOnClickListener(MainActivity.this);
        s22.setOnClickListener(MainActivity.this);
        s23.setOnClickListener(MainActivity.this);
        s24.setOnClickListener(MainActivity.this);
        s25.setOnClickListener(MainActivity.this);
        s26.setOnClickListener(MainActivity.this);
        s30.setOnClickListener(MainActivity.this);
        s31.setOnClickListener(MainActivity.this);
        s32.setOnClickListener(MainActivity.this);
        s33.setOnClickListener(MainActivity.this);
        s34.setOnClickListener(MainActivity.this);
        s35.setOnClickListener(MainActivity.this);
        s36.setOnClickListener(MainActivity.this);
        s40.setOnClickListener(MainActivity.this);
        s41.setOnClickListener(MainActivity.this);
        s42.setOnClickListener(MainActivity.this);
        s43.setOnClickListener(MainActivity.this);
        s44.setOnClickListener(MainActivity.this);
        s45.setOnClickListener(MainActivity.this);
        s46.setOnClickListener(MainActivity.this);
        s50.setOnClickListener(MainActivity.this);
        s51.setOnClickListener(MainActivity.this);
        s52.setOnClickListener(MainActivity.this);
        s53.setOnClickListener(MainActivity.this);
        s54.setOnClickListener(MainActivity.this);
        s55.setOnClickListener(MainActivity.this);
        s56.setOnClickListener(MainActivity.this);
        s60.setOnClickListener(MainActivity.this);
        s61.setOnClickListener(MainActivity.this);
        s62.setOnClickListener(MainActivity.this);
        s63.setOnClickListener(MainActivity.this);
        s64.setOnClickListener(MainActivity.this);
        s65.setOnClickListener(MainActivity.this);
        s66.setOnClickListener(MainActivity.this);




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
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
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
                if (msg.what==0){
                    Toast.makeText(MainActivity.this,"Xong film",Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                    mpEndGame.start();
                }
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handlerplayTime.sendEmptyMessage(playTime);
            }
        },1000, 601);
    }



}
