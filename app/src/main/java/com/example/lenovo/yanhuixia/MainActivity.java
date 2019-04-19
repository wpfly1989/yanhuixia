package com.example.lenovo.yanhuixia;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bin.david.form.annotation.SmartTable;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.IBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.listener.OnColumnItemClickListener;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge.BadgePagerTitleView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private MagicIndicator magicIndicator;
    private List<String> tittl = new ArrayList<>();
    private List<String> add1 = new ArrayList<>();
    private List<String> add2 = new ArrayList<>();
    private CommonFragment commonFragment = new CommonFragment();
    private long exitTime = 0;

    private final String update = BuildConfig.VERSION_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        magicIndicator = (MagicIndicator)findViewById(R.id.magic);




        //检测网络是否可用
        testNetwork();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://43.226.46.228/database/main.txt")
                            .build();
                    Response response = client.newCall(request).execute();
                    assert response.body() != null;
                    String responseData = response.body().string();
                    try {
                        JSONArray jsonArray = new JSONArray(responseData);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            tittl.add(jsonObject.getString("name"));
                            add1.add(jsonObject.getString("add1"));
                            add2.add(jsonObject.getString("add2"));

                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    //domainz();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction transaction = fm.beginTransaction();

                            Bundle bundle = new Bundle();
                            bundle.putString("excelname", tittl.get(0));
                            bundle.putString("add1",add1.get(0));
                            bundle.putString("add2",add2.get(0));
                            commonFragment.setArguments(bundle);

                            transaction.replace(R.id.contentFragment,commonFragment).show(commonFragment).commit();

                            CommonNavigator commonNavigator = new CommonNavigator(MainActivity.this);
                            commonNavigator.setAdapter(new CommonNavigatorAdapter() {
                                @Override
                                public int getCount() {
                                    return tittl.size();
                                }

                                @Override
                                public IPagerTitleView getTitleView(Context context, final int index) {
                                    BadgePagerTitleView badgePagerTitleView = new BadgePagerTitleView(context);

                                    SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);//设置为可渐变的View
                                    simplePagerTitleView.setNormalColor(Color.GRAY);//字渐变前
                                    simplePagerTitleView.setSelectedColor(Color.BLACK);//字渐变后
                                    simplePagerTitleView.setText(tittl.get(index));
                                    simplePagerTitleView.setTextSize(15);//设置字体大小
                                    simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            magicIndicator.onPageSelected(index);
                                            magicIndicator.onPageScrolled(index, 0.0F, 0);
                                            FragmentManager fm = getSupportFragmentManager();
                                            FragmentTransaction transaction = fm.beginTransaction();
                                            transaction.remove(commonFragment);

                                            CommonFragment commonFragment = new CommonFragment();
                                            Bundle bundle = new Bundle();
                                            bundle.putString("excelname", tittl.get(index));
                                            bundle.putString("add1",add1.get(index));
                                            bundle.putString("add2",add2.get(index));
                                            commonFragment.setArguments(bundle);

                                            transaction.replace(R.id.contentFragment,commonFragment).show(commonFragment).commit();


                                        }
                                    });
                                    badgePagerTitleView.setInnerPagerTitleView(simplePagerTitleView);

                                    return badgePagerTitleView;
                                }

                                @Override
                                public IPagerIndicator getIndicator(Context context) {
                                    LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                                    linePagerIndicator.setColors(Color.RED);//线的颜色
                                    return linePagerIndicator;

                                }
                            });
                            magicIndicator.setNavigator(commonNavigator);


                        }
                    });

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://43.226.46.228/database/update/update.txt")
                            .build();
                    Response response = client.newCall(request).execute();
                    assert response.body() != null;
                    final String responseData = response.body().string();

                    if (!update.equals(responseData)) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                                dialog.setTitle("通知");
                                dialog.setMessage("发现最新版本，请下载更新");
                                dialog.setCancelable(false);
                                dialog.setNegativeButton("更新", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(Intent.ACTION_VIEW);
                                        intent.setData(Uri.parse("https://www.lanzous.com/b649350"));
                                        startActivity(intent);
                                    }
                                });

                                dialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                dialog.show();
                            }
                        });


                    }

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }


    public void testNetwork() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ConnectivityManager cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
                assert cm != null;
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                if (networkInfo == null || !networkInfo.isAvailable()) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,"网络不可用！",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        }).start();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - exitTime > 2000) {

                Toast.makeText(MainActivity.this, "再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }

            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


}