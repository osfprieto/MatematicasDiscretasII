/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sumaceroestrategiaaleatoria;

import java.util.Arrays;
import javax.swing.JOptionPane;
import sun.security.util.Length;

/**
 *
 * @author osfprieto
 */
public class Controller {
    
    public static void maxForA(Object data[][]){

        Simplex simplex = solveWithSimplex(data);
        showAnswer(simplex.primal());
        
    }
    
    public static void maxForB(Object data[][]){
        
        Simplex simplex = solveWithSimplex(data);
        showAnswer(simplex.dual());
        
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
    
    public static Simplex solveWithSimplex(Object data[][]){
        double doubleData[][] = fromObjToDouble(data);
        int n = doubleData.length;
        int m = doubleData[0].length;
        int N = n+1;
        int M = m+1;
        
        double A[][] = new double[N][M];
        double b[] = new double[N];
        double c[] = new double[M];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                A[i][j] = doubleData[i][j];
        
        for(int i=0;i<N;i++)
            if(i==n)
                A[i][m] = 0;
            else
                A[i][m] = -1;
        
        for(int j=0;j<M;j++)
            if(j==m)
                A[n][j] = 0;
            else
                A[n][j] = 1;
        
        for(int i=0;i<N;i++)
            if(i==n)
                b[i] = 1;
            else
                b[i] = 0;
        
        for(int j=0;j<M;j++)
            if(j==m)
                c[j] = 1;
            else
                c[j] = 0;
        
        
        return new Simplex(A, b, c);
        
    }
    
    public static void showAnswer(double answer[]){
    
        JOptionPane.showMessageDialog(null, Arrays.toString(answer), "Answer",
                JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
