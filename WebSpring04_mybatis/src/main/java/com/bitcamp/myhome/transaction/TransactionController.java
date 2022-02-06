package com.bitcamp.myhome.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.myhome.board.BoardDAOImp;
import com.bitcamp.myhome.board.BoardVO;

@Controller
public class TransactionController {
   @Autowired
   SqlSession sqlSession;
   
   //transaction ��ü
   @Autowired
   DataSourceTransactionManager transactionManager;
   
   @RequestMapping("/transactionTest")
   @Transactional(rollbackFor= {Exception.class, RuntimeException.class})
   public ModelAndView tran() {
      // transaction ó���� ���� ��ü ����
      DefaultTransactionDefinition def = new DefaultTransactionDefinition();
      def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
      TransactionStatus status = transactionManager.getTransaction(def); 
      //
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("redirect:list");
      BoardDAOImp dao = sqlSession.getMapper(BoardDAOImp.class);
      try {
         //ù��° �߰��� ���ڵ�
         BoardVO vo = new BoardVO();
         vo.setUserid("goguma");
         vo.setSubject("Ʈ����� �׽�Ʈ ��");
         vo.setContent("�� ����");
         vo.setIp("123.123.123.123");
         
         //�ι�° �߰��� ���ڵ�
         BoardVO vo2 = new BoardVO();
         vo2.setUserid("goguma");
         vo2.setSubject("Transaction Test");
         vo2.setContent("�� ����2");
         vo2.setIp("111.222.333.444");
         
         dao.boardWriteOk(vo); //ù��° �߰�
         dao.boardWriteOk(vo2); //�ι�° �߰�
         
         transactionManager.commit(status);
         System.out.println("*");
      }catch(Exception e) {
         e.printStackTrace();
      }
      
      return mav;
   }
}