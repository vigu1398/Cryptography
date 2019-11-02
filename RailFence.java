import java.util.Scanner;

public class RailFence
{
    public static String Encrypt(int key,String plainText)
    {

        char mat[][] = new char[key][plainText.length()];
        int itr=0;
        String cipherText="";
        for(int j=0;j<plainText.length();j++)
        {
            if(itr==plainText.length())
            {
                break;
            }
            for(int i=0;i<key;i++)
            {
                mat[i][j]=plainText.charAt(itr++);
            }
        }
    
        for(int i=0;i<key;i++)
        {
            for(int j=0;j<plainText.length();j++)
            {
                cipherText+=mat[i][j];
            }
        }
        return cipherText;
    }

    public static void main(String[] args)
    {
        Scanner scanner1=new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        System.out.println("Enter Key:");
        int key = scanner1.nextInt();
        System.out.println("Enter PlainText:");
        String plainText = scanner2.nextLine();

        String cipherText=Encrypt(key,plainText);
        System.out.println("Cipher Text:"+cipherText);
    }
}