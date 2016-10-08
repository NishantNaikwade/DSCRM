package com.nextech.dscrm.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.jdbc.PreparedStatement;
import com.nextech.dscrm.model.LoginUserRequest;

public class LoginUserRequestDAOImpl implements LoginUserRequestDAO {

	@Autowired
	SessionFactory sessionFactory;

	public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "dscrm";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = (PreparedStatement) conn
                    .prepareStatement("select * from usermodel where userName=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
	
	@Override
	public Integer loginSaveUserRequest(LoginUserRequest loginUserRequest) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(loginUserRequest);
		tx.commit();
		Serializable id = session.getIdentifier(loginUserRequest);
		session.close();
		return (Integer) id;

	}

}
