package cn.juntai.wxpaydemo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private DateUtil(){
        throw new RuntimeException("不能被实列化！");
    }

    /**
     * 获取当前时间(14位)
     * @return
     */
    public static String getCurrentTime(){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(now);
    }
    /**
     * 获取当前时间戳，单位秒（10位）
     * @return
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis()/1000;
    }

    /**
     * 获取当前时间戳，单位毫秒（13位）
     * @return
     */
    public static long getCurrentTimestampMs() {
        return System.currentTimeMillis();
    }

}
