package com.mark.controller;

import com.mark.entity.UserInfo;
import com.mark.exception.BaseBusinessException;
import com.mark.model.CheckUserDto;
import com.mark.model.RegisterDto;
import com.mark.model.UpdateUserDto;
import com.mark.service.IUserInfoService;
import com.mark.utils.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    private IUserInfoService iUserInfoService;



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResultVo<?> register(@RequestBody RegisterDto dto){
        if(StringUtils.isEmpty(dto.getUsername())|| StringUtils.isEmpty(dto.getPassword())){
            throw new BaseBusinessException("请输入用户名和密码");
        }
        return iUserInfoService.register(dto);
    }


    /**
     * 检查管理员账户
     *
     * @param dto 用户实体
     * @return {@link ResultVo}<{@link Boolean}>
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultVo<Boolean> checkAdminAccount(@RequestBody CheckUserDto dto){
        if(StringUtils.isEmpty(dto.getUsername())|| StringUtils.isEmpty(dto.getPassword())){
            throw new BaseBusinessException("请输入用户名和密码");
        }
        if(!iUserInfoService.checkUser(dto)){
            return ResultVo.fail("账户不存在");
        }
        return ResultVo.ok();
    }

    /**
     * 更新账户信息
     *
     * @param dto 用户实体
     * @return {@link ResultVo}<{@link ?}>
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultVo<?> updateAccountInfo(@RequestBody UpdateUserDto dto){
        if(StringUtils.isEmpty(Long.toString(dto.getId()))||StringUtils.isEmpty(dto.getUsername())|| StringUtils.isEmpty(dto.getPassword())){
            throw new BaseBusinessException("请输入id,用户名和密码");
        }
        return iUserInfoService.updateAccountInfo(dto);
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
