/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodinfrinz.dao;

import foodinfrinz.pojo.Customer;
import foodinfrinz.pojo.Product;
import foodinfrinz.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author welcome
 */
public class CustomerDao {
    public static String getNewID() throws SQLException
{ 
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select count(*) from customer");
    int id=101;
    ResultSet rs=ps.executeQuery();
    if(rs.next())
    { 
        id=id+rs.getInt(1);
    }
    return "C"+id;
}
public static boolean addCustomer(Customer c)throws SQLException, ParseException
{ 
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into customer values(?,?,?,?,?)");
 ps.setString(1,c.getCust_Id());
 ps.setString(2,c.getCust_name());
 ps.setString(3,c.getCust_mno());
 java.util.Date today=new java.util.Date();//copy line 817 to 819 for present date
 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
 ps.setString(4,sdf.format(today) );
 ps.setString(5,c.getCust_type());
 int result=ps.executeUpdate();
 return(result>0);
}
public static ArrayList<Customer> getAllData() throws SQLException
{ 
  Connection conn=DBConnection.getConnection();
  String qry="Select * from customer";
  Statement st= conn.createStatement();
  ResultSet rs=st.executeQuery(qry);
  ArrayList<Customer>customerList=new ArrayList<Customer>();
  while(rs.next())
  { 
      Customer c=new Customer();
      c.setCust_Id(rs.getString("cust_Id"));
      c.setCust_name(rs.getString("cust_name"));
      c.setCust_mno(rs.getString("cust_mno"));
      c.setOrdDate(rs.getString("ord_Date"));
      c.setCust_type(rs.getString("cust_type"));
      customerList.add(c);
  }
  return customerList;
}
public static boolean searchCustomer(Customer c)throws SQLException, ParseException
{ 
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("select cust_id,cust_name,cust_mno,ord_date,cust_type from customer where values(?,?,?,?)");
 ps.setString(1,c.getCust_Id());
 ps.setString(2,c.getCust_name());
 ps.setString(3,c.getCust_mno());
 String dateStr=c.getOrdDate();
 java.util.Date today=new java.util.Date();
 SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
 ps.setString(4,sdf.format(today) );
 java.util.Date d1=sdf.parse(dateStr);
 java.sql.Date d2=new java.sql.Date(d1.getTime());
 ps.setDate(4, d2);
 ps.setString(5,c.getCust_type());
 int result=ps.executeUpdate();
 return(result==1);
}

}
