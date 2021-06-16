package com.codegym.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends  BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
    @OneToMany(
            mappedBy = "categoryEntity"
    )
    private List<NewEntity> news = new ArrayList<>();

    public List<NewEntity> getNews() {
        return news;
    }

    public void setNews(List<NewEntity> news) {
        this.news = news;
    }

    public CategoryEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
