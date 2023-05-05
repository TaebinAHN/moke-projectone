package moke.mokeprojectone.service;

import lombok.RequiredArgsConstructor;
import moke.mokeprojectone.mapper.BoardMapper;
import moke.mokeprojectone.vo.BoardVo;
import moke.mokeprojectone.vo.CriteriaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    BoardMapper boardMapper;


    @Transactional
    public void openBoardList(BoardVo boardVo){

        boardMapper.selectBoardList();
    }

    public List<BoardVo> selectBoardList(CriteriaVo criteriaVo) throws Exception {


        return boardMapper.selectBoardList(criteriaVo);
    }

    @Transactional
    public int authorGetTotal(CriteriaVo criteriaVo) throws Exception {

        return boardMapper.authorGetTotal(criteriaVo);
    }


    @Transactional
    public void insertBoard(BoardVo boardVo) throws Exception{

        boardMapper.insertBoard(boardVo);
    }

    public List<BoardVo> getBoard(int boardNo) {

        // boardMapper.boardRead(boardNo);
        return boardMapper.boardRead(boardNo);
    }

    /* public List<BoardVo> getBoardUpdate(int boardNo) {

        return boardMapper.boardUpdate(boardNo);
    } */

    public List<BoardVo> getBoardUpdate(int boardNo) {

        return boardMapper.boardUpdate(boardNo);
    }

    public List<BoardVo> boardUpdate_1(int boardNo) {

        return boardMapper.boardUpdate_1(boardNo);
    }


}

