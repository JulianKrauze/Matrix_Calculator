import java.util.ArrayList;
import java.util.Scanner;
/**
 *Main Class
 *
 * By Julian
 * version 5/23/2024
 */
public class Main
{

    public static void main(){
        //Variables go here
        //Stores all matrices
        ArrayList<Matrix> allMatrices = new ArrayList<Matrix>();
        //used to control main loop, program terminates if flase
        boolean running = true;
        //used when a string needs to temporarily be stored
        String tempString = "";
        //used to temporarily store two int's
        int[] tempInt = new int[2];
        //used to temporarily store a boolean
        boolean tempBool = true;
        //Scanner used for getting user info and input stores it
        Scanner s = new Scanner(System.in);
        String input = "";
        
        allMatrices.add( new SquareMatrix(3,"x"));
        allMatrices.get(0).setValue(0,0, 1);
        allMatrices.get(0).setValue(1,0, 2);
        allMatrices.get(0).setValue(0,1, 3);
        allMatrices.get(0).setValue(1,1, 4);
        allMatrices.get(0).setValue(2,2, 4);

        //Prints all members of allMatrices
        clearScreen();
        for(int i = 0; i < allMatrices.size(); i++){
            allMatrices.get(i).printMatrix();
        }
            
        while(running){
            //Put code that depends on user input under here
            //Gets user input and stores it in input
            input = s.next();
            //Put code that depends on user input under here
            //sets running to false terminating the program if quit is inputed
            if(input.equals("quit") || input.equals("Quit") ||input.equals("q") || input.equals("Q")){
                running = false;
            }
            
            //allows the user to create a new matrix and add it to allMatrices
            else if(input.equals("create")){
                clearScreen();
                System.out.println("What would you like to name your new matrix.\nThe name should consist only of lowercase letter with no spaces.");
                tempString = s.next();
                System.out.println("How many rows would you like your new matrix to have.");
                tempInt[0] = Integer.parseInt(s.next());
                System.out.println("How many columns would you like your new matrix to have.");
                tempInt[1] = Integer.parseInt(s.next());
                if(tempInt[0] == tempInt[1]){
                    allMatrices.add(new SquareMatrix(tempInt[0], tempString));
                }
                else{
                    allMatrices.add(new Matrix(tempInt[0], tempInt[1], tempString));
                }
                System.out.println("Would you like to set the values of your new matrix.\nIf you do not all locations will be set to zero by default.");
                input = s.next();
                if(input.equals("Yes") || input.equals("yes") || input.equals("y") || input.equals("Y")){
                    for(int i = 0; i < allMatrices.get(allMatrices.size()-1).getRows(); i++){
                        for(int j = 0; j < allMatrices.get(allMatrices.size()-1).getCols(); j++){
                            clearScreen();
                            System.out.println("Please imput a value for location " + i + " " + j + " of the matrix.");
                            allMatrices.get(allMatrices.size()-1).printMatrix();
                            allMatrices.get(allMatrices.size()-1).setValue(i, j, Double.parseDouble(s.next()));
                        }
                    }
                    clearScreen();
                    for(int i = 0; i < allMatrices.size()-1; i++){
                        allMatrices.get(i).printMatrix();
                    }
                    System.out.println("\nHere is the matrix you just created.");
                    allMatrices.get(allMatrices.size()-1).printMatrix();
                }
                else{
                    clearScreen();
                    for(int i = 0; i < allMatrices.size()-1; i++){
                        allMatrices.get(i).printMatrix();
                    }
                    System.out.println("\nHere is the matrix you just created.");
                    allMatrices.get(allMatrices.size()-1).printMatrix();
                }
            }
            
            //Multplies Matricies
            else if(input.equals("multiply")){
                while(tempBool && allMatrices.size() != 0){
                    System.out.println("Please enter the name of the first matrix you want to multiply.");
                    tempString = s.next();
                    for(int i = 0; i < allMatrices.size(); i++){
                        if(allMatrices.get(i).getName().equals(tempString)){
                            tempInt[0] = i;
                            tempBool = false;
                        }
                    }
                    if(tempBool){
                        System.out.println("Please enter the name of a matrix shown on the display.");
                    }
                }
                tempBool = true;
                while(tempBool && allMatrices.size() != 0){
                    System.out.println("Please enter the name of the second matrix you want to multiply.");
                    tempString = s.next();
                    for(int i = 0; i < allMatrices.size(); i++){
                        if(allMatrices.get(i).getName().equals(tempString)){
                            tempInt[1] = i;
                            tempBool = false;
                        }
                    }
                    if(tempBool){
                        System.out.println("Please enter the name of a matrix shown on the display.");
                    }
                }
                //Multiply matrix function works
                //give user option to save
                Matrix.multiplyMatrix(allMatrices.get(tempInt[0]), allMatrices.get(tempInt[1])).printMatrix();
            }
            else if(input.equals("determinant") || input.equals("det")){
                while(tempBool && allMatrices.size() != 0){
                    System.out.println("Please enter the name of the square matrix you would like to take the determinant of.");
                    tempString = s.next();
                    for(int i = 0; i < allMatrices.size(); i++){
                        if(allMatrices.get(i).getName().equals(tempString) && allMatrices.get(i) instanceof SquareMatrix){
                            tempInt[0] = i;
                            tempBool = false;
                        }
                    }
                    if(tempBool){
                        System.out.println("Please enter the name of a square matrix shown on the display.");
                    }
                }
                tempBool = true;
                System.out.println(SquareMatrix.determinant((SquareMatrix) allMatrices.get(tempInt[0])));
            }
            else if(input.equals("inverse")){
                System.out.println("inverse");
            }
            else if(input.equals("eigenvalue")){
                System.out.println("eigenvalue");
            }
            else if(input.equals("eigenvector")){
                System.out.println("eigenvector");
            }
        }
    }
    
    //Pre: None
    //Post: Clears the terminal window
    public static void clearScreen(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            System.out.println("An error has occured");
        }
    }
}