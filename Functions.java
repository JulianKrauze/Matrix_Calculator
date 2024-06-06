
/**
 * Contains Helper Functions
 *
 * By Julian
 * version 5/23/2024
 */
public class Functions
{
    public static int getNumLength(double num){
        String text = "";
        if(num == (int) num){
            text = Double.toString(num);
            return text.length()-2;
        }
        else{
            text = Double.toString(num);
            return text.length();
        }
    }
    
    public static void printSpaces(int spaces){
        for(int i = 0; i < spaces; i ++){
            System.out.print(" ");
        }
    }
}
