package com.finalproject.itda.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.finalproject.itda.service.RecommendService;
import com.finalproject.itda.vo.RecommendPagingVO;
import com.finalproject.itda.vo.RecommendVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RecommendController {
	
	private final RecommendService recommendService;
	
	// 추천게시판 리스트
	@RequestMapping(value="/recommendList", method = RequestMethod.GET)
	public ModelAndView recommendList(RecommendVO vo) {
		ModelAndView mav = new ModelAndView();
		RecommendPagingVO pVo = new RecommendPagingVO();
		mav.addObject("pVo", recommendService.page(pVo));
		mav.addObject("list", recommendService.recommendList(pVo));
		mav.setViewName("/recommend/recommendList");
		return mav;
	}
	
	@RequestMapping(value="/recommendListTagSearch", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tagSearch(RecommendPagingVO pVo){
		Map<String, Object> map = new HashMap<String, Object>();
		RecommendPagingVO ppVo = recommendService.page(pVo);
		ppVo.setNowPage(pVo.getNowPage());
		map.put("pVo", ppVo);
		map.put("vo", recommendService.recommendList(pVo));
		return map;
	}

	@RequestMapping(value="/recommendWrite")
	public String recommendWrite() {
		return "/recommend/recommendWrite";
	}
	
	@RequestMapping(value="/recommendWriteOk", method = RequestMethod.POST)
	public ModelAndView recommendWriteOk(RecommendVO vo, HttpServletRequest req) throws Exception {
	    
	    ModelAndView mav = new ModelAndView();
    	
		
    	String contextPath = req.getSession().getServletContext().getRealPath("/img");
    	String[] pathSplit = contextPath.split("\\\\");
    	for(int i=0; i < pathSplit.length; i ++) {
    		System.out.println("split "+ i +" 번째 = "+pathSplit[i]);
    	}
    	
    	String path =  pathSplit[0] + "/" + pathSplit[1] + "/itda/src/main/webapp/upload";
    	System.out.println(path);
		// 파일업로드를 위해서는 HttpServletRequest객체를 이용하여 MultipartHttpServletRequest객체를 구하여야 한다.
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)req;
		// mr에서 MultipartFile객체를 얻어와야 한다.
		List<MultipartFile> files = mr.getFiles("input-file");
		// 업로드한 파일이 있으면
		List<String> fileList = new ArrayList<String>(); // 업로드된 파일명들을 저장할 곳
		System.out.println("recommendWriteOk 들어옴");
		if(files != null) {
			System.out.println("recommendWriteOk if 문 들어옴");
			// 업로드 구현
			System.out.println("files.size = " + files.size());
			for(int i=0; i<files.size(); i++) {
				// 업로드 할 MultipartFile 객체를 얻어온다.
				MultipartFile mf = files.get(i);
				// 원래 파일명
				String fname = mf.getOriginalFilename(); // ccc.jpg
				System.out.println("fname=" + fname);
				if(fname!=null && !fname.equals("")) {
					System.out.println("두번째 if문 들어옴");
					// 같은 파일명이 서버에 있는지 확인
					File fileObj = new File(path, fname);
					File newFileObj = new File(path, fname);
					if(fileObj.exists()) { // 파일존재여부 확인 --> boolean
						System.out.println("세번째 if문 들어옴");
						for(int num=1; ;num++) {
							// 파일명 변경
							int point = fname.lastIndexOf(".");
							String orgFileName = fname.substring(0, point);
							String orgFileExt = fname.substring(point+1);
							String newFileName = orgFileName + "(" + num + ")." + orgFileExt; // ex) ccc(1).jpg
							newFileObj = new File(path, newFileName);
							if(!newFileObj.exists()) {
								break;
							}
						} // for
					} // if
					// 업로드 실행
					System.out.println("업로드 실행?!");
					try {
						mf.transferTo(newFileObj);
					} catch (Exception e) {
						e.printStackTrace();
					}
					fileList.add(newFileObj.getName());
				} // for
			} // if
		}
		
		String[] image = vo.getB_content().split("<img");
		String[] imageSplit = image[1].split("width");
		String thumbnail = "<img" + imageSplit[0] + "width: 120px;\" ";
		vo.setThumbImg(thumbnail);
		int cnt = recommendService.recommendWriteOk(vo);
		
		if(cnt>0) {
			mav.setViewName("redirect:recommendList");
		}else {
			mav.setViewName("redirect:recommendWrite");
		}
		mav.setViewName("redirect:recommendList");
		
		return mav;
	}
	
	@RequestMapping(value="recommendView")
	public ModelAndView recommentView(int board_seq) {
		ModelAndView mav = new ModelAndView();
		int cnt = recommendService.countHit(board_seq);
		mav.addObject("vo", recommendService.recommendView(board_seq));
		mav.setViewName("recommend/recommendView");
		return mav;
	}
	
}
