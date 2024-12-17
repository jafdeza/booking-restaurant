package com.restaurant.booking.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="RESERVATION")
public class Reservation implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ID",unique = true, nullable = false)
        Long id;
        @Column(name="NAME")
        String name;
        @Column(name="PEOPLE")
        Integer people;
        @Column(name="DATE")
        String date;
        @Column(name="TIME")
        String time;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getPeople() {
                return people;
        }

        public void setPeople(Integer people) {
                this.people = people;
        }

        public String getDate() {
                return date;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public String getTime() {
                return time;
        }

        public void setTime(String time) {
                this.time = time;
        }
}
