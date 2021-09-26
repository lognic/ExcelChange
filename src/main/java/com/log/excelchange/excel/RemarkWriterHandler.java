package com.log.excelchange.excel;

import com.alibaba.excel.write.handler.AbstractSheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

public class RemarkWriterHandler extends AbstractSheetWriteHandler {

    private static final String REMARK = "导入说明（必读）:\n" +
            "1、货号、品名、零售价为必填项；批发价、配送价（门店之间调拨的价格）仅为连锁门店选填,不填默认为0；\n" +
            "2、多规格导入的时候表头的三个规格必填一项，可修改表头的规格名称；一个货号可以有多个规格，每个规格可为不同的价格和不同的条码，其他信息必须相同且系统取此货号所在的第一行数据；\n" +
            "3、导入只能新增商品，如果存在相同的货号不会覆盖数据；                                                            \n" +
            "4、普通商品条形码为1-18位数字或字母；多规格商品只支持普通商品；\n" +
            "5、所有的价格,必须以数字形式录入,并且范围在0 ~ 999999.99之间；\n" +
            "6、进货规格:如1箱纯净水24瓶,则填写:24；\n" +
            "7、连锁版设置初始库存无效；\n" +
            "8、本说明不影响导入，请勿删除。";

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        Workbook workbook = writeWorkbookHolder.getWorkbook();
        Sheet sheet = workbook.getSheetAt(0);
        // 设置第一行第一格内容
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(REMARK);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        // 合并单元格
        sheet.addMergedRegionUnsafe(new CellRangeAddress(0, 0, 0, 8));
    }
}
