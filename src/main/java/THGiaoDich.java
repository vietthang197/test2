import org.apache.commons.codec.binary.Hex;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


public class THGiaoDich {
    public static void main(String[] args) {
        try {

            Date now = new Date();
            SimpleDateFormat formatPattern = new SimpleDateFormat("yyyyMMddHHmmss");
            String sDate = formatPattern.format(now);
            String from_date = "";
            String to_date = "";
            String name = "tong_hop_giao_dich_" + sDate;
            int cellNum = 8;
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();
            sheet.setZoom(100);
            sheet.setDefaultColumnWidth(14);

            CellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.LEFT);
            Font font = wb.createFont();
            font.setFontName("Times New Roman");
            font.setFontHeightInPoints((short) 12);
            font.setBold(true);
            style.setFont(font);

            CellStyle style_small = wb.createCellStyle();
            style_small.setAlignment(HorizontalAlignment.CENTER);
            Font font_small = wb.createFont();
            font_small.setFontName(HSSFFont.FONT_ARIAL);
            font_small.setFontHeightInPoints((short) 10);
            style_small.setFont(font_small);

            CellStyle style_column = wb.createCellStyle();
            style_column.setAlignment(HorizontalAlignment.CENTER);
            Font font_column = wb.createFont();
            font_column.setFontName(HSSFFont.FONT_ARIAL);
            font_column.setFontHeightInPoints((short) 10);
            font_column.setBold(true);
            style_column.setFont(font_column);

            //create title
            Row titleHeadRow1 = sheet.createRow(0);
            titleHeadRow1.createCell(0);
            titleHeadRow1.getCell(0).setCellValue("Tổng công ty Bưu điện Việt Nam");
            titleHeadRow1.getCell(0).setCellStyle(style);

            Row titleHeadRow2 = sheet.createRow(1);
            titleHeadRow2.createCell(0);
            titleHeadRow2.getCell(0).setCellValue("Đơn vị HTPT: ….");
            titleHeadRow2.getCell(0).setCellStyle(style);

            Row titleHeadRow3 = sheet.createRow(2);
            titleHeadRow3.createCell(0);
            titleHeadRow3.getCell(0).setCellValue("Đơn vị trực thuộc: …..");
            titleHeadRow3.getCell(0).setCellStyle(style);

            Row titleHeadRow4 = sheet.createRow(3);
            titleHeadRow4.createCell(0);
            titleHeadRow4.getCell(0).setCellValue("Điểm giao dịch: ……");
            titleHeadRow4.getCell(0).setCellStyle(style);

            Row rowSheetName = sheet.createRow(5);
            rowSheetName.createCell(0);
            rowSheetName.createCell(1);
            Cell cellSheetName = rowSheetName.getCell(0);
            cellSheetName.setCellValue("BÁO CÁO TỔNG HỢP GIAO DỊCH BÁN RA THEO TRẠNG THÁI GIAO DỊCH");
            CellStyle cellSheetNameStyle = wb.createCellStyle();
            cellSheetNameStyle.setAlignment(HorizontalAlignment.CENTER);
            Font fontSheetName = wb.createFont();
            fontSheetName.setFontName("Times New Roman");
            fontSheetName.setFontHeightInPoints((short) 12);
            fontSheetName.setBold(true);
            cellSheetNameStyle.setFont(fontSheetName);
            cellSheetName.setCellStyle(cellSheetNameStyle);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A6:G6"));

//            CreationHelper factory = wb.getCreationHelper();
//            Drawing drawing = sheet.createDrawingPatriarch();
//            ClientAnchor anchor = factory.createClientAnchor();
//            anchor.setCol1(14);
//            anchor.setCol2(16);
//            anchor.setRow1(4);
//            anchor.setRow2(7);
//            Comment cmt = drawing.createCellComment(anchor);
//            cmt.setVisible(true);
//            Font fontCommentDefault = wb.createFont();
//            fontCommentDefault.setFontName("Tahoma");
//            fontCommentDefault.setFontHeightInPoints((short) 9);
//
//            Font fontCommentBold = wb.createFont();
//            fontCommentBold.setFontName("Tahoma");
//            fontCommentBold.setFontHeightInPoints((short) 9);
//            fontCommentBold.setBold(true);
//
//            RichTextString str = factory.createRichTextString("ADMIN:\n" +
//                    "Chỉ lấy lên giao dịch có mã doanh thu là doanh thu phát sinh");
//            str.applyFont(fontCommentDefault);
//            str.applyFont(0, 5, fontCommentBold);
//            cmt.setString(str);
//            cellSheetName.setCellComment(cmt);

            // tu ngay thang nam den ngay thang nam
            Row row7 = sheet.createRow(6);
            row7.createCell(0);
            Cell cell7 = row7.getCell(0);
            cell7.setCellValue("Từ ngày   tháng   năm   đến ngày   tháng   năm   ");
            CellStyle cellStyle7to9 = wb.createCellStyle();
            cellStyle7to9.setAlignment(HorizontalAlignment.CENTER);
            Font font7to9 = wb.createFont();
            font7to9.setFontName("Times New Roman");
            font7to9.setFontHeightInPoints((short) 10);
            cellStyle7to9.setFont(font7to9);
            cell7.setCellStyle(cellStyle7to9);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A7:G7"));

            Row row8 = sheet.createRow(7);
            row8.createCell(0);
            Cell cell8 = row8.getCell(0);
            cell8.setCellValue("Chọn trạng thái  1. Chưa khởi tạo; 2. Đã khởi tạo;3. Đã xuất hóa đơn nội bộ;4. Đã xuất hóa đơn khách hàng; 9. tất cả");
            cell8.setCellStyle(cellStyle7to9);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A8:G8"));

            Row row9 = sheet.createRow(8);
            row9.createCell(0);
            Cell cell9 = row9.getCell(0);
            cell9.setCellValue("Tất cả/ mã khách hàng");
            cell9.setCellStyle(cellStyle7to9);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A9:G9"));


            String[] listColExport = new String[]{
                    "STT", "Mã trạng thái của giao dịch", "Tên đơn vị mua hàng", "Số lượng giao dịch",
                    "Thành tiền", "Tiền thuế GTGT (đồng)", "Thành tiền sau thuế"
            };

            Row row11 = sheet.createRow(10);
            row11.setHeightInPoints(35);

            String rgbS = "C9C9C9";
            byte[] rgbB = Hex.decodeHex(rgbS); // get byte array from hex string
            XSSFColor colorColExport = new XSSFColor(rgbB, null);
            XSSFCellStyle styleColExportDef = (XSSFCellStyle) wb.createCellStyle();
            XSSFCellStyle styleColExportBold = (XSSFCellStyle) wb.createCellStyle();
            XSSFCellStyle styleRow12 = (XSSFCellStyle) wb.createCellStyle();

            styleColExportBold.setFillForegroundColor(colorColExport);
            styleColExportBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);

//            CellStyle styleColExport = wb.createCellStyle();
            styleColExportDef.setWrapText(true);
            styleColExportDef.setAlignment(HorizontalAlignment.CENTER);
            styleColExportDef.setVerticalAlignment(VerticalAlignment.CENTER);
            styleColExportDef.setBorderBottom(BorderStyle.THIN);
            styleColExportDef.setBorderTop(BorderStyle.THIN);
            styleColExportDef.setBorderLeft(BorderStyle.THIN);
            styleColExportDef.setBorderRight(BorderStyle.THIN);

            styleColExportBold.setWrapText(true);
            styleColExportBold.setAlignment(HorizontalAlignment.CENTER);
            styleColExportBold.setVerticalAlignment(VerticalAlignment.TOP);
            styleColExportBold.setBorderBottom(BorderStyle.THIN);
            styleColExportBold.setBorderTop(BorderStyle.THIN);
            styleColExportBold.setBorderLeft(BorderStyle.THIN);
            styleColExportBold.setBorderRight(BorderStyle.THIN);

            Font fontDef = wb.createFont();
            fontDef.setFontName("Times New Roman");
            fontDef.setFontHeightInPoints((short) 9);
            styleColExportDef.setFont(fontDef);

            Font fontBold = wb.createFont();
            fontBold.setFontName("Times New Roman");
            fontBold.setFontHeightInPoints((short) 9);
            fontBold.setBold(true);
            styleColExportBold.setFont(fontBold);

            for (int i = 0; i < listColExport.length; i++) {
                Cell cellItem = row11.createCell(i);
                cellItem.setCellValue(listColExport[i]);
                cellItem.setCellStyle(styleColExportBold);
            }

            int rowInsert = 11;
            List<Map<String, String>> list = new ArrayList<>();

            String[] headerField = new String[]{"OFFICE_CODE", "TRANS_DATE", "PRODUCT_CODE", "GROUP_CODE", "APP_SOURCE_CODE", "BUSINESS_CODE", "TRANS_TYPE", "SERVICE_TRANS_CODE", "MANAGE_TRANS_CODE", "TRANS_PROPERTIES", "APP_USER", "CONTRACT_CODE", "GROUP_CUSTOMER_CODE", "CUSTOMER_CODE", "OFFICE_RECEIVE_CODE", "TAX_DECLARATION_CODE", "TAX_CODE", "CUS_NAME", "OFFICE_NAME", "CUS_ADDRESS", "CUS_TAX_CODE", "CUS_BANK_NO", "EMAIL", "CUS_PHONE", "PAYMENT_METHOD", "PRODUCT_NAME", "NAME_CAT", "QUANTITY", "PRICE", "TOTAL", "TAX", "TAX_PRICE", "MONEY_AFTER_TAX"};
            Map<String, String> data = new HashMap<>();
            for (int i = 0; i < headerField.length; i++) {
                data.put(headerField[i], i + "");
            }
            list.add(data);
            BigDecimal totalMoney = new BigDecimal(0);
            BigDecimal totalTaxPrice = new BigDecimal(0);
            BigDecimal totalMoneyAfterTax = new BigDecimal(0);

            Font fontBody = wb.createFont();
            fontBody.setFontHeightInPoints((short) 10);
            fontBody.setFontName("Times New Roman");
            XSSFCellStyle bodyStyle = (XSSFCellStyle) wb.createCellStyle();
            bodyStyle.setFont(fontBody);

            for (int i = 0; i < list.size(); i++) {
                Row dr = sheet.createRow(rowInsert);
                dr.setRowStyle(styleColExportBold);
                Cell cell = dr.createCell(0);
                cell.setCellStyle(styleColExportBold);
                cell.setCellValue(i);
                rowInsert++;
            }

            Row rowSumMoney = sheet.createRow(rowInsert + 1);
            Cell lblSum = rowSumMoney.createCell(0);
            CellStyle styleSumMoney = wb.createCellStyle();
            Font fontSumMoney = wb.createFont();
            fontSumMoney.setFontHeightInPoints((short) 10);
            fontSumMoney.setBold(true);
            styleSumMoney.setWrapText(true);
            styleSumMoney.setAlignment(HorizontalAlignment.RIGHT);
            styleSumMoney.setVerticalAlignment(VerticalAlignment.CENTER);
            styleSumMoney.setFont(fontSumMoney);
            lblSum.setCellStyle(styleSumMoney);
            lblSum.setCellValue("Cộng");

            Cell cellTotalMoney = rowSumMoney.createCell(29);
            cellTotalMoney.setCellValue(totalMoney.toString());
            cellTotalMoney.setCellStyle(styleSumMoney);

            Cell cellTotalTaxPrice = rowSumMoney.createCell(31);
            cellTotalTaxPrice.setCellValue(totalTaxPrice.toString());
            cellTotalTaxPrice.setCellStyle(styleSumMoney);

            Cell cellTotalMoneyAfterTax = rowSumMoney.createCell(32);
            cellTotalMoneyAfterTax.setCellValue(totalMoneyAfterTax.toString());
            cellTotalMoneyAfterTax.setCellStyle(styleSumMoney);

            //System.out.println(name);
            File fileNew = new File("D:/apache_poi_export/" + ".xlsx");

            if (fileNew.exists()) {
                fileNew.delete();
            }
            fileNew.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(fileNew);
            wb.write(fileOut);
            wb.close();
            fileOut.close();
            fileNew.
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
