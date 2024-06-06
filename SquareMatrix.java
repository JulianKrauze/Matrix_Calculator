
/**
 * Write a description of class SquareMatrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SquareMatrix extends Matrix
{
    private int dimensions;
    public SquareMatrix(int dim, String name){
        super(dim, dim, name);
        dimensions = dim;
    }
    
    public int getDimensions(){
        return dimensions;
    }
    
    public static double determinant(SquareMatrix m){
        double output = 0;
        if(m.getDimensions() == 2){
            output += m.getValue(0, 0)*m.getValue(1, 1) - m.getValue(1, 0)*m.getValue(0, 1);
            return output;
        }
        else{
            //row 0 being used
            int n = 0;
            for(int i = 0; i < m.getDimensions(); i++){
                SquareMatrix mPrime = new SquareMatrix(m.getDimensions()-1, "mPrime");
                double valueList[] = new double[(m.getDimensions()-1)*(m.getDimensions()-1)];
                for(int j = 1; j < m.getDimensions(); j++){
                    for(int k = 0; k < m.getDimensions(); k++){
                        if(k != i){
                            valueList[n] = m.getValue(j, k);
                            n++;
                        }
                    }
                }
                n = 0;
                for(int j = 0; j <m.getDimensions()-1; j++){
                    for(int k = 0; k < m.getDimensions()-1; k++){
                        mPrime.setValue(j, k, valueList[n]);
                        n++;
                    }
                }
                n = 0;
                output += Math.pow(-1, i) * m.getValue(0, i)*SquareMatrix.determinant(mPrime);
            }
            return output;
        }
    }
}
