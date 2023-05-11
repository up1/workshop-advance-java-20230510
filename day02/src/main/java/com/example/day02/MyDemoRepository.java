package com.example.day02;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyDemoRepository extends JpaRepository<MyData, Integer> {
}

@Entity
class MyData {
    @Id @GeneratedValue
    private Integer id;
    private String data;

    public MyData() {
    }

    public MyData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
