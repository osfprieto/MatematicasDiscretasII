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
    
    private String[] columnNames;
    private int n;
    private Object[][] data;

    public MyJTableModel(){
        n = 4;
        data = new Object[n][n+1];
        for(int i=0;i<n;i++)
            for(int j=1;j<n+1;j++)
                data[i][j] = "";
        
        for(int i=0;i<n;i++)
            data[i][0] = "S"+(i+1);
        
        columnNames = new String[n+1];
        columnNames[0] = "A\\B";
        for(int j=1;j<=n;j++)
            columnNames[j] = "S"+j;
    }
    
    public int getN(){
        return n;
    }
    
    public void setN(int newN){
        
        if(n>=2){
            int prevN = this.n;
            n = newN;

            if(prevN<newN){

                Object newData[][] = new Object[newN][newN+1];
                for(int i=0;i<newN;i++)
                    for(int j=1;j<newN+1;j++)
                        newData[i][j] = ((i<prevN && j<prevN+1)?data[i][j]:"");

                for(int i=0;i<newN;i++)
                    newData[i][0] = "S"+(i+1);

                data = newData;

                columnNames = new String[newN+1];
                columnNames[0] = "A\\B";
                for(int j=1;j<=newN;j++)
                    columnNames[j] = "S"+j;

            }else{//newN>=prevN
                
                Object newData[][] = new Object[newN][newN+1];
                for(int i=0;i<newN;i++)
                    for(int j=1;j<newN+1;j++)
                        newData[i][j] = data[i][j];

                for(int i=0;i<newN;i++)
                    newData[i][0] = "S"+(i+1);

                data = newData;

                columnNames = new String[newN+1];
                columnNames[0] = "A\\B";
                for(int j=1;j<=newN;j++)
                    columnNames[j] = "S"+j;

            }
        }
        
    }
    
    public int getColumnCount() {
        return n+1;
    }

    public int getRowCount() {
        return n;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col==0) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}