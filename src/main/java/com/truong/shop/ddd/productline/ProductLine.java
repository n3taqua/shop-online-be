package com.truong.shop.ddd.productline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine {
   @Id
   @GeneratedValue
    private int id;
    private String productName;
    private String buyer;
    private String address;
    private int amount;
    private int price;
    private String phone;

}
