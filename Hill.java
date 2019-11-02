import java.util.Scanner;
import java.lang.Math;

class Hill
{
	static int[][] keymatrix;
	static int[][] stringmatrix;

    public static int[][] keyMatrix(String ks,int in)
    {
    	keymatrix=new int[in][in];
    	int l=ks.length();
    	int j=0;
    	int[] val=new int[l];
    	for(int i=0;i<l;i++)
    	{
			val[j++]=(ks.charAt(i)- 97) % 26;
		}
    	j=0;
    	for(int x=0;x<in;x++)
    	{
    		for(int y=0;y<in;y++)
    		{
    			keymatrix[x][y]=val[j++];
    		}
    	}
    	System.out.println("KEY MATRIX : ");
    	for(int x=0;x<in;x++)
    	{
    		for(int y=0;y<in;y++)
    		{
    			System.out.print(keymatrix[x][y]+"  ");
    		}
    		System.out.println();
    	}
        return keymatrix;
    }

     public static int[][] stringMatrix(String s,int in)
    {
    	stringmatrix=new int[in][1];
    	int l=s.length();
    	int j=0;
    	int[] val=new int[l];
    	for(int i=0;i<l;i++)
    	{
			val[j++]=(s.charAt(i)- 97) % 26;
		}
    	j=0;
    	for(int x=0;x<in;x++)
    	{
    		for(int y=0;y<1;y++)
    		{
    			stringmatrix[x][y]=val[j++];
    		}
    	}
        return stringmatrix;
    }

    public static int[][] multiplication(int[][] a,int[][] b,int in)
    {
    	int[][] mul=new int[in][1];
    	for(int i=0;i<in;i++)
    	{    
			for(int j=0;j<1;j++)
			{    
 				mul[i][j]=0;      
				for(int k=0;k<in;k++)      
				{      
					mul[i][j]=(mul[i][j]+a[i][k]*b[k][j])%26;
				}
			}
		}
        return mul;
    }

    public  static String encrypt(int[][] mul,int in)
    {
    	String enc="";
    	for(int x=0;x<in;x++)
    	{
    		for(int y=0;y<1;y++)
    		{
    	    	enc+=(char)(mul[x][y]+97);
    	    }
    	}
    	//System.out.println(enc);
    	return enc;
    }

    public static int[][] inverse(int m[][],int in)
    {
        int det =  ((m[0][0]* (m[1][1]*m[2][2] - m[2][1]*m[1][2]))
                              - (m[0][1]*(m[1][0]*m[2][2] - m[2][0]*m[1][2]))
                              + (m[0][2]*(m[1][0]*m[2][1] - m[2][0]*m[1][1]))) %26;

        if(det<0)
        {
            det =det + 26;
        }
        System.out.println("Determinant : " + det);
        int detInv;
        for(detInv=1;detInv<25;detInv+=2)
        {
            if((det*detInv)%26 == 1)
                break;
        }

        System.out.println("Determinant Inverse : "+detInv);

        int inv[][] = new int[in][in];

        System.out.println("Inverse of the matrix");
        for(int i = 0; i < in; ++i) 
        {
            for(int j = 0; j < in; ++j)
            {
                inv[i][j] = ((((m[(j+1)%3][(i+1)%3] * m[(j+2)%3][(i+2)%3]) - (m[(j+1)%3][(i+2)%3] * m[(j+2)%3][(i+1)%3]))*detInv)%26);
                if(inv[i][j]<0)
                {
                    inv[i][j]+=26;
                }
            }
        }
        for(int x=0;x<in;x++)
        {
            for(int y=0;y<in;y++)
            {
                System.out.print(inv[x][y]+"  ");
            }
            System.out.println();
        }
        return inv;
    }
    
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		String str;
		System.out.println("Enter a string :");
		str=scanner.nextLine();
		String key;
        System.out.println("Enter a keyword : ");
        key=scanner.nextLine();
        double len=key.length();
        int index=(int)Math.sqrt(len);
        System.out.println(index);
        int km[][];
        km=keyMatrix(key,index);
        int sm[][];
        int mul[][];
        String en="";
        int l=str.length();
        for(int i=0;i<l-1;i=i+index)
        {
        	sm=stringMatrix(str.substring(i,i+index),index);
        	mul=multiplication(km,sm,index);
    		en+=encrypt(mul,index);
    	}
    	System.out.println("ENCRYPTION : "+en);
        int inv[][];
        int dm[][];
        String de="";
        inv=inverse(km,index);
        for(int i=0;i<l-1;i=i+index)
        {
            dm=stringMatrix(en.substring(i,i+index),index);
            mul=multiplication(inv,dm,index);
            de+=encrypt(mul,index);
        }
        System.out.println("DECRYPTION : "+de);
	}
}