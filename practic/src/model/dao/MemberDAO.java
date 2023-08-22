package model.dao;

import org.apache.ibatis.session.SqlSession;

import model.vo.MemberVO;

public class MemberDAO {
   
	private static MemberDAO dao = new MemberDAO();
	public MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public int registerMember(SqlSession sqlSession, MemberVO vo) {
		return sqlSession.insert("memberMapper.registerMember", vo);
		
	}
	
	public List<MemberVO> showAllMember(SqlSession sqlSession) {
		return sqlSession.selectList("memberMapper.showAllMember");
	}
	
}
