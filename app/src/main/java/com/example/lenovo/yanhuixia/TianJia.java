package com.example.lenovo.yanhuixia;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.util.ArrayList;

public class TianJia extends AppCompatActivity {
    private LinearLayout linearLayout0;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    private LinearLayout linearLayout5;
    private LinearLayout linearLayout6;
    private LinearLayout linearLayout7;
    private LinearLayout linearLayout8;
    private LinearLayout linearLayout9;
    private LinearLayout linearLayout10;
    private LinearLayout linearLayout11;
    private LinearLayout linearLayout12;
    private LinearLayout linearLayout13;
    private LinearLayout linearLayout14;
    private LinearLayout linearLayout15;
    private LinearLayout linearLayout16;
    private LinearLayout linearLayout17;
    private LinearLayout linearLayout18;
    private LinearLayout linearLayout19;
    private LinearLayout linearLayout20;
    private LinearLayout linearLayout21;
    private LinearLayout linearLayout22;
    private LinearLayout linearLayout23;
    private LinearLayout linearLayout24;
    private LinearLayout linearLayout25;
    private LinearLayout linearLayout26;
    private LinearLayout linearLayout27;
    private LinearLayout linearLayout28;

    private TextView textView0;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;
    private TextView textView12;
    private TextView textView13;
    private TextView textView14;
    private TextView textView15;
    private TextView textView16;
    private TextView textView17;
    private TextView textView18;
    private TextView textView19;
    private TextView textView20;
    private TextView textView21;
    private TextView textView22;
    private TextView textView23;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    private TextView textView27;
    private TextView textView28;

    private EditText editText0;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;
    private EditText editText11;
    private EditText editText12;
    private EditText editText13;
    private EditText editText14;
    private EditText editText15;
    private EditText editText16;
    private EditText editText17;
    private EditText editText18;
    private EditText editText19;
    private EditText editText20;
    private EditText editText21;
    private EditText editText22;
    private EditText editText23;
    private EditText editText24;
    private EditText editText25;
    private EditText editText26;
    private EditText editText27;
    private EditText editText28;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_jia);

        linearLayout0 = (LinearLayout)findViewById(R.id.linearlayout0);
        linearLayout1 = (LinearLayout)findViewById(R.id.linearlayout1);
        linearLayout2 = (LinearLayout)findViewById(R.id.linearlayout2);
        linearLayout3 = (LinearLayout)findViewById(R.id.linearlayout3);
        linearLayout4 = (LinearLayout)findViewById(R.id.linearlayout4);
        linearLayout5 = (LinearLayout)findViewById(R.id.linearlayout5);
        linearLayout6 = (LinearLayout)findViewById(R.id.linearlayout6);
        linearLayout7 = (LinearLayout)findViewById(R.id.linearlayout7);
        linearLayout8 = (LinearLayout)findViewById(R.id.linearlayout8);
        linearLayout9 = (LinearLayout)findViewById(R.id.linearlayout9);
        linearLayout10 = (LinearLayout)findViewById(R.id.linearlayout10);
        linearLayout11= (LinearLayout)findViewById(R.id.linearlayout11);
        linearLayout12 = (LinearLayout)findViewById(R.id.linearlayout12);
        linearLayout13 = (LinearLayout)findViewById(R.id.linearlayout13);
        linearLayout14 = (LinearLayout)findViewById(R.id.linearlayout14);
        linearLayout15 = (LinearLayout)findViewById(R.id.linearlayout15);
        linearLayout16 = (LinearLayout)findViewById(R.id.linearlayout16);
        linearLayout17 = (LinearLayout)findViewById(R.id.linearlayout17);
        linearLayout18 = (LinearLayout)findViewById(R.id.linearlayout18);
        linearLayout19 = (LinearLayout)findViewById(R.id.linearlayout19);
        linearLayout20 = (LinearLayout)findViewById(R.id.linearlayout20);
        linearLayout21 = (LinearLayout)findViewById(R.id.linearlayout21);
        linearLayout22 = (LinearLayout)findViewById(R.id.linearlayout22);
        linearLayout23 = (LinearLayout)findViewById(R.id.linearlayout23);
        linearLayout24 = (LinearLayout)findViewById(R.id.linearlayout24);
        linearLayout25 = (LinearLayout)findViewById(R.id.linearlayout25);
        linearLayout26 = (LinearLayout)findViewById(R.id.linearlayout26);
        linearLayout27 = (LinearLayout)findViewById(R.id.linearlayout27);
        linearLayout28 = (LinearLayout)findViewById(R.id.linearlayout28);

        textView0 = (TextView)findViewById(R.id.textview0);
        textView1 = (TextView)findViewById(R.id.textview1);
        textView2 = (TextView)findViewById(R.id.textview2);
        textView3 = (TextView)findViewById(R.id.textview3);
        textView4 = (TextView)findViewById(R.id.textview4);
        textView5 = (TextView)findViewById(R.id.textview5);
        textView6 = (TextView)findViewById(R.id.textview6);
        textView7 = (TextView)findViewById(R.id.textview7);
        textView8 = (TextView)findViewById(R.id.textview8);
        textView9 = (TextView)findViewById(R.id.textview9);
        textView10 = (TextView)findViewById(R.id.textview10);
        textView11 = (TextView)findViewById(R.id.textview11);
        textView12 = (TextView)findViewById(R.id.textview12);
        textView13 = (TextView)findViewById(R.id.textview13);
        textView14 = (TextView)findViewById(R.id.textview14);
        textView15 = (TextView)findViewById(R.id.textview15);
        textView16 = (TextView)findViewById(R.id.textview16);
        textView17 = (TextView)findViewById(R.id.textview17);
        textView18 = (TextView)findViewById(R.id.textview18);
        textView19 = (TextView)findViewById(R.id.textview19);
        textView20 = (TextView)findViewById(R.id.textview20);
        textView21 = (TextView)findViewById(R.id.textview21);
        textView22 = (TextView)findViewById(R.id.textview22);
        textView23 = (TextView)findViewById(R.id.textview23);
        textView24 = (TextView)findViewById(R.id.textview24);
        textView25 = (TextView)findViewById(R.id.textview25);
        textView26 = (TextView)findViewById(R.id.textview26);
        textView27 = (TextView)findViewById(R.id.textview27);
        textView28 = (TextView)findViewById(R.id.textview28);

        editText0 = (EditText)findViewById(R.id.edittext0);
        editText1 = (EditText)findViewById(R.id.edittext1);
        editText2 = (EditText)findViewById(R.id.edittext2);
        editText3 = (EditText)findViewById(R.id.edittext3);
        editText4 = (EditText)findViewById(R.id.edittext4);
        editText5 = (EditText)findViewById(R.id.edittext5);
        editText6 = (EditText)findViewById(R.id.edittext6);
        editText7 = (EditText)findViewById(R.id.edittext7);
        editText8 = (EditText)findViewById(R.id.edittext8);
        editText9 = (EditText)findViewById(R.id.edittext9);
        editText10 = (EditText)findViewById(R.id.edittext10);
        editText11 = (EditText)findViewById(R.id.edittext11);
        editText12 = (EditText)findViewById(R.id.edittext12);
        editText13 = (EditText)findViewById(R.id.edittext13);
        editText14 = (EditText)findViewById(R.id.edittext14);
        editText15 = (EditText)findViewById(R.id.edittext15);
        editText16 = (EditText)findViewById(R.id.edittext16);
        editText17 = (EditText)findViewById(R.id.edittext17);
        editText18 = (EditText)findViewById(R.id.edittext18);
        editText19 = (EditText)findViewById(R.id.edittext19);
        editText20 = (EditText)findViewById(R.id.edittext20);
        editText21 = (EditText)findViewById(R.id.edittext21);
        editText22 = (EditText)findViewById(R.id.edittext22);
        editText23 = (EditText)findViewById(R.id.edittext23);
        editText24 = (EditText)findViewById(R.id.edittext24);
        editText25 = (EditText)findViewById(R.id.edittext25);
        editText26 = (EditText)findViewById(R.id.edittext26);
        editText27 = (EditText)findViewById(R.id.edittext27);
        editText28 = (EditText)findViewById(R.id.edittext28);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.tianjiafloatingactionbutton);


        Intent intent = getIntent();
        ArrayList<String> columnname = intent.getStringArrayListExtra("data");
        String url = intent.getStringExtra("url");

        if (columnname.size() == 29) {
            mymothend(linearLayout0,textView0,editText0,columnname.get(0));
            mymothend(linearLayout1,textView1,editText1,columnname.get(1));
            mymothend(linearLayout2,textView2,editText2,columnname.get(2));
            mymothend(linearLayout3,textView3,editText3,columnname.get(3));
            mymothend(linearLayout4,textView4,editText4,columnname.get(4));
            mymothend(linearLayout5,textView5,editText5,columnname.get(5));
            mymothend(linearLayout6,textView6,editText6,columnname.get(6));
            mymothend(linearLayout7,textView7,editText7,columnname.get(7));
            mymothend(linearLayout8,textView8,editText8,columnname.get(8));
            mymothend(linearLayout9,textView9,editText9,columnname.get(9));
            mymothend(linearLayout10,textView10,editText10,columnname.get(10));
            mymothend(linearLayout11,textView11,editText11,columnname.get(11));
            mymothend(linearLayout12,textView12,editText12,columnname.get(12));
            mymothend(linearLayout13,textView13,editText13,columnname.get(13));
            mymothend(linearLayout14,textView14,editText14,columnname.get(14));
            mymothend(linearLayout15,textView15,editText15,columnname.get(15));
            mymothend(linearLayout16,textView16,editText16,columnname.get(16));
            mymothend(linearLayout17,textView17,editText17,columnname.get(17));
            mymothend(linearLayout18,textView18,editText18,columnname.get(18));
            mymothend(linearLayout19,textView19,editText19,columnname.get(19));
            mymothend(linearLayout20,textView20,editText20,columnname.get(20));
            mymothend(linearLayout21,textView21,editText21,columnname.get(21));
            mymothend(linearLayout22,textView22,editText22,columnname.get(22));
            mymothend(linearLayout23,textView23,editText23,columnname.get(23));
            mymothend(linearLayout24,textView24,editText24,columnname.get(24));
            mymothend(linearLayout25,textView25,editText25,columnname.get(25));
            mymothend(linearLayout26,textView26,editText26,columnname.get(26));
            mymothend(linearLayout27,textView27,editText27,columnname.get(27));
            mymothend(linearLayout28,textView28,editText28,columnname.get(28));
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TianJia.this);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setMessage("数据添加中......");
                alertDialog.show();

                String name0 = "'" + editText0.getText().toString() + "'";
                String name1 = "'" + editText1.getText().toString() + "'";
                String name2 = "'" + editText2.getText().toString() + "'";
                String name3 = "'" + editText3.getText().toString() + "'";
                String name4 = "'" + editText4.getText().toString() + "'";
                String name5 = "'" + editText5.getText().toString() + "'";
                String name6 = "'" + editText6.getText().toString() + "'";
                String name7 = "'" + editText7.getText().toString() + "'";
                String name8 = "'" + editText8.getText().toString() + "'";
                String name9 = "'" + editText9.getText().toString() + "'";
                String name10 = "'" + editText10.getText().toString() + "'";
                String name11 = "'" + editText11.getText().toString() + "'";
                String name12 = "'" + editText12.getText().toString() + "'";
                String name13 = "'" + editText13.getText().toString() + "'";
                String name14 = "'" + editText14.getText().toString() + "'";
                String name15 = "'" + editText15.getText().toString() + "'";
                String name16 = "'" + editText16.getText().toString() + "'";
                String name17 = "'" + editText17.getText().toString() + "'";
                String name18 = "'" + editText18.getText().toString() + "'";
                String name19 = "'" + editText19.getText().toString() + "'";
                String name20 = "'" + editText20.getText().toString() + "'";
                String name21 = "'" + editText21.getText().toString() + "'";
                String name22 = "'" + editText22.getText().toString() + "'";
                String name23 = "'" + editText23.getText().toString() + "'";
                String name24 = "'" + editText24.getText().toString() + "'";
                String name25 = "'" + editText25.getText().toString() + "'";
                String name26 = "'" + editText26.getText().toString() + "'";
                String name27 = "'" + editText27.getText().toString() + "'";
                String name28 = "'" + editText28.getText().toString() + "'";

                ConnectivityManager cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
                assert cm != null;
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();

                if (networkInfo == null || !networkInfo.isAvailable()) {
                    alertDialog.dismiss();
                    Toast.makeText(TianJia.this,"请检测网络是否可用！",Toast.LENGTH_SHORT).show();
                }else if (editText0.getText().toString().trim().equals("")&&
                        editText1.getText().toString().trim().equals("")&&
                        editText2.getText().toString().trim().equals("")&&
                        editText3.getText().toString().trim().equals("")&&
                        editText4.getText().toString().trim().equals("")&&
                        editText5.getText().toString().trim().equals("")&&
                        editText6.getText().toString().trim().equals("")&&
                        editText7.getText().toString().trim().equals("")&&
                        editText8.getText().toString().trim().equals("")&&
                        editText9.getText().toString().trim().equals("")&&
                        editText10.getText().toString().trim().equals("")&&
                        editText11.getText().toString().trim().equals("")&&
                        editText12.getText().toString().trim().equals("")&&
                        editText13.getText().toString().trim().equals("")&&
                        editText14.getText().toString().trim().equals("")&&
                        editText15.getText().toString().trim().equals("")&&
                        editText16.getText().toString().trim().equals("")&&
                        editText17.getText().toString().trim().equals("")&&
                        editText18.getText().toString().trim().equals("")&&
                        editText19.getText().toString().trim().equals("")&&
                        editText20.getText().toString().trim().equals("")&&
                        editText21.getText().toString().trim().equals("")&&
                        editText22.getText().toString().trim().equals("")&&
                        editText23.getText().toString().trim().equals("")&&
                        editText24.getText().toString().trim().equals("")&&
                        editText25.getText().toString().trim().equals("")&&
                        editText26.getText().toString().trim().equals("")&&
                        editText27.getText().toString().trim().equals("")&&
                        editText28.getText().toString().trim().equals("")){
                    alertDialog.dismiss();
                    Toast.makeText(TianJia.this,"不能将所有内容设为空值！",Toast.LENGTH_SHORT).show();
                }else {

                    final int[] i = new int[1];

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://43.226.43.155:3306/mysql190312606e_db", "mysql190312606e", "60S6e49405");
                                PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into " + url + "(name1,name2,name3,name4,name5,name6,name7,name8,name9,name10,name11,name12,name13,name14,name15,name16,name17,name18,name19,name20,name21,name22,name23,name24,name25,name26,name27,name28,name29) values(" +
                                        name0 + "," +
                                        name1 + "," +
                                        name2 + "," +
                                        name3 + "," +
                                        name4 + "," +
                                        name5 + "," +
                                        name6 + "," +
                                        name7 + "," +
                                        name8 + "," +
                                        name9 + "," +
                                        name10 + "," +
                                        name11 + "," +
                                        name12 + "," +
                                        name13 + "," +
                                        name14 + "," +
                                        name15 + "," +
                                        name16 + "," +
                                        name17 + "," +
                                        name18 + "," +
                                        name19 + "," +
                                        name20 + "," +
                                        name21 + "," +
                                        name22 + "," +
                                        name23 + "," +
                                        name24 + "," +
                                        name25 + "," +
                                        name26 + "," +
                                        name27 + "," +
                                        name28 + ")" );
                                //ps.execute();

                                i[0] = ps.executeUpdate();

                                ps.close();
                                con.close();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        if (i[0] > 0) {
                                            alertDialog.dismiss();

                                            AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(TianJia.this);

                                            alertDialogBuilder1.setPositiveButton("直接退出", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    finish();

                                                }
                                            });
                                            alertDialogBuilder1.setNegativeButton("再添加一条", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {


                                                }
                                            });
                                            AlertDialog alertDialog1 = alertDialogBuilder1.create();
                                            alertDialog1.setTitle("提示：");
                                            alertDialog1.setMessage("数据添加成功！\n注意：请点击主页表格名称刷新数据，否则新添加数据显示不出来。");
                                            alertDialog1.show();
                                        } else {
                                            alertDialog.dismiss();
                                            Toast.makeText(TianJia.this, "数据库故障，请及时联系作者", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }).start();
                }
            }
        });
    }

    public void mymothend(LinearLayout linearLayout, TextView textView, EditText editText, String msg) {
        textView.setText(msg + ": ");
        if (msg.equals("")) {
            linearLayout.setVisibility(View.GONE);
        } else if (msg.equals("出库情况")) {
            editText.setCursorVisible(false);
            editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(TianJia.this);

                    alertDialogBuilder1.setPositiveButton("已出库", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editText.setText("已出库");

                        }
                    });
                    alertDialogBuilder1.setNegativeButton("未出库", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editText.setText("");
                            editText.setHint("未出库");

                        }
                    });
                    AlertDialog alertDialog1 = alertDialogBuilder1.create();
                    alertDialog1.setTitle("提示：");
                    alertDialog1.setMessage("请选择出库情况：");
                    alertDialog1.show();
                }
            });
        }
    }
}
