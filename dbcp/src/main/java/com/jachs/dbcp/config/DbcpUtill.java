package com.jachs.dbcp.config;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DbcpUtill {
	public BasicDataSource initBasicDataSource() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileInputStream(DbcpUtill.class.getResource("/dbcp.properties").getPath()));
//		BasicDataSourceFactory bsf = new BasicDataSourceFactory();// 创建工厂

		return BasicDataSourceFactory.createDataSource(properties);// 获取数据源
	}
}
