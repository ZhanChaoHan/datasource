package com.jachs.c3p0.config;

import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/***
 * 
 * @author zhanchaohan
 *
 */
public class C3P0Test {
	private C3p0Utill c3p0Utill = new C3p0Utill();

	ComboPooledDataSource cpds;

	@Before
	public void init() throws FileNotFoundException, IOException, PropertyVetoException {
		cpds = c3p0Utill.initProperties();
//		cpds = c3p0Utill.initXML();
	}

	@Test
	public void tetc() throws SQLException {
		Connection connection = cpds.getConnection();

		ResultSet resultSet = connection.prepareStatement("show tables").executeQuery();

		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
		System.out.println(cpds.getMaxPoolSize());
	}
}
