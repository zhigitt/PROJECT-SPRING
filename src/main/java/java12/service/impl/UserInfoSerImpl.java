package java12.service.impl;

import jakarta.transaction.Transactional;
import java12.entity.UserInfo;
import java12.repo.UserInfoRepo;
import java12.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserInfoSerImpl implements UserInfoService {

    private final UserInfoRepo userInfoRepo;

    @Override
    public UserInfo findUserInfoNyUserId(Long userId) {
        return userInfoRepo.findUserInfoNyUserId(userId);
    }

    @Override
    public String updateUserInfo(Long userInfoId, UserInfo userInfo) {
        return userInfoRepo.updateUserInfo(userInfoId, userInfo);
    }

    @Override
    public UserInfo getUserInfoById(Long userInfoId) {
        return userInfoRepo.getUserInfoById(userInfoId);
    }

    @Override
    public List<UserInfo> getAllUserInfos() {
        return userInfoRepo.getAllUserInfos();
    }
}
