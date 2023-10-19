package com.pozwizd.royal_house.criteria;

import com.pozwizd.royal_house.model.Status;
import lombok.Getter;

@Getter
public class RequestsSearchCriteria {
    private String name;
    private String phoneNumber;
    private String email;
    private Status status;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
