package com.lrh.cs.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器
 * 字符串转换时间类型
 *
 */
public class StringToDateConverter implements Converter<String, Date> {
  private  String dataPattern;
  public StringToDateConverter(String dataPattern){
      System.out.println("StringToDateConverter +++"+dataPattern  );
      this.dataPattern=dataPattern;
  }
    @Override
    public Date convert(String s) {
      Date date =null;
        try {
            date=new SimpleDateFormat(dataPattern).parse(s);
            System.out.println("conver date" +date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
