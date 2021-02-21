package com.jeasy.common.ueditor.define;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taomk
 * @version 1.0
 * @since 2015/05/13 17:34
 */
public class FileType {

    public static final String JPG = "JPG";

    private static final Map<String, String> TYPES = new HashMap<String, String>() {
        private static final long serialVersionUID = -935543810424292061L;

        {
            put(FileType.JPG, ".jpg");
        }
    };

    public static String getSuffix(String key) {
        return FileType.TYPES.get(key);
    }

    /**
     * 根据给定的文件名,获取其后缀信息
     *
     * @param filename 文件名
     * @return String 文件扩展名
     */
    public static String getSuffixByFilename(String filename) {
        return filename.substring(filename.lastIndexOf(".")).toLowerCase();
    }

}
