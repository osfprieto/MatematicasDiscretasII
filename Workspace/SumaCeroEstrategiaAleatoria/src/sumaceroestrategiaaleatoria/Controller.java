/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sumaceroestrategiaaleatoria;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author osfprieto
 */
public class Controller {
    
    public static void calcular(Object data[][]){
        double doubleData[][] = fromObjToDouble(data);
        
        int puntoSilla[] = hallarPuntoSilla(doubleData);
                
        if(puntoSilla!=null){//Esa es la solución
            //Mostrar que tiene que usar la estrategia guardada en puntoSilla[]
            JOptionPane.showMessageDialog(null,
                    "Usar la alternativa en la fila "+(puntoSilla[0]+1)
                    +"\nUsar la alternativa en la fila "+(puntoSilla[1]+1)
                    +"\nEsperar resultados de "+doubleData[puntoSilla[0]][puntoSilla[1]]
                    , "Punto de silla", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            
            doubleData = quitarDominadas(doubleData, true);
            doubleData = quitarDominadas(doubleData, false);
            
            Simplex simplex = Simplex.createSimplex(doubleData);
            
            showAnswer(simplex, doubleData);
        }
        
    }
    
    public static double[][] fromObjToDouble(Object[][] data){
        double doubleData[][] = new double[data.length][data[0].length];
        
        for(int i=0;i<data.length;i++)
            for(int j=0;j<data[0].length;j++)
                doubleData[i][j] = Double.parseDouble((String)data[i][j]);
        
        return doubleData;
    }
    
    public static double[][] transponseMatrix(double[][] data){
        double newData[][] = new double[data[0].length][data.length];
        for(int i=0;i<data.length;i++)
            for(int j=0;j<data[0].length;j++)
                newData[j][i] = data[i][j];
        return newData;
    }
    
    /*Quita filas dominadas y columnas dominadas hasta que no se puede*/
    public static double[][] quitarDominadas(double[][] data, boolean empezarConFilas){
        
        boolean quitandoFilas = empezarConFilas;
        boolean eliminada = true;
        
        while(eliminada){
            //System.out.println("Eliminando");
            eliminada = false;
            if(quitandoFilas){
                
                int i=0;
                
                while(i<data.length){
                    if(filaDominada(data, i)){
                        data = quitarFila(data, i);
                        eliminada = true;
                    }
                    else{
                        i++;
                    }
                }
                
                quitandoFilas = false;
            }else{
               
                int j=0;
                
                while(j<data[0].length){
                    if(columnaDominada(data, j)){
                        data = quitarColumna(data, j);
                        eliminada = true;
                    }
                    else{
                        j++;
                    }
                }
                
                quitandoFilas = true;
            }
        }
        
        return data;
        
    }
    
    public static boolean filaDominada(double data[][], int fila){
        
        for(int i=0;i<data.length;i++){
            if(i!=fila && filaDominadaPorFila(data, fila, i)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean filaDominadaPorFila(double data[][], int fila, int filaQueDomina){
        for(int j=0;j<data[fila].length;j++){
            if(data[fila][j]>data[filaQueDomina][j]){
                return false;
            }
        }
        return true;
    }
    
    public static boolean columnaDominada(double data[][], int columna){
        
        for(int j=0;j<data[0].length;j++){
            if(j!=columna && columnaDominadaPorColumna(data, columna, j)){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean columnaDominadaPorColumna(double data[][], int columna, int columnaQueDomina){
        
        for(int i=0;i<data.length;i++){
            if(data[i][columna]>data[i][columnaQueDomina]){
                return false;
            }
        }
        return true;
        
    }
    
    public static double[][] quitarFila(double data[][], int fila){
    
        double newData[][] = new double[data.length-1][data[0].length];
        
        for(int i=0;i<newData.length;i++){
            for(int j=0;j<newData[0].length;j++){
                newData[i][j] = data[i<fila?i:i+1][j];
            }
        }
        
        return newData;
    }
    
    public static double[][] quitarColumna(double data[][], int columna){
        double newData[][] = new double[data.length][data[0].length-1];
        
        for(int i=0;i<newData.length;i++){
            for(int j=0;j<newData[0].length;j++){
                newData[i][j] = data[i][j<columna?j:j+1];
            }
        }
        
        return newData;
    }
    
    /*Retorna la ubicación del punto silla si lo hay, sino retorna nulo*/
    public static int[] hallarPuntoSilla(double data[][]){
        
        //Hallar mínimo de máximos por columnas
        
        double minimoMaximosColumna = Double.MAX_VALUE;
        
        for(int j=0;j<data[0].length;j++){
            double tempMax = Double.MIN_VALUE;
            for(int i=0;i<data.length;i++){
                if(data[i][j]>tempMax){
                    tempMax = data[i][j];
                }
            }
            if(tempMax<minimoMaximosColumna){
                minimoMaximosColumna = tempMax;
            }
        }
        
        //Hallar máximo de mínimos por fila
        
        double maximoMinimosFila = Double.MIN_VALUE;
        
        for(int i=0;i<data.length;i++){
            double tempMin = Double.MAX_VALUE;
            for(int j=0;j<data[0].length;j++){
                if(data[i][j]<tempMin){
                    tempMin = data[i][j];
                }
            }
            if(tempMin>maximoMinimosFila){
                maximoMinimosFila = tempMin;
            }
        }
        
        //Hay punto silla
        if(maximoMinimosFila == minimoMaximosColumna){
            int ubicacion[] = {-1, -1};
            double puntoSilla = maximoMinimosFila;
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[i].length;j++){
                    if(data[i][j]==puntoSilla){
                       ubicacion[0] = i;
                       ubicacion[1] = j;
                       
                    }
                }
            }
            return ubicacion;
        }
        else{
            return null;
        }
        
    }
    
    public static void showAnswer(Simplex simplex, double data[][]){
    
        try{
            MyOutputJTableModel model = new MyOutputJTableModel(simplex, data);

            JTable table = new JTable(model);
            
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            
            panel.add(new JLabel("Solución encontrada:"), BorderLayout.NORTH);
            panel.add(table, BorderLayout.CENTER);
            panel.setSize(200, 200);
            
            JOptionPane.showMessageDialog(null, panel, "Distribución probabilística",
                    JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Problema irrestricto."
                    + "soluciones infinitas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
