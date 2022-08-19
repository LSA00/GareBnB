package garebnb.review.dao;

import java.util.List;
import java.util.Map;

public interface ReviewDAO {
	
	public Map<String, Object> selectmyReview (Map<String,Object> map) throws Exception;
	public void insertReview (Map<String,Object> map) throws Exception;
	public void deleteReview (Map<String,Object> map) throws Exception;
	public void updatemyReview(Map<String, Object> map);
	public List<Map<String, Object>> selectReviewList (Map<String,Object> map) throws Exception;

}


