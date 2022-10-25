package com.example.finalalbaplaceresjimenez684598endassignment.dal;

import com.example.finalalbaplaceresjimenez684598endassignment.model.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private List<Item> items = new ArrayList<>();   // List of all the items

    public List<Item> getItems() {
        return items;
    }

    public void addItem(int itemCode, String title, String author){
        items.add(new Item(itemCode, title, author));
    }
}
