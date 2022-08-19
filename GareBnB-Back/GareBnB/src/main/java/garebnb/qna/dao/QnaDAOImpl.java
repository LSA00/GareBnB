package garebnb.qna.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("qnaDAO")
public class QnaDAOImpl implements QnaDAO{
	
	protected Log log = LogFactory.getLog(QnaDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:  " + queryId);
		}
	}

	 @SuppressWarnings("unchecked")
	 @Override
	 public List<Map<String, Object>> selectOneQnaList(Map<String, Object> map) throws Exception { 
		 return sqlSession.selectList("qna.selectOneQnaList", map); 
		 }//selectList
	 
	 @Override
	 public void insertOneQna(Map<String, Object> map) throws Exception{
		 sqlSession.insert("qna.insertOneQna", map);
		}

	@Override
	public void deleteQna(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("qna.deleteQna", map);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,Object>> selectQNAList(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("qna.selectQNAList", map);
	}

	@Override
	public Map<String, Object> selectAdminOneQNA(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("qna.selectAdminOneQNA", map);
		//return Map<String, Object> sqlSession.selectOne("qna.selectAdminOneQNA",map);
	}

	@Override
	public void updateQNAComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("qna.updateQNAComment", map);
	}

	@Override
	public Map<String, Object> selectDetailQna(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("qna.selectDetailQna", map);
	}
}
