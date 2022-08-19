package garebnb.login.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service("loginService")
public interface LoginService {
	
	Map<String, Object> selectOneId(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectOnePw(Map<String, Object> map) throws Exception;

	void updateOnePw(Map<String, Object> map) throws Exception;

	Map<String, Object> selectId(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectAuth(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectIDCheck(Map<String, Object> map) throws Exception;
}
