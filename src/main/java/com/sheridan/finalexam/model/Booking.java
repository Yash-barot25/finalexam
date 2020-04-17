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

    @OneToOne
	@JoinColumn(name = "room_type")
    private RoomType roomType;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private int noOfAdult;

    private int noOfSeniorCitizen;

    private int noOfChildren;


}
