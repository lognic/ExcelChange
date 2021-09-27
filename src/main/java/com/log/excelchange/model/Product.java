package com.log.excelchange.model;

import com.alibaba.excel.annotation.ExcelProperty;

public class Product {

    @ExcelProperty(value = "货号", index = 0)
    public String itemNo;
    @ExcelProperty(value = "品名（必填）", index = 1)
    public String name;
    @ExcelProperty(value = "条形码", index = 3)
    public String barCode;
    @ExcelProperty(value = "规格", index = 4)
    public String specification;
    @ExcelProperty(value = "销售方式", index = 5)
    public String salesMode = "普通销售"; // 普通销售、称重销售、按数量销售
    @ExcelProperty(value = "单位", index = 7)
    public String unit = "件";
    @ExcelProperty(value = "进货价", index = 13)
    public double purchasingCost;
    @ExcelProperty(value = "零售价（必填）", index = 14)
    public double retailPrice;
    @ExcelProperty(value = "初始库存", index = 33)
    public int initialInventory = 1;
    @ExcelProperty(value = "是否参与折扣", index = 47)
    public String isDiscount = "参与"; // 参与；不参与

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
                ", salesMode='" + salesMode + '\'' +
                ", unit='" + unit + '\'' +
                ", purchasingCost=" + purchasingCost +
                ", retailPrice=" + retailPrice +
                ", initialInventory=" + initialInventory +
                ", isDiscount='" + isDiscount + '\'' +
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

    public String getSalesMode() {
        return salesMode;
    }

    public void setSalesMode(String salesMode) {
        this.salesMode = salesMode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public int getInitialInventory() {
        return initialInventory;
    }

    public void setInitialInventory(int initialInventory) {
        this.initialInventory = initialInventory;
    }

    public String getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount;
    }
}
