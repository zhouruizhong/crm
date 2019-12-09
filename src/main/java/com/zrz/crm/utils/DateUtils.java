package com.zrz.crm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间格式化工具
 *
 * @author qcdl
 * @date 2019/6/6
 */
public class DateUtils {

    public static final String DATE_YYYYMMDD = "yyyyMMdd";

    public static final String DATE_YYYYMM = "yyyyMM";

    public static final String DD_MM_YYYY = "dd-MM-yyyy";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DATE_YYYYMMDD_HHMMSS = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_YYYY_MM_DD_HHMM = "yyyy-MM-dd HH:mm";

    public static final String DATE_DD_MM_YYYY_HHMMSS = "dd-MM-yyyy HH:mm:ss";

    public static final String DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String DATE_YYYYMMDD__HHMMSS = "yyyyMMdd HHmmss";

    public static final String DATE_YYYYMMDDHH = "yyyyMMddHH";

    /**
     * cron格式日期
     */
    public static final String DATE_CRON_EXPRESSION = "ss mm HH dd MM ? yyyy";

    /**
     * TIMESPAN_BEGIN_POSTFIX 时间段开始时间后缀
     */
    public static final String TIMESPAN_BEGIN_POSTFIX = "00:00:00";

    /**
     * TIMESPAN_END_POSTFIX 时间段结束时间后缀
     */
    public static final String TIMESPAN_END_POSTFIX = "23:59:59";

    /**
     * 使用ThreadLocal管理时间格式化对象
     */
    private static ThreadLocal<Map<String, SimpleDateFormat>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    /**
     * 从ThreadLocal中获取时间格式化对象
     *
     * @param dateType 时间类型
     * @return 格式化后的时间串
     */
    private static SimpleDateFormat getDateFormat(final String dateType) {
        Map<String, SimpleDateFormat> map = threadLocal.get();
        SimpleDateFormat df = map.get(dateType);
        if (df == null) {
            df = new SimpleDateFormat(dateType);
            map.put(dateType, df);
        }
        return df;
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss类型的时间字符串
     */
    @SuppressWarnings("unused")
    public static String getCurrentTimeString() {
        return getTimeString(DATE_YYYY_MM_DD_HHMMSS, new Date());
    }

    /**
     * 将日期装换成指定格式的字符串
     *
     * @param format 格式
     * @param date   日期
     * @return String
     */
    public static String getTimeString(String format, Date date) {
        if (date == null) {
            return null;
        }
        return getDateFormat(format).format(date).trim();
    }

    /**
     * 日期解析
     *
     * @param format  format
     * @param strDate strDate
     * @return Date
     */
    public static Date parse(String format, String strDate) {
        try {
            return getDateFormat(format).parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取指定日期的
     *
     * @param date     日期
     * @param timeType 日期类型(年、月、周、日)Calendar.MONTH...
     * @return 当前数(第几日 周 月 年..)
     */
    private static int getNumByDate(final Date date, final int timeType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(timeType);
    }

    /**
     * 获取指定日期当前年份中的月数
     *
     * @param date 日期
     * @return 第几月 eg: 20160826 ->8
     */
    @SuppressWarnings("unused")
    public static int getMonthNum(final Date date) {
        return getNumByDate(date, Calendar.MONTH) + 1;
    }

    /**
     * 获取指定时间当前年份中的周数
     *
     * @param date 日期
     * @return 第几周 eg:20160826 ->35
     */
    @SuppressWarnings("unused")
    public static int getWeekNum(final Date date) {
        return getNumByDate(date, Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取指定时间当前月份中的日数的前一日
     *
     * @param date 日期
     * @return 第几日 eg:20160826 ->25
     */
    @SuppressWarnings("unused")
    public static int getLastDayNum(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getLastDay(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    public static Date getDate(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取日期对应的星期
     *
     * @param date date
     * @return int
     */
    @SuppressWarnings("unused")
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int retval = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (retval == 0) {
            retval = 7;
        }

        return retval;
    }

    /**
     * 日期比较
     *
     * @param format  日期字符串格式
     * @param dateStr 日期字符串
     * @param date    日期
     * @return true/false dateStrTime < dateTime
     */
    @SuppressWarnings("unused")
    public static boolean compareTime(String format, String dateStr, Date date) {
        Date time = parse(format, dateStr);
        return time != null && date != null && time.getTime() < date.getTime();
    }

    /**
     * 获取上周周数
     *
     * @param date 日期
     * @return 上周第几周
     */
    @SuppressWarnings("unused")
    public static int getLastWeekNum(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        // 上周
        calendar.add(Calendar.WEEK_OF_YEAR, -1);

        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取指定日期上一个月份中的月数
     *
     * @param date 日期
     * @return 指定日期上一个月份中的月数
     */
    @SuppressWarnings("unused")
    public static int getLastMonthNum(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);

        return calendar.get(Calendar.MONTH) + 1;
    }

}
