import java.util.Scanner;

public class Vigenere
{
    public static String GenerateKey(String key,String plainText)
    {
        for(int i=0;;i++)
        {
            if(key.length()==plainText.length())
            {
                break;
            }
            else
            {
                key+=(key.charAt(i));
            }
        }
        return key;
    }

    public static String GenerateCipher(String generatedKey,String plainText)
    {
        String cipherText="";
        for(int i=0;i<plainText.length();i++)
        {
            int val=(generatedKey.charAt(i)+plainText.charAt(i))%26;
            val=val+65;
            cipherText+=(char)val;
        }
        return cipherText;
    }

    public static String Decrypt(String generatedKey,String cipherText)
    {
        String plainText="";
        for(int i=0;i<cipherText.length();i++)
        {
            int val=(cipherText.charAt(i)-generatedKey.charAt(i)+26)%26;
            val+=65;
            plainText+=(char)val;
        }
        return plainText;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Key:");
        String key = scanner.nextLine();
        System.out.println("Enter Plaintext:");
        String plainText = scanner.nextLine();

        String generatedKey = GenerateKey(key,plainText);
        String cipherText= GenerateCipher(generatedKey,plainText);
        plainText= Decrypt(generatedKey,cipherText);
        System.out.println("The generated key is :"+generatedKey);
        System.out.println("The generated cipher is :"+cipherText);
        System.out.println("The generated plaintext is :"+plainText);
    }
}