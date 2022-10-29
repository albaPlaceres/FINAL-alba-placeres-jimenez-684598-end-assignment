package com.example.finalalbaplaceresjimenez684598endassignment.logic;

import com.example.finalalbaplaceresjimenez684598endassignment.dal.ItemDao;
import com.example.finalalbaplaceresjimenez684598endassignment.model.Item;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
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

    // Calculate the days an item is late
    public long daysLate(Item item){
        LocalDate threeWeeksPastLendingDate = item.getLendingDate().plusWeeks(3);   // 3 weeks after lending date
        if (LocalDate.now().isAfter(threeWeeksPastLendingDate)){ // If the item is too late return the amount of late days
            return (ChronoUnit.DAYS.between(threeWeeksPastLendingDate, LocalDate.now()));
        }
        return 0; // If it is not late return 0 days
    }

    // Get the items from the database
    public List<Item> getItems(){
        return itemDao.getItems();
    }
}
