/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.dal.dao;

import java.util.List;

import studentapp.dal.Entity.Student;

/**
 *
 * @author apple
 */
public interface StudentDao 
{
    public boolean addStudent(Student stu);
    
    public boolean updateStudent(Student stu);
    
    public boolean delStudentbyID(int id);
    
    public Student getStudentbyID(int id);
    
    public Student getStudentbyNum(String snum);
    
    public List<Student> getStudentbyName(String name);
    
    public List<Student> getAllStudent();
    
 }
