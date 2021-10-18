package com.finalproject.itda.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.AdminService;
import com.finalproject.itda.vo.MemberVO;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
//어드민 페이지 이동 
	@RequestMapping(value="/admin")
	public String test() {
		return "admin/admin";
	}
	//어드민 페이지 이동 	
	
//유저 inesrt
	@RequestMapping(value = "/MemberInsert")
	public String MemberInsert() {
		return "admin/adminInsert";}

	@RequestMapping(value = "/adminInsertOk", method = RequestMethod.POST)
	public ModelAndView adminInsertOk(MemberVO vo, HttpSession session) {
		int cnt = adminService.MemberInsert(vo);
		ModelAndView mav = new ModelAndView();
		if (cnt > 0) { 
			mav.setViewName("redirect:MemberInsert");
		} else {
			mav.setViewName("redirect:admin");
		}
		return mav;
	}
//

//유저 멤버리스트
	@RequestMapping(value = "/MemberList")
	public String AdminMember(Model model) {
		model.addAttribute("list", adminService.MemberList());
		return "admin/MemberList";
	}
	  //모달에 넘겨줄 데이터 셀렉
	  @RequestMapping(value="/MemberView", method=RequestMethod.POST)
	  @ResponseBody public MemberVO AdminMemberView(MemberVO vo) {
	  System.out.println(vo.getM_seq()); 
	  MemberVO membervo =adminService.MemberView(vo);
	  return membervo; }
//
	  
//유저 업데이트
//	  @RequestMapping(value = "/MemberUpdate",method=RequestMethod.POST)
//	  public ModelAndView Member()
//	  {
//		  
//		  
//	  }
	  
//
//	  
//		@RequestMapping(value="/boardEditOk",method=RequestMethod.POST)
//		public ModelAndView boardEditOk(BoardVO vo,HttpSession session)
//		{
//			vo.setUserid((String)session.getAttribute("login"));
//			   System.out.println(vo.getUserid());
//			int result = boardService.boardUpdate(vo);
//			ModelAndView mav = new ModelAndView();
//			if(result>0)
//			{
//				mav.addObject("no", vo.getNo());
//				mav.setViewName("redirect:boardView");
//			}
//			else
//			{
//				mav.setViewName("board/result");
//			}
//			return mav;
//			
//		}
//		
//	  
	  
//어드민 모든 게시판 
		@RequestMapping(value = "/BoardAllView")
		public String AdminAllBoard(Model model) {
			return "admin/adminboardList";}
		
//어드민 모든 게시판 
		
		
//어드민 모든 게시판 
		@RequestMapping(value="/BoardBlackList")
		public String AdminBlackBoard(Model model) {
			return "admin/adminboardCall";}
//어드민 모든 게시판 
				

}
