package com.log.excelchange.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.analysis.ExcelReadExecutor;
import com.log.excelchange.log.Log;

public class ExcelManager {

    public static final String TAG = "ExcelManager";

    /**
     * 读取指定Excel文件的指定sheet名的表单数据
     * @param clazz 读取后的数据封装bean类
     * @param sourceFile Excel文件路径
     * @param sheetName 需要读取的sheet的名字
     * @param headRowNumber 表头的索引（从1开始）
     * @param listener 读取数据完成后回调
     */
    public static <T> void readSheetFile(Class<T> clazz, String sourceFile, String sheetName,
                                         int headRowNumber, IReadResultListener listener) {
        try {
            EasyExcel.read(sourceFile, clazz, new MyReadListener<T>(listener))
                    .sheet(sheetName).headRowNumber(headRowNumber).doRead();
        } catch (Exception e) {
            Log.error(TAG, e.getMessage());
        }
    }


    public static <T> void readSheetFile(Class<T> clazz, String sourceFile, String sheetName,
                                         IReadResultListener listener) {
        try {
            EasyExcel.read(sourceFile, clazz, new MyReadListener<T>(listener))
                    .sheet(sheetName).doRead();
        } catch (Exception e) {
            Log.error(TAG, e.getMessage());
        }
    }

    /**
     * 获取excel表里sheet的数量
     *
     * @param file
     * @return
     */
    public static int getSheetSize(String file) {
        int sheetCount = 0;
        try {
            ExcelReadExecutor excelReadExecutor = EasyExcel.read(file).build().excelExecutor();
            sheetCount = excelReadExecutor.sheetList().size();
        } catch (Exception e) {
            Log.error(e.getMessage());
        }
        return sheetCount;
    }

    /**
     * 将数据模板写入到指定的输出文件里
     *
     * @param dataClazz  输出数据的bean类
     * @param outFile    输出文件
     * @param moduleFile 模板文件
     * @param data       输出的数据
     */
    public static void writeWithModule(Class<?> dataClazz, String outFile, String moduleFile, Object data) {
        Log.info(TAG, "dataClazz: " + dataClazz + ", outFile:" + outFile +
                ", moduleFile: " + moduleFile + ", data: " + data);
        try {
            EasyExcel.write(outFile, dataClazz)
                    .withTemplate(moduleFile)
                    .sheet().doFill(data);
        } catch (Exception e) {
            Log.error(TAG, "writeWithModule: " + e.getMessage());
        }
    }

    public static void writeWithModule(Class<?> dataClazz, String outFile,
                                       String moduleFile, Object data, String sheetName) {
        Log.info(TAG, "dataClazz: " + dataClazz + ", outFile:" + outFile +
                ", moduleFile: " + moduleFile + ", sheetName: " + sheetName + ", data: " + data);
        try {
            EasyExcel.write(outFile, dataClazz)
                    .withTemplate(moduleFile)
                    .sheet(sheetName).doFill(data);
        } catch (Exception e) {
            Log.error(TAG, "writeWithModule: " + e.getMessage());
        }
    }

    public static void writeWithModule(Class<?> dataClazz, String outFile,
                                       String moduleFile, Object data, int sheetIndex) {
        Log.info(TAG, "dataClazz: " + dataClazz + ", outFile:" + outFile +
                ", moduleFile: " + moduleFile + ", sheetIndex: " + sheetIndex + ", data: " + data);
        try {
            EasyExcel.write(outFile, dataClazz)
                    .withTemplate(moduleFile)
                    .sheet(sheetIndex).doFill(data);
        } catch (Exception e) {
            Log.error(TAG, "writeWithModule: " + e.getMessage());
        }
    }

}
