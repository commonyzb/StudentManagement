/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.dal.dao;

import java.util.List;

import studentapp.dal.Entity.User;

/**
 *
 * @author apple
 */
public interface UserDao 
{
    public boolean addUser(User user);
    public boolean update(User user);
    public User getUserbyID(int id);
    public List<User> getallUser();
    public boolean certifyUser(String uname,String upassword);
            
}
