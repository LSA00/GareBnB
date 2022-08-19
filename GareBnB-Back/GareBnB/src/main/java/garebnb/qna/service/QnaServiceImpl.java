package garebnb.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import garebnb.qna.dao.QnaDAO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{ //서비스 인터페이스로 정의된 메서드를 실제로 구현

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="qnaDAO") //서비스에서 DAO 접근
	private QnaDAO qnaDAO;
	
	 @Override
	 public List<Map<String, Object>> selectOneQnaList(Map<String, Object> map) throws Exception {
		 return qnaDAO.selectOneQnaList(map);
	 	}
	 
	 @Override
	 public void insertOneQna(Map<String, Object> map) throws Exception {
		 qnaDAO.insertOneQna(map);
	 	}

	@Override
	public void deleteQna(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.deleteQna(map);
	}

	@Override
	public List<Map<String, Object>> selectQNAList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.selectQNAList(map);
	}

	@Override
	public Map<String, Object> selectAdminOneQNA(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.selectAdminOneQNA(map);
	}

	@Override
	public void updateQNAComment(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		qnaDAO.updateQNAComment(map);
	}

	@Override
	public Map<String, Object> selectDetailQna(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.selectDetailQna(map);
	}

}
