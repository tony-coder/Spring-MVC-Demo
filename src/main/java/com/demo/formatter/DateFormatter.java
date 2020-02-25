package com.demo.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// 实现Formatter接口
public class DateFormatter implements Formatter<Date> {

    // 日期类型模板：如yyyy-MM-dd
    private String dataPattern;
    // 日期格式化对象
    private SimpleDateFormat dateFormat;

    // 构造器，通过依赖注入的日期类型创建日期格式化对象
    public DateFormatter(String dataPattern) {
        this.dataPattern = dataPattern;
        this.dateFormat = new SimpleDateFormat(dataPattern);
    }

    // 解析文本字符串返回一个Formatter<T>的T类型对象。
    // 使用指定的Locale将一个String解析成目标T类型
    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        System.out.println("formatter：parse");
        try {
            return dateFormat.parse(s);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    // 显示Formatter<T>的T类型对象
    // 用于返回T类型的字符串表示形式，使用SimpleDateFormat对象将String转换成Date类型，日期类型模板 yyyy-MM-dd之后会通过配置未见的依赖注入设置
    @Override
    public String print(Date date, Locale locale) {
        System.out.println("formatter：print");
        return dateFormat.format(date);
    }
}
