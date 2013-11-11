/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sumaceroestrategiaaleatoria;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author osfprieto
 */
class MyJTableModel extends AbstractTableModel {
    
    private int n;
    private int m;
    private Object[][] data;

    public MyJTableModel(){
        n = 4;
        m = 4;
        data = new Object[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                data[i][j] = "";
        
    }
    
    public int getN(){
        return n;
    }
    
    public int getM(){
        return m;
    }
    
    public Object[][] getData(){
        return data;
    }
    
    public void setN(int newN){
        
        if(newN>=2){
            int prevN = this.n;
            n = newN;
            
            Object newData[][] = new Object[n][m];
            
            for(int i=0;i<n && i<prevN;i++)
                for(int j=0;j<m;j++)
                    newData[i][j] = data[i][j];
            data = newData;
        }
    }
    
    public void setM(int newM){
        if(newM>=2){
            int prevM = this.m;
            m = newM;
            
            Object newData[][] = new Object[n][m];
            
            for(int i=0;i<n;i++)
                for(int j=0;j<m && j<prevM;j++)
                    newData[i][j] = data[i][j];
            data = newData;
        }
    }
    
    public int getColumnCount() {
        return m+1;
    }

    public int getRowCount() {
        return n;
    }

    public String getColumnName(int col) {
        if(col==0)
            return "A\\B";
        return col+"º";
    }

    public Object getValueAt(int row, int col) {
        if(col==0)
            return (row+1)+"º";
        if(row>=0 && row<n && col>0 && col<=m)
            return data[row][col-1];
        return null;
    }

    public Class getColumnClass(int c) {
        return String.class;
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col==0) 
            return false;
        return true;
    }
    
    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    
    public void setValueAt(Object value, int row, int col) {
        if(row>=0 && row<n && col>0 && col<=m){
            data[row][col-1] = value;
            fireTableCellUpdated(row, col);
        }
    }
}