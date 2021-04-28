package com.example.carrentaldemo.business.domain;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements  java.io.Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    @Version
    protected Long version;

    @Column
    protected Long createUserId;

    @Column
    protected Date updateTime;
    @Column
    protected Date createTime;

    @Column
    protected Long updateUserId;

    @Column
    protected Boolean active = Boolean.TRUE;

}
