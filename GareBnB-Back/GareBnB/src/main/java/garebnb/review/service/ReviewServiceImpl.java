package garebnb.review.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import garebnb.board.dao.BoardDAO;
import garebnb.review.dao.ReviewDAO;

@Repository("reviewService") 
public class ReviewServiceImpl implements ReviewService{

	Logger log = Logger.getLogger(this.getClass());
	  
	@Resource(name ="reviewDAO") 
	private ReviewDAO reviewDAO;

	@Override
	public Map<String, Object> selectmyReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.selectmyReview(map);
	}

	@Override
	public void insertReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reviewDAO.insertReview(map);
	}

	@Override
	public void deleteReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reviewDAO.deleteReview(map);
	}

	
	@Override
	public void updatemyReview(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		reviewDAO.updatemyReview(map);
	}

	@Override
	public List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return reviewDAO.selectReviewList(map);
	}

	
	
}
