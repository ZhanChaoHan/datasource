package com.jachs.c3p0.config;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.cfg.C3P0ConfigUtils;

/***
 * 
 * @author zhanchaohan
 *
 */
public class C3p0Utill {
	
	/***
	 * 加载Properties方式初始化数据源
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws PropertyVetoException 
	 * @see C3P0ConfigUtils
	 */
	public ComboPooledDataSource initProperties() throws FileNotFoundException, IOException, PropertyVetoException {
		
		Properties properties=C3P0ConfigUtils.findResourceProperties();
		
		
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		
//		cpds.setProperties(properties);//不起作用
		
		cpds.setDriverClass(properties.getProperty("driverClassName"));
		cpds.setJdbcUrl(properties.getProperty("url"));
		cpds.setUser(properties.getProperty("username"));
		cpds.setPassword(properties.getProperty("password"));
		
		cpds.setInitialPoolSize(Integer.parseInt(properties.getProperty("initialPoolSize")));
		cpds.setMaxIdleTime(Integer.parseInt(properties.getProperty("maxIdleTime")));
		cpds.setMaxPoolSize(Integer.parseInt(properties.getProperty("maxPoolSize")));
		cpds.setMinPoolSize(Integer.parseInt(properties.getProperty("minPoolSize")));
		
		return cpds;
	}
	/***
	 * 
	 * @return
	 * @see C3P0ConfigXmlUtils
	 */
	public ComboPooledDataSource initXML() {
//		ComboPooledDataSource cpds=new ComboPooledDataSource("mySource");
		ComboPooledDataSource cpds=new ComboPooledDataSource();//不给参数使用默认数据源
		return cpds;
	}
}
