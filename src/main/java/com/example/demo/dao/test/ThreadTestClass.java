package com.example.demo.dao.test;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lbs
 * @dete
 */
@Component
@Data
public class ThreadTestClass {

    private Integer id;
    private String name;
    private String age;

    public ThreadTestClass() {
    }

    public ThreadTestClass(Integer id) {
        this.id = id;
    }

    public ThreadTestClass(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ThreadTestClass(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ThreadTestClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
