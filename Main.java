
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package matrixsimplesalgorithm;

/**
 *
 * @author bassem
 **/

//import java.util.InputMismatchException;
import java.util.*;
import java.awt.*;
import java.applet.*;
import sun.misc.ConditionLock;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Input_Value input_value = new Input_Value();
        boolean continueloop = true; //determines if more input is neded
        Scanner scanner = new Scanner(System.in);

        do
        {

         System.out.println("please enter the type of targrt equation....");
         System.out.println("when you enter [0] you main Min and when you enter [1] you main Max.... ");
         int  type_of_equation = scanner.nextInt();
        input_value.setNum(type_of_equation);


         System.out.println("please enter the number of variable of equation.....");
         int num_of_var = scanner.nextInt();
         input_value.setNum_of_var(num_of_var);


         System.out.println("please enter the num of limited ....");
         int num_of_lim = scanner.nextInt();
         input_value.setNum_of_lim(num_of_lim);


         float valu_of_var[][] = new float [10][10];
            for (int i = 0; i < num_of_lim+1; i++)
            {
                for (int j = 0; j < num_of_var; j++)
                {
                    if( i == 0)
                    {
                        System.out.print("please enter the value of  variable that fond in target equation..." + "X"  );
                        System.out.println(j+1);
                        valu_of_var[i][j] = scanner.nextInt();
                    }
                    else
                    {
                        System.out.print("please enter the value of  variable..." + "X"  );
                        System.out.println(j+1);
                        valu_of_var[i][j] = scanner.nextInt();
                    }
                }

            }
         input_value.setVal_of_var(valu_of_var );

         float  val_of_const [] = new float [num_of_lim+1];
             for (int i = 0; i < num_of_lim+1; i++)
             {
                 if (i == 0)
                 {
                    System.out.println("please enter the value of  constant...thad found in target eqution" );
                    val_of_const[i] = scanner.nextInt(); 
                 }
                 else
                 {
                    System.out.println("please enter the value of  constant of equation that have a number" + "(" +  i + ")");
                    val_of_const[i] = scanner.nextInt();
                 }
             }

       input_value.setVal_of_const(val_of_const);

       input_value.base_form(valu_of_var);
       input_value.toString();
       input_value.mak_simp_matr(valu_of_var);
       input_value.toString();
       if (input_value.getNum() == 0)
           input_value.do_simp_matr_min(valu_of_var);
       else
           input_value.do_simp_matr_max(valu_of_var);
            
         continueloop = false;
       }while (continueloop);
    }
}
