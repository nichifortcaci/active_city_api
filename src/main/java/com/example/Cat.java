package com.example;

import javax.persistence.*;

/**
 * Created by nick on 2/7/16.
 */
@Entity
public class Cat {
    @Id
    @SequenceGenerator(name="cat_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="cat_id_seq")
    private long id;

    private String name;

    private String birthday;

    protected Cat(){}

    public Cat(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
