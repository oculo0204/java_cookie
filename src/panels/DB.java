package panels;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import main.Main;

public final class DB {
	
	static Connection con = makeConnection();
	
	
	public static Connection makeConnection() {
		String url = "jdbc:mysql://34.44.174.67:3306/cookie?serverTimezone=Asia/Seoul";
		String id = "cookie_id";
        String passwd = "cookie_pw";

//		아이디 및 비밀번호 보호
		Properties properties = new Properties();
        	// 커넥션 생성
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결중 ...");
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾지 못했습니다...");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	
//	리턴값이 ResultSet인 SELECT 쿼리문
	public static ResultSet selectQuery(String sql) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	
//	리턴값이 없는 INSERT 쿼리문
	public static int insertQuery(String sql) throws SQLException{
		Statement stmt = con.createStatement();
		int temp = stmt.executeUpdate(sql);
		stmt.close();
		return temp;
		
	}
	
	
	public static boolean getIsNew(int index) {
		String s = index+"_isnew";
		ResultSet rs;
		try {
			rs = selectQuery("SELECT " + s + " FROM endings WHERE id_user = '" + Main.userId + "';");
			while(rs.next()) {
				if(rs.getInt(1)==0)
				return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void changeIsNew(int index){	
		try {
			String s = index + "_isnew";
			insertQuery("UPDATE endings SET " + s + " = 0 WHERE id_user = '" + Main.userId + "';");
			System.out.println("update success");
		} catch (SQLException e) {
			System.out.println("update fail");
			e.printStackTrace();
		}
	}
	
	public static boolean isWrongAccount(String id, String pw) {
		try {
			String sql = "SELECT * FROM user where id = '" + id + "'&& pw = '" + pw +"';";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
				return true;
			}}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean isNewID(String id) {
		String sql = "select * from user where id = '" + id + "';";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public static boolean isPossibleAccount(String id, String pw) {
		
		return false;
	}
	
	public static void makeAccount(String id, String pw) {
		try {
			insertQuery("INSERT into user (id, pw) values ('" + id + "', '" + pw +"');");
			insertQuery("INSERT into endings (id_user) values ('" + id +"');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

