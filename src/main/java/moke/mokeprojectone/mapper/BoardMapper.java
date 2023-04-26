package moke.mokeprojectone.mapper;

import moke.mokeprojectone.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void selectBoardList(BoardVo boardVo);

    List<BoardVo> selectBoardList() throws Exception;

    void insertBoard(BoardVo boardVo) throws Exception;


}
