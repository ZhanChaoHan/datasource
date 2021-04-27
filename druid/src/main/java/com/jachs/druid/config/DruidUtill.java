package com.jachs.druid.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DruidUtill {

	public DruidDataSource init() throws FileNotFoundException, IOException {
		Properties properties=new Properties();
		properties.load(DruidUtill.class.getResourceAsStream("/druid.properties"));
		
		
		DruidDataSource dataSource = new DruidDataSource();
		
		dataSource.configFromPropety(properties);
		
		return dataSource;
	}
}
