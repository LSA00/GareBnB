package garebnb.review.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reviewDAO")
public class ReviewDAOImpl implements ReviewDAO{

	protected Log log = LogFactory.getLog(ReviewDAO.class);

    @Autowired
    private SqlSessionTemplate sqlSession;

    protected void printQueryId(String queryId) {
        if(log.isDebugEnabled()) {
            log.debug("\t QueryId \t:  " + queryId);
        }
    }
    
    
    
	
    @SuppressWarnings("unchecked")
    @Override
	public Map<String, Object> selectmyReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
    	return (Map<String , Object>) sqlSession.selectOne("review.selectmyReview", map);
	}




    @SuppressWarnings("unchecked")
	@Override
	public void insertReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("review.insertReview",map);
	}




    @SuppressWarnings("unchecked")
	@Override
	public void deleteReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("review.deleteReview",map);
	}


    @SuppressWarnings("unchecked")
    @Override
	public void updatemyReview(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("review.updatemyReview",map);
	}




	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("review.selectReviewList", map);
	}


}
