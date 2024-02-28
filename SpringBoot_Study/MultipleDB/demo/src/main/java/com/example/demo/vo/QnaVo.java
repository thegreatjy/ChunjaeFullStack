package com.example.demo.vo;

import lombok.Data;

@Data
public class QnaVo {
    private int id;
    private String title;
    private String userId;

    public QnaVo(String title, String userId){
        this.title = title;
        this.userId = userId;
    }
}
