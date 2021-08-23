package cn.thales.ioc.core.io;

/**
 * @author TestLove
 * @version 1.0
 * @date 2021/8/16 21:16
 * @Description: null
 */
public abstract class AbstractResource implements Resource {

    @Override
    public String getFilename() {
        return getFile().getName();
    }

    @Override
    public String getFilePath() {
        return getFile().getPath();
    }
}
