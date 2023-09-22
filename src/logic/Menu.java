package logic;

import entity.Item;
import entity.Sale;
import entity.SaleList;

import java.util.Scanner;

public class Menu {
    private ItemLogic itemLogic;
    private SaleLogic saleLogic;
    private SaleListLogic saleListLogic;

    public Menu() {
        Sale[] sales = new Sale[100];
        saleLogic = new SaleLogic(sales);
        Item[] items = new Item[100];
        itemLogic = new ItemLogic(items);
        SaleList[] saleLists = new SaleList[100];
        saleListLogic = new SaleListLogic(saleLogic,itemLogic,saleLists);

    }

    public void show() {
        while (true) {
            showMenu();
            int functionChoice = chooseFunction();
            switch (functionChoice) {
                case 1:
                    itemLogic.inputItem();
                    break;
                case 2:
                    itemLogic.showItem();
                    break;
                case 3:
                    saleLogic.inputSale();
                    break;
                case 4:
                    saleLogic.showSale();
                    break;
                case 5:
                    saleListLogic.showList();
                    break;
                case 6:
                    menuSort();
                    break;
                case 7:
                    saleListLogic.salary();
                    break;
                case 8:
                    return;
            }
        }
    }

    private void menuSort() {
        System.out.println("_______________Các lựa chọn sắp xếp_______________");
        System.out.println("1. Theo tên nhân viên.");
        System.out.println("2. Theo nhóm mặt hàng");
        System.out.println("0. Trở lại menu chính.");
        int x = 0;
        System.out.print("Bạn chọn: ");
        do {
            x = new Scanner(System.in).nextInt();
            if (x == 1 || x == 2) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (x) {
            case 1:
                saleListLogic.sortBySaleName();

                break;
            case 2:
                saleListLogic.sortByGroupItem();

                break;
        }
    }

    private static int chooseFunction() {
        System.out.print("Xin mời nhập lựa chọn: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 8) {
                break;
            }
            System.out.print("Chức năng không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }

    public static void showMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Nhap mat hang moi");
        System.out.println("2. In danh sach mat hang");
        System.out.println("3. Nhap nhan vien moi");
        System.out.println("4. In danh sach nhan vien");
        System.out.println("5. In bang danh sach ban hang");
        System.out.println("6. Sap xep bang danh sach ban hang");
        System.out.println("7. Lap bang doanh thu cho moi nhan vien");
        System.out.println("8. Thoat");
    }
}
