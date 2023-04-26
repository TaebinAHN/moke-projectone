package moke.mokeprojectone.mapper;

import moke.mokeprojectone.vo.UserVo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void joinUser(UserVo userVo);

    int idCheck(String userId);

    UserVo loginUser(UserVo userVo);
}
