package logic;

import entity.Item;
import entity.Sale;


import java.util.Scanner;

public class ItemLogic {
    private Item[] items;
    private int totalItems;


    public ItemLogic(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
    public void inputItem(){
        System.out.print("Có bao nhiêu mặt hàng muốn thêm mới: ");
        int itemNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < itemNumber; i++) {
            System.out.println("Nhập thông tin cho mặt hàng thứ : " + (i + 1));
            Item item = new Item();
            item.inputInfo();
            saveItem(item);
        }
        totalItems += itemNumber;
    }

    private void saveItem(Item item) {
        for (int j = 0; j < items.length; j++) {
            if(items[j] == null){
                items[j] = item;
                break;
            }
        }
    }
    public void showItem() {
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null) {
                System.out.println(items[i]);
            }
        }
    }

    public Item findItemById(int itemId) {
        Item result = null;
        for (int i = 0; i < items.length; i++) {
            if(items[i] != null && items[i].getId() == itemId){
                result = items[i];
                break;
            }
        }
        return result;

    }
}

