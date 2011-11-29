/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package matrixsimplesalgorithm;

/**
 *
 * @author bassem
 */
import java.util.*;
import java.awt.*;
import java.applet.*;
import sun.java2d.pipe.ValidatePipe;

public class Input_Value {

    private int  num; //this number is one or tow that main one is Max and tow is Min .
    private int num_of_var;//number of variable.
    private int num_of_lim;//number of limitation.
    private float [][] val_of_var  = new float [10][10];//this maatrix content the value of variable
    private float [] val_of_const  = new float [10];//this matrix content the value of the right hand
    private float [][] mat_simp_val = new  float [10][10];//this matrix content the value the base form
    private  float [][] reference = new float [10][10];//this matrix used to work
    private int [] solution = new int [10];

    public Input_Value() {
    }

    public Input_Value(int num) {
        this.setNum(num);
    }

    public Input_Value(int num, int num_of_var) {
        this.setNum(num);
        this.setNum_of_var(num_of_var);
    }

    public Input_Value(int num, int num_of_var, int num_of_lim) {
        this.setNum(num);
        this.setNum_of_var(num_of_var);
        this.setNum_of_lim(num_of_lim);
    }

    public void setNum(int num) {
        this.num = (num >=0 || num <=1)? num : 2;
    }

    public void setNum_of_lim(int num_of_lim) {
        this.num_of_lim = (num_of_lim > 0 && num_of_lim < 10) ? num_of_lim : 0 ;
    }

    public void setNum_of_var(int num_of_var) {
        this.num_of_var =  (num_of_var > 0 && num_of_var < 10) ? num_of_var:0;
    }

    public void setVal_of_const(float [] val_of_const)  {

        for (int i = 0; i < num_of_lim+1; i++)
            {
              if (val_of_const [i] < 0)
                 {
                     System.err.print("this values that you input is wrong  ");
                 }
              else
                      this.val_of_const = val_of_const;
            }
        
    }

    public void setVal_of_var(float [][] val_of_var)  {
        this.val_of_var = val_of_var;
    }

    public float[][] getMat_simp_val() {
        return mat_simp_val;
    }

    public void setSolution(int[] solution) {
        this.solution = solution;
    }

    public int getNum() {
        return num;
    }

    public int getNum_of_lim() {
        return num_of_lim;
    }

    public int getNum_of_var() {
        return num_of_var;
    }

    public float[][] getReference() {
        return reference;
    }

    public float[] getVal_of_const() {
        return val_of_const;
    }

    public float[][] getVal_of_var() {
        return val_of_var;
    }



    public void base_form (float [][] val_of_var) //this method make the base form
    {
        for (int i = 0; i < num_of_lim+1; i++)
          {
              for (int j = 1; j < num_of_var; j++)

                      this.val_of_var [i][j] = val_of_var[i][j];

          }

        for (int i = 0; i < num_of_lim+1; i++)
          {
              for (int j = num_of_lim; j < 2*num_of_var; j++)
              {
                  if (i == 0)

                      this.val_of_var [i][j] = 0 ;

                  else
                  {
                       if (i+num_of_lim -1 == j)
                          this.val_of_var [i][j] = 1;
                       else
                          this.val_of_var[i][j] = 0;
                  }
              }
          }
        this.reference = val_of_var;
    }


    public void mak_simp_matr (float [][] val_of_var) //this method make the base form
    {
        float [][] A = new float [10][10] ;
        for (int i = 0; i < num_of_lim+1; i++)
          {
              for (int j = 1; j < 2*num_of_var; j++)
              {
                  if (i == 0)

                      A [i][j] = -1*val_of_var[i][j-1];

                  else

                      A [i][j] = val_of_var[i][j-1];
              }

          }
        for (int i = 0; i < num_of_lim+1; i++)
        {

            if (i == 0)
                A [i][i] = 1;
            else
                A [i][0] = 0;
        }



        for (int i = 0; i < num_of_lim+1; i++)
          {
              for (int j = num_of_lim+1; j < 2*num_of_var+1; j++)
              {
                  if (i == 0)

                      A [i][j] = 0 ;

                  else
                  {
                       if (i+num_of_lim  == j)
                          A [i][j] = 1;
                       else
                           A [i][j] = 0;
                  }
              }
          }
         for (int i = 0; i < num_of_lim; i++) {
            solution [i] = num_of_lim+i;

        }
        this.val_of_var = A;
    }

    public int maximom (float [][] val_of_var)
    {
        float max = 0 ;
        int index = 0;
         for (int i = 1; i < num_of_lim; i++)
         {
            if (max > val_of_var[0][i])
            {
                max = val_of_var[0][i];
                index = i;
            }
         }

     return index;
    }
     public int minmom (float [][] val_of_var)
    {
        float min = 0 ;
        int index = 0;
         for (int i = 1; i < num_of_lim; i++)
         {
            if (min < val_of_var[0][i])
            {
                min = val_of_var[0][i];
                index = i;
            }
         }

     return index;
    }

//when the target equation is Min
     public void do_simp_matr_min(float [][] val_of_var)
     {
             if ( this.minmom(val_of_var) == 0 )
             {
                 System.out.println("We don't do any thing for the matrix Because we access to finshed solution");
                for (int i = 0; i < num_of_lim+1; i++)
                  System.out.println( "X"+ solution[i] +" = " + val_of_const[i+1] );
             }
             else
             {
                 int index = 0;
                 for (int i = 1; i < num_of_lim; i++)
                 {
                     float resolt = val_of_const[i] / val_of_var[i][this.minmom(val_of_var)];
                     float smoll = 1000 ;
                     
                     smoll = (resolt > 0 && resolt < smoll ? resolt:0 );
                     index = i;//row anchor

                 }
                     solution[index-1] = this.minmom(val_of_var);
                     if (val_of_var[index][this.minmom(val_of_var)] <= 0   )
                        System.out.println("We don't do any thing for the matrix Because we have solution isn't limet ");
                     else
                     {
                         float val_anchor = this.val_of_var[index][this.minmom(this.val_of_var)];

                         for (int j = 0; j < 2*num_of_lim + 1; j++)
                         {
                             val_of_var[index][j] = val_of_var[index][j] /val_anchor;

                         }
                         val_of_const [index] = val_of_const [index] / val_anchor;
                     }

                 for (int i = index-1; i >= 0; i--)
                 {
                     float value = val_of_var[i][this.minmom(val_of_var)];
                     if (value == 0)
                         continue;
                     else
                     {
                        if (value > 0)
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] = -1 * value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =-1 * value * val_of_const [index] + val_of_const[i];
                            }

                        }
                        else
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] =  value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =  value * val_of_const [index] + val_of_const[i];
                            }
                        }
                     }
                 }
                 for (int i = index+1 ;i < num_of_lim+1 ;i++)
                 {
                   float value = val_of_var[i][this.minmom(val_of_var)];
                     if (value == 0)
                         continue;
                     else
                     {
                        if (value > 0)
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] = -1 * value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =-1 * value * val_of_const [index] + val_of_const[i];
                            }

                        }
                        else
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] =  value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =  value * val_of_const [index] + val_of_const[i];
                            }
                        }
                     }

                 }

             }
        //do_simp_matr_min(val_of_var);
          
     }


     ////when the target equation is Max
     public void do_simp_matr_max(float [][] val_of_var)
     {

             if ( this.maximom(val_of_var) == 0 )
             {
                System.out.println("We don't do any thing for the matrix Because we access to finshed solution");
                for (int i = 0; i < num_of_lim+1; i++)
                        System.out.println( "X"+ solution[i] +" = " + val_of_const[i+1] );
             }

             else
             {
                 int index = 0;
                 for (int i = 1; i < num_of_lim; i++)
                 {
                     float resolt = val_of_const[i] / val_of_var[i][this.minmom(val_of_var)];
                     float smoll = 1000 ;

                     smoll = (resolt > 0 && resolt < smoll ? resolt:0 );
                     index = i;//row anchor

                 }
                     solution[index-1] = this.minmom(val_of_var);
                     if (val_of_var[index][this.minmom(val_of_var)] <= 0  )
                        System.out.println("We don't do any thing for the matrix Because we have solution isn't limet ");
                     else
                     {
                         float val_anchor = this.val_of_var[index][this.minmom(this.val_of_var)];

                         for (int j = 0; j < 2*num_of_lim + 1; j++)
                         {
                             val_of_var[index][j] = val_of_var[index][j] /val_anchor;

                         }
                         val_of_const [index] = val_of_const [index] / val_anchor;
                     }

                 for (int i = index-1; i >= 0; i--)
                 {
                     float value = val_of_var[i][this.minmom(val_of_var)];
                     if (value == 0)
                         continue;
                     else
                     {
                        if (value > 0)
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] = -1 * value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =-1 * value * val_of_const [index] + val_of_const[i];
                            }

                        }
                        else
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] =  value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =  value * val_of_const [index] + val_of_const[i];
                            }
                        }
                     }
                 }
                 for (int i = index+1 ;i < num_of_lim+1 ;i++)
                 {
                   float value = val_of_var[i][this.minmom(val_of_var)];
                     if (value == 0)
                         continue;
                     else
                     {
                        if (value > 0)
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] = -1 * value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =-1 * value * val_of_const [index] + val_of_const[i];
                            }

                        }
                        else
                        {
                            for (int j = 0; j < 2*num_of_lim+1; j++)
                            {
                                val_of_var[i][j] =  value * val_of_var[index][j] + val_of_var[i][j];
                                val_of_const [i] =  value * val_of_const [index] + val_of_const[i];
                            }
                        }
                     }

                 }

             }
    // do_simp_matr_max(val_of_var);

     }

    @Override
    public String toString()
    {
        for (int i = 0; i < num_of_lim +1; i++)
        {
            for (int j = 0; j < 2*num_of_lim+1; j++)
            {
            System.out.print(this.val_of_var[i][j] + "  ");

            }
            System.out.println();


        }
        return "";
    }


}
