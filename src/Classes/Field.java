package Classes;

import java.lang.reflect.Array;
import java.sql.SQLOutput;

public class Field {

    public void DrawField(int [][]battlefield)
    {
        System.out.println("    A B C D E F G H I J K L M N O P");
        for(int i = 0; i<=15 ;i++)
        {
            if(i<10)
            {
                System.out.print(i+"   ");
            }
            else {
                System.out.print(i + "  ");
            }
            for (int j = 0; j <battlefield[1].length; j++) {
                if(battlefield[j][i]==0)
                {
                    System.out.print("- ");
                }
                if(battlefield[j][i]==1)
                {
                    System.out.print("+ ");
                }
                if(battlefield[j][i]==2)
                {
                    System.out.print("! ");
                }
                if(battlefield[j][i]==3)
                {
                    System.out.print("x ");
                }

            }
            System.out.println();
        }
    }
    public void DrawEnemyField(int [][]EnemyField)
    {
        System.out.println("    A B C D E F G H I J K L M N O P");
        for(int i = 0; i<=15 ;i++)
        {
            if(i<10)
            {
                System.out.print(i+"   ");
            }
            else {
                System.out.print(i + "  ");
            }
            for (int j = 0; j <EnemyField[1].length; j++) {
                if(EnemyField[j][i]==0)
                {
                    System.out.print("- ");
                }
                if(EnemyField[j][i]==1)
                {
                    System.out.print("! ");
                }
                if(EnemyField[j][i]==2)
                {
                    System.out.print("x ");
                }

            }
            System.out.println();
        }
    }
}
