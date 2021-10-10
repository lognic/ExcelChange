package com.log.excelchange.model;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 进货单数据bean
 */
public class StockGoods {

    @ExcelProperty("条码")
    public String barCode;
    @ExcelProperty("品名")
    public String goodsName;
    @ExcelProperty("规格")
    public String specification;
    @ExcelProperty("数量")
    public String num;
    @ExcelProperty("出货单价")
    public String purchasePrice;
    @ExcelProperty("备注")
    public String remark;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
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
                ", goodsName='" + goodsName + '\'' +
                ", specification='" + specification + '\'' +
                ", num='" + num + '\'' +
                ", purchasePrice='" + purchasePrice + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
