package com.finalproject.itda;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.InjeungService;
import com.finalproject.itda.service.MatchingService;
import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.MatchingPagingVO;
import com.finalproject.itda.vo.RecommendPagingVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RecommendService recommendService;
    private final MatchingService matchingService;
    private final InjeungService injeungService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		MatchingPagingVO mpv = new MatchingPagingVO();
		RecommendPagingVO pVo = new RecommendPagingVO();
		mav.setViewName("/index");
		
		return mav;
	}

}
