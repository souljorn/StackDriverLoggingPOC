//package com.stackdriverpoc.Model;
//
//import lombok.Data;
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Data
//@Entity
//public class Starship implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    @Column(nullable = false)
//    private String model;
//
//    @Column(nullable = false)
//    private String manufacturer;
//
//    @Column(nullable = false)
//    private String length;
//
//    @Column(nullable = false)
//    private String crew;
//
//    @Column(nullable = false)
//    private String passengers;
//
//    @Column(nullable = false)
//    private String hyperdriveRating;
//
//    @Override
//    public String toString() {
//        return String.format("Starship{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", model='" + model + '\'' +
//                ", manufacturer='" + manufacturer + '\'' +
//                ", length='" + length + '\'' +
//                ", crew='" + crew + '\'' +
//                ", passengers='" + passengers + '\'' +
//                ", hyperdriveRating='" + hyperdriveRating + '\'' +
//                '}');
//    }
//}
