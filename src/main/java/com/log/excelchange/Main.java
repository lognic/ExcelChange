package com.log.excelchange;

import com.log.excelchange.constant.Constant;
import com.log.excelchange.excel.ExcelManager;
import com.log.excelchange.excel.IReadResultListener;
import com.log.excelchange.log.Log;
import com.log.excelchange.model.Product;
import com.log.excelchange.model.StockGoods;
import com.log.excelchange.setting.Setting;
import com.log.excelchange.setting.SettingManager;
import com.log.excelchange.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String inFile = "/Users/log/Downloads/黄埔站21秋冬.xlsx";
    public static String outFile = "/Users/log/Downloads/testOut.xls";
    public static String moduleFile = "/Users/log/Downloads/商品导入模板.xls";

    public static final String TAG = "Main";

    public static void main(String[] args) {
        readSource();
    }

    public static void readSource() {
        final Setting setting = SettingManager.readSetting();
        Log.info(TAG, "[readSource] " + setting);
        String sourceFile = setting.sourceFile;
        int sheetCount = ExcelManager.getSheetSize(sourceFile);
        if (setting.sourceSheetIndex < 0 || setting.sourceSheetIndex > sheetCount - 1) {
            Log.error(TAG, "sourceSheetIndex必须大于等于0，且不能大于Excel文件里sheet的数量-1");
            return;
        }

        int headRowNumber = setting.headRowNumber;
        if (headRowNumber < 0) {
            headRowNumber = 0;
        }
        int sourceSheetIndex = setting.sourceSheetIndex;
        String sheetName = setting.sourceSheetName;

        ExcelManager.readSheetFile(StockGoods.class, inFile, sheetName, headRowNumber, new IReadResultListener<StockGoods>() {
            @Override
            public void onResult(List<StockGoods> list) {
                Log.info(TAG, "结果：" + list);
                System.out.println("onResult：" + list);
                if (list == null || list.size() == 0) {
                    return;
                }

                // 获取配置文件内容
                String itemNoPrefix = setting.itemNoPrefix;
                if (TextUtils.isEmpty(itemNoPrefix)) {
                    itemNoPrefix = Constant.DEFAULT_ITEM_PREFIX;
                }
                String outFile = setting.outFile;
                if (TextUtils.isEmpty(outFile)) {
                    outFile = Constant.DEFAULT_OUTPUT_FILE;
                }

                List<Product> productList = new ArrayList<>();
                long baseNo = System.currentTimeMillis();
                for (int i = 0; i < list.size(); i++) {
                    StockGoods goods = list.get(i);
                    Product product = new Product();
                    product.itemNo = itemNoPrefix + (baseNo + i);
                    product.name = goods.name;
                    product.barCode = goods.barCode;
                    product.specification = goods.specification;
                    product.purchasePrice = goods.purchasePrice;
                    float purchasePrice = goods.purchasePrice * (1.0f + setting.grossProfitRate);// 零售价默认是进货价1.3倍（毛利30%）
                    if (purchasePrice < 0) {
                        purchasePrice = 0;
                    }
                    product.retailPrice = purchasePrice;
                    product.initialInventory = goods.num;
                    product.remark = goods.remark;
                    productList.add(product);
                }
                Log.info(TAG, "[入库商品列表] " + productList);
                ExcelManager.writeWithModule(Product.class, outFile, moduleFile, productList);
            }
        });
    }

}
