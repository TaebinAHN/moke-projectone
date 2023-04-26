package moke.mokeprojectone.service;

import lombok.RequiredArgsConstructor;
import moke.mokeprojectone.mapper.BoardMapper;
import moke.mokeprojectone.vo.BoardVo;
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

        boardMapper.selectBoardList(boardVo);
    }

    public List<BoardVo> selectBoardList(BoardVo boardVo) throws Exception {


        return boardMapper.selectBoardList();
    }


    @Transactional
    public void insertBoard(BoardVo boardVo) throws Exception{

        boardMapper.insertBoard(boardVo);
    }

}

