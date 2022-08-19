
package garebnb.board.dao;
  
import java.util.List;
import java.util.Map;
  
import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
import org.mybatis.spring.SqlSessionTemplate; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;
  
  
@Repository("boardDAO") 
public class BoardDAOImpl implements BoardDAO{
  
	protected Log log = LogFactory.getLog(BoardDAO.class);
	  
	@Autowired private SqlSessionTemplate sqlSession;
	  
	protected void printQueryId(String queryId) { 
		 if(log.isDebugEnabled()) {
			 log.debug("\t QueryId \t:  " + queryId); 
			 } 
		 }
	  
	@Override 
	public List<Map<String, Object>> selectOneBoardList(Map<String, Object>map) throws Exception { 
		 // TODO Auto-generated method stub 
		 return sqlSession.selectList("board.selectOneBoardList", map); 
	}
	  
	@Override 
	public void updateOneBoardDelete(Map<String, Object> map) throws Exception { 
		// TODO Auto-generated method stub
		sqlSession.update("board.updateOneBoardDelete",map); 
	}
	  
	@Override 
	public Map<String, Object> insertOneBoard(Map<String, Object> map) throws Exception { // TODO Auto-generated method stub
		sqlSession.insert("board.insertOneBoard",map);
		return map;
	  }
	
	

	@SuppressWarnings("unchecked")
	@Override 
	public Map<String, Object> selectOneBoard(Map<String, Object> map)throws Exception { // TODO Auto-generated method stub 
		  return (Map<String ,Object>) sqlSession.selectOne("board.selectOneBoard", map); 
	  }
	  
	
	 @Override
	public Map<String, Object> insertOneBoardModify(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("board.insertOneBoardModify",map); 
		return map;
	}
	 
	 
	@Override
	public void updateOneBoardModifyCancel(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("board.updateOneBoardModifyCancel",map);
	}

	@Override 
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map)throws Exception { // TODO Auto-generated method stub 
		  return sqlSession.selectList("board.selectBoardList", map); 
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	public Map<String, Object> selectBoardDetail(Map<String, Object>map) throws Exception { // TODO Auto-generated method stub 
		  return (Map<String, Object>) sqlSession.selectOne("board.selectBoardDetail", map); 
	}
	  
	@Override 
	public List<Map<String, Object>> selectHostBoardList(Map<String, Object>map) throws Exception { 
		// TODO Auto-generated method stub 
		return sqlSession.selectList("board.selectHostBoardList", map); 
	}
	  
	@Override 
	public void updateHostBoardConfirm(Map<String, Object> map) throws Exception { // TODO Auto-generated method stub
		sqlSession.update("board.updateHostBoardConfirm",map); 
	}
	  
	@Override 
	public void updateHostBoardDeny(Map<String, Object> map) throws
		Exception { // TODO Auto-generated method stub
		  sqlSession.update("board.updateHostBoardDeny",map); 
	}
  
  
}
 