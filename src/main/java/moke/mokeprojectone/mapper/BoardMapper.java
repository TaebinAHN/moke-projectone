package moke.mokeprojectone.mapper;

import moke.mokeprojectone.vo.BoardVo;
import moke.mokeprojectone.vo.CriteriaVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardVo> selectBoardList();

    /* 작가 등록 */
    void authorEnroll(BoardVo boardVo);

    /* 작가 총 수 */
    int authorGetTotal(CriteriaVo criteriaVo);

    List<BoardVo> selectBoardList(CriteriaVo criteriaVo) throws Exception;

    void insertBoard(BoardVo boardVo) throws Exception;


}
