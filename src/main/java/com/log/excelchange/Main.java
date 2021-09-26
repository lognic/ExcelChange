package com.log.excelchange;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import com.log.excelchange.excel.RemarkWriterHandler;
import com.log.excelchange.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String inFile = "/Users/log/Downloads/";
    public static String outFile = "/Users/log/Downloads/testOut.xls";
    public static String moduleFile = "/Users/log/Downloads/单规格商品导入模板.xls";
    public static List<Object> data = new ArrayList<>();

    static {
        for (int i = 0; i < 3; i++) {
            data.add(new Product("SUV" + i, "品名" + i, "条形码" + i, "规格" + i, (80 + i), (100 + i)));
        }
    }

    public static void main(String[] args) {
        writeWithModule(outFile);
    }

    public static void writeWithModule(String file) {
        EasyExcel.write(file, Product.class)
                .withTemplate(moduleFile)
                .sheet().doFill(data);
    }

    public static void write(String file) {
        EasyExcel.write(file, Product.class)
                .registerWriteHandler(new RemarkWriterHandler())
                .relativeHeadRowIndex(1)
                .sheet("单品商品导入导出模板").doWrite(data);
    }
}
