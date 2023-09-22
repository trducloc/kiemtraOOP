package entity;

import java.util.Arrays;

public class SaleList {
    private Sale sale;
    private SaleListDetail[] saleListDetail;
    private int totalGroupItem;

    public SaleList(Sale sale, SaleListDetail[] saleListDetail) {
        this.sale = sale;
        this.saleListDetail = saleListDetail;
        int tempTotal = 0;
        for (int i = 0; i < saleListDetail.length; i++){
            tempTotal += saleListDetail[i].getQuantity();
        }
        this.totalGroupItem = tempTotal;
    }

    public SaleList(Sale sale, SaleListDetail[] saleListDetail, int totalGroupItem) {
        this.sale = sale;
        this.saleListDetail = saleListDetail;
        this.totalGroupItem = totalGroupItem;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public SaleListDetail[] getSaleListDetail() {
        return saleListDetail;
    }

    public void setSaleListDetail(SaleListDetail[] saleListDetail) {
        this.saleListDetail = saleListDetail;
    }

    public int getTotalGroupItem() {
        return totalGroupItem;
    }

    public void setTotalGroupItem(int totalGroupItem) {
        this.totalGroupItem = totalGroupItem;
    }

    @Override
    public String toString() {
        return "SaleList{" +
                "sale=" + sale +
                ", saleListDetail=" + Arrays.toString(saleListDetail) +
                ", totalGroupItem=" + totalGroupItem +
                '}';
    }
}
