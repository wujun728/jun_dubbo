package com.jeasy.common.ueditor.manager;

import com.jeasy.common.ueditor.ActionConfig;
import com.jeasy.common.ueditor.define.State;

import java.io.InputStream;

/**
 * @author taomk
 * @version 1.0
 * @since 2015/05/13 17:34
 */
public interface IUeditorFileManager {
    /**
     * 文件列表
     *
     * @param conf  配置
     * @param start 开始
     * @return state 状态接口
     */
    State list(ActionConfig conf, int start);

    /**
     * 保存二进制文件
     *
     * @param data     图片二进制信息
     * @param rootPath 跟路径
     * @param savePath 保存路径
     * @return state 状态接口
     */
    State saveFile(byte[] data, String rootPath, String savePath);

    /**
     * 保存流文件
     *
     * @param is       流
     * @param rootPath 跟路径
     * @param savePath 保存路径
     * @param maxSize  文件最大字节
     * @return state 状态接口
     */
    State saveFile(InputStream is, String rootPath, String savePath, long maxSize);

    /**
     * 保存流文件
     *
     * @param is       流
     * @param rootPath 跟路径
     * @param savePath 保存路径
     * @return state 状态接口
     */
    State saveFile(InputStream is, String rootPath, String savePath);

}
