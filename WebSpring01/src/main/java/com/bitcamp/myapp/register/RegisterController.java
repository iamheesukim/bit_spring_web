package com.bitcamp.myapp.register;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // 컨트롤러 객체가 됨 (상속받는 느낌)
public class RegisterController {
	RegisterDAO dao = new RegisterDAO();

	public RegisterController() { // 내가 추가해준 것
		System.out.println("레지스터생성자"); // 서버 연결할 때마다 객체를 생성 (생성자만 실행됨)
	}

	@RequestMapping("/registerForm") // index.do 같은 느낌. 이 이름하고 아래 메서드명하고 맞춰줌 (헷갈릴까 봐ㅎ)
	public String registerForm() {

		return "register/form";
	}

	@RequestMapping("/idCheck")
	public ModelAndView idCheck(String userid) { // 데이터와 뷰파일명을 모두 담는 객체

		int result = dao.idDoubleCheck(userid);

		ModelAndView mav = new ModelAndView(); // 뷰파일에 필요한 데이터, 뷰파일명을 저장하는 객체
		mav.addObject("userid", userid);
		mav.addObject("result", result);
		mav.setViewName("register/idCheck");

		return mav;
	}

	// 우편번호 검색페이지로
	@RequestMapping("/zipSearch")
	public String zipSearch() {

		return "register/zipcodeSearch";
	}

	// 우편번호 검색
	@RequestMapping("/zipFind")
	@ResponseBody
	public List<ZipCodeVO> zipFind(String doro) {
		// List<ZipCodeVO> list = dao.zipSearchRecord(doro);

		return dao.zipSearchRecord(doro);
	}

	// 회원등록
	// POST 방식은 반드시 이렇게 길게 써줘야함 (위에처럼 GET방식은 짧게 해도 됨)
	@RequestMapping(value = "/formOk", method = RequestMethod.POST)
	public String formOk(RegisterVO vo, Model model) { // 매개변수에 vo로 써주면, jsp에서 name이 vo에 있는 멤버변수와 같으면 자동으로 request된다.
														// ip는 불가.
		// 회원등록
		int result = dao.insertRecord(vo);
		// 등록여부, 뷰파일명
		model.addAttribute("result", result);
		return "register/formResult";
	}

	// 로그인폼
	@RequestMapping("/login")
	public String loginForm() {
		return "register/login";
	}

	// 로그인
	@RequestMapping(value = "loginOk", method = RequestMethod.POST)
	public ModelAndView loginOk(HttpServletRequest req, RegisterVO vo) {
		dao.loginSelect(vo);

		ModelAndView mav = new ModelAndView();
		if (vo.getLogStatus() == "Y") { // 로그인 성공 - 로그인폼으로
			System.out.println(vo.getUserid());
			HttpSession session = req.getSession();
			// 이름, 로그인 상태
			session.setAttribute("logname", vo.getUsername());
			session.setAttribute("logid", vo.getUserid());
			session.setAttribute("logStatus", vo.getLogStatus());

			mav.setViewName("redirect:/");
		} else { // 로그인 실패 - 로그인화면으로
			mav.setViewName("redirect:login");
		}
		return mav;
	}

	// 로그아웃
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	// 수정폼
	@RequestMapping("/registerEdit")
	public ModelAndView registerEdit(HttpSession session) {
		RegisterVO vo = new RegisterVO();
		vo.setUserid((String) session.getAttribute("logid"));
		dao.selectRecord(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("register/edit");
		return mav;
	}

	// 회원정보 수정
	@RequestMapping(value = "/editOk", method = RequestMethod.POST)
	public ModelAndView editOk(RegisterVO regVo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		regVo.setUserid((String) session.getAttribute("logid"));
		int result = dao.updateRecord(regVo);

		// 수정실패시 history, 수정성공 : 수정폼으로 이동

		if (result > 0) {// 수정 성공
			mav.setViewName("redirect:registerEdit");

		} else {// 수정 실패
			mav.setViewName("register/editResult");

		}

		return mav;
	}
}
