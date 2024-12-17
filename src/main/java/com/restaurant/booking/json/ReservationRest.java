package com.restaurant.booking.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("people")
    private Integer people;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer people() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String date() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String time() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
