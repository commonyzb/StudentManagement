/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.dal.Entity;

/**
 *
 * @author apple
 */
public class Student 
{
    private int sid;
    private String sname;
    private String snumber;
    private int sage;
    private String sphone;
    private String saddress;

    public Student() {
    }

    public Student(String sname, String snumber, int sage, String sphone, String saddress) {
        this.sname = sname;
        this.snumber = snumber;
        this.sage = sage;
        this.sphone = sphone;
        this.saddress = saddress;
    }

    public void setSid(int sid) {
    	this.sid=sid;
    }
    
    public int getSid() {
        return sid;
    } 

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
    
    
}
