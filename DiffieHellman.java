import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

class DiffieHellman
{
    public static void FindPrimeFactors(HashSet<BigInteger>s,BigInteger phi)
    {
        while(phi.mod(BigInteger.valueOf(2))==BigInteger.valueOf(0))
        {(
            s.add(2);
            phi=phi.divide(BigInteger.valueOf(2));
            System.out.println(2);
        }
        for(BigInteger i= new BigInteger("3");i.compareTo(phi.sqrt())<=0;i=i.add(BigInteger.valueOf(2)))
        {
            while(phi.mod(i)==BigInteger.valueOf(0))
            {
                s.add(i);
                System.out.println(i);
                phi=phi.divide(i);
            }
        }

        if(phi.compareTo(2)>=1)
        {
            s.add(phi);
            System.out.println(phi);
        }
    }
    public static BigInteger FindPrimitive(BigInteger p)
    {
        BigInteger phi=p.subtract(BigInteger.ONE);
        HashSet <BigInteger> s = new HashSet<BigInteger>();
        FindPrimeFactors(s,phi);
    }
    public static void main(String[] args)
    {
        int i=0;
        Random rand = new Random();
        BigInteger p,phi;
        p=BigInteger.probablePrime(50,rand);
        System.out.println("P:"+p);

        BigInteger alpha=FindPrimitive(p);
    }
}