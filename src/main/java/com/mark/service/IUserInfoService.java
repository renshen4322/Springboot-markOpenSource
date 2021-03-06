package com.mark.service;

import com.mark.entity.UserInfo;
import com.mark.model.CheckUserDto;
import com.mark.model.RegisterDto;
import com.mark.model.UpdateUserDto;
import com.mark.utils.ResultVo;

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
     * @param dto the user entity
     * @return result vo
     */
    ResultVo<Boolean> updateAccountInfo(UpdateUserDto dto);


    UserInfo getUserInfoByName(String userName);


    /**
     * 用户注册
     *
     * @param dto the user entity
     * @return result vo
     */
    ResultVo<?> register(RegisterDto dto);

    /**
     * 删除用户信息
     *
     * @param ids the ids
     * @return result vo
     */
    ResultVo<Boolean> delete(String ids);


}
