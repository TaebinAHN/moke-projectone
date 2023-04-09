package moke.mokeprojectone.service;

import lombok.RequiredArgsConstructor;
import moke.mokeprojectone.mapper.UserMapper;
import moke.mokeprojectone.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void joinUser(UserVo userVo){

        userMapper.joinUser(userVo);

    }


}
