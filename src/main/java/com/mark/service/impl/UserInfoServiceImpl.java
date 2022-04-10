package com.mark.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mark.entity.UserInfo;
import com.mark.mapper.UserInfoMapper;
import com.mark.model.RegisterDto;
import com.mark.model.UpdateUserDto;
import com.mark.service.IUserInfoService;
import com.mark.model.CheckUserDto;
import com.mark.utils.ExtBeansUtils;
import com.mark.utils.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * ClassName:UserInfoServiceImpl
 * Package:com.mark.springbootmarkopensource.service.impl
 * Description:
 *
 * @Date:2021/10/20 15:46
 * @Author: mark
 */
@Service("IUserInfoService")
public class UserInfoServiceImpl implements IUserInfoService {

    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userDao;

    /**
     * 检查用户数量
     *
     * @param dto 用户实体
     * @return {@link Boolean}
     */
    @Override
    public Boolean checkUser(CheckUserDto dto) {
        LambdaQueryWrapper<UserInfo> lambdaQueryWrapper = Wrappers.lambdaQuery();
        UserInfo info = ExtBeansUtils.map(dto, UserInfo.class);
        lambdaQueryWrapper.eq(UserInfo::getUsername, info.getUsername())
                .eq(UserInfo::getPassword, info.getPassword());
        Integer count = userDao.selectCount(lambdaQueryWrapper);
        return count > 0;
    }

    /**
     * 根据用户名查询
     *
     * @param userName 用户名
     * @return {@link UserInfo}
     */
    @Override
    public UserInfo getUserInfoByName(String userName) {
        QueryWrapper<UserInfo> userEntityQueryWrapper = new QueryWrapper<>();
        userEntityQueryWrapper.eq("username", userName);
        return userDao.selectOne(userEntityQueryWrapper);
    }


    /**
     * 根据用户名更新用户密码
     *
     * @param userEntity 用户实体
     * @return {@link ResultVo}<{@link Boolean}>
     */
    @Override
    public ResultVo<Boolean> updateAccountInfo(UpdateUserDto dto) {
        try {
            UserInfo info = ExtBeansUtils.map(dto,UserInfo.class);
            userDao.updateById(info);
        } catch (Exception e) {
            logger.error("更新失败" + e.getMessage());
            return ResultVo.fail(400, "更新失败，请联系管理员");
        }
        return ResultVo.ok();
    }

    /**
     * 注册
     *
     * @param dto 用户实体
     * @return {@link ResultVo}<{@link ?}>
     */
    @Override
    public ResultVo<?> register(RegisterDto dto) {
        try {
            UserInfo info = ExtBeansUtils.map(dto, UserInfo.class);
            userDao.insert(info);
        } catch (Exception e) {
            logger.error("插入失败" + e.getMessage());
            return ResultVo.fail(400, "注册失败，请联系管理员");
        }
        return ResultVo.ok();
    }

    /**
     * 删除
     *
     * @param ids id
     * @return {@link ResultVo}<{@link Boolean}>
     */
    @Override
    public ResultVo<Boolean> delete(String ids) {
        userDao.deleteBatchIds(Arrays.asList(ids.split(",")));
        return ResultVo.ok();
    }


}
