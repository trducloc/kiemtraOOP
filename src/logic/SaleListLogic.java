package logic;

import entity.Item;
import entity.Sale;
import entity.SaleList;
import entity.SaleListDetail;

import java.util.Scanner;

public class SaleListLogic {
    private final SaleLogic saleLogic;
    private final ItemLogic itemLogic;
    private SaleList[] saleLists;

    public SaleListLogic(SaleLogic saleLogic, ItemLogic itemLogic, SaleList[] saleLists) {
        this.saleLogic = saleLogic;
        this.itemLogic = itemLogic;
        this.saleLists = saleLists;
    }
    public void showList(){
        for (int i = 0; i < saleLists.length; i++) {
            if(saleLists[i] != null){
                System.out.println(saleLists[i]);
            }
        }
    }

    public void list(){
        if(!isEmptySale()){
            System.out.println("Chưa có thông tin nhân viên, vui lòng nhập trước.");
            return;
        }
        System.out.println("Lập bảng tính công cho bao nhiêu nhân viên trong một ngày: ");
        int saleNumber;
        do{
            saleNumber = new Scanner(System.in).nextInt();
            if(saleNumber > 0 && saleNumber <= saleLogic.getTotalSale()){
                break;
            }
            System.out.println("Số lượng nhân viên phải nhỏ hơn tổng số lượng nhân viên bán hàng của cửa hàng.");
        } while(true);
        for (int i = 0; i < saleNumber; i++) {
            System.out.println("Nhap thong tin nhan vien thu: " + (i +1));
            Sale sale = inputSaleForList();
            SaleListDetail[] details = inputSaleListDetail();
            SaleList saleList = new SaleList(sale,details);
            saveList(saleList);
        }
        showSaleList();
    }
    private SaleListDetail[] inputSaleListDetail() {
        int itemNumber;
        do {
            System.out.println("Nhan vien nay ban bao nhieu mat hang: ");
            itemNumber = new Scanner(System.in).nextInt();
            if (itemNumber >= 1 && itemNumber < 5 && itemNumber <= itemLogic.getTotalItems()) {
                break;
            }
            System.out.print("Mỗi nhân viên chỉ tham gia bán tối đa 5 mặt hàng khác nhau, nhập lại: ");
        } while (true);
        SaleListDetail[] details = new SaleListDetail[itemNumber];
        int count = 0;
        for (int i = 0; i < itemNumber; i++) {
            System.out.println("Nhap thong tin cho mat hang thu: " + (i + 1));
            System.out.println("Nhap ma mat hang: ");
            int itemId;
            Item item = null;
            do {
                itemId = new Scanner(System.in).nextInt();
                item = itemLogic.findItemById(itemId);
                if (item != null) {
                    break;
                }
                System.out.println("Khong co mat hang mang ma " + itemId + ",nhap lai: ");
            } while (true);
            System.out.println("Mat hang mang ma  " + item.getId() + " duoc ban so luong bao nhieu: ");
            int quantity;
            do {
                quantity = new Scanner(System.in).nextInt();
                if (quantity > 0) {
                    break;
                }
                System.out.println("So luong ban duoc phai la mot so nguyen duong, nhap lai: ");
            } while (true);
            SaleListDetail detail = new SaleListDetail(item, quantity);
            details[count] = detail;
            count++;
        }
        return details;
    }
    private Sale inputSaleForList() {
        System.out.println("Nhập mã nhân viên cần lập bảng: ");
        int saleId;
        Sale sale;
        do{
            saleId = new Scanner(System.in).nextInt();
            sale = saleLogic.findSaleById(saleId);
            if(sale != null){
                break;
            }
            System.out.print("Khong ton tai nhan vien mang ma " + saleId + ", nhap lai: ");
        }while (true);
        return sale;
    }

    private void saveList(SaleList saleList) {
        for (int i = 0; i < saleLists.length; i++) {
            if(saleLists[i] == null ){
                saleLists[i] = saleList;
                break;
            }
        }
    }
    public void showSaleList(){
        for (int i = 0; i < saleLists.length; i++) {
            if(saleLists[i] != null){
                System.out.println(saleLists[i]);
            }
        }
    }


    public void sortBySaleName(){
        if(!isEmptySale()){
            System.out.println("Chua co thong tin nhan vien, vui long nhap truoc khi thuc hien.");
            return;
        }
        for (int i = 0; i < saleLists.length -1; i++) {
            if(saleLists[i] == null){
                continue;
            }
            for (int j = i +1 ; j < saleLists.length; j++) {
                if(saleLists[j] == null){
                    continue;
                }
            if(saleLists[i].getSale().getName().trim().compareToIgnoreCase(saleLists[j].getSale().getName().trim()) > 0){
                SaleList temp = saleLists[i];
                saleLists[i] = saleLists[j];
                saleLists[j] = temp;
            }
            }
        }
        showSaleList();
    }

    public void sortByGroupItem() {
        if (isEmptyItem()) {
            System.out.println("Chua co thong tin nhom mat hang, vui long nhap truoc khi thuc hien.");
            return;
        }
        for (int i = 0; i < saleLists.length - 1; i++) {
            if (saleLists[i] == null) {
                continue;
            }
            for (int j = i+1; j < saleLists.length; j++) {
                if (saleLists[j] == null) {
                    continue;
                }
                if (saleLists[i].getTotalGroupItem() < saleLists[j].getTotalGroupItem()){
                    SaleList temp = saleLists[i];
                    saleLists[i] = saleLists[j];
                    saleLists[j] = temp;
                }
            }
        }
        showSaleList();
    }
    public void salary(){
        for (int i = 0; i < saleLists.length; i++) {
            double salary = 0;
            SaleList itemNumbers = saleLists[i];
            SaleListDetail[] listItem = itemNumbers.getSaleListDetail();
            for (int j = 0; j < listItem.length; j++) {
                salary += listItem[j].getItem().getPrince() * listItem[j].getQuantity();
            }
            System.out.println("Tong doanh thu cua nhan vien " + saleLists[i].getSale().getName() + " la " + salary);

        }
    }

    private boolean isEmptySale(){
        boolean havaDataSale = false;
        for (int i = 0; i < saleLogic.getSales().length; i++) {
            if(saleLogic.getSales()[i] != null){
                havaDataSale = true;
                break;
            }
        }
        return havaDataSale;
    }
    private boolean isEmptyItem(){
        boolean haveDataItem = false;
        for (int i = 0; i < itemLogic.getItems().length; i++) {
            if(itemLogic.getItems()[i] != null){
                haveDataItem = true;
                break;
            }
        }
        return haveDataItem;

    }


}

