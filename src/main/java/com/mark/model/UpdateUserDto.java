package com.mark.model;

import lombok.Data;

import java.io.Serializable;

/**
 * ClassName:UpdateUserDto
 * Package:com.mark.model
 * Description:
 *
 * @Date:2022/4/10 11:55
 * @Author: mark
 */
@Data
public class UpdateUserDto implements Serializable {
    private static final long serialVersionUID = 4214834329134734350L;

    private Long id;

    private String username;

    /**
     * 用户密码
     */
    private String password;
}
