package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Dto.RankDto;

public class RankDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public RankDao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "system", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<RankDto> SelectAll() {
		List<RankDto> list = new ArrayList();
		RankDto dto = null;
		
		try {
			String sql = null;
			sql = "select member.m_no, m_name, count(vote.m_no) as sum_count \r\n"
					+ "from tbl_member_202005 member\r\n"
					+ "inner join tbl_vote_202005 vote\r\n"
					+ "on member.m_no=vote.m_no\r\n"
					+ "where V_confirm='Y'\r\n"
					+ "group by member.m_no, m_name\r\n"
					+ "order by count(vote.m_no) desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					dto = new RankDto();
					dto.setM_no(rs.getString("m_no"));
					dto.setM_name(rs.getString("m_name"));
					dto.setSum_count(rs.getInt("sum_count") + "");  //이게문제네..?
					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch(Exception e) {}
			try {pstmt.close();} catch(Exception e) {}
			try {con.close();} catch(Exception e) {}
		}
		return list;
	}
	
	
	
	
}
