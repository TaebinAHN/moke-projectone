package moke.mokeprojectone.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import moke.mokeprojectone.service.BoardService;
import moke.mokeprojectone.vo.BoardVo;
import moke.mokeprojectone.vo.CriteriaVo;
import moke.mokeprojectone.vo.PageVo;
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
    public ModelAndView boardlist(@ModelAttribute("criteriaVo") final CriteriaVo criteriaVo) throws Exception{

        ModelAndView mv = new ModelAndView();
        List<BoardVo> list = boardService.selectBoardList(criteriaVo);
        // System.out.println(boardVo);
        mv.addObject("list", list);

        /* 페이지 이동 인터페이스 데이터 */
        int total = boardService.authorGetTotal(criteriaVo);

        PageVo pageMaker = new PageVo(criteriaVo, total);

        mv.addObject("pageMaker", pageMaker);
        
        mv.setViewName("boardList");
        mv.addObject("reponse", "boardList");

        return mv;
    }

    /* @RequestMapping("/boardList")
    public String openPostList(@ModelAttribute("params") final BoardVo params, Model model) {

        List<BoardVo> posts = boardService.findAllPost(params);
        model.addAttribute("posts", posts);
        return "/boardList";
    } */


    @RequestMapping("/boardWrite")		//게시글 작성 화면 호출
    public String boardWrite() throws Exception{
        return "/boardWrite";
    }

    @RequestMapping("/insertBoard")		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insertBoard(@ModelAttribute BoardVo boardVo) throws Exception{

        boardService.insertBoard(boardVo);

        return "redirect:/boardList";	//게시글 리스트로 이동
    }

    /* @RequestMapping("/boardRead")
    public String boardRead(BoardVo boardVo) throws Exception {

        boardVo.addAttribute("cnt",service.boardCount());

    } */

}
