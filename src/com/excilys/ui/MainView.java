package com.excilys.ui;

import java.sql.SQLException;

import com.excilys.model.Company;
import com.excilys.model.ConnectionDB;

public class MainView {
	private ConnectionDB conn;
	
	public MainView() {
		try {
			conn = new ConnectionDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ConnectionDB getConn() {
		return conn;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView mv = new MainView();
		try {
			for(Company c: mv.getConn().listCompany().values()) {
				System.out.println(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
