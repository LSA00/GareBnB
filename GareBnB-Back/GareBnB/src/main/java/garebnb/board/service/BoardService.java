
package garebnb.board.service;
  
import java.util.List;
import java.util.Map;
  

import org.springframework.stereotype.Service;

@Service("boardService")
public interface BoardService {
  
	List<Map<String, Object>> selectOneBoardList(Map<String, Object> map) throws Exception;
	void updateOneBoardDelete(Map<String,Object> map) throws Exception;
	Map<String, Object> insertOneBoard(Map<String,Object> map) throws Exception; 
	Map<String,Object> selectOneBoard(Map<String,Object>map) throws Exception;
	Map<String, Object> insertOneBoardModify(Map<String, Object> map) throws Exception;
	void updateOneBoardModifyCancel(Map<String, Object> map) throws Exception;
	
	
	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception; 
	Map<String,Object> selectBoardDetail(Map<String,Object>map) throws Exception;
	
	
	
	List<Map<String, Object>> selectHostBoardList(Map<String, Object> map) throws Exception; 
	void updateHostBoardConfirm(Map<String, Object> map) throws Exception; 
	void updateHostBoardDeny(Map<String, Object> map) throws Exception; 
	
	
}
 