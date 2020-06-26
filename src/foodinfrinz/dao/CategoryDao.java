
package foodinfrinz.dao;

import foodinfrinz.pojo.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import foodinfrinz.util.DBConnection;
import java.sql.PreparedStatement;

public class CategoryDao {
public static HashMap<String,String> getAllCategoryId() throws SQLException
{  
   Connection conn=DBConnection.getConnection();
   Statement st=conn.createStatement();
   ResultSet rs=st.executeQuery("Select catname,catid from categories");
   HashMap<String,String> categories =new HashMap<>();
   while(rs.next())
   { 
    String catName=rs.getString(1);
    String catId=rs.getString(2);
    categories.put(catName,catId);
   }
   return categories;
}
public static boolean addCategory(Category c)throws SQLException
{ 
   Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into categories values(?,?)");
    ps.setString(1,c.getCatId());
    ps.setString(2,c.getCatName());
    int x=ps.executeUpdate();
    return(x>0);
}
}
