package db;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilsSampleCode {
	  public static void main(String[] args) {  
	        Connection conn = null;  
	        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
	        String jdbcDriver = "com.mysql.jdbc.Driver";  
	        String user = "root";  
	        String password = "123456";  
	  
	        DbUtils.loadDriver(jdbcDriver);  
	        try {  
	            conn = DriverManager.getConnection(url, user, password);  
	            QueryRunner qr = new QueryRunner();  
	  
	            /**
	             * insert delete update 采取如下方法
	             */
	            String sql = "insert into test(id,name) values(?,?)";
//	            String sql = "delete from code";
	            int inserts = qr.update(conn, sql, "3", "测试3");
	            System.out.println(inserts);
	            
	            /**
	             * 各种查询的使用方法
	             */
//	            //1.ArrayHandler 将查询结果的第一行转换为一个数组对象返回
//	            Object[] objs = runner.query("select * from account where name=?",new ArrayHandler() , "c");
//	            System.out.println(objs);
//	             
//	            //2.ArrayHandler 将查询结果的第一行转换为一个数组对象返回
//	            List<Object[]> list = runner.query("select * from account",new ArrayListHandler() );
//	            System.out.println(list);
//	             
//	            //3.BeanHandler,将查询结果的第一行转换为一个JavaBean对象返回
//	            Account acc = runner.query("select * from account where name=?",new BeanHandler<Account>(Account.class) , "c");
//	            System.out.println(acc);
//	             
//	            //4.BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
//	            List<Account> acclist = runner.query("select * from account",new BeanListHandler<Account>(Account.class));
//	            System.out.println(acclist);
//	             
//	            //5.MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
//	            Map map = runner.query("select * from account",new MapHandler() );
//	            System.out.println(map);
//	             
//	            //6.MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
//	            List<Map<String, Object>> maplist = runner.query("select * from account",new MapListHandler() );
//	            System.out.println(maplist);
//	             
//	            //7.ColumnListHandler：将结果集中某一列的数据存放到List中。
//	            List<Object> columnList = runner.query("select * from account",new ColumnListHandler(2) );
//	            System.out.println(columnList);
//	             
//	            //8.KeyedHandler(name)：将结果集中的每一行数据都封装到一个Map里(List<Map>)，再把这些map再存到一个map里，其key为指定的列。
//	            Map<Object, Map<String, Object>> keymap = runner.query("select * from account",new KeyedHandler("id") );
//	            System.out.println(keymap);
//	             
//	            //9.ScalarHandler: 单值查询
//	            //select count(*) from account;
//	            Long count = (Long)runner.query("select count(*) from account",new ScalarHandler(1) );
//	            System.out.println(count);
//	            
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } finally {  
	            DbUtils.closeQuietly(conn);  
	        }  
	 }
}
