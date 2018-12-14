package com.example.demo.util;

import io.micrometer.core.instrument.util.StringEscapeUtils;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class SystemutilTestDemo {

    public static void main(String[] args) {
        String[] datas = {"22", "33", "44", "55"};
        String[] datas1 = {"22", "33", "44", "55"};
        String[] datas2 = {"aa", "bb", "cc"};
        int[] datasInt = {22, 33, 44, 55,23, 56 ,90, 91, 88 ,54};

        System.out.println(Objects.deepEquals(datas, datas1));
        System.out.println(ArrayUtils.contains(datas, "33"));
        System.out.println(ArrayUtils.toString(datas2));

        Map map = ArrayUtils.toMap(new String[][] { { "RED", "#FF0000" }, { "GREEN", "#00FF00" }, { "BLUE", "#0000FF" } });
        System.out.println(map.toString());

        System.out.println(ClassUtils.getShortClassName(SystemutilTestDemo.class));
        System.out.println(ClassUtils.getPackageName(SystemutilTestDemo.class));

        System.out.println(NumberUtils.isCreatable("111"));
        System.out.println(NumberUtils.max((int[])ArrayUtils.toPrimitive(datasInt)));
        System.out.println(NumberUtils.toInt("123", 110));
        System.out.println(NumberUtils.toInt("123a", 111));

        System.out.println(RandomStringUtils.randomAlphabetic(30));
        System.out.println(RandomStringUtils.randomAlphanumeric(30));

        System.out.println(StringEscapeUtils.escapeJson("{\"hello\" : 111}"));

        System.out.println(StringUtils.join(datas, "|"));
        System.out.println(StringUtils.capitalize("hello"));
        System.out.println(StringUtils.deleteWhitespace(" hello Tom "));

        System.out.println(DateFormatUtils.format(new Date(), "yyyyMMdd"));
        System.out.println(DateFormatUtils.format(DateUtils.addDays(new Date(), 2),"yyyyMMdd"));

        String str = "The quick brown fox jumps over the lazy dog.";
        System.out.println(CharSetUtils.count(str, "u"));
        System.out.println(CharSetUtils.delete(str, "a"));
        System.out.println(CharSetUtils.keep(str, "o"));
        System.out.println(CharSetUtils.squeeze("a bb ccc dddddd e", "bd"));

    }
}
