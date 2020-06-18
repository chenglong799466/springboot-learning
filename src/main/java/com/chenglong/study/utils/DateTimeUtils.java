package com.chenglong.study.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author v_longcheng
 * @date 2019/6/5
 * @description 时间转换工具类
 */
public class DateTimeUtils {

    private static final Logger logger = LogManager.getLogger(DateTimeUtils.class);

    /**
     * 获取时间间隔duration
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static Duration getDuration(Date dateStart, Date dateEnd) {

        if (dateStart == null || dateEnd == null) {
            return null;
        }

        DateTime start = new DateTime(dateStart);
        DateTime end = new DateTime(dateEnd);
        Duration duration = new Duration(start, end);

        return duration;
    }

    /**
     * 获取时间间隔（秒）DurationSeconds
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static long getDurationSeconds(Date dateStart, Date dateEnd) {

        if (dateStart == null || dateEnd == null) {
            return 0L;
        }

        DateTime start = new DateTime(dateStart);
        DateTime end = new DateTime(dateEnd);
        Duration duration = new Duration(start, end);

        return duration.getStandardSeconds();
    }

    /**
     * 获取时间间隔（分钟）DurationMinutes
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static long getDurationMinutes(Date dateStart, Date dateEnd) {

        if (dateStart == null || dateEnd == null) {
            return 0L;
        }

        DateTime start = new DateTime(dateStart);
        DateTime end = new DateTime(dateEnd);
        Duration duration = new Duration(start, end);

        return duration.getStandardMinutes();
    }

    /**
     * 获取时间间隔（小时）DurationHours
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static long getDurationHours(Date dateStart, Date dateEnd) {

        if (dateStart == null || dateEnd == null) {
            return 0L;
        }

        DateTime start = new DateTime(dateStart);
        DateTime end = new DateTime(dateEnd);
        Duration duration = new Duration(start, end);

        return duration.getStandardHours();
    }

    /**
     * 获取时间间隔（天）DurationDays
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static long getDurationDays(Date dateStart, Date dateEnd) {

        if (dateStart == null || dateEnd == null) {
            return 0L;
        }

        DateTime start = new DateTime(dateStart);
        DateTime end = new DateTime(dateEnd);
        Duration duration = new Duration(start, end);

        return duration.getStandardDays();
    }

    /**
     * 获取时间间隔period(例如：时间间隔为1天0小时4分57秒，period.getSeconds()=57,period.getMinutes()=4,period.getHours()=0,period.getDays()=1)
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static Period getPeriodSeconds(Date dateStart, Date dateEnd) {

        if (dateStart == null || dateEnd == null) {
            return null;
        }

        DateTime start = new DateTime(dateStart);
        DateTime end = new DateTime(dateEnd);

        Period period = new Period(start, end);
        return period;
    }

    /**
     * string convert to dateTime
     *
     * @param dateStr
     * @return
     */
    public static DateTime convertStringToDateTime(String dateStr, DateTimeType dateTimeType) {

        if (StringUtils.isBlank(dateStr)) {
            logger.error("Method convertStringToDateTime dateStr is null");
            return null;
        }

        DateTimeFormatter formatter = getDateTimeFormatter(dateTimeType);

        if (formatter == null) {
            logger.error("Method convertStringToDateTime dateTimeFormatter is null");
            System.out.println("Method convertStringToDateTime dateTimeFormatter is null");
            return null;
        }


        DateTime dateTime = DateTime.parse(dateStr, formatter);

        return dateTime;
    }

    /**
     * string convert to date
     *
     * @param dateStr
     * @return
     */
    public static Date convertStringToDate(String dateStr, DateTimeType dateTimeType) {

        DateTime dateTime = convertStringToDateTime(dateStr, dateTimeType);

        if (dateTime == null) {
            return null;
        }

        return dateTime.toDate();
    }

    /**
     * string convert to dateString
     *
     * @param dateStr
     * @return
     */
    public static String convertStringToDateString(String dateStr, DateTimeType dateTimeTypeFrom, DateTimeType dateTimeTypeTo) {

        System.out.println("原始 timeStr :" + dateStr);

        DateTime dateTime = convertStringToDateTime(dateStr, dateTimeTypeFrom);

        if (dateTime == null) {
            logger.error("Method convertStringToDateString datetime is null");
            return null;
        }

        String string = dateTime.toString(dateTimeTypeTo.type);
        System.out.println("结果 string：" + string);
        return string;
    }

    /**
     * get DateTimeFormatter
     *
     * @param dateTimeType
     * @return
     */
    public static DateTimeFormatter getDateTimeFormatter(DateTimeType dateTimeType) {

        if (dateTimeType == null) {
            logger.error("Method getDateTimeFormatter dateTimeType is null");
            return null;
        }


        DateTimeFormatter formatter = null;
        List<DateTimeType> dateTimeTypeList = Arrays.stream(DateTimeType.values()).collect(Collectors.toList());
        for (DateTimeType type : dateTimeTypeList) {
            if (type.equals(dateTimeType)) {

                if (type.equals(DateTimeType.YMD_EN)) {
                    System.out.println("1----");

                    System.out.println(type.type);

                    formatter = DateTimeFormat.forPattern(type.type).withLocale(Locale.US).withZone(DateTimeZone.forOffsetHours(8));
                } else {
                    System.out.println("2----");
                    formatter = DateTimeFormat.forPattern(type.type);
                }

            }
        }

        if (formatter == null) {
            logger.error("Method convertStringToDateTime dateTimeFormatter is null");
            System.out.println("Method convertStringToDateTime dateTimeFormatter is null");
            return null;
        }

        return formatter;
    }

    /**
     * string convert to datetime
     *
     * @param dateStr
     * @return
     */
    public static DateTime convertStringToDateTime(String dateStr, DateTimeFormatter formatter) {

        if (StringUtils.isBlank(dateStr)) {
            logger.error("Method convertStringToDateTime dateStr is blank");
            return null;
        }

        if (formatter == null) {
            logger.error("Method convertStringToDateTime formatter is null");
            return null;
        }

        DateTime dateTime = DateTime.parse(dateStr, formatter);

        return dateTime;
    }

    /**
     * string convert to date
     *
     * @param dateStr
     * @return
     */
    public static Date convertStringToDate(String dateStr, DateTimeFormatter formatter) {

        DateTime dateTime = convertStringToDateTime(dateStr, formatter);

        if (dateTime == null) {
            return null;
        }


        return dateTime.toDate();
    }

    public static void main(String[] args) {
        String enStr = "Thu Jun 06 18:06:06 CST 2019";
        String dateTimeStr = "2019-06-07T07:06:06.000+08:00";


        String string = DateTimeUtils.convertStringToDateString(dateTimeStr, DateTimeUtils.DateTimeType.YMD_DATETIME, DateTimeUtils.DateTimeType.YMD_DATETIME_GMT);
        Date date = DateTimeUtils.convertStringToDate(enStr, DateTimeUtils.DateTimeType.YMD_EN);
        System.out.println(date);
    }

    public enum DateTimeType {


        /**
         * 2019-06-06T17:49:43.585+08:00
         */
        YMD_DATETIME("yyyy-MM-dd'T'HH:mm:ss.SSSZZ"),

        /**
         * 2019-06-06T17:49:43.585+0800
         */
        YMD_DATETIME_GMT("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),

        YMD_SLASH("yyyy/MM/dd"),

        YMD_DASH("yyyy-MM-dd"),

        YMD_DASH_HM_COLON("yyyy-MM-dd HH:mm"),

        YMD_DASH_HMS_COLON("yyyy-MM-dd HH:mm:ss"),

        YMD_SLASH_HMS_COLON("yyyy/MM/dd HH:mm:ss"),

        /**
         * Thu Jun 06 18:06:06 CST 2019
         */
        YMD_EN("EEE MMM dd HH:mm:ss zzz yyyy"),

        YMD_CN("yyyy年MM月dd日");


        private String type;

        DateTimeType(String type) {
            this.type = type;
        }

    }


}
