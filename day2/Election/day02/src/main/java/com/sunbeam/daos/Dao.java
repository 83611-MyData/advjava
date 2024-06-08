package com.sunbeam.daos;

import java.sql.Connection;
import java.sql.SQLException;

import com.sunbeam.utils.Dbutils;

public class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = Dbutils.getConnection();
	}
	public void close() {
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
