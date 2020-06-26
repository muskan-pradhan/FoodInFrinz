package foodinfrinz.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import foodinfrinz.pojo.EmpPojo;
import foodinfrinz.util.DBConnection;
public class EmpDao {
public static boolean addEmployee(EmpPojo e)throws SQLException
{ 
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into employee values(?,?,?)");
 ps.setInt(1,e.getEmpId());
 ps.setString(2,e.getEname());
 ps.setString(3,e.getJob());
 ps.setDouble(4,e.getSal());
 int result=ps.executeUpdate();
 return(result==1);
}
public static boolean searchEmployee(EmpPojo e)throws SQLException
{ 
 PreparedStatement ps=DBConnection.getConnection().prepareStatement("select EmpNo,Ename,Salary from employee where values(?,?,?)");
 ps.setInt(1,e.getEmpId());
 ps.setString(2,e.getEname());
 ps.setString(3,e.getJob());
 ps.setDouble(4,e.getSal()); 
 int result=ps.executeUpdate();
 return(result==1);
}
}