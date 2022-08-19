package garebnb.qna.dao;

import java.util.List;
import java.util.Map;

public interface QnaDAO {

	public List<Map<String, Object>> selectOneQnaList(Map<String, Object> map) throws Exception;

	public void insertOneQna(Map<String, Object> map) throws Exception;

	public void deleteQna(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> selectQNAList(Map<String, Object> map) throws Exception; //관리자 리스트 전체

	public Map<String, Object> selectAdminOneQNA(Map<String, Object> map) throws Exception; //관리자 문의 상세

	public void updateQNAComment(Map<String, Object> map)throws Exception; //관리자 문의 답변

	public Map<String, Object> selectDetailQna(Map<String, Object> map) throws Exception;
	

}
