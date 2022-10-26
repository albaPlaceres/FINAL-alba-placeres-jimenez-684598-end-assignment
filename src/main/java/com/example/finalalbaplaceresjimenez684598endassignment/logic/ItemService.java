package com.example.finalalbaplaceresjimenez684598endassignment.logic;

import com.example.finalalbaplaceresjimenez684598endassignment.dal.ItemDao;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Item;

import java.util.Objects;

public class ItemService {
    private ItemDao itemDao;

    // Constructor
    public ItemService() {
        itemDao = new ItemDao();
        addItems();
    }

    // Get an item by its item code
    public Item getItemByItemCode (int itemCode){
        for (Item item : itemDao.getItems()){
            if (Objects.equals(item.getItemCode(), itemCode)){
                return item;
            }
        }
        return null;
    }

    // Adding items to the database
    public void addItems(){
        for (int i = 0; i<4; i++){
            itemDao.addItem(242, "Java for Dummies, 13th edition", "Vries, E. de");
        }
        itemDao.addItem(147, "Coding for Dummies", "Abraham, Nikhil");
        itemDao.addItem(308, "Clean Code", "Martin, Robert C.");
    }
}
