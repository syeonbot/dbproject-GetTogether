package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.MemberRecommend;
import model.MemberSplit;
import model.Project;
import model.TeamRecommend;

public class TeamRecommendDAO {
private JDBCUtil jdbcUtil = null;
	
	public TeamRecommendDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<TeamRecommend> findRecomendTeam() throws SQLException {
        String sql = "SELECT pid, title, subtitle, lookupcnt, recommendcnt " 
        		   + "FROM project "
        		   + "ORDER BY lookupcnt DESC";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<TeamRecommend> teamRecommendList = new ArrayList<TeamRecommend>();	
			while (rs.next()) {
				TeamRecommend teamRecommend = new TeamRecommend(
					rs.getInt("pid"),
					rs.getString("title"),
					rs.getString("subtitle"),
					rs.getInt("lookupcnt"),
					rs.getInt("recommendcnt"));
				teamRecommendList.add(teamRecommend);			
			}		
			return teamRecommendList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public MemberSplit memberSplit(int mnum) throws SQLException{
		String sql = "SELECT mnum, field, language " 
     		   + "FROM member "
     		   + "WHERE mnum = ? ";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {mnum});
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			MemberSplit memberSplit = null;	
			while (rs.next()) {
				memberSplit = new MemberSplit(
					mnum,
					rs.getString("field"),
					rs.getString("language"));
			}		
			return memberSplit;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	
	public List<TeamRecommend> findIdentifyRecommendTeam(String[] field, String[] language) throws SQLException {
        String sql = "SELECT pid, title, subtitle, lookupcnt, recommendcnt " 
        		   + "FROM project "
        		   + "WHERE field = ? OR language LIKE ? ";
        
        jdbcUtil.setSqlAndParameters(sql, new Object[] {field[(int) Math.random() * (field.length+1)], "%"+language[(int) Math.random() * (language.length+1)]+"%"});

					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<TeamRecommend> teamRecommendList = new ArrayList<TeamRecommend>();	
			while (rs.next()) {
				TeamRecommend teamRecommend = new TeamRecommend(
					rs.getInt("pid"),
					rs.getString("title"),
					rs.getString("subtitle"),
					rs.getInt("lookupcnt"),
					rs.getInt("recommendcnt"));
				teamRecommendList.add(teamRecommend);			
			}		
			return teamRecommendList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingMember(String mid) throws SQLException {
		String sql = "SELECT count(*) FROM USERINFO WHERE userid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {mid});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
}
