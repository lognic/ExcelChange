package com.log.excelchange;

import com.alibaba.excel.EasyExcel;
import com.log.excelchange.excel.ExcelManager;
import com.log.excelchange.excel.IReadResultListener;
import com.log.excelchange.excel.RemarkWriterHandler;
import com.log.excelchange.log.Log;
import com.log.excelchange.model.Product;
import com.log.excelchange.model.StockGoods;
import com.log.excelchange.setting.Setting;
import com.log.excelchange.setting.SettingManager;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String inFile = "/Users/log/Downloads/黄埔站21秋冬.xlsx";
    public static String outFile = "/Users/log/Downloads/testOut.xls";
    public static String moduleFile = "/Users/log/Downloads/商品导入模板.xls";
    public static List<Object> data = new ArrayList<>();
    private static int INITAL_SUV = 10000;

    public static final String TAG = "Main";

    static {
        for (int i = 0; i < 3; i++) {
            data.add(new Product("SUV" + (INITAL_SUV + i),
                    "品名" + i, "条形码" + i, "规格" + i, (80 + i), (100 + i)));
        }
    }

    public static void main(String[] args) {
//        writeWithModule(outFile);
//        SettingManager.readSetting();
        readSource(inFile);
    }

    public static void readSource(String sourceFile) {
        Setting setting = SettingManager.readSetting();
        int sheetCount = ExcelManager.getSheetSize(sourceFile);
        if (setting.sourceSheetIndex < 0 || setting.sourceSheetIndex > sheetCount - 1) {
            Log.error(TAG, "sourceSheetIndex必须大于等于0，且不能大于Excel文件里sheet的数量-1");
            return;
        }

        String sheetName = setting.sourceSheetName;
        ExcelManager.readSheetFile(StockGoods.class, inFile, sheetName, 2, new IReadResultListener<StockGoods>() {
            @Override
            public void onResult(List<StockGoods> list) {
                Log.info(TAG, "结果：" + list);
                System.out.println("结果：" + list);
                if(list == null || list.size() == 0) {
                    return;
                }

                List<Product> productList = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    StockGoods goods = list.get(i);
                    Product product = new Product();
                    product.name = goods.goodsName;
                }
            }
        });
    }


    public static void write(String file) {
        EasyExcel.write(file, Product.class)
                .registerWriteHandler(new RemarkWriterHandler())
                .relativeHeadRowIndex(1)
                .sheet("单品商品导入导出模板").doWrite(data);
    }
}
