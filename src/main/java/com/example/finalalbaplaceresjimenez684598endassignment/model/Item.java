package com.example.finalalbaplaceresjimenez684598endassignment.model;

import java.time.LocalDate;

public class Item {

    //region Variables
    private int itemCode;
    private boolean available;
    private String title;
    private String author;
    private LocalDate lendingDate;
    //endregion

    //region Getters and Setters
    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    //endregion

    public Item(int itemCode, String title, String author) {
        this.itemCode = itemCode;
        this.available = true;
        this.title = title;
        this.author = author;
    }
}
