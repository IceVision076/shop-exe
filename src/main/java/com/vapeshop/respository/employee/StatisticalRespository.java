package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.entity.User;
import com.vapeshop.entity.statistic.MoneyWithMonth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StatisticalRespository {
    public static int totalUser() {
        int totalUser = 0;
        try {
            String query = "select count(1) from UserInfo where role='0'";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalUser = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalUser;
    }

    //Số nhân viên đang làm việc
    public static int totalEmployeeWorking() {
        int totalUser = 0;
        try {
            String query = "select count(*)\n" +
                    "from UserInfo\n" +
                    "where status = '1'\n" +
                    "  and role = '1'";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalUser = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalUser;
    }

    //--Số tài khoản khách hàng vi phạm
    public static int totalCustomerIsLocked() {
        int totalUser = 0;
        try {
            String query = "select count(*)\n" +
                    "    from UserInfo\n" +
                    "    where status = '0'\n" +
                    "      and role = '0'";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalUser = resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalUser;
    }

    public static int[] productAmountChart() {
        int[] result = new int[3];
        try {
            String query = "select *\n" +
                    "from (select 'Vape' as 'Product', count(1) as 'Amount'\n" +
                    "      from Product\n" +
                    "      where id like 'V%'\n" +
                    "      union\n" +
                    "      select 'Accessory' as 'Product', count(1) as 'Amount'\n" +
                    "      from Product\n" +
                    "      where id like 'A%'\n" +
                    "      union\n" +
                    "      select 'Juice'as 'Product', count(1) as 'Amount'\n" +
                    "      from Product\n" +
                    "      where id like 'J%') x\n" +
                    "order by x.Product";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                result[i] = resultSet.getInt(2);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //Lấy tiền thu nhập hôm nay
    public static double totalMoneyToday() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and CONVERT(date, o.create_date) = CONVERT(date, GETDATE())\n";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }

    //Lấy tiền thu nhập trong tháng này
    public static double totalMoneyOnMonth() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.create_date) = MONTH(GETDATE())\n" +
                    "  and YEAR(o.create_date) = YEAR(GETDATE());";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }

    //Lấy tiền thu nhâp trong năm
    public static double totalMoneyInYear() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and YEAR(o.create_date) = YEAR(GETDATE());";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }


    //Lấy tiền thu nhập năm trước
    public static double totalMoneyBeforeYear() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and YEAR(o.create_date) = YEAR(DATEADD(YEAR, -1, GETDATE()));";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }

    //Lấy tiền thu nhập tháng trước
    public static double totalMoneyBeforeMonth() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.create_date) = MONTH(DATEADD(MONTH, -1, GETDATE()))\n" +
                    "  and YEAR(o.create_date) = YEAR(DATEADD(MONTH, -1, GETDATE()));";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }


    //Lấy tổng thu nhập của phụ kiên trong năm
    public static double totalMoneyAccessoryInYear() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and od.product_type_id like 'A%'\n" +
                    "  and YEAR(o.create_date) = YEAR(getdate())";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }


    //Lấy tổng thu nhập của tinh dầu trong năm
    public static double totalMoneyJuiceInYear() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and od.product_type_id like 'J%'\n" +
                    "  and YEAR(o.create_date) = YEAR(getdate())";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }

    //Lấy tổng thu nhập của vape trong năm
    public static double totalMoneyVapeInYear() {
        double totalMoney = 0;
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and od.product_type_id like 'V%'\n" +
                    "  and YEAR(o.create_date) = YEAR(getdate())";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                totalMoney = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalMoney;
    }

    //top 5 sản phẩm bán chạy trong tháng
    public static ArrayList<ProductType> top5ProductTypeBestSellOnMonth() {
        ArrayList<ProductType> productTypes = null;
        try {
            String query = "select Product.product_name, *\n" +
                    "from ProductType\n" +
                    "         join (select top 5 product_type_id, sum(amount) as amount\n" +
                    "               from OrderDetail od\n" +
                    "                        join [Order] o on o.order_id = od.order_id\n" +
                    "               where o.status = '4'\n" +
                    "               group by product_type_id\n" +
                    "               order by amount desc) top5\n" +
                    "              on ProductType.Id = top5.product_type_id\n" +
                    "\n" +
                    "         join Product on ProductType.product_id = Product.Id\n" +
                    "order by amount desc\n";
            Connection con = DBConnect.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            productTypes = new ArrayList<>();
            while (resultSet.next()) {
                String productTypeId = resultSet.getString("Id");
                String typeName = resultSet.getString("name");
                double typePrice = resultSet.getDouble("price");
                String productName = resultSet.getString("product_name");
                int selledAmount = resultSet.getInt("amount");


                Product product = new Product();
                product.setProductName(productName);
                ArrayList<ImageProduct> imageProducts = ProductRespository.getImgProductType(productTypeId);
                ProductType productType = new ProductType();
                productType.setProduct(product);
                productType.setProductTypeId(productTypeId);
                productType.setSelledAmount(selledAmount);
                productType.setTypeName(typeName);
                productType.setTypePrice(typePrice);
                productType.setImageProducts(imageProducts);
                productTypes.add(productType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypes;
    }


    //Lấy thu nhập của từng tháng trong năm
    public static MoneyWithMonth totalMoneyOnEachMonth() {
        MoneyWithMonth moneyWithMonth = new MoneyWithMonth();
        try {
            String query = "select sum(amount * price_at_purchase)\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.create_date) = ?\n" +
                    "  and YEAR(o.create_date) = YEAR(DATEADD(MONTH, -1, GETDATE()));";
            Connection con = DBConnect.getConnection();
            PreparedStatement statement = con.prepareStatement(query);

            for (int i = 1; i < 13; i++) {
                statement.setString(1, i + "");
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) moneyWithMonth.getEachMonths().get(i - 1).setTotalMoney(resultSet.getDouble(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moneyWithMonth;
    }

    //Số nhân viên đang làm việc


    public static void main(String[] args) {
//        top5ProductTypeBestSellOnMonth().stream().forEach(System.out::println);
        totalMoneyOnEachMonth().getEachMonths().stream().forEach(System.out::println);
    }
}
