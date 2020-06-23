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

public class TestApachePoi {
    public static void main(String[] args) throws IOException {
        try {

            Date now = new Date();
            SimpleDateFormat formatPattern = new SimpleDateFormat("yyyyMMddHHmmss");
            String sDate = formatPattern.format(now);
            String from_date = "";
            String to_date = "";
            String name = "bangkegiaodichbanra_" + sDate;
            int cellNum = 8;
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet();
            sheet.setZoom(110);

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
            titleHeadRow3.getCell(0).setCellValue("Đơn vị: …..");
            titleHeadRow3.getCell(0).setCellStyle(style);

            Row titleHeadRow4 = sheet.createRow(3);
            titleHeadRow4.createCell(0);
            titleHeadRow4.getCell(0).setCellValue("Điểm giao dịch: ……");
            titleHeadRow4.getCell(0).setCellStyle(style);

            Row rowSheetName = sheet.createRow(5);
            rowSheetName.createCell(0);
            Cell cellSheetName = rowSheetName.getCell(0);
            cellSheetName.setCellValue("BẢNG KÊ GIAO DỊCH BÁN RA");
            CellStyle cellSheetNameStyle = wb.createCellStyle();
            cellSheetNameStyle.setAlignment(HorizontalAlignment.CENTER);
            Font fontSheetName = wb.createFont();
            fontSheetName.setFontName("Times New Roman");
            fontSheetName.setFontHeightInPoints((short) 14);
            fontSheetName.setBold(true);
            cellSheetNameStyle.setFont(fontSheetName);
            cellSheetName.setCellStyle(cellSheetNameStyle);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A6:M6"));

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
            sheet.addMergedRegion(CellRangeAddress.valueOf("A7:M7"));

            Row row8 = sheet.createRow(7);
            row8.createCell(0);
            Cell cell8 = row8.getCell(0);
            cell8.setCellValue("Chọn Giao dịch đã xuất hóa đơn (Đã xuất HĐ nội bộ/ đã xuất hóa đơn KH)");
            cell8.setCellStyle(cellStyle7to9);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A8:M8"));

            Row row9 = sheet.createRow(8);
            row9.createCell(0);
            Cell cell9 = row9.getCell(0);
            cell9.setCellValue("Chọn Giao dịch chưa xuất hóa đơn (chưa khởi tạo, đã khởi tạo)");
            cell9.setCellStyle(cellStyle7to9);
            sheet.addMergedRegion(CellRangeAddress.valueOf("A9:M9"));


            Row row10 = sheet.createRow(10);
            row10.createCell(0);
            Cell cell010 = row10.getCell(0);
            cell010.setCellValue("Thông tin giao dịch");
            CellStyle cellStyle10 = wb.createCellStyle();
            cellStyle10.setAlignment(HorizontalAlignment.CENTER);
            cellStyle10.setBorderBottom(BorderStyle.MEDIUM);
            Font font10 = wb.createFont();
            font10.setFontName("Times New Roman");
            font10.setFontHeightInPoints((short) 10);
            font10.setBold(true);
            cellStyle10.setFont(font10);
            cell010.setCellStyle(cellStyle10);
            CellRangeAddress cellRangeA11Q11 = CellRangeAddress.valueOf("A11:Q11");
            RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeA11Q11, sheet);
            RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeA11Q11, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeA11Q11, sheet);
            sheet.addMergedRegion(cellRangeA11Q11);

            row10.createCell(17);
            Cell cell1710 = row10.getCell(17);
            cell1710.setCellValue("Thông tin hoá đơn điện tử");
            cell1710.setCellStyle(cellStyle10);
            CellRangeAddress cellRangeR11AG11 = CellRangeAddress.valueOf("R11:AG11");
            RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeR11AG11, sheet);
            RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeR11AG11, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeR11AG11, sheet);
            sheet.addMergedRegion(cellRangeR11AG11);

            String[] listColExport = new String[]{
                    "Mã đơn vị", "Ngày/tháng/năm", "Mã sản phẩm, dịch vụ", "Mã nhóm sản phẩm dịch vụ\n1. BCCP\n2. TCBC\n3. PHBC\n4. PPTT\n5. Khác",
                    "Mã nguồn dữ liệu\n1. BCCP\n2. PUD\n3. Paypost\n4. Sim bông sen\n5. PRS\n6.CAS\n99. Khác",
                    "Mã kinh doanh:\n1- Bán hàng hóa, cung cấp dịch vụ\n5- Cung cấp DV Đại lý hưởng hoa hồng",
                    "Mã loại giao dịch\n1. Bán\n2. Chiết khấu \n3. Giảm giá\n4. Hàng bán trả lại\n", "Mã giao dịch theo dịch vụ: lấy theo mã, số hiệu từng giao dịch nghiệp vụ",
                    "Mã quản lý giao dịch: đánh số từ 1 đến hết (theo mã đơn vị quản lý), khởi tạo lại hàng tháng",
                    "Tính chất giao dich\n1. Giao dịch ban đầu\n2. Giao dịch điều chỉnh tăng\n3. Giao dịch điều chỉnh giảm\n4. Giao dịch hủy",
                    "Mã nhân viên", "Mã Hợp đồng", "Mã nhóm khách hàng\n1. Nhóm khách hàng ghi nợ\n2. Nhòm khách hàng thu ngay",
                    "Mã khách hàng", "Mã đơn vị nhận hóa đơn", "Mã kê khai thuế  (R, K, C)",
                    "Mã thuế suất:\n1. 0%\n2. 5%\n3. 10%\n4. Để trống", "Tên người mua hàng", "Tên đơn vị mua hàng",
                    "Địa chỉ (đơn vị mua hàng)", "Mã số thuế (đơn vị mua hàng)", "Số tài khoản (đơn vị mua hàng)",
                    "Email", "Điện thoại (đơn vị mua hàng)", "Hình thức thanh toán", "Tên dịch vụ, hàng hóa", "Đơn vị tính",
                    "Số lượng", "Đơn giá", "Thành tiền", "Thuế suất GTGT", "Tiền thuế GTGT (đồng)", "Thành tiền sau thuế"
            };

            Row row11 = sheet.createRow(11);
            Row row12 = sheet.createRow(12);

            String rgbS = "C9C9C9";
            byte[] rgbB = Hex.decodeHex(rgbS); // get byte array from hex string
            XSSFColor colorColExport = new XSSFColor(rgbB, null);
            XSSFCellStyle styleColExportDef = (XSSFCellStyle) wb.createCellStyle();
            XSSFCellStyle styleColExportBold= (XSSFCellStyle) wb.createCellStyle();
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
            styleColExportBold.setVerticalAlignment(VerticalAlignment.CENTER);
            styleColExportBold.setBorderBottom(BorderStyle.THIN);
            styleColExportBold.setBorderTop(BorderStyle.THIN);
            styleColExportBold.setBorderLeft(BorderStyle.THIN);
            styleColExportBold.setBorderRight(BorderStyle.THIN);

            styleRow12.setWrapText(true);
            styleRow12.setAlignment(HorizontalAlignment.CENTER);
            styleRow12.setVerticalAlignment(VerticalAlignment.CENTER);
            styleRow12.setBorderBottom(BorderStyle.THIN);
            styleRow12.setBorderTop(BorderStyle.THIN);
            styleRow12.setBorderLeft(BorderStyle.THIN);
            styleRow12.setBorderRight(BorderStyle.THIN);



            Font fontDef = wb.createFont();
            fontDef.setFontName("Times New Roman");
            fontDef.setFontHeightInPoints((short) 9);
            styleColExportDef.setFont(fontDef);

            Font fontRow12 = wb.createFont();
            fontRow12.setFontName("Times New Roman");
            fontRow12.setFontHeightInPoints((short) 10);
            styleRow12.setFont(fontRow12);

            for(int i = 0; i < listColExport.length; i++) {
                Cell cellItem = row11.createCell(i);
                cellItem.setCellValue(listColExport[i]);
                CreationHelper factory = wb.getCreationHelper();
                RichTextString str = factory.createRichTextString(listColExport[i]);

                Font fontBoldAll = wb.createFont();
                fontBoldAll.setBold(true);
                fontBoldAll.setFontName("Times New Roman");
                fontBoldAll.setFontHeightInPoints((short) 9);

                Font fontNotBold = wb.createFont();
                fontNotBold.setFontName("Times New Roman");
                fontNotBold.setFontHeightInPoints((short) 9);

                if (i < 17) {
                    if (i < 3 || i == 8 || i == 10 || i == 11 || i == 13 || i == 14 || i == 15 || i == 16) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(fontBoldAll);
                        cellItem.setCellValue(str);
                    } else if (i == 3) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 24, fontBoldAll);
                        str.applyFont(25, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    } else if ( i  == 4 ) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 16, fontBoldAll);
                        str.applyFont(17, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    } else if (i == 5) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 14, fontBoldAll);
                        str.applyFont(15, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    } else if (i == 6) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 17, fontBoldAll);
                        str.applyFont(18, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    } else if (i == 7) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 26, fontBoldAll);
                        str.applyFont(27, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    } else if ( i == 9) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 19, fontBoldAll);
                        str.applyFont(20, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    }else if ( i == 12) {
                        cellItem.setCellStyle(styleColExportDef);
                        str.applyFont(0, 18, fontBoldAll);
                        str.applyFont(19, listColExport[i].length() - 1,fontNotBold);
                        cellItem.setCellValue(str);
                    }
                } else {
                    styleColExportBold.setFont(fontBoldAll);
                    cellItem.setCellStyle(styleColExportBold);
                }


                // init row12
                Cell cellRow12 = row12.createCell(i);
                cellRow12.setCellValue(i + 1);
                cellRow12.setCellStyle(styleRow12);
            }

            int rowInsert = 13;
            List<Map<String, String>> list = new ArrayList<>();

            String[] headerField = new String[]{"OFFICE_CODE", "TRANS_DATE", "PRODUCT_CODE", "GROUP_CODE", "APP_SOURCE_CODE", "BUSINESS_CODE", "TRANS_TYPE", "SERVICE_TRANS_CODE", "MANAGE_TRANS_CODE", "TRANS_PROPERTIES", "APP_USER", "CONTRACT_CODE", "GROUP_CUSTOMER_CODE", "CUSTOMER_CODE", "OFFICE_RECEIVE_CODE", "TAX_DECLARATION_CODE", "TAX_CODE", "CUS_NAME", "OFFICE_NAME", "CUS_ADDRESS", "CUS_TAX_CODE", "CUS_BANK_NO", "EMAIL", "CUS_PHONE", "PAYMENT_METHOD", "PRODUCT_NAME", "NAME_CAT", "QUANTITY", "PRICE", "TOTAL", "TAX", "TAX_PRICE", "MONEY_AFTER_TAX"};
            Map<String, String> data = new HashMap<>();
            for(int i = 0; i < headerField.length; i++) {
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

            for(int i = 0; i < list.size(); i++) {
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
            File fileNew = new File("D:/apache_poi_export/" + "demo.xlsx");

            if (fileNew.exists()) {
                fileNew.delete();
            }
            fileNew.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(fileNew);
            wb.write(fileOut);
            fileOut.close();
            wb.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
