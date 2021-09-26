package com.log.excelchange.model;

import com.alibaba.excel.annotation.ExcelProperty;

public class Product {

    @ExcelProperty(value = {"主标题","货号"}, index = 0)
    public String itemNo;
    @ExcelProperty(value = {"主标题","品名（必填）"}, index = 1)
    public String name;
    @ExcelProperty(value = {"主标题","条形码"}, index = 3)
    public String barCode;
    @ExcelProperty(value = {"主标题","规格"}, index = 4)
    public String specification;
    @ExcelProperty(value = {"主标题","进货价"}, index = 13)
    public double purchasingCost;
    @ExcelProperty(value = {"主标题","零售价（必填）"}, index = 14)
    public double retailPrice;

    public Product() {
    }

    public Product(String itemNo, String name, String barCode, String specification, double purchasingCost, double retailPrice) {
        this.itemNo = itemNo;
        this.name = name;
        this.barCode = barCode;
        this.specification = specification;
        this.purchasingCost = purchasingCost;
        this.retailPrice = retailPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "itemNo='" + itemNo + '\'' +
                ", name='" + name + '\'' +
                ", barCode='" + barCode + '\'' +
                ", specification='" + specification + '\'' +
                ", purchasingCost='" + purchasingCost + '\'' +
                ", retailPrice='" + retailPrice + '\'' +
                '}';
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getPurchasingCost() {
        return purchasingCost;
    }

    public void setPurchasingCost(double purchasingCost) {
        this.purchasingCost = purchasingCost;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
