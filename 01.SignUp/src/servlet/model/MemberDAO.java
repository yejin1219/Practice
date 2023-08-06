package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.Serverinfo;

public class MemberDAO implements MemberDAOTemplate {

	
   public MemberDAO() {
		
		try {
			Class.forName(Serverinfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 ");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(Serverinfo.URL, Serverinfo.USER, Serverinfo.PASSWORD);
		System.out.println("데이터 베이스 연결");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
		
	}

	@Override
	public void closeAll(ResultSet st, PreparedStatement ps, Connection conn) throws SQLException {
	 st.close();
	 closeAll(ps,conn);
		
	}

	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();
		String query = "INSER INTO MEMBER(ID, PASSWORD, NAME, NICKNAME, GENDER)VALUES(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getNickname());
		ps.setString(5, vo.getGender());
		
       System.out.println(ps.executeUpdate() + "명 가입!");
		
		
		closeAll(ps,conn);
	}

	@Override
	public ArrayList<MemberVO> showALLMember() throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<MemberVO> memberlist = new ArrayList<>();
		
		while(rs!=null) {
			memberlist.add(new MemberVO(rs.getString("ID"),rs.getString("PASSWORD"),rs.getString("NAME"),
					rs.getString("NICKNAME"),rs.getString("GENDER")));
		}
		closeAll(rs,ps,conn);
		return memberlist;
	}

	@Override
	public MemberVO findByPasswordMember(String password) throws SQLException {
		Connection conn = getConnection();
		String query = "SELECT $ FROM MEMBER WHERE PASSWORD=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,password);
		
		ResultSet rs = ps.executeQuery();
		MemberVO vo = new MemberVO();
		
		if(rs!=null) {
			vo = new MemberVO(rs.getString("ID"),password,rs.getString("NAME"),
					rs.getString("NICKNAME"),rs.getString("GENDER"));
		}
		closeAll(rs,ps,conn);
		return vo;
	}

}
