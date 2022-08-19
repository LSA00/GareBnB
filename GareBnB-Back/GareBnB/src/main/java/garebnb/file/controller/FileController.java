package garebnb.file.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import garebnb.common.common.CommandMap;
import garebnb.file.service.FileService;

@Controller
public class FileController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="fileService")
	private FileService  fileService;
	
	@ResponseBody
	@RequestMapping(value="/file/selectFiles.do")
	public List<Map<String,Object>> selectFiles(CommandMap commandMap) throws Exception{
		List<Map<String, Object>> list = fileService.selectFiles(commandMap.getMap());
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		
		for(int i = 0; i<list.size(); i++) {
			Map<String,Object> returnMap = new HashMap<String, Object>();
			Map<String,Object> map = list.get(i);
			String storedFileName = (String)map.get("FILE_STDNAME");
			String File_Level = (String)map.get("FILE_LEVEL");
			String File_Num = (String)map.get("FILE_NUM");
			String File_Name = (String)map.get("FILE_ORGNAME");
			
			byte fileByte[] = FileUtils.readFileToByteArray(new File("/Users/jinkim/Documents/upload/"+storedFileName));
			returnMap.put("FILE_LEVEL",File_Level);
			returnMap.put("URL", fileByte);
			returnMap.put("FILE_NUM",File_Num);
			returnMap.put("FILE_NAME", File_Name);
			returnList.add(returnMap);
			
		}
		return returnList;
	}
	
	@ResponseBody
	@RequestMapping(value="/file/selectOneFile.do")
	public List<Map<String,Object>> selectOneFile(CommandMap commandMap) throws Exception{
		Map<String,Object> file = fileService.selectOneFile(commandMap.getMap());
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> info = new HashMap<String,Object>();
		if(file == null) {
			info.put("FILE_BOARD_IDX", "파일이 존재하지 않습니다.");
			info.put("URL","파일이 존재하지 않습니다.");
			list.add(info);
		} else {
		String storedFileName = (String)file.get("FILE_STDNAME");
		byte fileByte[] = FileUtils.readFileToByteArray(new File("/Users/jinkim/Documents/upload/"+storedFileName));
		info.put("FILE_BOARD_IDX", file.get("FILE_BOARD_IDX"));
		info.put("URL",fileByte);
		list.add(info);
		}
		return list;
	}

	@ResponseBody
	@RequestMapping(value="/file/update.do")
	public void updateFile(CommandMap commandMap, HttpServletRequest request) throws Exception{
		fileService.updateFile(commandMap.getMap(),request);
	}
	@ResponseBody
	@RequestMapping(value="/file/delete.do")
	public void deleteFile(CommandMap commandMap) throws Exception{
		fileService.deleteFile(commandMap.getMap());
	}
	@ResponseBody
	@RequestMapping(value="/file/insert.do")
	public String insertFile(CommandMap commandMap, HttpServletRequest request) throws Exception{
		fileService.insertFile(commandMap.getMap(), request);
		return "업로드 성공";
	}
}
