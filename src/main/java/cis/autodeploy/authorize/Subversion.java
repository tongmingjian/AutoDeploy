/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     Cis.AutoDeploy.authorize
 *
 *    Filename:    Subversion.java
 *
 *    Description: Svn登录认证
 *
 *    Copyright:   Copyright (c) 2001-2017
 *
 *    Company:     Sinosoft.com.cn
 *
 *    @author:     tmj
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年10月29日 上午3:05:44
 *
 *    Revision:
 *
 *    2017年10月29日 上午3:05:44
 *        - first revision
 *
 *****************************************************************/
package cis.autodeploy.authorize;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * @ClassName Subversion
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author tmjkk
 * @Date 2017年10月29日 上午3:05:44
 * @version 1.0.0
 */
public class Subversion {

    private String RepositoryUrl;
    private String Username;
    private String Password;
    private SVNURL repositoryURL;
    private SVNRepository repository;
    private ISVNAuthenticationManager authManager;
    private ISVNOptions options;
    private SVNClientManager ClientManager;
    private SVNUpdateClient updateClient;

    /**
     * <style type="text/css"> span {color: blue} </style>
     * 
     * @Description 根据<span> SVN路径，用户名，密码 </span>来初始化SVN仓库
     * @param repositoryUrl
     *            <span>SVN路径</span>
     * @param username
     *            <span>用户名</span>
     * @param password
     *            <span>密码</span>
     * @author tmj
     */
    public Subversion(String repositoryUrl, String username, String password) {
        super();
        RepositoryUrl = repositoryUrl;
        Username = username;
        Password = password;
        Authorize();
        System.out.println(this.toString());
    }

    @SuppressWarnings("deprecation")
    public SVNRepository Authorize() {
        try {
            repositoryURL = SVNURL.parseURIEncoded(RepositoryUrl);
            // 根据URL实例化SVN版本库。
            repository = SVNRepositoryFactory.create(repositoryURL);
            // 设置认证管理器
            authManager = SVNWCUtil.createDefaultAuthenticationManager(Username, Password);
            // 将版本库与认证管理器绑定
            repository.setAuthenticationManager(authManager);
            // 以默认设置初始化一个SVN设置
            options = SVNWCUtil.createDefaultOptions(true);
            // 用之前的认证管理器和设置实例化一个客户端管理类
            ClientManager = SVNClientManager.newInstance((DefaultSVNOptions) options, authManager);
            // 通过客户端管理类获得updateClient类的实例。
            updateClient = ClientManager.getUpdateClient();
            // 不忽略外部定义
            updateClient.setIgnoreExternals(false);
        } catch (SVNException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
        return repository;
    }

    @Override
    public String toString() {
        try {
            return "Url：" + RepositoryUrl + "\r\n" + "最新版本：" + repository.getLatestRevision();
        } catch (SVNException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "SVN初始化ERROR";
    }
    
}
