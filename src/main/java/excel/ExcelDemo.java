package excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangdj
 * @date 2019/8/7
 */
public class ExcelDemo {
    public static void main(String[] args) throws Exception {
        Workbook workbook = writeExcel();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.flush();
    }

    /**
     * 写Excel
     * @return
     */
    public static Workbook writeExcel(){
        //创建Excel文档对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet
        HSSFSheet sheet = workbook.createSheet("sheet0");
        //写表头
        writeHead(sheet,workbook);
        //写内容
        writeContent(sheet);
        return workbook;
    }

    /**
     * 写内容
     * @param sheet
     */
    public static void writeContent(HSSFSheet sheet){
        HSSFRow two = sheet.createRow(1);
        HSSFCell twoOne = two.createCell(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String s = simpleDateFormat.format(new Date());
        twoOne.setCellValue(s);
    }

    /**
     * 写表头
     * @param sheet
     * @param workbook
     */
    public static void writeHead(HSSFSheet sheet,HSSFWorkbook workbook){
        //列宽
        sheet.setColumnWidth(0, 256 * 15);
        sheet.setColumnWidth(1, 256 * 15);
        sheet.setColumnWidth(2, 256 * 15);
        sheet.setColumnWidth(3, 256 * 15);
        sheet.setColumnWidth(4, 256 * 15);
        sheet.setColumnWidth(5, 256 * 15);
        sheet.setColumnWidth(6, 256 * 15);
        sheet.setColumnWidth(7, 256 * 15);
        //在sheet中创建第一行
        HSSFRow one = sheet.createRow(0);
        //获取样式
        HSSFCellStyle style = setStyle(workbook);

        //第一行创建第一列单元格
        HSSFCell oneOne = one.createCell(0);
        //单元格设置值
        oneOne.setCellValue("采购商名称");
        oneOne.setCellStyle(style);
        //一行二列
        HSSFCell oneTwo = one.createCell(1);
        oneTwo.setCellValue("供货商名称");
        oneTwo.setCellStyle(style);
        //一行三列
        HSSFCell oneThree = one.createCell(2);
        oneThree.setCellValue("合同日期");
        oneThree.setCellStyle(style);
        //一行四列
        HSSFCell oneFour = one.createCell(3);
        oneFour.setCellValue("合同名称");
        oneFour.setCellStyle(style);
        //一行五列
        HSSFCell oneFive = one.createCell(4);
        oneFive.setCellValue("合同编号");
        oneFive.setCellStyle(style);
        //一行六列
        HSSFCell oneSix = one.createCell(5);
        oneSix.setCellValue("商品名称");
        oneSix.setCellStyle(style);

        HSSFCell oneSeven = one.createCell(6);
        oneSeven.setCellValue("商品单位");
        oneSeven.setCellStyle(style);

        HSSFCell oneEight = one.createCell(7);
        oneEight.setCellValue("错误原因");
        oneEight.setCellStyle(style);
    }

    /**
     * 创建单元格表头样式
     * @param workbook
     * @return
     */
    public static HSSFCellStyle setStyle(HSSFWorkbook workbook) {
        //创建样式
        HSSFCellStyle style = workbook.createCellStyle();
        //填充
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置填充颜色
        style.setFillForegroundColor(IndexedColors.ORCHID.getIndex());
        //创建字体
        HSSFFont font = workbook.createFont();
        //设置字体颜色
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        return style;
    }

}
