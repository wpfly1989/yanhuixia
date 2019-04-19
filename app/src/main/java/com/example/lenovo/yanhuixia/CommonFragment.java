package com.example.lenovo.yanhuixia;

import android.Manifest;
import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ListPopupWindow;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.bg.IBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.table.TableData;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;

public class CommonFragment extends Fragment {

    private ProgressBar progressBar;
    private com.bin.david.form.core.SmartTable<CommonItem> table;
    private List<String> columnname = new ArrayList<>();
    private List<CommonItem> commonItems = new ArrayList<>();
    private List<CommonItem> commonItems1 = new ArrayList<>();
    private BoomMenuButton boomMenuButton;

    ArrayList<ArrayList<String>> recordList = new ArrayList<>();

    private AlertDialog alertDialog;
    private AlertDialog mDialog;


    private static final int NOT_NOTICE = 2;//如果勾选了不再询问

    String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentlayout,container,false);
        progressBar = (ProgressBar)view.findViewById(R.id.fragmentprogressbar);
        table = (com.bin.david.form.core.SmartTable<CommonItem>)view.findViewById(R.id.fragmentsmarttable);
        boomMenuButton = (BoomMenuButton)view.findViewById(R.id.boommenubutton);

        boomMenuButton.setButtonEnum(ButtonEnum.TextOutsideCircle);
        boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_1);
        boomMenuButton.setInFragment(true);

        boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.xinzeng).normalText("新增"));
        boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.xiugai).normalText("修改"));
        boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.chaxun).normalText("查询"));
        boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.dongjielie).normalText("冻结列"));
        boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.daochu).normalText("导出为EXCEL"));
        boomMenuButton.addBuilder(new TextOutsideCircleButton.Builder().normalImageRes(R.drawable.fenxiang).normalText("分享该软件"));

        boomMenuButton.setDraggable(true);


        progressBar.setVisibility(View.VISIBLE);

        registerForContextMenu(table);

        //添加列标题为29个空内容
        for(int i = 0; i < 29; i++) {
            columnname.add("");
        }

        Bundle bundle = this.getArguments();
        String excelname = bundle.getString("excelname");
        String url1 = bundle.getString("add1");
        String url2 = bundle.getString("add2");



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url(url1)
                            .build();
                    Response response = client.newCall(request).execute();
                    assert response.body() != null;
                    final String responseData = response.body().string();
                    try {
                        JSONArray jsonArray = new JSONArray(responseData);
                        if (jsonArray.length() <= 30) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                columnname.set(i, jsonObject.getString("name"));

                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://43.226.43.155:3306/mysql190312606e_db", "mysql190312606e", "60S6e49405");
                    Statement stmt   = (Statement) con.createStatement();

                    ResultSet result = (ResultSet) stmt.executeQuery("select * from " + url2);
                    while(result.next()){
                        commonItems.add(new CommonItem(result.getInt("id"),
                                result.getString("name1"),
                                result.getString("name2"),
                                result.getString("name3"),
                                result.getString("name4"),
                                result.getString("name5"),
                                result.getString("name6"),
                                result.getString("name7"),
                                result.getString("name8"),
                                result.getString("name9"),
                                result.getString("name10"),
                                result.getString("name11"),
                                result.getString("name12"),
                                result.getString("name13"),
                                result.getString("name14"),
                                result.getString("name15"),
                                result.getString("name16"),
                                result.getString("name17"),
                                result.getString("name18"),
                                result.getString("name19"),
                                result.getString("name20"),
                                result.getString("name21"),
                                result.getString("name22"),
                                result.getString("name23"),
                                result.getString("name24"),
                                result.getString("name25"),
                                result.getString("name26"),
                                result.getString("name27"),
                                result.getString("name28"),
                                result.getString("name29")));
                    }
                    result.close();
                    stmt.close();
                    con.close();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Column<Integer> id = new Column<Integer>("行号","id");
                            Column<String> name1 = new Column<String>(columnname.get(0),"name1");
                            Column<String> name2 = new Column<String>(columnname.get(1),"name2");
                            Column<String> name3 = new Column<String>(columnname.get(2),"name3");
                            Column<String> name4 = new Column<String>(columnname.get(3),"name4");
                            Column<String> name5 = new Column<String>(columnname.get(4),"name5");
                            Column<String> name6 = new Column<String>(columnname.get(5),"name6");
                            Column<String> name7 = new Column<String>(columnname.get(6),"name7");
                            Column<String> name8 = new Column<String>(columnname.get(7),"name8");
                            Column<String> name9 = new Column<String>(columnname.get(8),"name9");
                            Column<String> name10 = new Column<String>(columnname.get(9),"name10");
                            Column<String> name11 = new Column<String>(columnname.get(10),"name11");
                            Column<String> name12 = new Column<String>(columnname.get(11),"name12");
                            Column<String> name13 = new Column<String>(columnname.get(12),"name13");
                            Column<String> name14 = new Column<String>(columnname.get(13),"name14");
                            Column<String> name15 = new Column<String>(columnname.get(14),"name15");
                            Column<String> name16 = new Column<String>(columnname.get(15),"name16");
                            Column<String> name17 = new Column<String>(columnname.get(16),"name17");
                            Column<String> name18 = new Column<String>(columnname.get(17),"name18");
                            Column<String> name19 = new Column<String>(columnname.get(18),"name19");
                            Column<String> name20 = new Column<String>(columnname.get(19),"name20");
                            Column<String> name21 = new Column<String>(columnname.get(20),"name21");
                            Column<String> name22 = new Column<String>(columnname.get(21),"name22");
                            Column<String> name23 = new Column<String>(columnname.get(22),"name23");
                            Column<String> name24 = new Column<String>(columnname.get(23),"name24");
                            Column<String> name25 = new Column<String>(columnname.get(24),"name25");
                            Column<String> name26 = new Column<String>(columnname.get(25),"name26");
                            Column<String> name27 = new Column<String>(columnname.get(26),"name27");
                            Column<String> name28 = new Column<String>(columnname.get(27),"name28");
                            Column<String> name29 = new Column<String>(columnname.get(28),"name29");

                            for(int i = 0; i < commonItems.size(); i++) {
                                commonItems1.add(commonItems.get(i));
                            }

                            TableData<CommonItem> tableData = new TableData<CommonItem>("名称",commonItems1,id,name1,name2,name3,
                                    name4,name5,name6,name7,name8,name9,name10,name11,name12,
                                    name13,name14,name15,name16,name17,name18,name19,name20,name21,name22,name23,name24,name25,name26,name27,name28,name29);

                            table.setTableData(tableData);

                            //progressbar消失
                            progressBar.setVisibility(View.GONE);

                            //不显示表格标题和左侧，并固定id这一列
                            table.getConfig().setShowTableTitle(false);
                            table.getConfig().setShowYSequence(false);
                            id.setFixed(true);


                            //boommenubutton点击事件
                            boomMenuButton.setOnBoomListener(new OnBoomListener() {
                                @Override
                                public void onClicked(int index, BoomButton boomButton) {

                                    switch (index) {
                                        case 0:
                                            Intent intent0 = new Intent(getActivity(),TianJia.class);
                                            intent0.putExtra("url",url2);
                                            intent0.putStringArrayListExtra("data", (ArrayList<String>) columnname);
                                            startActivity(intent0);
                                            break;
                                        case 1:
                                            AlertDialog.Builder alertDialogBuilderxiugai = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                                            View viewForXiuGai = LayoutInflater.from(getActivity()).inflate(R.layout.xiugai,null);
                                            EditText editTextForXiuGai = (EditText)viewForXiuGai.findViewById(R.id.xiugaiedittext);
                                            alertDialogBuilderxiugai.setView(viewForXiuGai);
                                            alertDialogBuilderxiugai.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    if (editTextForXiuGai.getText().toString().trim().equals("") || (Integer.parseInt(editTextForXiuGai.getText().toString())) > commonItems.size() || (Integer.parseInt(editTextForXiuGai.getText().toString())) <= 0) {
                                                        Toast.makeText(getActivity(),"输入不合法或超出范围！",Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Intent intentXiuGai = new Intent(getActivity(), XiuGaiActivity.class);
                                                        intentXiuGai.putStringArrayListExtra("data", (ArrayList<String>) columnname);
                                                        intentXiuGai.putExtra("duixiang", commonItems.get(Integer.parseInt(editTextForXiuGai.getText().toString()) - 1));
                                                        intentXiuGai.putExtra("url", url2);
                                                        intentXiuGai.putExtra("index",Integer.parseInt(editTextForXiuGai.getText().toString()));

                                                        startActivity(intentXiuGai);
                                                    }
                                                }
                                            });

                                            AlertDialog alertDialogXiuGai = alertDialogBuilderxiugai.create();
                                            alertDialogXiuGai.setTitle("提示： ");
                                            alertDialogXiuGai.show();
                                            break;
                                        case 2:
                                            AlertDialog.Builder alertDialogBuilderChaXun = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                                            View viewForChaXun = LayoutInflater.from(getActivity()).inflate(R.layout.chaxun,null);
                                            EditText editTextForChaXun = (EditText)viewForChaXun.findViewById(R.id.guanjianzichaxun);
                                            alertDialogBuilderChaXun.setView(viewForChaXun);
                                            alertDialogBuilderChaXun.setPositiveButton("查询", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    commonItems1.clear();
                                                    String msg = editTextForChaXun.getText().toString();
                                                    for (CommonItem commonItem : commonItems) {
                                                        if (commonItem.getName1().contains(msg) ||
                                                                commonItem.getName2().contains(msg) ||
                                                                commonItem.getName3().contains(msg) ||
                                                                commonItem.getName4().contains(msg) ||
                                                                commonItem.getName5().contains(msg) ||
                                                                commonItem.getName6().contains(msg) ||
                                                                commonItem.getName7().contains(msg) ||
                                                                commonItem.getName8().contains(msg) ||
                                                                commonItem.getName9().contains(msg) ||
                                                                commonItem.getName10().contains(msg) ||
                                                                commonItem.getName11().contains(msg) ||
                                                                commonItem.getName12().contains(msg) ||
                                                                commonItem.getName13().contains(msg) ||
                                                                commonItem.getName14().contains(msg) ||
                                                                commonItem.getName15().contains(msg) ||
                                                                commonItem.getName16().contains(msg) ||
                                                                commonItem.getName17().contains(msg) ||
                                                                commonItem.getName18().contains(msg) ||
                                                                commonItem.getName19().contains(msg) ||
                                                                commonItem.getName20().contains(msg) ||
                                                                commonItem.getName21().contains(msg) ||
                                                                commonItem.getName22().contains(msg) ||
                                                                commonItem.getName23().contains(msg) ||
                                                                commonItem.getName24().contains(msg) ||
                                                                commonItem.getName25().contains(msg) ||
                                                                commonItem.getName26().contains(msg) ||
                                                                commonItem.getName27().contains(msg) ||
                                                                commonItem.getName28().contains(msg) ||
                                                                commonItem.getName29().contains(msg)){
                                                            commonItems1.add(commonItem);
                                                        }
                                                    }
                                                    table.notifyDataChanged();

                                                }
                                            });
                                            alertDialogBuilderChaXun.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                }
                                            });


                                            AlertDialog alertDialog = alertDialogBuilderChaXun.create();
                                            alertDialog.setTitle("提示：");
                                            alertDialog.show();
                                            break;
                                        case 3:
                                            AlertDialog.Builder alertDialogBuilderdongjie = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
                                            View viewForDongJie = LayoutInflater.from(getActivity()).inflate(R.layout.dongjielie,null);
                                            EditText editTextForDongJie = (EditText)viewForDongJie.findViewById(R.id.dongjielieedittext);
                                            alertDialogBuilderdongjie.setView(viewForDongJie);

                                            editTextForDongJie.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    editTextForDongJie.setFocusable(true);
                                                    editTextForDongJie.setFocusableInTouchMode(true);
                                                    editTextForDongJie.requestFocus();

                                                    List<String> listForDongJie = new ArrayList<>();
                                                    for (String s : columnname){
                                                        if (!s.trim().equals("")) {
                                                            listForDongJie.add(s);
                                                        }
                                                    }


                                                    final String[] list = (String[])listForDongJie.toArray(new String[listForDongJie.size()]);//要填充的数据
                                                    final ListPopupWindow listPopupWindow;
                                                    listPopupWindow = new ListPopupWindow(getActivity());
                                                    listPopupWindow.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, list));//用android内置布局，或设计自己的样式
                                                    listPopupWindow.setAnchorView(editTextForDongJie);//以哪个控件为基准，在该处以mEditText为基准
                                                    listPopupWindow.setModal(true);


                                                    listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置项点击监听
                                                        @Override
                                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                            editTextForDongJie.setText(list[i]);//把选择的选项内容展示在EditText上
                                                            listPopupWindow.dismiss();//如果已经选择了，隐藏起来
                                                        }
                                                    });
                                                    listPopupWindow.show();//把ListPopWindow展示出来
                                                }
                                            });

                                            alertDialogBuilderdongjie.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                    String msgdongjie = editTextForDongJie.getText().toString();

                                                    if (msgdongjie.equals(columnname.get(0))) {
                                                        name1.setFixed(true);

                                                        name1.setColumnName(columnname.get(0) + "（冻）");



                                                    } else if (msgdongjie.equals(columnname.get(1))) {
                                                        name2.setFixed(true);
                                                        name2.setColumnName(columnname.get(1) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(2))) {
                                                        name3.setFixed(true);
                                                        name3.setColumnName(columnname.get(2) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(3))) {
                                                        name4.setFixed(true);
                                                        name4.setColumnName(columnname.get(3) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(4))) {
                                                        name5.setFixed(true);
                                                        name5.setColumnName(columnname.get(4) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(5))) {
                                                        name6.setFixed(true);
                                                        name6.setColumnName(columnname.get(5) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(6))) {
                                                        name7.setFixed(true);
                                                        name7.setColumnName(columnname.get(6) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(7))) {
                                                        name8.setFixed(true);
                                                        name8.setColumnName(columnname.get(7) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(8))) {
                                                        name9.setFixed(true);
                                                        name9.setColumnName(columnname.get(8) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(9))) {
                                                        name10.setFixed(true);
                                                        name10.setColumnName(columnname.get(9) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(10))) {
                                                        name11.setFixed(true);
                                                        name11.setColumnName(columnname.get(10) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(11))) {
                                                        name12.setFixed(true);
                                                        name12.setColumnName(columnname.get(11) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(12))) {
                                                        name13.setFixed(true);
                                                        name13.setColumnName(columnname.get(12) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(13))) {
                                                        name14.setFixed(true);
                                                        name14.setColumnName(columnname.get(13) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(14))) {
                                                        name15.setFixed(true);
                                                        name15.setColumnName(columnname.get(14) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(15))) {
                                                        name16.setFixed(true);
                                                        name16.setColumnName(columnname.get(15) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(16))) {
                                                        name17.setFixed(true);
                                                        name17.setColumnName(columnname.get(16) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(17))) {
                                                        name18.setFixed(true);
                                                        name18.setColumnName(columnname.get(17) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(18))) {
                                                        name19.setFixed(true);
                                                        name19.setColumnName(columnname.get(18) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(19))) {
                                                        name20.setFixed(true);
                                                        name20.setColumnName(columnname.get(19) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(20))) {
                                                        name21.setFixed(true);
                                                        name21.setColumnName(columnname.get(20) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(21))) {
                                                        name22.setFixed(true);
                                                        name22.setColumnName(columnname.get(21) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(22))) {
                                                        name23.setFixed(true);
                                                        name23.setColumnName(columnname.get(22) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(23))) {
                                                        name24.setFixed(true);
                                                        name24.setColumnName(columnname.get(23) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(24))) {
                                                        name25.setFixed(true);
                                                        name25.setColumnName(columnname.get(24) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(25))) {
                                                        name26.setFixed(true);
                                                        name26.setColumnName(columnname.get(25) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(26))) {
                                                        name27.setFixed(true);
                                                        name27.setColumnName(columnname.get(26) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(27))) {
                                                        name28.setFixed(true);
                                                        name28.setColumnName(columnname.get(27) + "（冻）");
                                                    } else if (msgdongjie.equals(columnname.get(28))) {
                                                        name29.setFixed(true);
                                                        name29.setColumnName(columnname.get(28) + "（冻）");
                                                    }
                                                    table.notifyDataChanged();
                                                }
                                            });
                                            alertDialogBuilderdongjie.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                }

                                            });

                                            AlertDialog alertDialogForDongJie = alertDialogBuilderdongjie.create();
                                            alertDialogForDongJie.setTitle("提示：");
                                            alertDialogForDongJie.show();
                                            break;
                                        case 4:

                                            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
                                                Toast.makeText(getActivity(), "您还没申请权限!", Toast.LENGTH_SHORT).show();
                                                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                                            } else {
                                                Toast.makeText(getActivity(), "正在存储中...", Toast.LENGTH_SHORT).show();
                                            }


                                            List<String> excelname1 = new ArrayList<>();
                                            excelname1.add("编号");
                                            excelname1.addAll(columnname);

                                            final String[] title = (String[])excelname1.toArray(new String[excelname1.size()]);


                                            for (int i = 0; i < commonItems.size(); i++) {
                                                CommonItem demoBean = commonItems.get(i);
                                                ArrayList<String> list = new ArrayList<>();
                                                list.add(demoBean.getId() + "");
                                                list.add(demoBean.getName1());
                                                list.add(demoBean.getName2());
                                                list.add(demoBean.getName3());
                                                list.add(demoBean.getName4());
                                                list.add(demoBean.getName5());
                                                list.add(demoBean.getName6());
                                                list.add(demoBean.getName7());
                                                list.add(demoBean.getName8());
                                                list.add(demoBean.getName9());
                                                list.add(demoBean.getName10());
                                                list.add(demoBean.getName11());
                                                list.add(demoBean.getName12());
                                                list.add(demoBean.getName13());
                                                list.add(demoBean.getName14());
                                                list.add(demoBean.getName15());
                                                list.add(demoBean.getName16());
                                                list.add(demoBean.getName17());
                                                list.add(demoBean.getName18());
                                                list.add(demoBean.getName19());
                                                list.add(demoBean.getName20());
                                                list.add(demoBean.getName21());
                                                list.add(demoBean.getName22());
                                                list.add(demoBean.getName23());
                                                list.add(demoBean.getName24());
                                                list.add(demoBean.getName25());
                                                list.add(demoBean.getName26());
                                                list.add(demoBean.getName27());
                                                list.add(demoBean.getName28());
                                                list.add(demoBean.getName29());
                                                recordList.add(list);
                                            }


                                            File file = new File(getSDPath() + "/Record");
                                            makeDir(file);
                                            ExcelUtils.initExcel(file.toString() + "/" + excelname + ".xls", title);
                                            String fileName = getSDPath() + "/Record/" + excelname + ".xls";
                                            ExcelUtils.writeObjListToExcel(recordList, fileName, getActivity());
                                            break;

                                        case 5:
                                            Intent intentForFengXiang = new Intent(getActivity(),FenXiang.class);
                                            startActivity(intentForFengXiang);
                                            break;
                                            default:
                                                break;
                                    }
                                }

                                @Override
                                public void onBackgroundClick() {

                                }

                                @Override
                                public void onBoomWillHide() {

                                }

                                @Override
                                public void onBoomDidHide() {

                                }

                                @Override
                                public void onBoomWillShow() {

                                }

                                @Override
                                public void onBoomDidShow() {

                                }
                            });

                            //隔行颜色不一样
                            table.getConfig().setContentCellBackgroundFormat(new ICellBackgroundFormat<CellInfo>() {

                                @Override
                                public void drawBackground(Canvas canvas, Rect rect, CellInfo cellInfo, Paint paint) {
                                    if(cellInfo.row%2==0){
                                        paint.setColor(Color.parseColor("#F5F5F5"));
                                        canvas.drawRect(rect,paint);
                                    }
                                }

                                @Override
                                public int getTextColor(CellInfo cellInfo) {
                                    return 0;
                                }
                            });

                            //放大缩小
                            table.setZoom(true);


                            //table.setSortColumn(name1,false);

                        }
                    });


                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();



        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {//选择了“始终允许”
                    Toast.makeText(getActivity(), "" + "权限" + permissions[i] + "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), permissions[i])) {//用户选择了禁止不再询问

                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("permission")
                                .setMessage("点击允许才可以使用我们的app哦")
                                .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (mDialog != null && mDialog.isShowing()) {
                                            mDialog.dismiss();
                                        }
                                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);//注意就是"package",不用改成自己的包名
                                        intent.setData(uri);
                                        startActivityForResult(intent, NOT_NOTICE);
                                    }
                                });
                        mDialog = builder.create();
                        mDialog.setCanceledOnTouchOutside(false);
                        mDialog.show();


                    } else {//选择禁止
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle("permission")
                                .setMessage("点击允许才可以使用我们的app哦")
                                .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        if (alertDialog != null && alertDialog.isShowing()) {
                                            alertDialog.dismiss();
                                        }
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                                    }
                                });
                        alertDialog = builder.create();
                        alertDialog.setCanceledOnTouchOutside(false);
                        alertDialog.show();
                    }

                }
            }
        }
    }

    private void showDialogTipUserRequestPermission() {
        ActivityCompat.requestPermissions(getActivity(),permissions, 321);
    }



    private String getSDPath() { File sdDir = null; boolean sdCardExist = Environment.getExternalStorageState().equals( android.os.Environment.MEDIA_MOUNTED); if (sdCardExist) { sdDir = Environment.getExternalStorageDirectory(); } String dir = sdDir.toString(); return dir; } public void makeDir(File dir) { if (!dir.getParentFile().exists()) { makeDir(dir.getParentFile()); } dir.mkdir(); }




}
