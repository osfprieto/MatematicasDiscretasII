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
public class MyOutputJTableModel extends AbstractTableModel {
    
    private double data[][];
    private double primal[];
    private double dual[];

    public MyOutputJTableModel(Simplex simplex, double data[][]){
        this.data = data;
        primal = simplex.primal();
        dual = simplex.dual();
        
        double sumPrimal = 0;
        for(int i=0;i<primal.length;i++){
            sumPrimal += primal[i];
        }
        for(int i=0;i<primal.length;i++){
            primal[i]/=sumPrimal;
        }
        
        double sumDual = 0;
        for(int i=0;i<dual.length;i++){
            sumDual += dual[i];
        }
        for(int i=0;i<dual.length;i++){
            dual[i]/=sumDual;
        }
        
    }
    
    public double[][] getData(){
        return data;
    }
    
    public int getColumnCount() {
        return data[0].length+1;
    }

    public int getRowCount() {
        return data.length+1;
    }

    public String getColumnName(int col) {
        if(col==0)
            return "A\\B";
        return redondear(primal[col-1]*100)+"%";
    }

    public Object getValueAt(int row, int col) {
        if(col==0 && row==0)
            return "A\\B";
        else if(col==0)
            return redondear(dual[row-1]*100)+"%";
        else if(row==0)
            return redondear(primal[col-1]*100)+"%";
        else
            return data[row-1][col-1];
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
        return false;
    }
    
    public static double redondear(double num){
        double ret = Math.round(num*10);
        return ret/10.0;
    }
}