package garebnb.review.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("reviewService")
public interface ReviewService {

	Map<String,Object> selectmyReview(Map<String,Object>map) throws Exception;
	void insertReview(Map<String,Object> map) throws Exception;
	void deleteReview(Map<String,Object> map) throws Exception;
	void updatemyReview(Map<String, Object> map) throws Exception;
	List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception;

}
