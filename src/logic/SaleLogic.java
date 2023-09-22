package logic;

import entity.Sale;

import java.util.Scanner;

public class SaleLogic {
    private Sale[] sales;
    private int totalSale;

    public SaleLogic(Sale[] sales) {
        this.sales = sales;
    }

    public Sale[] getSales() {
        return sales;
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
    }

    public int getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(int totalSale) {
        this.totalSale = totalSale;
    }

    public void inputSale(){
        System.out.print("Có bao nhiêu nhân viên bán hàng muốn thêm mới: ");
        int saleNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < saleNumber; i++) {
            System.out.println("Nhập thông tin cho nhân viên thứ: " + (i+1));
            Sale sale = new Sale();
            sale.inputInfo();
            saveSale(sale);
        }
        totalSale += saleNumber;

    }

    private void saveSale(Sale sale) {
        for (int i = 0; i < sales.length; i++) {
            if(sales[i] == null){
                sales[i] = sale;
                break;
            }
        }
    }
    public void showSale(){
        for (int i = 0; i < sales.length; i++) {
            if(sales[i] != null){
                System.out.println(sales[i]);
            }
        }
    }

    public Sale findSaleById(int saleId) {
        Sale result = null;
        for (int i = 0; i < sales.length; i++) {
            if(sales[i] != null && sales[i].getId() == saleId){
                result = sales[i];
                break;
            }
        }
        return result;

    }
}
