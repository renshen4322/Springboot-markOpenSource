package com.mark.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:checkUserDto
 * Package:com.mark.springbootmarkopensource.model
 * Description:
 *
 * @Date:2022/4/9 13:42
 * @Author: mark
 */
@Data
public class CheckUserDto implements Serializable {

    /**
     * 用户名
     */

    private String username;

    /**
     * 用户密码
     */
    private String password;
}
