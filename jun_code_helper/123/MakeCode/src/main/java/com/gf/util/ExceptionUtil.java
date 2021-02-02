package com.gf.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Monkey
 * @Date: Created in 9:49  2019/4/12.
 * @Description:
 */
public class ExceptionUtil {

    private final static String EXCEPTION = "Exception";
    private final static int EXCEPTION_LV = 4;
    private final static String ERROR_MSG = "操作失败";

    /**
     * 异常封装
     * @param e
     * @return
     */
    public static R getException(Exception e) {

        return getMsg(e, "");
    }
    /**
     * 带异常信息的封装
     * @param e
     * @return
     */
    public static R getException(Exception e, String errorMsg) {

        return getMsg(e, errorMsg);
    }


    /**
     * 打印错误信息日志
     * @param e2
     * @param errorMsg
     * @return
     */
    private static R getMsg (Object e2, String errorMsg) {
        String msg = null;
        if (e2  instanceof  Exception) {

            msg = ((Exception)e2).getMessage();
        }
        //如果有自定义异常，就返回自定义异常给前端，如果没有，就给默认
        if (StringUtils.isBlank(msg) && !msg.contains(EXCEPTION)) {
            msg = "";
        }
        if (StringUtils.isNotBlank(errorMsg)) {
            RecordLogUtil.error(msg + errorMsg, EXCEPTION_LV);
        } else {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Map<String, String[]> parameterMap = request.getParameterMap();
            String param = "";
            if (parameterMap.size() > 0) {
                Iterator<Map.Entry<String, String[]>> item = parameterMap.entrySet().iterator();
                while (item.hasNext()) {
                    if (StringUtils.isNotBlank(param)) {
                        param += ", ";
                    }
                    Map.Entry<String, String[]> next = item.next();
                    param += next.getKey() + "=" + next.getValue()[0] ;
                }

            }

            RecordLogUtil.error(msg + "参数=" + param, EXCEPTION_LV);
        }
        //错误信息修改，提供所有错误信息
        return new R(null,msg + errorMsg, R.FAIL);
    }

}
