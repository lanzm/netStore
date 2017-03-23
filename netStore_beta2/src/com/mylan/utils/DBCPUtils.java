package com.mylan.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	
	private static DataSource datasource;
	static{
		
		try{
			
			InputStream in = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(in);
			datasource = BasicDataSourceFactory.createDataSource(prop);
			
		}catch(Exception e){
			throw new RuntimeException("服务器忙");
		}
		
	}
	public static DataSource getDataSource(){
		return datasource;
	}
	public static Connection getconnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
