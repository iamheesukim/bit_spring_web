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
	//������ ������ ���ε� �� ���(name�� ���� ���)

	@RequestMapping(value="/dataUpload",method=RequestMethod.POST)
	   public ModelAndView fileUploadTest(DataVO vo,HttpServletRequest req) {
	      //vo->�ۼ���,����
	      
	      //���ε� ��ġ
	      String path = req.getSession().getServletContext().getRealPath("/upload");
	      
	      //���Ͼ��ε带 ���ؼ��� HttpServletRequest��ü�� �̿��Ͽ� MultipartHttpServletRequest ��ü�� ���Ͽ��� �Ѵ�.
	      MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
	      
	      //mr���� MultipartFile��ü�� ���;� �Ѵ�.
	      List<MultipartFile> files = mr.getFiles("filename");
	      List<String> fileList = new ArrayList<String>();//���ε�� ���ϸ��� ������ ��
	      //���ε��� ������ ������
	      if(files!=null) {
	         //���ε� ����
	         
	         for(int i=0;i<files.size();i++) {
	            //���ε��� MultipartFile��ü�� ���´�
	            MultipartFile mf = files.get(i);
	            //���� ���ϸ�
	            String fname = mf.getOriginalFilename();
	            if(fname!=null && !fname.equals("")) {
	            //�������ϸ��� ������ �ִ��� Ȯ��
	            File fileObj = new File(path,fname);
	            File newFileObj = new File(path,fname);
	            //�������翩��Ȯ��
	            if(fileObj.exists()) {//������ Ʈ��,������ ����\
	            	for(int num=1; ;num++) {
	               //������ ������->���ϸ� ����
	               int point = fname.lastIndexOf(".");//������ ���� ��ġ�� ���ض�
	               String orgFileName = fname.substring(0,point);//���ϸ�(�ε���0���� .�ձ���) file1
	               String orgFileExt = fname.substring(point+1);//Ȯ���ڸ�(.�������� ������)    jpg
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
	            }//for�� �ȿ� if����
	         }//for����
	      }//if�� ��
	      vo.setFileList(fileList);
	      
	      ModelAndView mav = new ModelAndView();
	      mav.addObject("vo",vo);
	      mav.setViewName("result");
	      return mav;
	   
	}
}