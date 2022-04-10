package com.mark.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ClassName:UserInfo
 * Package:com.mark.springbootmarkopensource.entity
 * Description:
 *
 * @Date:2021/10/20 15:41
 * @Author: mark
 */

@Data
@TableName(value = "t_user")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 571620662071575840L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;


    /**
     * 删除状态
     */
    @TableField(value = "delete_status")
    private int deleteStatus;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;

}

