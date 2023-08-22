package model.service;

import org.apache.ibatis.session.SqlSession;

import common.Template;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class MemberService {
   public int registerMember(MemberVO vo) {
	   SqlSession sqlSession = Template.getSqlSession();
	    int result = new MemberDAO().getInstance().registerMember(sqlSession, vo);
	   
	    if(result>0) sqlSession.commit();
	    sqlSession.close();
	    return result;
	   
   }
   public MemberVO showAllMember() {
	   SqlSession sqlSession = Template.getSqlSession();
	  MemberVO vo  = new MemberDAO().getInstance().showAllMember(sqlSession);
	   sqlSession.close();
	   return vo;
   }
}
