package com.example;

import javax.persistence.*;



@Entity
public class Document {
    @Id
    @SequenceGenerator(name="doc_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="doc_id_seq")
    private long id;

    private String name;

    private String data_incarcarii;

    private String versiunea;

    private String username;

    private String pw;

    protected Document(){}

    public Document(String name, String data_incarcarii,String versiunea,String user, String pw) {
        this.name = name;
        this.data_incarcarii = data_incarcarii;
        this.versiunea = versiunea;
        this.username=user;
        this.pw = pw;
    }

    public String getData_incarcarii() {
        return data_incarcarii;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getVersiunea() {
        return versiunea;
    }

    public String getUser() {
        return username;
    }

    public String getPw() {
        return pw;
    }
}
