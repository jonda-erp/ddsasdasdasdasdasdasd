package com.jonda.erp.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.util.Random;

/**
 * Created by rejoady on 2014/9/15.
 */
public class OrderNoGenerator {

    public static String generate() {
        StringBuffer sb = new StringBuffer();
        sb.append("O");
        sb.append(DateFormatUtils.format(System.currentTimeMillis(), "yyyyMMddHHmmssSSS"));
        Random r = new Random(System.nanoTime());
        Long l = r.nextLong();
        if (l < 0) l = -l;
        String numberString = l.toString();
        if (StringUtils.length(numberString) < 4) {
            StringUtils.leftPad(numberString,4,"0");
        }
        sb.append(numberString.substring(numberString.length() - 4));
        return sb.toString();
    }

}
