package com.log.excelchange.model;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 进货单数据bean
 */
public class StockGoods {

    @ExcelProperty("条码")
    public String barCode;
    @ExcelProperty("品名")
    public String name;
    @ExcelProperty("规格")
    public String specification;
    @ExcelProperty("数量")
    public int num;
    @ExcelProperty("出货单价")
    public float purchasePrice;
    @ExcelProperty("备注")
    public String remark;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StockGoods{" +
                "barCode='" + barCode + '\'' +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", num='" + num + '\'' +
                ", purchasePrice='" + purchasePrice + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
