/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp.gui;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import studentapp.dal.Entity.Student;

/**
 *
 * @author bob50
 * @param <T>
 */
public  class SimpleTableModel<T> extends AbstractTableModel
{
   private static final Comparator MySort = null;
protected List<String> cols;
   protected List<T> rows;

    public SimpleTableModel(List<String> cols, List<T> rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    
    

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return  cols.size();
    }

    @Override
    public String getColumnName(int column) {
        return cols.get(column);
    }
    

    @Override
    public  Object getValueAt(int rowIndex, int columnIndex) {
       try {
           List<Method> getMethods=ClassRefect.getAllGetMethod(rows.get(rowIndex));          
//             java.util.Collections.sort(getMethods,MySort);       
 //          getMethods.sort((Comparator<? super Method>) new MySort());
           return getMethods.get(columnIndex).invoke(rows.get(rowIndex), null);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalArgumentException ex) {
           Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InvocationTargetException ex) {
           Logger.getLogger(SimpleTableModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       return "";
    }
    class MySort implements Comparator<Method>
    {
		@Override
		public int compare(Method o1, Method o2) {
			// TODO Auto-generated method stub
			if(o1.getName()=="getSid") {
				return 1;
			}
			else if(o1.getName()=="getSname" && o2.getName()!="getSid") {
				return 1;
			}
			else if(o1.getName()=="getSage" &&(o2.getName()!="getSid"||o2.getName()!="getSname")) {
				return 1;
			}
			else if(o1.getName()=="getSaddress") {
				if(o2.getName()=="getSnumber"||o2.getName()=="getSphone"){
					return 1;
				}
				else {
					return -1;
				}
			}
			else if(o1.getName()=="getSnumber") {
				if(o2.getName()=="getSphone") {
					return 1;
				}else {
					return -1;
				}
			}
			else if(o1.getName()=="getSphone"){
				return -1;
			}
			else {
				return 0;
			}			
		}  	
    }
}
