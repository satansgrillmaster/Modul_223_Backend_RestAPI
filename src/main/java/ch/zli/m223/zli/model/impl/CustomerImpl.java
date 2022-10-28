package ch.zli.m223.zli.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.zli.m223.zli.model.Customer;
import ch.zli.m223.zli.model.Memo;

@Entity(name = "Customer")
public class CustomerImpl implements Customer {

    @Id // makes the id to the primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // makes an auto-increment on the id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MemoImpl> memos;

    public CustomerImpl(String name, String street, String city) {
        this.name = name;
        this.street = street;
        this.city = city;
        memos = new ArrayList<>();
    }

    protected CustomerImpl() {

    }// For JPA only

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public List<Memo> getMemos() {
        return memos.stream().map((memo) -> {
            return memo;
        }).collect(Collectors.toList());
    }

    @Override
    public String getStreet() {
        // TODO Auto-generated method stub
        return street;
    }

    @Override
    public String getCity() {
        // TODO Auto-generated method stub
        return city;
    }

    public void addMemo(MemoImpl memo) {
        memos.add(memo);
    }

}