package garebnb.login.loginDAO;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import garebnb.qna.dao.QnaDAO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	
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
	public Map<String, Object> selectOneId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectOne("login.selectOneId", map); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectOnePw(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectOne("login.selectOnePw", map); 
	}
	
	@Override
	public void updateOnePw(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("login.updateOnePw", map);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectId(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectOne("login.selectId", map); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectAuth(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectOne("login.selectAuth", map); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectIDCheck(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return (Map<String, Object>) sqlSession.selectOne("login.selectIDCheck", map); 
	}

}
