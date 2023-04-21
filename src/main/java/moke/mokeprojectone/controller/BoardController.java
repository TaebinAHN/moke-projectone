package moke.mokeprojectone.controller;

import java.util.List;

import moke.mokeprojectone.service.BoardService;
import moke.mokeprojectone.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller // 컨트롤러라고 선언함
public class BoardController {

    @Autowired
    BoardService boardService; //서비스와 연결

    @RequestMapping("/boardList") //노테이션의 값으로 주소 지정
    public ModelAndView boardlist(BoardVo boardVo) throws Exception{
        //templates 폴더 아래있는 /boardList.html을 의미함. Thymeleaf와 같은 템플릿엔진을 사용할 경우 스프링 부트의 자동 설정 기능으로 '.html'과 같은 접미사 생략 가능
        ModelAndView mv = new ModelAndView();
        //게시글 목록을 조회하기 위해 ServiceImpl 클래스의 selectBoardList 메서드 호출
        List<BoardVo> list = boardService.selectBoardList(boardVo);
        mv.addObject("list", list);
        mv.setViewName("boardList");
        mv.addObject("reponse", "boardList");

        return mv;
    }

    /*@PostMapping("/boardList")
    public String selectBoardList(BoardVo boardVo) throws Exception {
        boardService.selectBoardList(boardVo);
        return "redirect:/boardList";
    }*/

}
