package moke.mokeprojectone.vo;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserVo {

    private String userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private String userGender;
    private String userRegdate;
    private String userRole;
    private String userPhone;

}
