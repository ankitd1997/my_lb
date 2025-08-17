package com.example.microservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String ankit;
    private String nishant;
    private String shailu;
    private String dumya;
    private String swapnil;
    private String vipib;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date; // New date field

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnkit() {
        return ankit;
    }

    public void setAnkit(String ankit) {
        this.ankit = ankit;
    }

    public String getNishant() {
        return nishant;
    }

    public void setNishant(String nishant) {
        this.nishant = nishant;
    }

    public String getShailu() {
        return shailu;
    }

    public void setShailu(String shailu) {
        this.shailu = shailu;
    }

    public String getDumya() {
        return dumya;
    }

    public void setDumya(String dumya) {
        this.dumya = dumya;
    }

    public String getSwapnil() {
        return swapnil;
    }

    public void setSwapnil(String swapnil) {
        this.swapnil = swapnil;
    }

    public String getVipib() {
        return vipib;
    }

    public void setVipib(String vipib) {
        this.vipib = vipib;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}