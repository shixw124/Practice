package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/15 0015.
 *
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class GetWebsite {
    public void getURL() {
        Pattern pattern;
        Matcher matcher;
        String input = "IT面试题博客中包含很多 软件测试面试题 http://www.mianwww.com/html/category/it-interview/softwaretest";
        pattern = Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        /*System.out.println(matcher.matches());

        Pattern p = Pattern.compile("(\\d{3,5})([a-z]{3})");  //小括号这里是表示分组
        Matcher m = p.matcher("234aa-456njd-789dhs-shi23");
        // 一般是吧要匹配的字符串单独出来建个对象
        while(m.find()) {
            System.out.println(m.group(1));
            // 第一组和第二组的区分方法是数左小括号，第一个就是第一组，第二个就是第二组
        }

        Pattern pp = Pattern.compile("java",Pattern.CASE_INSENSITIVE); //忽略大小写
        Matcher mm = pp.matcher("java Java JAva JAVA JaVa niHaoJava adfse");
        StringBuffer buf = new StringBuffer();//可扩展的string类型
        int i = 0;
        while(mm.find()) {
            i++;
            if(i%2 == 0) {
                mm.appendReplacement(buf, "JAVA");
                //appendReplacement 是将当前位置上的替换引号中的
            } else {
                mm.appendReplacement(buf, "java");
            }
        }
        mm.appendTail(buf); //将匹配器mm后面的尾巴放在buf后面
        System.out.println(buf);*/


    }

    public static void main(String[] args) {
        new GetWebsite().getURL();
    }


}
