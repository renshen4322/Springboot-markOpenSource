package com.mark.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:RegisterDto
 * Package:com.mark.model
 * Description:
 *
 * @Date:2022/4/10 11:28
 * @Author: mark
 */
@Data
public class RegisterDto implements Serializable {
    private static final long serialVersionUID = -5383929266871696962L;



    private String username;

    /**
     * 用户密码
     */
    private String password;

}
