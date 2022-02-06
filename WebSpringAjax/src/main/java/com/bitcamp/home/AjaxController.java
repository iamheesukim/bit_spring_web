package com.bitcamp.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	@RequestMapping("/ajax")
	public String ajaxStart() {
		return "ajax/ajaxView";
		//ajax 폴더 안에 있는 ajaxView.jsp 실행
	}
	
	//화면전환없이 비동기식으로 불러낼땐 @ResponseBody						한글 깨져서 추가
	@RequestMapping(value="/ajaxStr", method=RequestMethod.GET, produces="application/text;charset=UTF-8")
	@ResponseBody			//ajaxView.jsp의 params
	public String ajaxString(int num, String name) {
		System.out.println("num = "+num +", name = "+name);
		return "<h1>번호="+num+", 이름="+name+"</h1>";
	}
	
	@RequestMapping(value="/ajaxList") //ajax에서 넘기는 url과 이름 일치하게 맵핑
	@ResponseBody
	public List<TestVO> ajaxList(TestVO vo) {//메소드 이름은 주로 맵핑과 일치하게
		List<TestVO> list = new ArrayList<TestVO>();
		list.add(vo);
		
		list.add(new TestVO(200,"ggg","지지지"));
		list.add(new TestVO(300,"ttt","티티티"));
		
		return list;
	}
	
	@RequestMapping(value="/ajaxObject")
	@ResponseBody
	public TestVO ajaxObject() {
		return new TestVO(500, "goguma", "고구마");

	}
	
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public HashMap<String, TestVO> ajaxMap() {
		HashMap<String, TestVO> hm = new HashMap<String, TestVO>();
		hm.put("k1", new TestVO(1000,"sunsin","순신"));
		hm.put("k2", new TestVO(2000,"hong","길동"));
		hm.put("k3", new TestVO(3000,"goguma","고구마"));
		
		return hm;
	}
	
	@RequestMapping(value="/ajaxJson", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxJson() {
		int no = 1234;
		String username = "홍길동";
		String tel = "010-8888-9999";
		String addr = "서울시 마포구 백범로";
		
		//데이터를 문자열로 만든다
		String jsonData = "{\"no\":\""+no+"\",\"username\":\""+username+"\"";
		jsonData += ",\"tel\":\""+tel+"\",\"addr\":\""+addr+"\"}";
		System.out.println(jsonData);
		
		return jsonData;
	}
}
