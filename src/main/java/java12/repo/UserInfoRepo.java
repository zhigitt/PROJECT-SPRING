package java12.repo;

import java12.entity.UserInfo;

import java.util.List;

public interface UserInfoRepo {
    UserInfo findUserInfoNyUserId(Long userId);

    String updateUserInfo(Long userInfoId, UserInfo userInfo);

    UserInfo getUserInfoById(Long userInfoId);


    List<UserInfo> getAllUserInfos();
}
