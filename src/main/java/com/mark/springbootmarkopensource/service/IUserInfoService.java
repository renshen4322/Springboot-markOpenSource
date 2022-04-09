package com.mark.springbootmarkopensource.service;

import com.mark.springbootmarkopensource.entity.UserInfo;
import com.mark.springbootmarkopensource.model.CheckUserDto;
import com.mark.springbootmarkopensource.utils.ResultVo;

import java.util.List;
import java.util.Map;

/**
 * ClassName:IUserInfoService
 * Package:com.mark.springbootmarkopensource.service
 * Description:
 *
 * @Date:2021/10/20 15:45
 * @Author: mark
 */
public interface IUserInfoService {
    /**
     * 用户角色权限登录
     *
     * @param userEntity the user entity
     * @return result vo
     */
    Boolean checkUser(CheckUserDto userEntity);


    /**
     * 根据用户名更新用户密码
     *
     * @param userEntity the user entity
     * @return result vo
     */
    ResultVo<Boolean> updateAccountInfo(UserInfo userEntity);


    UserInfo getUserInfoByName(String userName);


    /**
     * 用户注册
     *
     * @param userEntity the user entity
     * @return result vo
     */
    ResultVo<?> register(UserInfo userEntity);

    /**
     * 删除用户信息
     *
     * @param ids the ids
     * @return result vo
     */
    ResultVo<Boolean> delete(String ids);


}
