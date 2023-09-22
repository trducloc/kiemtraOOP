package entity;

import constant.ItemType;

import java.util.Scanner;

public class Item implements InputTable {
    private static int AUTO_ID = 100;
    private int id;
    private String itemName;
    private String groupItem;
    private double prince;
    private int quantity;
    private ItemType itemType;

    public static int getAutoId() {
        return AUTO_ID;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getGroupItem() {
        return groupItem;
    }

    public void setGroupItem(String groupItem) {
        this.groupItem = groupItem;
    }

    public double getPrince() {
        return prince;
    }

    public void setPrince(double prince) {
        this.prince = prince;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", groupItem='" + itemType.value + '\'' +
                ", prince=" + prince +
                ", quantity=" + quantity +
                '}';
    }

    public void inputInfo(){
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập tên mặt hàng: ");
        this.setItemName(new Scanner(System.in).nextLine());
        System.out.print("Nhập giá bán của mặt hàng: ");
        this.setPrince(new Scanner(System.in).nextDouble());
        System.out.println("Nhập loại nhóm mặt hàng, chọn 1 trong các loại dưới đây: ");
        System.out.println("1. Điện tử");
        System.out.println("2. Điện lạnh");
        System.out.println("3. Máy tính");
        System.out.println("4. Thiết bị văn phòng");
        int type = 0;
        System.out.print("Lựa chọn của bạn: ");
        do{
            type = new Scanner(System.in).nextInt();
            if (type >= 1 && type <=4 ){
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, chọn lại: ");
        }while(true);
        switch(type){
            case 1:
                this.setItemType(ItemType.ELECTRONIC);
                break;
            case 2:
                this.setItemType(ItemType.REFRIGERATION);
                break;
            case 3:
                this.setItemType(ItemType.COMPUTER);
                break;
            case 4:
                this.setItemType(ItemType.OFFICE_EQUIPMENT);
                break;
        }
        System.out.print("Nhập số lượng của mặt hàng: ");
        this.setQuantity(new Scanner(System.in).nextInt());
    }
}
