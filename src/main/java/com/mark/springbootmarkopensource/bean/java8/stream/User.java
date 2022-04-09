package com.mark.springbootmarkopensource.bean.java8.stream;

import lombok.Data;

@Data
public class User {
    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /**
     * 重写equals和hashCode
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            if (name.equals(user.name)){
                return true;
            }
        }
        return false;
    }
    @Override
    public int hashCode () {
        return name.hashCode();
    }


}
