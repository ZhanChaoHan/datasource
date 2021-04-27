package com.jachs.druid;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.jachs.druid.config.DruidUtill;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DruidUtillTest {
	private DruidDataSource druidDataSource;
	
	@Before
	public void init() throws FileNotFoundException, IOException {
		DruidUtill du=new DruidUtill();
		
		druidDataSource=du.init();
	}
	@Test
	public void test1() throws SQLException {
		DruidPooledConnection dpc=	druidDataSource.getConnection();
		
		PreparedStatement preparedStatement=dpc.prepareStatement("show tables");
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}
}
