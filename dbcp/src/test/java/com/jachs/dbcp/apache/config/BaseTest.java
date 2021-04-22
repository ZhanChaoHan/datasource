package com.jachs.dbcp.apache.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import com.jachs.dbcp.config.DbcpUtill;
/***
 * 
 * @author zhanchaohan
 *
 */
public class BaseTest {
	DbcpUtill DbcpUtill=new DbcpUtill();
	BasicDataSource bds;
	
	@Before
	public void init() {
		try {
			bds=DbcpUtill.initBasicDataSource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testc() throws SQLException {
		Connection connection=bds.getConnection();
		
		ResultSet resultSet=connection.prepareStatement("show tables").executeQuery();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
	}
}
