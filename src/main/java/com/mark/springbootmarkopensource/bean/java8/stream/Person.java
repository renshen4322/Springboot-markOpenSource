package com.mark.springbootmarkopensource.bean.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {
    private Integer id;
    /**
     * 姓名 在name上使用UUID注解
     */
    @UUID
    private String name;
    private String sex;
    private Integer status;
    private int age;

    public Person( String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.status =1;
    }
    public Person(int id, String name, String sex, int age) {
        this.id = id ;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.status =1;
    }

}
