package foodinfrinz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import foodinfrinz.pojo.Product;
import foodinfrinz.util.DBConnection;

public class ProductDao {
    
public static String getNewID() throws SQLException
{ 
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select count(*) from products");
    int id=101;
    ResultSet rs=ps.executeQuery();
    if(rs.next())
    { 
        id=id+rs.getInt(1);
    }
    return "P"+id;
}
public static boolean addProduct(Product p)throws SQLException
{ 
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into products values(?,?,?,?,?)");
    ps.setString(1,p.getProdId());
    ps.setString(2,p.getCatId());
    ps.setString(3,p.getProdName());
    ps.setDouble(4,p.getProdPrice());
    ps.setString(5,p.getIsActive());
    int x=ps.executeUpdate();
    return(x>0);
}
public static HashMap<String,Product> getProductsByCategory(String catId) throws SQLException
{  
   Connection conn=DBConnection.getConnection();
   String qry="Select * from Products where catid=?"; 
   PreparedStatement ps=conn.prepareStatement(qry);
   HashMap<String,Product>productList=new HashMap<String,Product>();
   ps.setString(1,catId);
   ResultSet rs=ps.executeQuery();
   while(rs.next())
   { 
     Product p=new Product();
     p.setCatId("catid");
     p.setProdId(rs.getString("prodid"));
     p.setProdName(rs.getString("prodname"));
     p.setProdPrice(rs.getDouble("prodprice"));
     p.setIsActive(rs.getString("active"));
     productList.put(p.getProdId(),p);
   }
   return productList;
}             
public static ArrayList<Product> getAllData() throws SQLException
{ 
  Connection conn=DBConnection.getConnection();
  String qry="Select * from products";
  Statement st= conn.createStatement();
  ResultSet rs=st.executeQuery(qry);
  ArrayList<Product>productList=new ArrayList<Product>();
  while(rs.next())
  { 
      Product p=new Product();
      p.setCatId(rs.getString("catid"));
      p.setProdId(rs.getString("prodid"));
      p.setProdName(rs.getString("prodname"));
      p.setProdPrice(rs.getDouble("prodprice"));
      p.setIsActive(rs.getString("active"));
      productList.add(p);
  }
  return productList;
}
public static boolean updateProduct(Product p) throws SQLException
{ 
  Connection conn=DBConnection.getConnection();
  PreparedStatement ps=conn.prepareStatement("Update Products set catid=?,prodname=?,prodprice=?,active=? where prodid=?");
  ps.setString(1,p.getCatId());
  ps.setString(2,p.getProdName());
  ps.setDouble(3,p.getProdPrice());
  ps.setString(4,p.getIsActive());
  ps.setString(5,p.getProdId());
  int x=ps.executeUpdate();
  return(x>0);
}
public static boolean removeProduct(String prodId)throws SQLException
{
  Connection conn=DBConnection.getConnection();
  PreparedStatement ps=conn.prepareStatement("Update Products set active='N' where prodid=?");
  ps.setString(1, prodId);
  int x=ps.executeUpdate();
  return x>0;
}
public static HashMap<String,String> getActiveProductsByCategory(String catId) throws SQLException
{ 
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select prodname,prodid from products where catid=? and active='Y'");
    ps.setString(1, catId);
    ResultSet rs=ps.executeQuery();
    HashMap<String,String> productList=new HashMap<>();
    while(rs.next())
    { 
      String prodName=rs.getString("prodname");
      String prodId=rs.getString("prodid");
      productList.put(prodName,prodId);
    }
    return productList;
}
}
