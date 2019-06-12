/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.dal.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import studentapp.dal.DBUtil;
import studentapp.dal.Entity.User;
import studentapp.dal.dao.UserDao;

/**
 *
 * @author apple
 */
public class UserDaoImpl implements UserDao
{

    @Override
    public boolean addUser(User user) {
        String insert="insert into user(uname,upassword) values('"+user.getUname()+"','"+user.getUpassword()+"')";
        try {
            DBUtil.runUpdate(insert);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserbyID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getallUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean certifyUser(String uname, String upassword) {
        String select="select * from user where uname='"+uname+"' and upassword='"+upassword+"'";
        boolean isCertifyUser=false;
        try {
            ResultSet rs=DBUtil.runQuery(select);
            if(rs!=null)
            {
                 isCertifyUser=rs.next();
                 DBUtil.realeaseAll();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isCertifyUser;
    }
    
}
