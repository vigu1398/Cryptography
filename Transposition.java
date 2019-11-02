import java.util.Scanner;
import java.util.HashMap;

class Transposition
{
    public static Integer FindMax(int keyArray[],int coloumn)
    {
        int min=-2,pos=-1;
        for(int i=0;i<coloumn;i++)
        {
            if(keyArray[i]>min)
            {
                min=keyArray[i];
                pos=i;
            }
        }
        keyArray[pos]=-1;
        return pos;
    }

    public static void PrintCipher(char matrix[][],int rows,int pos)
    {

        for(int i=0;i<rows;i++)
        {
            System.out.println(matrix[i][pos]);
        }
    }
    
    public static String Encrypt(int keyArray[],char matrix[][],String plainText,int rows,int coloumn)
    {
        String cipherText="";
        int itr=0,temp1,temp2,pos;X

        int index[] = new int[coloumn];

        System.out.println("String Matrix");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<coloumn;j++)
            {
                if(itr<plainText.length())
                {
                    matrix[i][j]=plainText.charAt(itr);
                    itr++;
                }
                else
                {
                    matrix[i][j]='X';
                }
            }
        }

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<coloumn;j++)
            {
                System.out.println(matrix[i][j]);
            }
        }

        for(int j=0;j<coloumn;j++)
        {
            pos=FindMax(keyArray,coloumn);
            PrintCipher(matrix,rows,pos);
        }
        return cipherText;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Keys:");
        String key = scanner.nextLine();
        System.out.println("Enter the Text:");
        String plainText = scanner.nextLine();
        int keyArray[] = new int[key.length()];
        int rows;

        for(int i=0;i<key.length();i++)
        {
            keyArray[i]=key.charAt(i)-'0';
        }
        for(int i=0;i<key.length();i++)
        {
            System.out.print(" "+keyArray[i]);
        }
        if(plainText.length()%key.length()==0)
            rows=plainText.length()/key.length();
        else
            rows=plainText.length()/key.length()+1;
        
        char matrix[][] = new char[rows][key.length()];
        
        String cipherText=Encrypt(keyArray,matrix,plainText,rows,key.length());
        System.out.println("Cipher Text:"+cipherText);

    }
}