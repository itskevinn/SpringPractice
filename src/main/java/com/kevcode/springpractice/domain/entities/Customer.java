package com.kevcode.springpractice.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer extends Person {

    @OneToMany
    @JoinColumn(name = "id")
    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
