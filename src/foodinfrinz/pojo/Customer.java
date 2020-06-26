/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodinfrinz.pojo;

/**
 *
 * @author welcome
 */
public class Customer {
    private String cust_Id;
    private String cust_name;
    private String cust_mno;
    private String ord_Date;
    private String cust_type;
    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }
    
    public String getCust_Id() {
        return cust_Id;
    }

    public void setCust_Id(String cust_Id) {
        this.cust_Id = cust_Id;
    }
    
    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_mno() {
        return cust_mno;
    }

    public void setCust_mno(String cust_mno) {
        this.cust_mno = cust_mno;
    }

    public String getOrdDate() {
        return ord_Date;
    }

    public void setOrdDate(String ordDate) {
        this.ord_Date = ordDate;
    }

    
}
