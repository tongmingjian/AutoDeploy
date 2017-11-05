package cis.autodeploy;

import java.io.File;
import java.sql.SQLException;

import cis.autodeploy.authorize.Subversion;
import cis.autodeploy.config.DataBase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Subversion sb = new Subversion("http://www.svnchina.com/svn/haitao", "tmjsvn", "kkk628");
        File Config = new File("Config.db");
        if(Config.exists()) {
            
        }
        try {
            DataBase.getConnection("Config.db");
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
