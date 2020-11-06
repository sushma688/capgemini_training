import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

public class InsertDemo {
	private static Logger logger=Logger.getLogger(InsertDemo.class);
	public static void main(String[] args) {
		try {
			//1: Gather DB Information
			String driverClassName="org.postgresql.Driver";
			String url="jdbc:postgresql://localhost:5432/employeedb";
			String user="postgres";
			String pwd="admin";
			//2: Register Driver
			Class c = Class.forName(driverClassName);
			logger.info(c);
			//3: Get Connection
			Connection con =  DriverManager.getConnection(url, user, pwd);
			logger.info(con);
			//4: Prepare sql and Statement and execute query
			String sql = "insert into employees(id,fname,lname,age) values (?,?,?,?)";
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setInt(1, 105);
			pstmt.setString(2, "Aman");
			pstmt.setString(3, "Soni");
			pstmt.setInt(4, 23);
			pstmt.execute();
			logger.info(pstmt);
			logger.info("Data Inserted successfully! Please Check DB");
			
			//5: Release resources
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
