package com.finalproject.itda.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finalproject.itda.service.Board_CallService;
import com.finalproject.itda.vo.Board_CallVO;

@Controller
public class Board_CallController {
	@Inject
	Board_CallService board_CallService;
	
	// �Ű��� �Խñ����� Ȯ��
	@RequestMapping(value="/boardCallCheck")
	@ResponseBody
	public int boardCallCheck(Board_CallVO vo) {
		return board_CallService.boardCallCheck(vo);
	}
	
	// �Ű��ϱ�
	@RequestMapping(value="/boardCall", method=RequestMethod.POST)
	@ResponseBody
	public int boardCall(Board_CallVO vo) {
		// ���ο� �Ű� ����
		board_CallService.boardCall(vo);
		// �Ű�� �����ϰ� �ش� �Խñ� �� �Ű�� ���� boardbase�� �־��ִ� ������
		return board_CallService.boardCount(vo);
	}
	
	// �Ű� öȸ
	@RequestMapping(value="/boardCallBack", method=RequestMethod.POST)
	@ResponseBody
	public int boardCallBack(Board_CallVO vo) {
		return board_CallService.boardCallBack(vo);
	}
	
	// ���ƿ��ߴ� �Խñ����� Ȯ��
	@RequestMapping("/goodHitCheck")
	@ResponseBody
	public int goodHitCheck(Board_CallVO vo) {
		return board_CallService.goodHitCheck(vo);
	}
	
	@RequestMapping("/goodHit")
	@ResponseBody
	public int goodHit(Board_CallVO vo) {
		return board_CallService.goodHit(vo);
	}
	
	@RequestMapping("/goodHitBack")
	@ResponseBody
	public int goodHitBack(Board_CallVO vo) {
		return board_CallService.goodHitBack(vo);
	}
	
	
	
	
	
	
	
	
	
	
}
