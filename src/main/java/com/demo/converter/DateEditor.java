package com.demo.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 自定义属性编辑器
public class DateEditor extends PropertyEditorSupport {

    // 将传如的字符串数据转换成Date类型
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        //super.setAsText(text);
        System.out.println("DateEditor：setAsText");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(text);
            setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
