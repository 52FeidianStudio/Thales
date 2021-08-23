package cn.thales.ioc.core.io;

import java.io.File;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:14
 * @Description: null
 */
public interface Resource {
    File getFile();
    String getFilename();
    String getFilePath();
}
