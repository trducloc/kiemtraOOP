package entity;

import java.util.Scanner;

public class Sale extends Person{
    private static int AUTO_ID = 1000;
    private int id;
    private String signDate;

    public static int getAutoId() {
        return AUTO_ID;
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

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", signDate='" + signDate + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public void inputInfo(){
        super.inputInfo();
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.print("Nhập ngày ký hợp đồng: ");
        this.setSignDate(new Scanner(System.in).nextLine());
    }
}
