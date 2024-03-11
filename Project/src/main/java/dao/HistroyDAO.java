package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import dto.HistoryDTO;
import jdbc.Dbconn;

public class HistroyDAO extends Dbconn{
	
	Connection conn = null;
	PreparedStatement ps = null;   
	ResultSet rs = null; 
		
	   public int saveHistory(Double lat, Double lnt) {
	        Connection conn = null;
	        PreparedStatement ps = null;

	        String sql = "insert into history(lat,lnt,date)" +
	                "values(?,?,now())";

	        try {
	            conn = connection();
	            // select 뺴고
	            // insert,update,delete 트랜젝션
	            conn.setAutoCommit(false); // 트랜젝션시작

	            ps = conn.prepareStatement(sql);
	            ps.setDouble(1, lat);
	            ps.setDouble(2, lnt);
	            int resultCount = ps.executeUpdate();
	            conn.commit();
	            return resultCount;

	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (SQLException e) {
	            try {
	                conn.rollback();
	            } catch (SQLException ex) {
	                throw new RuntimeException(ex);
	            }
	            throw new RuntimeException(e);
	        } finally {
	            closeStatement(ps);
	            closeConnection(conn);
	        }


	    }
	   

	    public List<HistoryDTO> HistoryselectAll() {


	        String sql = " select * from history " +
	                " order by id desc ";
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null; // 한줄씩읽는애
	        try {
	            conn = connection();
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            List<HistoryDTO> HistoryList = new ArrayList<>();
	            while (rs.next()) {

	            	HistoryList.add(new HistoryDTO(
	                        rs.getString("id"), rs.getDouble("lat"), rs.getDouble("lnt")
	                        ,rs.getString("date"))
	                );
	            }
	            return HistoryList;

	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }finally {
	            closeResultSet(rs);
	            closeStatement(ps);
	            closeConnection(conn);
	        }


	    }
	
	
}
