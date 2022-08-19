package garebnb.reservation.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("reservationService")
public interface ReservationService {

	void updateResCancel(Map<String, Object> map);

	void updateResConfirm(Map<String, Object> map);
	
	List<Map<String, Object>> selectMemReserveList(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectOneResComList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectReserve(Map<String, Object> map) throws Exception;

	void updateResApprove(Map<String, Object> map) throws Exception;
	
	void updateResReject(Map<String, Object> map) throws Exception;

	void insertOneReserve(Map<String, Object> map) throws Exception;

	Map<String, Object> selectReserveDetail(Map<String, Object> map) throws Exception;

	void resPay(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectResFinish(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectAllresList(Map<String, Object> map) throws Exception;	//전체 예약 리스트

	Map<String, Object> selectresInfo(Map<String, Object> map) throws Exception;	//하나의 예약 정보
	
	List<Map<String,Object>> selectBoardReserve(Map<String,Object> map) throws Exception;

}
