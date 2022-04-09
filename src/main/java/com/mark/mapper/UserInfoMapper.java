package com.mark.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mark.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * ClassName:UserInfoMapper
 * Package:com.mark.springbootmarkopensource.mapper
 * Description:
 *
 * @Date:2021/10/20 15:43
 * @Author: mark
 */


@Repository(value = "UserInfoMapper")
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}