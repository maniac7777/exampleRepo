package dao;

import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import model.BoardBean;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BoardDAOImpl {
	
//	Reader reader = null;	
//	SqlSessionFactory factory = null;
//	SqlSession sqlsession = null;	
//
//	public void getSession() throws Exception {
//		String resource = "util/SqlMapConfig.xml";
//		reader = Resources.getResourceAsReader(resource);
//		factory = new SqlSessionFactoryBuilder().build(reader);		
//		sqlsession = factory.openSession(true);	// true : auto commit	
//	}

	private SqlSession sqlSession;//mybatis 쿼리문 실행 변수

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}//스프링 setter DI 의존관계를 설정
	
	
	/* 게시판 저장 */
	public void insertBoard(BoardBean b) throws Exception {
//		getSession();		
		sqlSession.insert("Test.board_insert", b);
//		sqlsession.commit();		
	}

	// 게시물 목록
	public List<BoardBean> getBoardList(int page) throws Exception {
//		getSession();
		List<BoardBean> list = sqlSession.selectList("Test.board_list", page);

		return list;
	}

	// 게시판 총 게시물 수
	public int getListCount() throws Exception {
		int count = 0;
		
//		getSession();
		count = ((Integer) sqlSession.selectOne("Test.board_count")).intValue();

		return count;
	}

	// 게시판 글내용보기
	public BoardBean getBoardCont(int board_num) throws Exception {
//		getSession();
		return (BoardBean) sqlSession.selectOne("Test.board_cont",board_num);
	}

	// 게시판 조회수 증가
	public void boardHit(int board_num) throws Exception {
//		getSession();
		sqlSession.update("Test.board_hit", board_num);
//		sqlsession.commit();		
	}

	// 게시물 수정
	public void boardEdit(BoardBean b) throws Exception {
//		getSession();
		sqlSession.update("Test.board_edit", b);
//		sqlsession.commit();		
	}

	// 게시물 삭제
	public void boardDelete(int board_num) throws Exception {
//		getSession();
		sqlSession.delete("Test.board_del", board_num);
//		sqlsession.commit();		
	}

	// 답변글 레벨 증가
	public void refEdit(BoardBean b) throws Exception {
//		getSession();
		sqlSession.update("Test.board_Level", b);
//		sqlsession.commit();		
	}

	// 답변글 저장
	public void boardReplyOk(BoardBean b) throws Exception {
//		getSession();
		sqlSession.insert("Test.board_reply", b);
//		sqlsession.commit();		
	}

}
