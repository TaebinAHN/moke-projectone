package moke.mokeprojectone.mapper;

import moke.mokeprojectone.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    void selectBoardList(BoardVo boardVo);

    // 여기서 지정한 메서드의 이름은 쿼리의 이름과 동일해야 함 (selectBoardList)
    List<BoardVo> selectBoardList() throws Exception;
}
