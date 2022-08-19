
package garebnb.board.dao;
  
import java.util.List;
import java.util.Map;
  
public interface BoardDAO {
  
  //호스트 
	public List<Map<String, Object>> selectOneBoardList (Map<String,Object> map) throws Exception; //호스트-내 게시글리스트 
	public void updateOneBoardDelete(Map<String,Object> map) throws Exception; //호스트-내 게시글 삭제 
	public Map<String, Object> insertOneBoard (Map<String,Object> map) throws Exception; //호스트-게시글 등록 
	public Map<String, Object> selectOneBoard (Map<String,Object> map) throws Exception;//호스트-내 게시글
	public Map<String, Object> insertOneBoardModify (Map<String,Object> map) throws Exception; //호스트-게시글 수정 등록
	public void updateOneBoardModifyCancel (Map<String,Object> map) throws Exception; //게시글 수정 취소
  
  //메인 
	public List<Map<String, Object>> selectBoardList (Map<String,Object> map)throws Exception; //전체 게시글 리스트 
	public Map<String, Object> selectBoardDetail(Map<String,Object> map) throws Exception; //게시글 상세보기
  
	//관리자 
	public List<Map<String, Object>> selectHostBoardList(Map<String,Object> map)throws Exception; //전체 호스트 게시글 리스트 
	public void updateHostBoardConfirm(Map<String,Object> map) throws Exception; //게시글 등록 승인 
	public void updateHostBoardDeny (Map<String,Object> map) throws Exception; //게시글 등록 거절
  
}
 