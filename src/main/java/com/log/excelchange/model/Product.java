package com.log.excelchange.model;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 收银系统输出数据bean
 * 【注意】一定要提供setter和getter方法才能导出成功！！！
 */
public class Product {

    @ExcelProperty(value = "货号")
    public String itemNo;
    @ExcelProperty(value = "品名（必填）")
    public String name;
    @ExcelProperty(value = "条形码")
    public String barCode;
    @ExcelProperty(value = "规格")
    public String specification;
    @ExcelProperty(value = "销售方式")
    public String salesMode = "普通销售"; // 普通销售、称重销售、按数量销售
    @ExcelProperty(value = "单位")
    public String unit = "件";
    @ExcelProperty(value = "进货价")
    public float purchasePrice;
    @ExcelProperty(value = "零售价（必填）")
    public float retailPrice;
    @ExcelProperty(value = "初始库存")
    public int initialInventory = 0;
    @ExcelProperty(value = "库存类型")
    public String inventoryType = "普通"; // 普通；批次
    @ExcelProperty(value = "进货规格")
    public float purchaseSpecification = 1.0f;
    @ExcelProperty(value = "供应商名称")
    public String supplierName = "自采供应商";
    @ExcelProperty(value = "管理库存")
    public String managingInventory = "是"; // 是；否
    @ExcelProperty(value = "是否允许积分")
    public String isAllowIntegration = "是"; // 是；否
    @ExcelProperty(value = "积分值")
    public float integrationValue = 0.0f;
    @ExcelProperty(value = "导购员是否提成")
    public String hasCommission = "按金额"; // 不提成；按比率；按金额
    @ExcelProperty(value = "提成值/提成率")
    public int commissionValue = 0;
    @ExcelProperty(value = "是否时价商品")
    public String isCurrentPriceGoods = "否"; // 是；否
    @ExcelProperty(value = "是否参与折扣")
    public String isDiscount = "参与"; // 参与；不参与
    @ExcelProperty(value = "适用季节")
    public String applySeason = "秋冬"; // 通用；春季；夏季；秋季；冬季；春秋；秋冬
    @ExcelProperty(value = "备注")
    public String remark = "备注";

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

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getInitialInventory() {
        return initialInventory;
    }

    public void setInitialInventory(int initialInventory) {
        this.initialInventory = initialInventory;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public float getPurchaseSpecification() {
        return purchaseSpecification;
    }

    public void setPurchaseSpecification(float purchaseSpecification) {
        this.purchaseSpecification = purchaseSpecification;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getManagingInventory() {
        return managingInventory;
    }

    public void setManagingInventory(String managingInventory) {
        this.managingInventory = managingInventory;
    }

    public String getIsAllowIntegration() {
        return isAllowIntegration;
    }

    public void setIsAllowIntegration(String isAllowIntegration) {
        this.isAllowIntegration = isAllowIntegration;
    }

    public float getIntegrationValue() {
        return integrationValue;
    }

    public void setIntegrationValue(float integrationValue) {
        this.integrationValue = integrationValue;
    }

    public String getHasCommission() {
        return hasCommission;
    }

    public void setHasCommission(String hasCommission) {
        this.hasCommission = hasCommission;
    }

    public int getCommissionValue() {
        return commissionValue;
    }

    public void setCommissionValue(int commissionValue) {
        this.commissionValue = commissionValue;
    }

    public String getIsCurrentPriceGoods() {
        return isCurrentPriceGoods;
    }

    public void setIsCurrentPriceGoods(String isCurrentPriceGoods) {
        this.isCurrentPriceGoods = isCurrentPriceGoods;
    }

    public String getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount;
    }

    public String getApplySeason() {
        return applySeason;
    }

    public void setApplySeason(String applySeason) {
        this.applySeason = applySeason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
                ", purchasingCost=" + purchasePrice +
                ", retailPrice=" + retailPrice +
                ", initialInventory=" + initialInventory +
                ", inventoryType='" + inventoryType + '\'' +
                ", purchaseSpecification=" + purchaseSpecification +
                ", supplierName='" + supplierName + '\'' +
                ", managingInventory='" + managingInventory + '\'' +
                ", isAllowIntegration='" + isAllowIntegration + '\'' +
                ", integrationValue=" + integrationValue +
                ", hasCommission='" + hasCommission + '\'' +
                ", commissionValue=" + commissionValue +
                ", isCurrentPriceGoods='" + isCurrentPriceGoods + '\'' +
                ", isDiscount='" + isDiscount + '\'' +
                ", applySeason='" + applySeason + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
