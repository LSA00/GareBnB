package garebnb.reservation.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("ReservationDAO")
public class ReservationDAOImpl implements ReservationDAO{
	
	protected Log log = LogFactory.getLog(ReservationDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()) {
			log.debug("\t QueryId \t:  " + queryId);
		}
	}
	
	
	
	
	//클라이언트 예약 취소
	@Override
	public void updateResCancel(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("reservation.updateResCancel", map);
	}




	//클라이언트 예약확정
	@Override
	public void updateResConfirm(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("reservation.updateResConfirm", map);
	}





	//클라이언트가 보는 예약내역조회
	@Override
	public List<Map<String, Object>> selectMemReserveList(Map<String, Object> map) throws Exception {
	        // TODO Auto-generated method stub
		 return sqlSession.selectList("reservation.selectMemReserveList", map);
	}
	 
	//클라이언트가 보는 이용내역
	@Override
	public List<Map<String, Object>> selectOneResComList(Map<String, Object> map) throws Exception {
	        // TODO Auto-generated method stub
		 return sqlSession.selectList("reservation.selectOneResComList", map);
	}
	 
	 //호스트가 보는 예약내역조회
	 @Override
	public List<Map<String, Object>> selectReserve(Map<String, Object> map) throws Exception {
	        // TODO Auto-generated method stub
		 return sqlSession.selectList("reservation.selectReserve", map);
	}
	 
	
	//호스트가 보는 이용내역
	@Override
	public List<Map<String, Object>> selectResFinish(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("reservation.selectResFinish", map);
	}




	//호스트가 예약승인
	@Override
	public void updateResApprove(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("reservation.updateResApprove", map);
	}

	//예약거절사유 입력
	@Override
	public void updateResReject(Map<String, Object> map) throws Exception{
		sqlSession.update("reservation.updateResReject", map);
	}
	 
	//상세페이지에서 예약요청
	public void insertOneReserve(Map<String, Object> map) throws Exception{
		sqlSession.insert("reservation.insertOneReserve", map);
	}
	 
	//예약요청전 상세보기
	@Override
	public Map<String, Object> selectReserveDetail(Map<String, Object> map) throws Exception {
	        // TODO Auto-generated method stub
		return sqlSession.selectOne("reservation.selectReserveDetail", map);
	}



	 //결제_예약완료 상태로 변경
	@Override
	public void updateResCompl(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("reservation.updateResCompl", map);
	}



	//결제 정보 입력
	@Override
	public void insertPayInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert("reservation.insertPayInfo", map);
	}



	//모든 예약 리스트 출력
	@Override
	public List<Map<String, Object>> selectAllresList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("reservation.selectAllresList",map);
	}



	//하나의 예약 정보 출력
	@Override
	public Map<String, Object> selectresInfo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("reservation.selectresInfo",map);
	}


	@Override
	public List<Map<String, Object>> selectBoardReserve(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("reservation.selectBoardReserve",map);
	}

}
