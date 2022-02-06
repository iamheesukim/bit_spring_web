package com.bitcamp.myapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	//여러개 파일을 업로드 할 경우(name이 같을 경우)

	@RequestMapping(value="/dataUpload",method=RequestMethod.POST)
	   public ModelAndView fileUploadTest(DataVO vo,HttpServletRequest req) {
	      //vo->작성자,제목
	      
	      //업로드 위치
	      String path = req.getSession().getServletContext().getRealPath("/upload");
	      
	      //파일업로드를 위해서는 HttpServletRequest객체를 이용하여 MultipartHttpServletRequest 객체를 구하여야 한다.
	      MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
	      
	      //mr에서 MultipartFile객체를 얻어와야 한다.
	      List<MultipartFile> files = mr.getFiles("filename");
	      List<String> fileList = new ArrayList<String>();//업로드된 파일명을 저장할 곳
	      //업로드한 파일이 있으면
	      if(files!=null) {
	         //업로드 구현
	         
	         for(int i=0;i<files.size();i++) {
	            //업로드할 MultipartFile객체를 얻어온다
	            MultipartFile mf = files.get(i);
	            //원래 파일명
	            String fname = mf.getOriginalFilename();
	            if(fname!=null && !fname.equals("")) {
	            //같은파일명이 서버에 있는지 확인
	            File fileObj = new File(path,fname);
	            File newFileObj = new File(path,fname);
	            //파일존재여부확인
	            if(fileObj.exists()) {//있으면 트루,없으면 폴스\
	            	for(int num=1; ;num++) {
	               //파일이 있으면->파일명 변경
	               int point = fname.lastIndexOf(".");//마지막 점의 위치를 구해라
	               String orgFileName = fname.substring(0,point);//파일명(인덱스0부터 .앞까지) file1
	               String orgFileExt = fname.substring(point+1);//확장자명(.다음부터 끝까지)    jpg
	               String newFileName = orgFileName+"("+num+")."+orgFileExt; //ccc(1).jpg
	               newFileObj = new File(path,newFileName);
	               if(!newFileObj.exists()) {
	                     break;
	                  }
	               }//for AAA
	               
	            }//if BBB
	               try {
	            	   mf.transferTo(newFileObj);
	               }catch(Exception e) {}
	               fileList.add(newFileObj.getName());
	            }//for문 안에 if문끝
	         }//for문끝
	      }//if문 끝
	      vo.setFileList(fileList);
	      
	      ModelAndView mav = new ModelAndView();
	      mav.addObject("vo",vo);
	      mav.setViewName("result");
	      return mav;
	   
	}
}