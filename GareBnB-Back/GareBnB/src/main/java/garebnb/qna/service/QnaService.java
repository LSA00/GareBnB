package garebnb.qna.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface QnaService { //비즈니스 로직 수행을 위한 메서드만

	//QNA One 리스트
	List<Map<String, Object>> selectOneQnaList(Map<String, Object> map) throws Exception;

	//QNA 입력
	void insertOneQna(Map<String, Object> map) throws Exception;
	
	//QNA 삭제
	void deleteQna(Map<String, Object> map) throws Exception;

	//Admin QNA 전체 리스트
	List<Map<String, Object>> selectQNAList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectAdminOneQNA(Map<String, Object> map) throws Exception;

	void updateQNAComment(Map<String, Object> map) throws Exception;

	//QNA Detail
	Map<String, Object> selectDetailQna(Map<String, Object> map) throws Exception;
	

}