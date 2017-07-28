package com.example.ex_wanzhipeng001.demo_java.basis.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex_wanzhipeng001.demo_java.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TestJavaActivity extends AppCompatActivity {
    private static final String TAG = "TestJavaActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_java);

        testJava();
    }

    private void testJava() {
//        testList();
//        testModifyStringXml();
//        testDumList();
//        testDouble2Integer();
//        testFor();
//        testMinusDouble();
//        testMapGet();
//        testAddDouble();
//        testRegexMatch();
//        testTextViewHtml();
//        testNewString();
//        testEquals();
//        textTextView();
        testRemove();
    }

    private void testRemove() {
//        String string = "";
//        String string = ",";
//        String string = "!12,3";
        String string = "1234!,";
        String substring = "";
        if (string.length()>=1) {
            String string1 = String.valueOf(string.charAt(string.length() - 1));
            if (TextUtils.equals(",",string1)) {
                substring = string.substring(0, string.length() - 1);

            }
        }
        Log.e(TAG, "string="+string+"=substring="+substring);

    }

    private void textTextView() {
        TextView textView = (TextView) findViewById(R.id.tv_test);
        Log.d(TAG, "textView.getText():" + textView.getText());
        textView.setVisibility(View.VISIBLE);
        Log.d(TAG, "textView.getText()2:" + textView.getText());
        textView.setVisibility(View.GONE);
        Log.d(TAG, "textView.getText()3:" + textView.getText());
    }


    private void testEquals() {
        Log.e(TAG,"".equals("1")+"");
    }


    private void testNewString() {
        byte[] arg3 = new byte[]{};
        String str3 = new String(arg3);
        Log.e(TAG,"str3="+str3);
//        byte[] arg2 = null;
//        String str2 = new String(arg2);
//        Log.e(TAG,"str2="+str2);
    }

    private void testTextViewHtml() {
        TextView textView = (TextView) findViewById(R.id.tv_test);
        String string = "<html><head><title>安全提示</title><style>body{TEXT-ALIGN: center;}#center{MARGIN-RIGHT: auto;" +
                "MARGIN-LEFT: auto; height:400px;width:400px;}</style></head><body><div id=\"center\">" +
                "您所输入的密码为初始密码或90天未有更新，请立即" +
                "<a href='http://um-selfservice.paic.com.cn/um-selfservice/ss/change_password.jsp' target='_balnk'>" +
                "修改密码</a>后再登陆!</div></body></html>";
//        textView.setText(Html.fromHtml("<html><head><title>安全提示</title></head><body><div id=\"center\">您所输入的密码为初始密码或90天未有更新，请立即<a href='http://um-selfservice.paic.com.cn/um-selfservice/ss/change_password.jsp' target='_balnk'>修改密码</a>后再登陆!</div></body></html>"));
        if (TextUtils.equals(string,"<html><head><title>安全提示</title><style>body{TEXT-ALIGN: center;}#center{MARGIN-RIGHT: auto;MARGIN-LEFT: auto; height:400px;width:400px;}</style></head><body><div id=\"center\">您所输入的密码为初始密码或90天未有更新，请立即<a href='http://um-selfservice.paic.com.cn/um-selfservice/ss/change_password.jsp' target='_balnk'>修改密码</a>后再登陆!</div></body></html>")){

            Toast.makeText(this, "您所输入的密码为初始密码或90天未有更新，请立即在电脑内网修改密码后再登陆",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void testRegexMatch() {
//        String str = "6227002734730752257";//建行卡
//        String str = "啊啊啊";//建行卡
//        String str = "6225758888333050";//建行卡
//        String str = "6230580000044709231";//平安卡
        // 邮箱验证规则
//        String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
//        String regEx = "^\\d{14}$|^\\d{16}$|^\\d{19}$";
//        String regEx = "^\\d{19}$";

        String str = "鸂";
        String regEx = "^[^鸂麪鼱隣獱珷瑺瓲疇癄\"“”\'/\\\\|\\[\\]<>《》‘’\\t\\r\\n]*$";
////        String regEx = "^[^\uE816\uE817\uE818\uE81E\uE826\uE82B\uE82C\uE831\uE832\uE83B\uE843\uE854\uE855\uE864鸂麪鼱隣獱珷瑺瓲疇癄\uE863\\\"“”\\'/\\\\\\\\|\\\\[\\\\]<>《》‘’\\\\t\\\\r\\\\n]*$\n";
//
//        // 编译正则表达式
////        Pattern pattern = Pattern.compile(regEx);
////        Matcher matcher = pattern.matcher(str);
////        // 字符串是否与正则表达式相匹配
//////        boolean rs = matcher.matches();
////        boolean rs = matcher.find();
//////        boolean rs = matcher.matches();
        Log.e(TAG, "===1" + str.matches(regEx));

//        // 要验证的字符串
//        String str2 = "baike.xsoftlab.net";
//        // 正则表达式规则
//        String regEx2 = "baike.*";
//        // 编译正则表达式
//        Pattern pattern2 = Pattern.compile(regEx2);
//        // 忽略大小写的写法
//        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
//        Matcher matcher2 = pattern2.matcher(str2);
//        // 查找字符串中是否有匹配正则表达式的字符/字符串
////        boolean rs2 = matcher2.find();
//        boolean rs2 = matcher2.find();
//
//        Log.e(TAG, "===2" + rs2);

//
//
//        String res = "中国建设银行股份有限公司总行(1234556779)";
//        String match= "中国建设银行";
//        String match2= "中国银行";
//        String match3= "中国工商银行";
//        String match4= "中国人民银行";
//        String match5= "中国农业银行";
//
//        String[] strings = new String[5];
//        strings[0]=match;
//        strings[1]=match2;
//        strings[2]=match3;
//        strings[3]=match4;
//        strings[4]=match5;
//
//        for (String string : strings) {
//            if (res.contains(string)) {
//                Log.e(TAG,"MATCH"+string+"---"+res);
//            }else  if (string.contains(res)){
//                Log.e(TAG,"MATCH"+string+"---"+res);
//
//            }
//        }


    }

    private void testAddDouble() {
        double invoiceFee = 0.3;
        double dOtherOneFee = 0.1;
        double dOtherTwoFee = 0.1;
        double dEditFee = 0.1;
        Boolean big = invoiceFee > (dOtherOneFee + dOtherTwoFee + dEditFee);

        Log.e(TAG, "big=" + big);

    }

    private void testMapGet() {
        Map<Integer, Boolean> shouldModifyMap = new HashMap<>();
        shouldModifyMap.put(1, true);
//        if(shouldModifyMap.get(2)){
//            Log.e(TAG,"------"+shouldModifyMap.get(2));
//        }


        Boolean b = shouldModifyMap.get(2);
        if (b) {
            Log.e(TAG, "------" + shouldModifyMap.get(2));
        }

    }

    private void testMinusDouble() {
        double i = 1.0;
        double j = 0.5;
        double j2 = 1.5;
        double j3 = 1.0;
        Log.e(TAG, "===" + (i - j));
        Log.e(TAG, "===" + (i - j2));
        Log.e(TAG, "===" + (i - j3));
    }

    private void testFor() {
        for (int i = 5; i < 3; i++) {
            Log.e(TAG, "========" + i);
        }
    }


    private void testDouble2Integer() {
//
        String s = "0";
        String s2 = "0.0";
//        CharSequence s = "";
//        Editable s ;

        Log.e(TAG,"s=="+s.toString().trim());
        Log.e(TAG,"s2=="+s2.toString().trim());
            double parseDouble = Double.parseDouble(s.toString().trim());
            double parseDouble2 = Double.parseDouble(s2.toString().trim());
            Log.e(TAG,"parseDouble=="+parseDouble);
            Log.e(TAG,"parseDouble2=="+parseDouble2);
//        String str = ".";
//        String str2 = "0.";
//        Log.e(TAG,str.startsWith(".")+"==="+str.startsWith("/."));
//        Log.e(TAG,str2.startsWith(".")+"==="+str2.startsWith("/."));

//        int a = Integer.valueOf("");
//        Integer.getInteger("");
//        int b = Integer.parseInt(s);
//        Log.e(TAG,"a=="+a);
//        Log.e(TAG,"b=="+b);
//        String d1 = "5.05";
//        Log.e(TAG, d1.contains(".")+"");
//        if (d1.contains(".")) {
//            String[] split = d1.split("\\.");
//            Log.e(TAG, d1 + "--" + split.toString());
//            String s = split[1];
//            boolean b = true;
//            for (int i = 0; i < s.length(); i++) {
//                if (!(s.charAt(i) + "").equals("0")) {
//                    b = false;
//                }
//            }
//            if (b) {//2.0  2.00 2.000
//                String substring = d1.substring(0, d1.indexOf("."));
//
//                Log.e(TAG, substring);
//            } else {//2.50
//                Log.e(TAG, d1);
//                //2.50 2.500 2.5500
//            }
//        } else {
//            Log.e(TAG, d1);
//
//        }

//        Log.e(TAG,Double.valueOf("")+"");


//        Log.e(TAG,Integer.valueOf(d1)+"");
//        Log.e(TAG,Integer.valueOf(d2)+"");
//        Log.e(TAG,Integer.valueOf(d3)+"");
//        Log.e(TAG,Integer.valueOf(d4)+"");
//        Log.e(TAG,Integer.valueOf(d5)+"");
//        Log.e(TAG,Integer.valueOf(d6)+"");


    }

    private void testModifyStringXml() {
//        有些朋友可能会动态的修改Android中strings.xml文件中的值，在这里给大家推荐一种简单的方法。
//        strings.xml中节点是支持占位符的，如下所示：
//        <string name="data">整数型:%1$d，浮点型：%2$.2f，字符串:%3$s</string>
//                其中%后面是占位符的位置，从1开始，
//        $ 后面是填充数据的类型
//        %d：表示整数型；
//        %f ：表示浮点型，其中f前面的.2表示小数的位数
//                %c：表示字符串
//                这些和C语言中输入输出函数的占位符很相似
//        在程序中我们可以通过下面的代码对字符串进行格式化，也就是填充占位符中的内容：
        String data = getResources().getString(R.string.data);
        Log.e(TAG, "before--" + data);
        data = String.format(data, 100, 10.3, "2011-07-01");
        Log.e(TAG, data);
        String data2 = getResources().getString(R.string.data);
        Log.e(TAG, data2);
    }

    private void testList() {
        List list = new ArrayList<String>();
        list.add("1");
        list.add("2");


        Log.d(TAG, list.size() + "--list-" + list.toString());

        list.clear();

        Log.d(TAG, list.size() + "--list-" + list.toString());


        List list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");

        List list3 = new ArrayList<String>();
        list3.add("1");
        list3.add("2");

        list2.removeAll(list3);

        Log.d(TAG, list2.size() + "--list2-" + list2.toString());


//        List list4 = new ArrayList<String>();
//        list4.add("1");
//        list4.add("2");
//
//        List list5 = new ArrayList<String>();
//        list5.add("1");
//        list5.add("2");
//
//        list5=null;

//        Log.d(TAG,list5.toString());
    }

    public void testDumList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("2");
        list.add("1");

        List<String> newList = getNewList(list);

        list = new ArrayList<String>(new HashSet<>(list));

        Log.e(TAG, "list--" + list.toString());
        Log.e(TAG, "newList--" + newList.toString());

    }

    public List<String> getNewList(List<String> li) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < li.size(); i++) {
            String str = li.get(i);  //获取传入集合对象的每一个元素
            if (!list.contains(str)) {   //查看新集合中是否有指定的元素，如果没有则加入
                list.add(str);
            }
        }
        return list;  //返回集合
    }
}
