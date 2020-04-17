package com.sheridan.finalexam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany()
    @JoinTable(name = "roomtype_booking", joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name="roomtype_id"))
    private Set<RoomType> roomTypes;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private int noOfAdult;

    private int noOfSeniorCitizen;

    private int noOfChildren;


}
