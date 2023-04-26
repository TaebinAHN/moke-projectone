package moke.mokeprojectone.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import moke.mokeprojectone.service.BoardService;
import moke.mokeprojectone.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    BoardService boardService;


    @RequestMapping("/boardList")
    public ModelAndView boardlist(BoardVo boardVo) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<BoardVo> list = boardService.selectBoardList(boardVo);
        mv.addObject("list", list);
        mv.setViewName("boardList");
        mv.addObject("reponse", "boardList");

        return mv;
    }


    @RequestMapping("/boardWrite")		//게시글 작성 화면 호출
    public String boardWrite() throws Exception{
        return "/boardWrite";
    }

    @RequestMapping("/insertBoard")		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insertBoard(@ModelAttribute BoardVo boardVo) throws Exception{

        boardService.insertBoard(boardVo);

        return "redirect:/boardList";	//게시글 리스트로 이동
    }

}
