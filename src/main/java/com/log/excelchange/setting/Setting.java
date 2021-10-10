package com.log.excelchange.setting;

/**
 * 配置数据bean
 */
public class Setting {

    // 货号前缀
    public String itemNoPrefix = "SUV";
    // 货号初始值
    public int itemNoInitial = 10000;
    // 数据来源模型类
    public String dataClass = "";
    // 指定输入excel的数据是第几个sheet（从1开始）
    public String sourceSheetName;
    // 指定输入excel的数据是第几个sheet（从0开始）
    public int sourceSheetIndex;
    // 进货单有两种格式（1和2）
    public int sourceFormat = 1;
    // 进货单文件路径
    public String sourceFile = "";
    // 生成文件路径
    public String outFile = "";
    // 行头的行号(从1开始，具体看excel表)
    public int headRowNumber;

    @Override
    public String toString() {
        return "Setting{" +
                "itemNoPrefix='" + itemNoPrefix + '\'' +
                ", itemNoInitial=" + itemNoInitial +
                ", dataClass='" + dataClass + '\'' +
                ", sourceSheetName='" + sourceSheetName + '\'' +
                ", sourceSheetIndex=" + sourceSheetIndex +
                ", sourceFormat=" + sourceFormat +
                ", sourceFile='" + sourceFile + '\'' +
                ", outFile='" + outFile + '\'' +
                ", headRowNumber=" + headRowNumber +
                '}';
    }
}
