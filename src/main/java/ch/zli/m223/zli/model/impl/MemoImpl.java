package ch.zli.m223.zli.model.impl;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.zli.m223.zli.model.Memo;

@Entity(name = "Memo")
public class MemoImpl implements Memo {

    @Id // makes the id to the primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // makes an auto-increment on the id
    private Long id;

    @Column(nullable = false)
    private String memo;

    @ManyToOne
    private CustomerImpl customer;

    @Column(nullable = false)
    private Date coverageDate;

    public MemoImpl(String memo, CustomerImpl customer) {
        this.customer = customer;
        this.memo = memo;
        this.coverageDate = Calendar.getInstance().getTime();
        System.out.println(coverageDate);
    }

    protected MemoImpl() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getMemo() {
        return memo;
    }

    public Date getDate() {
        return coverageDate;
    }
}