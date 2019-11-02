import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

public class RSA
{
    public static void main(String[] args)
    {
        int val;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message:");
        String plainText=scanner.nextLine();

        String message="";
        for(int i=0;i<plainText.length();i++)
        {
            val = ((int)plainText.charAt(i)-22);
            message+=val;
        }

        System.out.println("Message:"+message);

        BigInteger p,q,n,phi,e,d;
        String decrypt="";
        Random rand = new Random();
        p=BigInteger.probablePrime(2048,rand);
        q=p.nextProbablePrime();
        n=p.multiply(q);
        phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e=BigInteger.probablePrime(1024,rand);
        while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
        {
            e.add(BigInteger.ONE);
        }
        d=e.modInverse(phi);

        BigInteger m = new BigInteger(message);
        BigInteger cipherText = m.modPow(e,n);
        BigInteger decipheredMessage=cipherText.modPow(d,n);
        String str = decipheredMessage.toString();

        for(int i=0;i<str.length();i+=2)
        {
            int num = Integer.parseInt(str.substring(i,i+2));
            decrypt+=(char)(num+22);
        }

        
        System.out.println("P:"+p);
        System.out.println("Q:"+q);
        System.out.println("N:"+n);
        System.out.println("Phi:"+phi);
        System.out.println("E:"+e);
        System.out.println("D:"+d);
        System.out.println("CipherText:"+cipherText);
        System.out.println("Deciphered Message:"+decipheredMessage);
        System.out.println("Deciphered Text:"+decrypt);
    }
}