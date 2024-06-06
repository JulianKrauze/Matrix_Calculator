import java.util.ArrayList;
/**
 * Stores the data of a m*n rows by columns matrix. Methods are
 *
 * By Julian
 * version 5/23/2024
 */
public class Matrix
{
    private double[][] matrix;
    private String matrixName;
    public Matrix(int Rows, int Columns, String name){
        matrixName = name;
        if(Rows != 0 && Columns != 0){
             matrix = new double[Rows][Columns];
        }
        else{
            matrix = new double[1][1];
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j ++){
                setValue(i, j, 0);
            }
        }
    }
    
    public void setValue(int row, int column, double value){
        if(row < matrix.length  && column < matrix[0].length){
            matrix[row][column] = value;
        }
    }

    public void changeName(String newName){
        matrixName = newName;
    }
    
    public void printMatrix(){
        int longest = getLargestNumLength();
        String forward = matrixName + "=  ";
        for(int i = 0; i < matrix.length; i++){
            if(i == (int) (matrix.length/2)){
                System.out.print(forward);
            }
            else{
                Functions.printSpaces(forward.length());
            }
            for(int j = 0; j < matrix[0].length; j ++){
                if(matrix[i][j] == (int) matrix[i][j]){
                    System.out.print((int) matrix[i][j] + "  ");
                    Functions.printSpaces(longest - Functions.getNumLength((int) matrix[i][j]));
                }
                else{
                    System.out.print(matrix[i][j] + "  ");
                    Functions.printSpaces(longest - Functions.getNumLength(matrix[i][j]));
                }
            }
            System.out.print("\n");
        }
    }
    
    public static Matrix multiplyMatrix(Matrix matrixOne, Matrix matrixTwo){
        Matrix output = new Matrix(matrixOne.getRows(), matrixTwo.getCols(), "output");
        double value = 0;
        if(matrixOne.getCols() != matrixTwo.getRows()){
            return null;
        }
        else{
            for(int i = 0; i < output.getRows(); i++){
                for(int j = 0; j < output.getCols(); j++){
                    value = 0;
                    //m1 row times m2col
                    for(int k = 0; k < matrixOne.getCols(); k++){
                        value += matrixOne.getValue(i, k) * matrixTwo.getValue(k, j);
                    }
                    output.setValue(i, j, value);
                }
            }
            return output;
        }
    }
    
    private int getLargestNumLength(){
        int out = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(out < Functions.getNumLength(matrix[i][j])){
                    out = Functions.getNumLength(matrix[i][j]);
                }
            }
        }
        return out;
    }
    
    public int getRows(){
        return matrix.length;
    }
    
    public int getCols(){
        return matrix[0].length;
    }
    
    public double getValue(int row, int column){
        return matrix[row][column];
    }
    
    public double[][] getMatrix(){
        return matrix;
    }
    
    public String getName(){
        return matrixName;
    }
}
