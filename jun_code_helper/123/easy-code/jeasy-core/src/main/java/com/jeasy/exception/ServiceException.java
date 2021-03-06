package com.jeasy.exception;

import com.jeasy.common.str.StrKit;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Service层 异常
 *
 * @author taomk
 * @version 1.0
 * @since 2015/05/13 17:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 8247610319171014183L;

    private int code;

    public ServiceException(int code, Throwable e) {
        super(e.getMessage(), e);
        this.code = code;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(int code, String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params));
        this.code = code;
    }

    public ServiceException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public ServiceException(int code, Throwable throwable, String messageTemplate, Object... params) {
        super(StrKit.format(messageTemplate, params), throwable);
        this.code = code;
    }
}
