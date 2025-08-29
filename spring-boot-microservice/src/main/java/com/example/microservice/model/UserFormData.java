package com.example.microservice.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class UserFormData {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    private String ankitDay;
    private String ankitNight;
    private String nishantDay;
    private String nishantNight;
    private String shailuDay;
    private String shailuNight;
    private String dumyaDay;
    private String dumyaNight;
    private String swapnilDay;
    private String swapnilNight;
    private String vipibDay;
    private String vipibNight;

    // Getters and Setters for all fields
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAnkitDay() {
        return ankitDay;
    }

    public void setAnkitDay(String ankitDay) {
        this.ankitDay = ankitDay;
    }

    public String getAnkitNight() {
        return ankitNight;
    }

    public void setAnkitNight(String ankitNight) {
        this.ankitNight = ankitNight;
    }

    public String getNishantDay() {
        return nishantDay;
    }

    public void setNishantDay(String nishantDay) {
        this.nishantDay = nishantDay;
    }

    public String getNishantNight() {
        return nishantNight;
    }

    public void setNishantNight(String nishantNight) {
        this.nishantNight = nishantNight;
    }

    public String getShailuDay() {
        return shailuDay;
    }

    public void setShailuDay(String shailuDay) {
        this.shailuDay = shailuDay;
    }

    public String getShailuNight() {
        return shailuNight;
    }

    public void setShailuNight(String shailuNight) {
        this.shailuNight = shailuNight;
    }

    public String getDumyaDay() {
        return dumyaDay;
    }

    public void setDumyaDay(String dumyaDay) {
        this.dumyaDay = dumyaDay;
    }

    public String getDumyaNight() {
        return dumyaNight;
    }

    public void setDumyaNight(String dumyaNight) {
        this.dumyaNight = dumyaNight;
    }

    public String getSwapnilDay() {
        return swapnilDay;
    }

    public void setSwapnilDay(String swapnilDay) {
        this.swapnilDay = swapnilDay;
    }

    public String getSwapnilNight() {
        return swapnilNight;
    }

    public void setSwapnilNight(String swapnilNight) {
        this.swapnilNight = swapnilNight;
    }

    public String getVipibDay() {
        return vipibDay;
    }

    public void setVipibDay(String vipibDay) {
        this.vipibDay = vipibDay;
    }

    public String getVipibNight() {
        return vipibNight;
    }

    public void setVipibNight(String vipibNight) {
        this.vipibNight = vipibNight;
    }
}
