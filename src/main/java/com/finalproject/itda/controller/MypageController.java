package com.finalproject.itda.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.MypageService;
import com.finalproject.itda.vo.BoardVO;
import com.finalproject.itda.vo.MemberBaseVO;

import com.finalproject.itda.vo.QuestionVO;


@Controller
public class MypageController {
   @Inject
   MypageService mypageService;
   
   
   @RequestMapping(value="/mypage")
   public String mypage() {
      return "mypage/mypage00Intro";
   }
   
   //내정보수정
   @RequestMapping(value="/editMyInfo", method=RequestMethod.POST)
   @ResponseBody 
   public MemberBaseVO editMyInfo(MemberBaseVO vo) {
      MemberBaseVO resultVo = mypageService.MyMemberView(vo);
      return resultVo;
   }
    //순찬 수정
    @RequestMapping(value="/editMyInfoUpdate", method=RequestMethod.POST)
   public ModelAndView editMyInfoUpdate(MemberBaseVO vo) {
       ModelAndView mav = new ModelAndView(); 
       System.out.println("갓현태 위대함 짱짱짱맨 이어폰 안가져와도 집가는대 20분도 안걸리면서 참으세열~~~~~"); 
       System.out.println(":"+vo.getM_email()+":"+vo.getM_addr()+":"+vo.getM_addrdetail()+":"+vo.getM_info()+":"+vo.getM_tag()+":"+vo.getM_seq());
       int cnt=0;
       cnt =mypageService.editMyInfoUpdate(vo);
       System.out.println(cnt);
       
        mav.setViewName("redirect:mypage"); 
       
     return mav; 
     }
  //순찬 수정
   
	//내가 쓴 글--------------------------------------------------------------------------------------
	@RequestMapping(value="/mypagePostList")
	public ModelAndView myPostList(BoardVO vo, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		int m_seq=Integer.parseInt(ses.getAttribute("logseq").toString());
		List<BoardVO> result = mypageService.mypagePostList(m_seq);
		mav.addObject("list", result);
		mav.setViewName("mypage/mypage01Post");
		return mav;
	}
	//내가 쓴 댓글--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageReplyList")
	public ModelAndView mypageReplyList(MemberBaseVO vo, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		vo.setM_seq((Integer)ses.getAttribute("logseq")); 
		
		mav.addObject("replyList", mypageService.mypageReplyList(vo));
		mav.setViewName("mypage/mypage02Reply");
		return mav;
	}
	//매칭--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageMatching")
	public String mypageMatching(Model model, HttpSession ses) {
		int m_seq = Integer.parseInt(ses.getAttribute("logseq").toString());
		model.addAttribute("matchingList",mypageService.myMatchingList(m_seq));

		return "mypage/mypage03Matching";
	}
	
//	//북마크--------------------------------------------------------------------------------------------
//	@RequestMapping(value="/mypageBookmark")
//	public String mypageBookmark() {
//		return "mypage/mypage04Bookmark";
//	}
	//구독--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageSubscribe")
	public ModelAndView mypageSubscribe(HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		int m_seq = Integer.parseInt(ses.getAttribute("logseq").toString());
		
		mav.addObject("subList", mypageService.mypageSubscribeList(m_seq));
		mav.setViewName("mypage/mypage05Subscribe");
		return mav;
	}
	
	//구독취소
	@RequestMapping(value="/cancleSubscribe")
	public ModelAndView cancleSubscribe(String m_nickname, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		System.out.println("서비스 잘들어옴 확인");
		int m_seq = Integer.parseInt(ses.getAttribute("logseq").toString());
		System.out.println(m_nickname);
		System.out.println(m_seq);
		
		
		int cnt = mypageService.cancleSubscribe(m_seq, m_nickname);
		if(cnt>0) {//구독 취소 성고오오오오옹~~~~~
			mav.setViewName("redirect:mypageSubscribe");
		}else {//구취실패 ㅠㅠ
			mav.addObject("m_seq", m_seq);
			mav.setViewName("redirect:mypageSubscribe");
		}
		return mav;
	}
	
//	//차단--------------------------------------------------------------------------------------------
//	@RequestMapping(value="/mypageCutout")
//	public String mypageCutout() {
//		return "mypage/mypage06Cutout";
//	}
	//1:1문의--------------------------------------------------------------------------------------------
	
	
	@RequestMapping("/mypageQnA")
	public String mypageQnA(Model model,HttpSession session){
		int seq=Integer.parseInt(session.getAttribute("logseq").toString());
		
		model.addAttribute("list", mypageService.MypageQnaList(seq));
		return "mypage/mypage07Question";
	}
	
	
	//1:1문의 글등록
	@RequestMapping(value="/askSomething", method=RequestMethod.POST)
	public ModelAndView AskSomething(QuestionVO quesVo, HttpSession ses) {
		ModelAndView mav = new ModelAndView();
		Integer logseq = (Integer)ses.getAttribute("logseq");
		quesVo.setM_seq(logseq);
		int cnt = mypageService.QuestionInsert(quesVo);
		if(cnt>0) {//글등록함!!!
			mav.setViewName("redirect:mypageQnA");
		}else {//글왜등록안됐담.... ㅠㅠ
			mav.setViewName("redirect:mypage");
		}
		return mav;
	}
	
	//쪽지함--------------------------------------------------------------------------------------------
	@RequestMapping(value="/mypageMsg")
	public String mypageMsg() {
		return "mypage/mypage08Message";
	}
}
