package garebnb.login.loginDAO;

import java.util.Map;

public interface LoginDAO {
	
	public Map<String, Object> selectOneId(Map<String,Object> map) throws Exception; 

	public Map<String, Object> selectOnePw(Map<String,Object> map) throws Exception; 

	
	public void updateOnePw(Map<String,Object> map) throws Exception;

	public Map<String, Object> selectId(Map<String,Object> map) throws Exception;
	
	public Map<String, Object> selectAuth(Map<String,Object> map) throws Exception;
	
	public Map<String, Object> selectIDCheck(Map<String,Object> map) throws Exception;
}
