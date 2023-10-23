package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.member.model.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {

//	@RequestMapping(value= "/memberJoin", method= RequestMethod.POST) 
	//METHOD를 써야 post,get등 지정 방식만 허용, 안쓰면 전체 허용
	@GetMapping("/memberJoin")
	public String memJoin() {
		System.out.println("memJoin 에 접근");
		return "member/memJoin";
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.GET)
	public String memLogin(Model model){
	
		return "member/memLogin";
	}
// 1. 전통 방식
//	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
//	public String memLogin(Model model,
//		HttpServletRequest request){
//			
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
//		
//		System.out.println(memId);
//		System.out.println(memPw);
//		return "member/memLogin_ok";
//	}
	
//	2. 파라미터 이용
//	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
//	public String memLogin(Model model,
//			@RequestParam("memId") String memId,
//			@RequestParam("memPw") String memPw
//			) {
//		
//		System.out.println(memId);
//		System.out.println(memPw);
//		return "member/memLogin_ok";
//	}
	
//	3. annotation 이용
//	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
//	public String memLogin(Model model,
////			@RequestParam("memId") String memId,
////			@RequestParam("memPw") String memPw,
////			@RequestParam(value = "memName", required = false, defaultValue="tester")
////			String name
////	4. command 정보 이용해서 부르기
////			vo객체에 동일한 setter가 있으면 자동으로 저장
//			MemberVO mem
//	){
//		System.out.println(mem.getMemId());
//		System.out.println(mem.getMemPw());
//		System.out.println(mem.getName());
//		
//		
//		return "member/memLogin_ok";
//		
//	}
//	
	// 4. Model: 컨트롤러에서 view에 data를 전달하기 위해서 사용되는 객체로 Model과 ModelAndView가 있다.
	//  1. Model은 데이터만 전달
	//  2. ModelAndView 데이터와 뷰의 이름을 함께 전달.
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin(Model model, MemberVO mem){
//		System.out.println(mem.getMemId());
//		System.out.println(mem.getMemPw());
//		System.out.println(mem.getName());
		
		// Model: addttribute("전달 이름", 값);
		model.addAttribute("memId", mem.getMemId());
		model.addAttribute("memPw", mem.getMemPw());
		model.addAttribute("mem", mem);
		
		return "member/memLogin_ok";
		
	}
	
	@RequestMapping(value="/memLoginModelAndView", method= RequestMethod.POST)
	public ModelAndView memPut(Model model, MemberVO memVO) {
		
		// 객체 생성
		ModelAndView mav = new ModelAndView();
		
		// ModelAndView에 값 추가
		mav.addObject("memId", memVO.getMemId());
		mav.addObject("mem", memVO);
		
		// View 설정
		mav.setViewName("member/memLogin_ok");
		
		return mav;
	}
	
	@RequestMapping("/req_ex01")
	public void req_ex01() { //void는 접속 경로의 파일이름을 사용
		// 접속 경로(uri 중 context를 뺀 경로)는? =>member/req_ex01
	}
	
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "member/req_ex02";
	}

	@RequestMapping("/req_ex03")
	public String req_ex03() {
		return "redirect:/member/req_ex01";
	}
	
	@ResponseBody	//메서드의 리턴 값을 viewresolver로 전달x 
					//해당 메서드를 호출한 곳으로 결과를 반환(비동기 통신에서 사용)
	@RequestMapping("/test")
	public String testResponseBody() {
		return "testResponseBody";
	}

	
	
	
}
