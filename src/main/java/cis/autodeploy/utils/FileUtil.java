/******************************************************************
 *
 *    Java , Powered By Sinosoft tmj.
 *
 *    Copyright (c) 2001-2017 Digital Telemedia Co.,Ltd
 *    http://www.sinosoft.com.cn/
 *
 *    Package:     cis.autodeploy.utils
 *
 *    Filename:    FileUtil.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2017
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     tmjkk
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月29日 下午7:25:57
 *
 *    Revision:
 *
 *    2017年10月29日 下午7:25:57
 *        - first revision
 *
 *****************************************************************/
package cis.autodeploy.utils;

import java.io.File;

/**
 * @ClassName FileUtil
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author tmjkk
 * @Date 2017年10月29日 下午7:25:57
 * @version 1.0.0
 */
public class FileUtil {
    /**
     * 
     * @Description 判断文件是否存在，若存在则返回true,否则返回false
     * @param dir 文件或文件夹的路径
     * @return true&false
     */
    public boolean exists(String dir) {
        File file = new File(dir);
        if (file.exists()) {
            return true;
        }
        return false;
    }
}
