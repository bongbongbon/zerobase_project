package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DistanceDTO;
import dto.RowDTO;
import jdbc.Dbconn;

public class DAO extends Dbconn{
	
	Connection conn = null;
    PreparedStatement ps = null;   
    ResultSet rs = null; 
	
	public void saveData(List<RowDTO> list) throws Exception{
		
        String sql = "insert into wifi(x_swifi_mgr_no, x_swifi_wrdofc, x_swifi_main_nm, \n" +
                "                 x_swifi_adres1, x_swifi_adres2, x_swifi_instl_floor, \n" +
                "                 x_swifi_instl_ty, x_swifi_instl_mby, x_swifi_svc_se, \n" +
                "                 x_swifi_cmcwr, x_swifi_cnstc_year, x_swifi_inout_door, \n" +
                "                 x_swifi_remars3, lat, lnt, work_dttm) \n" +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = connection();
			
			ps = conn.prepareStatement(sql);
			
			for (int i = 0; i < list.size(); i++) {
				RowDTO rowDTO = list.get(i);
				ps.setString(1, rowDTO.getMGR_NO());
				ps.setString(2, rowDTO.getWRDOFC());
				ps.setString(3, rowDTO.getMAIN_NM());
				ps.setString(4, rowDTO.getADRES1());
				ps.setString(5, rowDTO.getADRES2());
				ps.setString(6, rowDTO.getFLOOR());
				ps.setString(7, rowDTO.getINSTL_TY());
				ps.setString(8, rowDTO.getINSTL_MBY());
				ps.setString(9, rowDTO.getSVC_SE());
				ps.setString(10, rowDTO.getCMCWR());
				ps.setString(11, rowDTO.getCNSTC_YEAR());
				ps.setString(12, rowDTO.getINOUT_DOOR());
				ps.setString(13, rowDTO.getREMARS3());
				ps.setString(14, rowDTO.getLAT());
				ps.setString(15, rowDTO.getLNT());
				ps.setString(16, rowDTO.getWORK_DTTM());
	
				
			}
			
			conn.commit();
			
		} catch (Exception e) {
			conn.rollback();
		}finally {
			closeStatement(ps);
			closeConnection(conn);
		}
		
		
		
	}
	
	public List<DistanceDTO> nearSearch (Double lat, Double lnt) {
		
	    String sql = "select * " +
                ", format((6371 * acos(cos(radians(" + lat + ")) * cos(radians(lat)) * cos(radians(lnt) - radians(" + lat + ")) " +
                "+ sin(radians(" + lnt + ")) * sin(radians(lat)))), 4) as distance " +
                " from wifi " +
                " order by distance , X_SWIFI_MGR_NO" +
                " limit 20";

	   try {
		  conn = connection();
		  ps = conn.prepareStatement(sql);
		  rs = ps.executeQuery();
		  	
		  List<DistanceDTO> list = new ArrayList<>();
		  
		  while(rs.next()) {
			  DistanceDTO distanceDTO = new DistanceDTO(
			            rs.getString("distance"),
                        rs.getString("X_SWIFI_MGR_NO"),
                        rs.getString("X_SWIFI_WRDOFC"),
                        rs.getString("X_SWIFI_MAIN_NM"),
                        rs.getString("X_SWIFI_ADRES1"),
                        rs.getString("X_SWIFI_ADRES2"),
                        rs.getString("X_SWIFI_INSTL_FLOOR"),
                        rs.getString("X_SWIFI_INSTL_TY"),
                        rs.getString("X_SWIFI_INSTL_MBY"),
                        rs.getString("X_SWIFI_SVC_SE"),
                        rs.getString("X_SWIFI_CMCWR"),
                        rs.getString("X_SWIFI_CNSTC_YEAR"),
                        rs.getString("X_SWIFI_INOUT_DOOR"),
                        rs.getString("X_SWIFI_REMARS3"),
                        rs.getString("LAT"),
                        rs.getString("LNT"),
                        rs.getString("WORK_DTTM")
					  );
			  
			  list.add(distanceDTO);
		  }
		  
		  return list;
		  
	} catch (Exception e) {
		throw new RuntimeException();
	}finally {
		closeResultSet(rs);
		closeStatement(ps);
		closeConnection(conn);
	}
	    
	}
	
	
    public int removeAllData(){

        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "delete from wifi ";


        try {
            conn = connection();
            conn.setAutoCommit(false); 

            ps = conn.prepareStatement(sql);

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
    
    

}
