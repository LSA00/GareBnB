
package garebnb.board.service;
  
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  
import javax.annotation.Resource; 
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import garebnb.board.dao.BoardDAO;
import garebnb.reservation.dao.ReservationDAO;

  
@Repository("boardService") 
public class BoardServiceImpl implements BoardService{ 
	Logger log = Logger.getLogger(this.getClass());
  
	@Resource(name ="boardDAO") 
	private BoardDAO boardDAO;
	
	@Resource(name = "ReservationDAO")
	private ReservationDAO reservationDAO;

	
	@Override
	public List<Map<String, Object>> selectOneBoardList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectOneBoardList(map);
	}

	
	
	@Override
	public void updateOneBoardDelete(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.updateOneBoardDelete(map);
		
	}


	//게시글 등록
	@Override
	public Map<String, Object> insertOneBoard(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.insertOneBoard(map);
	}


	//게시글 수정등록
	@Override
	public Map<String, Object> insertOneBoardModify(Map<String, Object> map) throws Exception {
			// TODO Auto-generated method stub
		return boardDAO.insertOneBoardModify(map);
	}


	//게시글 수정 취소	
	@Override
	public void updateOneBoardModifyCancel(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.updateOneBoardModifyCancel(map);
	}



	@Override
	public Map<String, Object> selectOneBoard(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectOneBoard(map);
	}



	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception  {
		// TODO Auto-generated method stub
		List<Map<String, Object>> boardList = boardDAO.selectBoardList(map);
		
		if(map.get("START_DATE") == null || map.get("START_DATE")=="") {
			System.out.println(map.get("START_DATE"));
			return boardList;
			
		} else {
		
		List<Map<String,Object>> returnList = new ArrayList<Map<String, Object>>();
		long c_start_date =  Long.parseLong((String)map.get("START_DATE"));
		long c_end_date = Long.parseLong((String)map.get("END_DATE"));
		   
		for(int i = 0; i < boardList.size(); i++) {
			int c = 0;
			Map<String,Object> sample = new HashMap<String, Object>();
			sample.put("RES_BOARD_NO", boardList.get(i).get("BOARD_NO"));
		   List<Map<String,Object>> reserve = reservationDAO.selectBoardReserve(sample);
		   
		   for(int j = 0; j<reserve.size(); j++) {
			   
			   java.sql.Timestamp ts1 = (Timestamp) reserve.get(j).get("RES_DATE_START");
			   java.sql.Timestamp ts2 = (Timestamp) reserve.get(j).get("RES_DATE_END");

			   long r_start = ts1.getTime();
			   long r_end = ts2.getTime();
			   
			   if((c_end_date<r_start) ^ (c_start_date<r_end)) {
				   
				   c = 1;
			   }
		   }
		   
		   if( c == 0) {
			   returnList.add(boardList.get(i));
		   }
		}
		return returnList;
		}
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectBoardDetail(map);
	}

	@Override
	public List<Map<String, Object>> selectHostBoardList(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.selectHostBoardList(map);
	}



	@Override
	public void updateHostBoardConfirm(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.updateHostBoardConfirm(map);
	}



	@Override
	public void updateHostBoardDeny(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.updateHostBoardDeny(map);
	}
	
  
	
	
}
 