package com.vapeshop.print_invoce;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.vapeshop.entity.Order;
import com.vapeshop.entity.OrderDetail;


public class PrintInvoce {

    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;

    public static void main(String[] args) {
//        Random random = new Random();
//        String pdfFilename = random.nextInt(1000) + ".pdf";
//        PrintInvoce generateInvoice = new PrintInvoce();
////        if (args.length < 1)
////        {
////            System.err.println("Usage: java "+ generateInvoice.getClass().getName()+
////                    " c:/Users/PC/Pictures/invoce/");
////            System.exit(1);
////        }
//
////        pdfFilename = args[0].trim();
//        generateInvoice.createPDF(pdfFilename);

    }

    public void createPDF(String pdfFilename, String pathSave, Order order) {
        System.out.println("create");
        Document doc = new Document();
        PdfWriter docWriter = null;
        initializeFonts();
        ArrayList<OrderDetail> orderDetails=order.getOrderDetails();
        try {
            String path = pathSave + pdfFilename;
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.addAuthor("VapeShop");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("VapeShop");
            doc.addTitle("Invoice");
            doc.setPageSize(PageSize.LETTER);

            doc.open();
            PdfContentByte cb = docWriter.getDirectContent();

            boolean beginPage = true;
            int y = 0;

            for (int i = 0; i < orderDetails.size(); i++) {
                if (beginPage) {
                    beginPage = false;
                    generateLayout(doc, cb,order);
                    generateHeader(doc, cb,order);
                    y = 615;
                }
                generateDetail(doc, cb, i, y,orderDetails.get(i));
                y = y - 15;
                if (y < 50) {
                    printPageNumber(cb);
                    doc.newPage();
                    beginPage = true;
                }
            }
            printPageNumber(cb);

        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (doc != null) {
                doc.close();
            }
            if (docWriter != null) {
                docWriter.close();
            }
        }
    }

    private void generateLayout(Document doc, PdfContentByte cb,Order order) {

        try {

            cb.setLineWidth(1f);

            // Invoice Header box layout
            cb.rectangle(420, 700, 150, 60);
            cb.moveTo(420, 720);
            cb.lineTo(570, 720);
            cb.moveTo(420, 740);
            cb.lineTo(570, 740);
            cb.moveTo(480, 700);
            cb.lineTo(480, 760);
            cb.stroke();

            // Invoice Header box Text Headings
            createHeadings(cb, 422, 743, "Tên người mua: ");
            createHeadings(cb, 422, 723, "Mã hóa đơn: ");
            createHeadings(cb, 422, 703, "Ngày đặt: ");

            // Invoice Detail box layout
            cb.rectangle(20, 50, 550, 600);
            cb.moveTo(20, 630);
            cb.lineTo(570, 630);
            cb.moveTo(50, 50);
            cb.lineTo(50, 650);
            cb.moveTo(150, 50);
            cb.lineTo(150, 650);
            cb.moveTo(430, 50);
            cb.lineTo(430, 650);
            cb.moveTo(500, 50);
            cb.lineTo(500, 650);
            cb.stroke();

            // Invoice Detail box Text Headings
            createHeadings(cb, 22, 633, "Số lượng");
            createHeadings(cb, 52, 633, "Mã sản phẩm ");
            createHeadings(cb, 152, 633, "Tên sản phẩm");
            createHeadings(cb, 432, 633, "Giá");
            createHeadings(cb, 502, 633, "Thành tiền");

            //add the images
            Image companyLogo = Image.getInstance("D:/Project_final_intership/Invoice/icon/icons8-vape-300.png");
            companyLogo.setAbsolutePosition(25, 700);
            companyLogo.scalePercent(25);
            doc.add(companyLogo);

        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void generateHeader(Document doc, PdfContentByte cb,Order order) {

        try {
           double sum=0;
            DecimalFormat df = new DecimalFormat("#,###,###");
            for (OrderDetail orderDetail:order.getOrderDetails()
                 ) {
                sum+=orderDetail.getAmount()*orderDetail.getPriceAtPurchase();
            }
            if(order.getVoucher().getId()!=null) sum=sum*(1-order.getVoucher().getVoucherPercent());
            createHeadings(cb, 200, 750, "Tên Shop: VapeShop");
            createHeadings(cb, 200, 735, "Địa chỉ giao: "+order.getOrderAddress());
            createHeadings(cb, 200, 720, "Mã giảm giá: "+((order.getVoucher().getId()!=null)?order.getVoucher().getId()+"("+order.getVoucher().getVoucherPercent()*100+"%)":"Không áp dụng"));
            createHeadings(cb, 200, 705, "Tổng: "+df.format(sum)+ " VNĐ");
            createHeadings(cb, 200, 690, "Số điện thoại khách hàng: "+order.getUser().getPhone());

            createHeadings(cb, 482, 743, order.getUser().getFullName());
            createHeadings(cb, 482, 723, order.getOrderId());
            createHeadings(cb, 482, 703, order.getCreateDate()+"");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void generateDetail(Document doc, PdfContentByte cb, int index, int y,OrderDetail orderDetail) {
        DecimalFormat df = new DecimalFormat("#,###,###");

        try {

            createContent(cb, 48, y, orderDetail.getAmount()+"", PdfContentByte.ALIGN_RIGHT);
            createContent(cb, 52, y, orderDetail.getProductType().getProductTypeId(), PdfContentByte.ALIGN_LEFT);
            createContent(cb, 152, y,  orderDetail.getProductType().getProduct().getProductName() + " - "+orderDetail.getProductType().getTypeName(), PdfContentByte.ALIGN_LEFT);

            double price = orderDetail.getPriceAtPurchase();
            double extPrice = price * orderDetail.getAmount();
            createContent(cb, 498, y, df.format(price)+" VND", PdfContentByte.ALIGN_RIGHT);
            createContent(cb, 568, y, df.format(extPrice)+" VND", PdfContentByte.ALIGN_RIGHT);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void createHeadings(PdfContentByte cb, float x, float y, String text) {


        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.setTextMatrix(x, y);
        cb.showText(text.trim());
        cb.endText();

    }

    private void printPageNumber(PdfContentByte cb) {


        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Trang " + (pageNumber + 1), 570, 25, 0);
        cb.endText();

        pageNumber++;

    }

    private void createContent(PdfContentByte cb, float x, float y, String text, int align) {


        cb.beginText();
        cb.setFontAndSize(bf, 8);
        cb.showTextAligned(align, text.trim(), x, y, 0);
        cb.endText();

    }

    private void initializeFonts() {
        try {
            String font   = "D:/Project_final_intership/Invoice/font/myfont.ttf";
//            bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED);
//            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED);
            bfBold = BaseFont.createFont(font, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            bf = BaseFont.createFont(font, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

//            bfBold = BaseFont.createFont(BaseF, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);


        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}