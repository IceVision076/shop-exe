package com.vapeshop.respository.employee;

import com.vapeshop.config.DBConnect;
import com.vapeshop.entity.ImageProduct;
import com.vapeshop.entity.Product;
import com.vapeshop.entity.ProductType;
import com.vapeshop.entity.User;
import com.vapeshop.entity.statistic.MoneyWithMonth;
import com.vapeshop.entity.statistic.MoneyWithWeek;
import com.vapeshop.entity.statistic.Top10MostPurchased;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and CONVERT(date, o.delivery_date) = CONVERT(date, GETDATE())";
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
            String query = "\n" +
                    "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.delivery_date) = MONTH(GETDATE())\n" +
                    "  and YEAR(o.delivery_date) = YEAR(GETDATE());";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and YEAR(o.delivery_date) = YEAR(GETDATE());";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "\n" +
                    "where o.status = '4'\n" +
                    "  and YEAR(o.delivery_date) = YEAR(DATEADD(YEAR, -1, GETDATE()));";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.delivery_date) = MONTH(DATEADD(MONTH, -1, GETDATE()))\n" +
                    "  and YEAR(o.delivery_date) = YEAR(DATEADD(MONTH, -1, GETDATE()));";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and od.product_type_id like 'A%'\n" +
                    "  and YEAR(o.delivery_date) = YEAR(getdate())";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and od.product_type_id like 'J%'\n" +
                    "  and YEAR(o.delivery_date) = YEAR(getdate())";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and od.product_type_id like 'V%'\n" +
                    "  and YEAR(o.delivery_date) = YEAR(getdate())";
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
                    "                 and MONTH(o.delivery_date) = MONTH(GETDATE())\n" +
                    "                 and YEAR(o.delivery_date) = YEAR(GETDATE())\n" +
                    "               group by product_type_id\n" +
                    "               order by amount desc) top5\n" +
                    "              on ProductType.Id = top5.product_type_id\n" +
                    "         join Product on ProductType.product_id = Product.Id\n" +
                    "order by amount desc";
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
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.delivery_date) = ?\n" +
                    "  and YEAR(o.delivery_date) = YEAR(GETDATE());";
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

    public static MoneyWithMonth totalMoneyOnEachMonthLastYear() {
        MoneyWithMonth moneyWithMonth = new MoneyWithMonth();
        try {
            String query = "select sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "               )\n" +
                    "           )\n" +
                    "from OrderDetail od\n" +
                    "         join [Order] o on od.order_id = o.order_id\n" +
                    "         left join Voucher V on V.id = o.voucher_id\n" +
                    "where o.status = '4'\n" +
                    "  and MONTH(o.delivery_date) = ?\n" +
                    "  and YEAR(o.delivery_date) = YEAR(DATEADD(YEAR, -1, GETDATE()));";
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

    public static MoneyWithWeek totalMoneyOnEachWeek() {
        MoneyWithWeek moneyWithWeek = new MoneyWithWeek();
        try {
            String query = "SET DATEFIRST 4;\n" +
                    "DECLARE @d DATETIME;\n" +
                    "DECLARE @startdate DATE;\n" +
                    "DECLARE @enddate DATE;\n" +
                    "SET @d = GETDATE();\n" +
                    "SET @startdate = CONVERT(date, DATEADD(dd, 0 - (@@DATEFIRST + 5 + DATEPART(dw, @d)) % 7, @d));\n" +
                    "SET @enddate = CONVERT(date, DATEADD(dd, 6 - (@@DATEFIRST + 5 + DATEPART(dw, @d)) % 7, @d));\n" +
                    "select OD.order_id, delivery_date, sum((od.amount * od.price_at_purchase)\n" +
                    "    * (1 -\n" +
                    "       (case\n" +
                    "            when V.vourcher_percent is NULL then 0\n" +
                    "            else V.vourcher_percent\n" +
                    "           end\n" +
                    "           )\n" +
                    "                                           )\n" +
                    "    ) as total\n" +
                    "from [Order]\n" +
                    "         join OrderDetail OD on [Order].order_id = OD.order_id\n" +
                    "         left join Voucher V on V.id = [Order].voucher_id\n" +
                    "\n" +
                    "where CONVERT(date, delivery_date) between @startdate and @enddate\n" +
                    "  and [Order].status = '4'\n" +
                    "group by OD.order_id, delivery_date";
            Connection con = DBConnect.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LocalDateTime createDay = resultSet.getObject("delivery_date", LocalDateTime.class);
                String dayOfWeek = createDay.getDayOfWeek().toString();
                switch (dayOfWeek) {
                    case "MONDAY":
                        double moneyMonday= moneyWithWeek.getEachDays().get(1).getTotalMoney();
                        moneyWithWeek.getEachDays().get(1).setTotalMoney(resultSet.getDouble("total")+moneyMonday);
                        break;
                    case "TUESDAY":
                        double moneyTuesday= moneyWithWeek.getEachDays().get(2).getTotalMoney();
                        moneyWithWeek.getEachDays().get(2).setTotalMoney(resultSet.getDouble("total")+moneyTuesday);
                        break;
                    case "WEDNESDAY":
                        double moneyWednesday= moneyWithWeek.getEachDays().get(3).getTotalMoney();
                        moneyWithWeek.getEachDays().get(3).setTotalMoney(resultSet.getDouble("total")+moneyWednesday);
                        break;
                    case "THURSDAY":
                        double moneyThursday= moneyWithWeek.getEachDays().get(4).getTotalMoney();
                        moneyWithWeek.getEachDays().get(4).setTotalMoney(resultSet.getDouble("total")+moneyThursday);
                        break;
                    case "FRIDAY":
                        double moneyFriday= moneyWithWeek.getEachDays().get(5).getTotalMoney();
                        moneyWithWeek.getEachDays().get(5).setTotalMoney(resultSet.getDouble("total")+moneyFriday);
                        break;
                    case "SATURDAY":
                        double moneySaturday= moneyWithWeek.getEachDays().get(6).getTotalMoney();
                        moneyWithWeek.getEachDays().get(6).setTotalMoney(resultSet.getDouble("total")+moneySaturday);
                        break;
                    case "SUNDAY":
                        double moneySunday= moneyWithWeek.getEachDays().get(0).getTotalMoney();
                        moneyWithWeek.getEachDays().get(0).setTotalMoney(resultSet.getDouble("total")+moneySunday);
                        break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return moneyWithWeek;
    }

    // lấy top 10 người mua đơn có giá trị cao
    public static Top10MostPurchased top10MostPurchased() {
        Top10MostPurchased top10MostPurchased = new Top10MostPurchased();
        try {
            String query = "select top 10 UserInfo.id,\n" +
                    "              full_name,\n" +
                    "              sum((od.amount * od.price_at_purchase)\n" +
                    "                  * (1 -\n" +
                    "                     (case\n" +
                    "                          when V.vourcher_percent is NULL then 0\n" +
                    "                          else V.vourcher_percent\n" +
                    "                         end\n" +
                    "                         )\n" +
                    "                      )\n" +
                    "                  ) AS 'total'\n" +
                    "from UserInfo\n" +
                    "         join [Order] on UserInfo.id = [Order].user_id\n" +
                    "         join OrderDetail OD on [Order].order_id = OD.order_id\n" +
                    "         left join Voucher V on V.id = [Order].voucher_id\n" +
                    "\n" +
                    "where [Order].status = '4'\n" +
                    "  and DATEPART(MONTH, [Order].delivery_date) = datepart(MONTH, GETDATE())\n" +
                    "  and DATEPART(YEAR, [Order].delivery_date) = datepart(YEAR, GETDATE())\n" +
                    "group by UserInfo.id, full_name\n" +
                    "order by total desc";
            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String userId = resultSet.getString("id");
                String fullName = resultSet.getString("full_name");
                double total = resultSet.getDouble("total");
                User user = new User();
                user.setId(userId);
                user.setFullName(fullName);
                top10MostPurchased.addUserPurchased(user, total);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return top10MostPurchased;
    }


    public static double moneyServiceOnMonth(){
        double moneyService = 0;
        try {
            String query = "select SUM(price) as 'total'\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'\n" +
                    "  AND DATEPART(MONTH, ServiceTracking.delivery_date) = DATEPART(Month, getdate())\n" +
                    "  and DATEPART(YEAR, ServiceTracking.delivery_date) = DATEPART(YEAR, getdate());";
            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) moneyService = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moneyService;
    }
    public static double moneyServiceInYear(){
        double moneyService = 0;
        try {
            String query = "select SUM(price) as 'total'\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'\n" +
                    "and DATEPART(YEAR, ServiceTracking.delivery_date) = DATEPART(YEAR, getdate());";
            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) moneyService = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moneyService;
    }
    public static double moneyServiceOnDay(){
        double moneyService = 0;
        try {
            String query = "select SUM(price) as 'total'\n" +
                    "from ServiceTracking\n" +
                    "where status = '4'\n" +
                    "  AND DATEPART(DAY,ServiceTracking.delivery_date) = DATEPART(DAY, getdate())\n" +
                    "  AND DATEPART(MONTH, ServiceTracking.delivery_date) = DATEPART(Month, getdate())\n" +
                    "  and DATEPART(YEAR, ServiceTracking.delivery_date) = DATEPART(YEAR, getdate());";
            Connection connection = DBConnect.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) moneyService = resultSet.getDouble(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moneyService;
    }


    public static void main(String[] args) {
        top10MostPurchased().getUserPurchaseds().stream().forEach(System.out::println);
    }
}
