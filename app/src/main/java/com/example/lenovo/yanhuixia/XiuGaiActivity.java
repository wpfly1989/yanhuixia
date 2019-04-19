package com.example.lenovo.yanhuixia;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.util.ArrayList;

public class XiuGaiActivity extends AppCompatActivity {
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


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_gai);

        linearLayout0 = (LinearLayout)findViewById(R.id.xlinearlayout0);
        linearLayout1 = (LinearLayout)findViewById(R.id.xlinearlayout1);
        linearLayout2 = (LinearLayout)findViewById(R.id.xlinearlayout2);
        linearLayout3 = (LinearLayout)findViewById(R.id.xlinearlayout3);
        linearLayout4 = (LinearLayout)findViewById(R.id.xlinearlayout4);
        linearLayout5 = (LinearLayout)findViewById(R.id.xlinearlayout5);
        linearLayout6 = (LinearLayout)findViewById(R.id.xlinearlayout6);
        linearLayout7 = (LinearLayout)findViewById(R.id.xlinearlayout7);
        linearLayout8 = (LinearLayout)findViewById(R.id.xlinearlayout8);
        linearLayout9 = (LinearLayout)findViewById(R.id.xlinearlayout9);
        linearLayout10 = (LinearLayout)findViewById(R.id.xlinearlayout10);
        linearLayout11= (LinearLayout)findViewById(R.id.xlinearlayout11);
        linearLayout12 = (LinearLayout)findViewById(R.id.xlinearlayout12);
        linearLayout13 = (LinearLayout)findViewById(R.id.xlinearlayout13);
        linearLayout14 = (LinearLayout)findViewById(R.id.xlinearlayout14);
        linearLayout15 = (LinearLayout)findViewById(R.id.xlinearlayout15);
        linearLayout16 = (LinearLayout)findViewById(R.id.xlinearlayout16);
        linearLayout17 = (LinearLayout)findViewById(R.id.xlinearlayout17);
        linearLayout18 = (LinearLayout)findViewById(R.id.xlinearlayout18);
        linearLayout19 = (LinearLayout)findViewById(R.id.xlinearlayout19);
        linearLayout20 = (LinearLayout)findViewById(R.id.xlinearlayout20);
        linearLayout21 = (LinearLayout)findViewById(R.id.xlinearlayout21);
        linearLayout22 = (LinearLayout)findViewById(R.id.xlinearlayout22);
        linearLayout23 = (LinearLayout)findViewById(R.id.xlinearlayout23);
        linearLayout24 = (LinearLayout)findViewById(R.id.xlinearlayout24);
        linearLayout25 = (LinearLayout)findViewById(R.id.xlinearlayout25);
        linearLayout26 = (LinearLayout)findViewById(R.id.xlinearlayout26);
        linearLayout27 = (LinearLayout)findViewById(R.id.xlinearlayout27);
        linearLayout28 = (LinearLayout)findViewById(R.id.xlinearlayout28);

        textView0 = (TextView)findViewById(R.id.xtextview0);
        textView1 = (TextView)findViewById(R.id.xtextview1);
        textView2 = (TextView)findViewById(R.id.xtextview2);
        textView3 = (TextView)findViewById(R.id.xtextview3);
        textView4 = (TextView)findViewById(R.id.xtextview4);
        textView5 = (TextView)findViewById(R.id.xtextview5);
        textView6 = (TextView)findViewById(R.id.xtextview6);
        textView7 = (TextView)findViewById(R.id.xtextview7);
        textView8 = (TextView)findViewById(R.id.xtextview8);
        textView9 = (TextView)findViewById(R.id.xtextview9);
        textView10 = (TextView)findViewById(R.id.xtextview10);
        textView11 = (TextView)findViewById(R.id.xtextview11);
        textView12 = (TextView)findViewById(R.id.xtextview12);
        textView13 = (TextView)findViewById(R.id.xtextview13);
        textView14 = (TextView)findViewById(R.id.xtextview14);
        textView15 = (TextView)findViewById(R.id.xtextview15);
        textView16 = (TextView)findViewById(R.id.xtextview16);
        textView17 = (TextView)findViewById(R.id.xtextview17);
        textView18 = (TextView)findViewById(R.id.xtextview18);
        textView19 = (TextView)findViewById(R.id.xtextview19);
        textView20 = (TextView)findViewById(R.id.xtextview20);
        textView21 = (TextView)findViewById(R.id.xtextview21);
        textView22 = (TextView)findViewById(R.id.xtextview22);
        textView23 = (TextView)findViewById(R.id.xtextview23);
        textView24 = (TextView)findViewById(R.id.xtextview24);
        textView25 = (TextView)findViewById(R.id.xtextview25);
        textView26 = (TextView)findViewById(R.id.xtextview26);
        textView27 = (TextView)findViewById(R.id.xtextview27);
        textView28 = (TextView)findViewById(R.id.xtextview28);

        editText0 = (EditText)findViewById(R.id.xedittext0);
        editText1 = (EditText)findViewById(R.id.xedittext1);
        editText2 = (EditText)findViewById(R.id.xedittext2);
        editText3 = (EditText)findViewById(R.id.xedittext3);
        editText4 = (EditText)findViewById(R.id.xedittext4);
        editText5 = (EditText)findViewById(R.id.xedittext5);
        editText6 = (EditText)findViewById(R.id.xedittext6);
        editText7 = (EditText)findViewById(R.id.xedittext7);
        editText8 = (EditText)findViewById(R.id.xedittext8);
        editText9 = (EditText)findViewById(R.id.xedittext9);
        editText10 = (EditText)findViewById(R.id.xedittext10);
        editText11 = (EditText)findViewById(R.id.xedittext11);
        editText12 = (EditText)findViewById(R.id.xedittext12);
        editText13 = (EditText)findViewById(R.id.xedittext13);
        editText14 = (EditText)findViewById(R.id.xedittext14);
        editText15 = (EditText)findViewById(R.id.xedittext15);
        editText16 = (EditText)findViewById(R.id.xedittext16);
        editText17 = (EditText)findViewById(R.id.xedittext17);
        editText18 = (EditText)findViewById(R.id.xedittext18);
        editText19 = (EditText)findViewById(R.id.xedittext19);
        editText20 = (EditText)findViewById(R.id.xedittext20);
        editText21 = (EditText)findViewById(R.id.xedittext21);
        editText22 = (EditText)findViewById(R.id.xedittext22);
        editText23 = (EditText)findViewById(R.id.xedittext23);
        editText24 = (EditText)findViewById(R.id.xedittext24);
        editText25 = (EditText)findViewById(R.id.xedittext25);
        editText26 = (EditText)findViewById(R.id.xedittext26);
        editText27 = (EditText)findViewById(R.id.xedittext27);
        editText28 = (EditText)findViewById(R.id.xedittext28);
        floatingActionButton = (FloatingActionButton)findViewById(R.id.xtianjiafloatingactionbutton);

        Intent intent = getIntent();
        ArrayList<String> columnname = intent.getStringArrayListExtra("data");
        CommonItem commonItem = (CommonItem) intent.getSerializableExtra("duixiang");
        String url = intent.getStringExtra("url");
        int a = intent.getIntExtra("index",-1);

        if (columnname.size() == 29) {
            mymothend(linearLayout0,textView0,editText0,columnname.get(0),commonItem.getName1());
            mymothend(linearLayout1,textView1,editText1,columnname.get(1),commonItem.getName2());
            mymothend(linearLayout2,textView2,editText2,columnname.get(2),commonItem.getName3());
            mymothend(linearLayout3,textView3,editText3,columnname.get(3),commonItem.getName4());
            mymothend(linearLayout4,textView4,editText4,columnname.get(4),commonItem.getName5());
            mymothend(linearLayout5,textView5,editText5,columnname.get(5),commonItem.getName6());
            mymothend(linearLayout6,textView6,editText6,columnname.get(6),commonItem.getName7());
            mymothend(linearLayout7,textView7,editText7,columnname.get(7),commonItem.getName8());
            mymothend(linearLayout8,textView8,editText8,columnname.get(8),commonItem.getName9());
            mymothend(linearLayout9,textView9,editText9,columnname.get(9),commonItem.getName10());
            mymothend(linearLayout10,textView10,editText10,columnname.get(10),commonItem.getName11());
            mymothend(linearLayout11,textView11,editText11,columnname.get(11),commonItem.getName12());
            mymothend(linearLayout12,textView12,editText12,columnname.get(12),commonItem.getName13());
            mymothend(linearLayout13,textView13,editText13,columnname.get(13),commonItem.getName14());
            mymothend(linearLayout14,textView14,editText14,columnname.get(14),commonItem.getName15());
            mymothend(linearLayout15,textView15,editText15,columnname.get(15),commonItem.getName16());
            mymothend(linearLayout16,textView16,editText16,columnname.get(16),commonItem.getName17());
            mymothend(linearLayout17,textView17,editText17,columnname.get(17),commonItem.getName18());
            mymothend(linearLayout18,textView18,editText18,columnname.get(18),commonItem.getName19());
            mymothend(linearLayout19,textView19,editText19,columnname.get(19),commonItem.getName20());
            mymothend(linearLayout20,textView20,editText20,columnname.get(20),commonItem.getName21());
            mymothend(linearLayout21,textView21,editText21,columnname.get(21),commonItem.getName22());
            mymothend(linearLayout22,textView22,editText22,columnname.get(22),commonItem.getName23());
            mymothend(linearLayout23,textView23,editText23,columnname.get(23),commonItem.getName24());
            mymothend(linearLayout24,textView24,editText24,columnname.get(24),commonItem.getName25());
            mymothend(linearLayout25,textView25,editText25,columnname.get(25),commonItem.getName26());
            mymothend(linearLayout26,textView26,editText26,columnname.get(26),commonItem.getName27());
            mymothend(linearLayout27,textView27,editText27,columnname.get(27),commonItem.getName28());
            mymothend(linearLayout28,textView28,editText28,columnname.get(28),commonItem.getName29());
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(XiuGaiActivity.this);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setMessage("数据修改中......");
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
                    Toast.makeText(XiuGaiActivity.this,"请检测网络是否可用！",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(XiuGaiActivity.this,"不能将所有内容设为空值,若需删除请写在备注处。",Toast.LENGTH_SHORT).show();
                }else {

                    final int[] i = new int[1];

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Class.forName("com.mysql.jdbc.Driver").newInstance();
                                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://43.226.43.155:3306/mysql190312606e_db", "mysql190312606e", "60S6e49405");
                                PreparedStatement ps = (PreparedStatement) con.prepareStatement("update " + url + " set name1=" + name0 +
                                        ",name2=" + name1 +
                                        ",name3=" + name2 +
                                        ",name4=" + name3 +
                                        ",name5=" + name4 +
                                        ",name6=" + name5 +
                                        ",name7=" + name6 +
                                        ",name8=" + name7 +
                                        ",name9=" + name8 +
                                        ",name10=" + name9 +
                                        ",name11=" + name10 +
                                        ",name12=" + name11 +
                                        ",name13=" + name12 +
                                        ",name14=" + name13 +
                                        ",name15=" + name14 +
                                        ",name16=" + name15 +
                                        ",name17=" + name16 +
                                        ",name18=" + name17 +
                                        ",name19=" + name18 +
                                        ",name20=" + name19 +
                                        ",name21=" + name20 +
                                        ",name22=" + name21 +
                                        ",name23=" + name22 +
                                        ",name24=" + name23 +
                                        ",name25=" + name24 +
                                        ",name26=" + name25 +
                                        ",name27=" + name26 +
                                        ",name28=" + name27 +
                                        ",name29=" + name28 +" where id=" + a);
                                //ps.execute();

                                i[0] = ps.executeUpdate();

                                ps.close();
                                con.close();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        if (i[0] > 0) {
                                            alertDialog.dismiss();

                                            AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(XiuGaiActivity.this);

                                            alertDialogBuilder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    finish();

                                                }
                                            });

                                            AlertDialog alertDialog1 = alertDialogBuilder1.create();
                                            alertDialog1.setTitle("提示：");
                                            alertDialog1.setMessage("数据修改成功！\n注意：请点击主页表格名称刷新数据，否则修改数据显示不出来。");
                                            alertDialog1.show();
                                        } else {
                                            alertDialog.dismiss();
                                            Toast.makeText(XiuGaiActivity.this, "数据库故障，请及时联系作者", Toast.LENGTH_SHORT).show();
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

    public void mymothend(LinearLayout linearLayout, TextView textView, EditText editText, String msg,String msg2) {
        textView.setText(msg + ": ");
        editText.setText(msg2);
        if (msg.equals("")) {
            linearLayout.setVisibility(View.GONE);
        } else if (msg.equals("出库情况")) {
            editText.setCursorVisible(false);
            editText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(XiuGaiActivity.this);

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
