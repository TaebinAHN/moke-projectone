package moke.mokeprojectone.mapper;

import moke.mokeprojectone.vo.BoardVo;
import moke.mokeprojectone.vo.CriteriaVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVo> selectBoardList();

    void authorEnroll(BoardVo boardVo);

    int authorGetTotal(CriteriaVo criteriaVo);

    /* 페이징 */
    List<BoardVo> selectBoardList(CriteriaVo criteriaVo) throws Exception;

    void insertBoard(BoardVo boardVo) throws Exception;

    List<BoardVo> boardRead(int boardNo);


    List<BoardVo> boardUpdate(int boardNo);

    List<BoardVo> boardUpdate_1(int boardNo);
}
