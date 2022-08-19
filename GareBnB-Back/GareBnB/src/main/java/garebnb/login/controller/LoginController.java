package garebnb.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import garebnb.common.common.CommandMap;
import garebnb.jwt.service.JwtService;
import garebnb.login.service.LoginService;

@Controller
public class LoginController {
	
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="loginService")
	private LoginService loginService;
	
	@Resource(name="jwtService")
	private JwtService jwtService;
	
	
	@ResponseBody
    @RequestMapping(value={"/login/findId"}) // 아이디 찾기, 아이디 찾기 결과  
    public Map<String, Object> selectOneId(CommandMap commandMap) throws Exception{
        return loginService.selectOneId(commandMap.getMap());

    }
	
	@ResponseBody
    @RequestMapping(value={"/login/findPwOK"}) // 아이디 찾기, 아이디 찾기 결과  
    public Map<String, Object> selectOnePw(CommandMap commandMap) throws Exception{
        return loginService.selectOnePw(commandMap.getMap());

    }
	
	@ResponseBody
	@RequestMapping(value= "/login/findPw") // 회원정보 수정 
	public void updateOneMember(CommandMap commandMap) throws Exception {
    	loginService.updateOnePw(commandMap.getMap());
	}
	
	@ResponseBody
    @RequestMapping(value={"/login/login"}) // 로그인 
    public Map<String,Object> selectId(CommandMap commandMap) throws Exception{
        String inputPassword = (String)commandMap.getMap().get("MEM_PW");
        Map<String, Object> sqlMap = loginService.selectId(commandMap.getMap());
        if(sqlMap == null) {
        	return null;
        } else {
			String realPassword = (String)sqlMap.get("MEM_PW");
	        if(inputPassword.equals(realPassword)) {
	        	Map<String ,Object> returnMap = new HashMap<String,Object>();

	        	String JWT = jwtService.generateJwtToken(sqlMap);
	    		System.out.println("jwt return pass");

	        	String memberId = (String)sqlMap.get("MEM_ID");
	    		System.out.println("id check pass");

	        	
	        	returnMap.put("MEM_ID", memberId);
	    		System.out.println("put MEM_ID pass");

	        	returnMap.put("JWT", JWT);
	    		System.out.println("put generate pass");

				return returnMap;
	        } 
	        else 
	        	return null;
        }
    }
	
	@ResponseBody
    @RequestMapping(value={"/Auth"}) // 인증 
    public Map<String, Object> selectAuth(CommandMap commandMap) throws Exception{
		
		String memIdx = jwtService.getMemIdx((String)commandMap.get("JWT"));
		String memLevel = jwtService.getMemLevel((String)commandMap.get("JWT"));
		String memId = jwtService.getMemId((String)commandMap.get("JWT"));		
		 
		if(Integer.parseInt(memLevel) <= Integer.parseInt((String)commandMap.get("BOARD_LEVEL"))) {
			
			Map<String, Object> returnMap = new HashMap<String,Object>();
			returnMap.put("MEM_IDX", memIdx);
			returnMap.put("MEM_ID", memId);
			returnMap.put("MEM_LEVEL", memLevel);
			return returnMap;
		} else {
			return null;
		}
		
    }
	
	@ResponseBody
    @RequestMapping(value={"/login/IDCheck"}) // ID중복체크
    public Map<String, Object> selectIDCheck(CommandMap commandMap) throws Exception{
		String inputID = (String)commandMap.getMap().get("MEM_ID");
		if(loginService.selectIDCheck(commandMap.getMap()) == null) {
        	return null;
        } else {
			String realID = (String)loginService.selectIDCheck(commandMap.getMap()).get("MEM_ID");
	        if(inputID.equals(realID)) {
				return loginService.selectIDCheck(commandMap.getMap());
	        } 
	        else 
	        	return null;
        }

    }
	

	

}
