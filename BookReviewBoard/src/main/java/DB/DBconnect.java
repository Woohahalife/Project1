package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class DBconnect {

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public DBconnect(ServletContext application) {
		
		try {
			//jdbc드라이버 로드
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);
			
			//DB연결
			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleID");
			String pw = application.getInitParameter("OraclePW");
			
			con = DriverManager.getConnection(url);
			
			System.out.println("DB연결성공");
		
		}catch(Exception e) {
			System.out.println("DB연결 중 예외발생");
			e.printStackTrace();
		}
		
		
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(psmt!=null) psmt.close();
			if(con!=null) con.close();
			
			System.out.println("DB연결해제");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
