package com.finalproject.itda.controller;

import java.util.HashMap;
import java.util.Map;

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
		board_CallService.boardCallBack(vo);
		return board_CallService.boardCount(vo);
	}
	
	// ���ƿ��ߴ� �Խñ����� Ȯ��
	@RequestMapping("/goodHitCheck")
	@ResponseBody
	public Map<String, Board_CallVO> goodHitCheck(Board_CallVO vo) {
		Map<String,Board_CallVO> map = new HashMap<String,Board_CallVO>();
		map.put("vo", board_CallService.reprint(vo));
		vo.setB_goodhit(board_CallService.goodHitCheck(vo));
		map.put("check", vo);
		return map;
	}
	
	// ���ƿ� �ϱ�
	@RequestMapping("/goodHit")
	@ResponseBody
	public Board_CallVO goodHit(Board_CallVO vo) {
		board_CallService.goodHit(vo);
		board_CallService.goodHitCount(vo);
		return board_CallService.reprint(vo);
	}
	
	// ���ƿ� öȸ
	@RequestMapping("/goodHitBack")
	@ResponseBody
	public Board_CallVO goodHitBack(Board_CallVO vo) {
		board_CallService.goodHitBack(vo);
		board_CallService.goodHitCount(vo);
		return board_CallService.reprint(vo);
	}
	
	
	
	
	
	
	
	
	
	
}
