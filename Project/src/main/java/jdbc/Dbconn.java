package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbconn {


    public void closeResultSet(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void closeStatement(PreparedStatement st){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void closeConnection(Connection con){


        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Connection connection() throws ClassNotFoundException, SQLException {
        //아이피 포트 계정 패스워드 인스턴스

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String id = "testuser1";
        String password = "zerobase";

        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(url, id, password);

    }
	
}
