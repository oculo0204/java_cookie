package panels;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public final class DB {
    
    static Connection con = makeConnection();
    
    public static Connection makeConnection() {
        String url = "jdbc:sqlite:cookieDB.sqlite"; // SQLite 데이터베이스 파일 경로
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC"); // SQLite JDBC 드라이버 로드
            System.out.println("데이터베이스 연결 중...");
            con = DriverManager.getConnection(url); // SQLite는 사용자명/비밀번호 필요 없음
            System.out.println("데이터베이스 연결 성공");

            // 테이블 생성
            String createTableSQL = "CREATE TABLE IF NOT EXISTS cookie (num INTEGER PRIMARY KEY, isNew INTEGER NOT NULL);";
            try (Statement stmt = con.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("테이블 생성 또는 확인 완료");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾지 못했습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패");
            e.printStackTrace();
        }

        return con;
    }
    
    // 리턴값이 ResultSet인 SELECT 쿼리문
    public static ResultSet selectQuery(String sql) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        return rs;
    }
    
    // 리턴값이 없는 INSERT 쿼리문
    public static void insertQuery(String sql) throws SQLException{
        Statement stmt = con.createStatement();

        // SQL 실행 후 결과 출력
        if (stmt.executeUpdate(sql) == 1) {
            System.out.println("레코드 추가 성공");
        } else {
            System.out.println("레코드 추가 실패");
        }

        stmt.close();
    }

    public static void connectionTest() {
        // SQLite에서 데이터베이스는 이미 존재하면 사용됨, CREATE DATABASE와 USE는 필요 없음
        String createTableSQL = "CREATE TABLE IF NOT EXISTS cookie (num INTEGER PRIMARY KEY, isNew INTEGER NOT NULL);";
        try {
            insertQuery(createTableSQL); // 테이블 생성
            System.out.println("테이블 생성 또는 확인 완료");

            for (int i = 0; i < Endings.count; i++) {
                // 먼저 num이 이미 존재하는지 확인
                String checkSQL = "SELECT COUNT(*) FROM cookie WHERE num = " + i;
                ResultSet rs = selectQuery(checkSQL);
                if (rs.next() && rs.getInt(1) == 0) {
                    // num이 존재하지 않으면 삽입
                    String insertSQL = "INSERT INTO cookie (num, isNew) VALUES (" + i + ", 1); ";
                    insertQuery(insertSQL);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean getIsNew(int index) throws SQLException {
        ResultSet rs = selectQuery("SELECT isNew FROM cookie WHERE num =" + index);
        while (rs.next()) {
            if (rs.getInt(1) == 1) {
                return true;
            }
        }
        return false;
    }

    public static void changeIsNew(int index) {    
        try {
            insertQuery("UPDATE cookie SET isNew = 0 WHERE num = " + index);
            System.out.println("update success");

        } catch (SQLException e) {
            System.out.println("update fail");
            e.printStackTrace();
        }
    }
}
