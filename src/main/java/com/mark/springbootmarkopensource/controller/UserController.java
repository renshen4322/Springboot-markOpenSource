package com.mark.springbootmarkopensource.controller;

import com.mark.springbootmarkopensource.entity.UserInfo;
import com.mark.springbootmarkopensource.exception.BaseBusinessException;
import com.mark.springbootmarkopensource.model.CheckUserDto;
import com.mark.springbootmarkopensource.service.IUserInfoService;
import com.mark.springbootmarkopensource.utils.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:UserApi
 * Package:com.mark.springbootmarkopensource.controller
 * Description:
 *
 * @Date:2021/10/20 15:55
 * @Author: mark
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserInfoService iUserInfoService;

    /**
     * 检查管理员账户
     *
     * @param dto 用户实体
     * @return {@link ResultVo}<{@link Boolean}>
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultVo<Boolean> checkAdminAccount(@RequestBody CheckUserDto dto){
        if(StringUtils.isEmpty(dto.getUsername())|| StringUtils.isEmpty(dto.getPassword())){
            throw new BaseBusinessException("请输入用户名和密码");
        }
        if(iUserInfoService.checkUser(dto)){
            return ResultVo.fail("账户不存在");
        }
        return ResultVo.ok();
    }

    /**
     * 更新账户信息
     *
     * @param userEntity 用户实体
     * @return {@link ResultVo}<{@link ?}>
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultVo<?> updateAccountInfo(@RequestBody UserInfo userEntity){
        return iUserInfoService.updateAccountInfo(userEntity);
    }


    /**
     * 删除用户信息
     *
     * @param ids id
     * @return {@link ResultVo}<{@link Boolean}>
     */
    @RequestMapping(value = "/delete/{ids}",method = RequestMethod.DELETE)
    public ResultVo<Boolean> deleteUserInfo(@PathVariable String ids){
        return iUserInfoService.delete(ids);
    }

}
