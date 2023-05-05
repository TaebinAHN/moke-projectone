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
        mv.addObject("response", "boardList");

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

    @RequestMapping(value = "/boardRead/{boardNo}", method = RequestMethod.GET)
    public ModelAndView boardRead(@PathVariable("boardNo") int boardNo) {

        System.out.println(boardNo);
        ModelAndView mv = new ModelAndView();
        List<BoardVo> updateList = boardService.getBoard(boardNo);
        BoardVo boardVo = updateList.get(0); // 첫번째 BoardVo 객체 꺼내오기
        // mv.addObject("list", list);

        mv.addObject("boardNo", boardVo.getBoardNo()); // 순번 추가
        mv.addObject("boardRegion", boardVo.getBoardRegion()); // 지역 추가
        mv.addObject("boardInterest", boardVo.getBoardInterest()); // 관심사 추가
        mv.addObject("boardTitle", boardVo.getBoardTitle()); // 제목 추가
        mv.addObject("boardName", boardVo.getBoardName()); // 작성자 추가
        mv.addObject("boardContent", boardVo.getBoardContent()); // 내용 추가

        mv.setViewName("boardRead");

        System.out.println(boardVo.getBoardNo());
        System.out.println(boardVo.getBoardRegion());
        System.out.println(boardVo.getBoardInterest());
        System.out.println(boardVo.getBoardTitle());
        System.out.println(boardVo.getBoardName());
        System.out.println(boardVo.getBoardContent());

        return mv;
    }

    @RequestMapping(value = "/boardUpdate/{boardNo}", method =  {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView boardUpdate(@PathVariable("boardNo") int boardNo) {

        System.out.println(boardNo);
        ModelAndView mv = new ModelAndView();
        List<BoardVo> updateList = boardService.getBoardUpdate(boardNo);
        BoardVo boardVo = updateList.get(0); // 첫번째 BoardVo 객체 꺼내오기

        mv.addObject("boardNo", boardVo.getBoardNo()); // 순번 추가
        mv.addObject("boardRegion", boardVo.getBoardRegion()); // 지역 추가
        mv.addObject("boardInterest", boardVo.getBoardInterest()); // 관심사 추가
        mv.addObject("boardTitle", boardVo.getBoardTitle()); // 제목 추가
        mv.addObject("boardName", boardVo.getBoardName()); // 작성자 추가
        mv.addObject("boardContent", boardVo.getBoardContent()); // 내용 추가

        mv.setViewName("boardUpdate");

        System.out.println(boardVo.getBoardNo());
        System.out.println(boardVo.getBoardRegion());
        System.out.println(boardVo.getBoardInterest());
        System.out.println(boardVo.getBoardTitle());
        System.out.println(boardVo.getBoardName());
        System.out.println(boardVo.getBoardContent());

        return mv;
    }

//    @RequestMapping(value = "/updateBoard", method = RequestMethod.GET)		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
//    public String updateBoard(@ModelAttribute int boardNo) throws Exception{
//
//        boardService.updateBoard(boardNo);
//
//        return "redirect:/updateBoard";	//게시글 리스트로 이동
//    }



}
