/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import model.Item;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultEditorKit;
import model.Customer;
import model.Input;
import model.InputInfo;
import model.OutPutInfo;
import model.Output;
import model.Suplier;

/**
 *
 * @author khact
 */
public class DAO {

    private Connection conn;
    PreparedStatement prepStatement = null;
    PreparedStatement prepStatement2 = null;
    Statement statement = null;
    Statement statement2 = null;

    public DAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KhoQuanAo;"
                    + "username=sa;password=123456;Encrypt=false");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConn() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=KhoQuanAo;"
                    + "username=sa;password=123456;Encrypt=false");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean addItem(Item item) {
        String sql = "insert into Item (itemId,itemName,suplierId)"
                + "values(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getItemId());
            ps.setString(2, item.getItemName());
            ps.setInt(3, item.getSuplierId());
            //thay đổi dữ liệu dùng update còn đọc thì chỉ cần xxcutequery thui 
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addCustomer(Customer customer) {
        String sql = "insert into Customer (customerId,customername,customerAddress,customerPhone,customerEmail,customerMoreInfo,customerContractDate)"
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getCustomerAddress());
            ps.setInt(4, customer.getCustomerPhone());
            ps.setString(5, customer.getCustomerEmail());
            ps.setString(6, customer.getCustomerMoreInfo());
            ps.setDate(7, new Date(customer.getCustomerContractDate().getTime()));

            //thay đổi dữ liệu dùng update còn đọc thì chỉ cần xxcutequery thui 
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addSuplier(Suplier suplier) {
        String sql = "insert into Suplier (suplierId,supliername,suplierAddress,suplierPhone,suplierEmail,suplierMoreInfo,suplierContractDate)"
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, suplier.getSuplierId());
            ps.setString(2, suplier.getSuplierName());
            ps.setString(3, suplier.getSuplierAddress());
            ps.setInt(4, suplier.getSuplierPhone());
            ps.setString(5, suplier.getSuplierEmail());
            ps.setString(6, suplier.getSuplierMoreInfo());
            ps.setDate(7, new Date(suplier.getSuplierContactDate().getTime()));

            //thay đổi dữ liệu dùng update còn đọc thì chỉ cần xxcutequery thui 
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addInput(Input input) {
        String sql = "insert into Input (inputId,inputDate)"
                + "values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, input.getInputId());
            ps.setDate(2, new Date(input.getInputDate().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addOutput(Output output) {
        String sql = "insert into Out_put (outputId,outputDate)"
                + "values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, output.getOutputId());
            ps.setDate(2, new Date(output.getOutputDate().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addInputInfo(InputInfo inputinfo) {
        String sql = "insert into InputInfo (inputInfoId,itemId,inputId,Quantity,inputPrice,outputPrice,inputInfoStatus)"
                + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, inputinfo.getInputInfoId());
            ps.setInt(2, inputinfo.getItemId());
            ps.setInt(3, inputinfo.getInputId());
            ps.setFloat(4, inputinfo.getQuantity());
            ps.setFloat(5, inputinfo.getInputPrice());
            ps.setFloat(6, inputinfo.getOutputPrice());
            ps.setString(7, inputinfo.getInputInfoStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
        public boolean addOutputInfo(OutPutInfo outPutInfo) {
        String sql = "insert into OutputInfo  (outputInfoId,itemId,inputInfoId,outputId,Quantity,customerId,outputInfoDate,outputStatus)"
                + "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,outPutInfo.getOutputInfoId() );
            ps.setInt(2,outPutInfo.getCustomerId() );
            ps.setInt(3, outPutInfo.getInputInforId());
            ps.setInt(4, outPutInfo.getOutputId());
            ps.setFloat(5, outPutInfo.getQuantity());
            ps.setInt(6, outPutInfo.getCustomerId());
            ps.setDate(7,new Date (outPutInfo.getOutputInfoDate().getTime()));
            ps.setString(8, outPutInfo.getOuputInfoStatus());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //    public void updateSuplier(Suplier suplier){
    //        String query ="UPDATE Suplier SET supliername=? ,suplierAddress =?,suplierPhone=?,suplierEmail=?,suplierMoreInfo=?,suplierContractDate=? WHERE suplierId=? ";
    //        PreparedStatement  = conn.prepareStatement(query);
    //        
    //        
    //        
    //    
    //    }
    public boolean deleteItem(int itemId) {
        String sql = "delete from Item where itemId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, itemId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteInputInfoId(int inputInfoId) {
        String sql = "delete from OutputInfo  where outputInfoId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, inputInfoId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(int customerId) {
        String sql = "delete from Customer where customerId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSuplier(int SuplierId) {
        String sql = "delete from Suplier where suplierId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, SuplierId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteInput(int inputId) {
        String sql = "delete from Input where inputId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, inputId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
        public boolean deleteOutput(int ouputId) {
        String sql = "delete from Out_put where outputId=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ouputId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    public ArrayList<Item> getListItem() {
        ArrayList<Item> list = new ArrayList<>();
        String sql = "select * from Item";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getInt("itemId"));
                item.setItemName(rs.getString("itemName"));
                item.setSuplierId(rs.getInt("suplierId"));
                list.add(item);

            }
        } catch (Exception e) {

        }
        return list;
    }

    public ArrayList<InputInfo> getListInputInfo() {
        ArrayList<InputInfo> list = new ArrayList<>();
        String sql = "select * from InputInfo";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InputInfo inputInfo = new InputInfo();
                inputInfo.setInputId(rs.getInt("inputInfoId"));
                inputInfo.setItemId(rs.getInt("itemId"));
                inputInfo.setInputId(rs.getInt("inputId"));
                inputInfo.setQuantity(rs.getFloat("Quantity"));
                inputInfo.setInputPrice(rs.getFloat("inputPrice"));
                inputInfo.setOutputPrice(rs.getFloat("outputPrice"));
                inputInfo.setInputInfoStatus(rs.getString("inputInfoStatus"));
                list.add(inputInfo);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Input> getLisInput() {
        ArrayList<Input> list = new ArrayList<>();
        String sql = "select * from Input";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Input input = new Input();
                input.setInputId(rs.getInt("inputId"));
                input.setInputDate(rs.getDate("inputDate"));
                list.add(input);

            }
        } catch (Exception e) {

        }
        return list;
    }

    public ArrayList<Output> getListOutnput() {
        ArrayList<Output> list = new ArrayList<>();
        String sql = "select * from Out_put";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Output output = new Output();
                output.setOutputId(rs.getInt("outputId"));
                output.setOutputDate(rs.getDate("outputDate"));
                list.add(output);

            }
        } catch (Exception e) {

        }
        return list;
    }

    public ArrayList<Customer> getListCustomer() {
        ArrayList<Customer> list = new ArrayList<>();
        String sql = "select * from Customer";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();

                customer.setCustomerId(rs.getInt("customerId"));
                customer.setCustomerName(rs.getString("customername"));
                customer.setCustomerAddress(rs.getString("customerAddress"));
                customer.setCustomerPhone(rs.getInt("customerPhone"));
                customer.setCustomerEmail(rs.getString("customerEmail"));
                customer.setCustomerMoreInfo(rs.getString("customerMoreInfo"));
                customer.setCustomerContractDate(rs.getDate("customerContractDate"));
                list.add(customer);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public ArrayList<OutPutInfo> getListOutputInfo() {
        ArrayList<OutPutInfo> list = new ArrayList<>();
        String sql = "select * from OutputInfo";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OutPutInfo outputInfo =new OutPutInfo();

                outputInfo.setOutputInfoId(rs.getInt("outputInfoId"));
                outputInfo.setItemId(rs.getInt("itemId"));
                outputInfo.setInputInforId(rs.getInt("inputInfoId"));
                outputInfo.setOutputId(rs.getInt("outputId"));
                outputInfo.setQuantity(rs.getFloat("Quantity"));
                outputInfo.setCustomerId(rs.getInt("customerId"));
                outputInfo.setOutputInfoDate(rs.getDate("outputInfoDate"));
                outputInfo.setOuputInfoStatus(rs.getString("outputStatus"));

                list.add(outputInfo);
            }
        } catch (Exception e) {

        }
        return list;
    }

    public ArrayList<Suplier> getListSuplier() {
        ArrayList<Suplier> list = new ArrayList<>();
        String sql = "select * from Suplier";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Suplier suplier = new Suplier();
                suplier.setSuplierId(rs.getInt("suplierId"));
                suplier.setSuplierName(rs.getString("supliername"));
                suplier.setSuplierAddress(rs.getString("suplierAddress"));
                suplier.setSuplierPhone(rs.getInt("suplierPhone"));
                suplier.setSuplierEmail(rs.getString("suplierEmail"));
                suplier.setSuplierMoreInfo(rs.getString("suplierMoreInfo"));
                suplier.setSuplierContactDate(rs.getDate("suplierContractDate"));
                list.add(suplier);
            }
        } catch (Exception e) {

        }
        return list;
    }
//    public boolean deltetem(Item item){
//    String sql = "insert into Item (itemId,itemName,suplierId)"
//            + "values(?,?,?)";
//    try {
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setInt(1, item.getItemId());
//        ps.setString(2,item.getItemName());
//        ps.setInt(3, item.getSuplierId());
//            //thay đổi dữ liệu dùng update còn đọc thì chỉ cần xxcutequery thui 
//        return ps.executeUpdate()> 0;
//    } catch(Exception e){
//        e.printStackTrace();
//    }
//    return false;
//    }

}
