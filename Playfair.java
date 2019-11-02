import java.util.Scanner;
import java.util.Arrays;

class Playfair
{
	static char[] letter={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
	static char[][] pmatrix=new char[5][5];

    public static void createMatrix(char[] keys)
    {
    	int j=0,k=0;
    	for(int i=0;i<keys.length;i++)//filling keyword in matrix
    	{
    		if(k!=5)
    		{
    			if(!check(keys[i]))
    			{
    				pmatrix[j][k++]=keys[i];
    			}
    		}
    		else
    		{
    			i--;
    			k=0;
    			j++;
    		}
    	}

    	for(int i=0;i<letter.length;i++)//filling remaining alphabets in matrix
    	{
    		if(k!=5)
    		{
    			if(!check(letter[i]))
    			{
    				pmatrix[j][k++]=letter[i];
    			}
    		}
    		else
    		{
    			i--;
    			k=0;
    			j++;
    		}
    	}
    }

    public static boolean check(char c)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(c==pmatrix[i][j])
    			{
    				return true;
    			}
    		}
        }
        return false;
    }

    public static void printMatrix()
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			System.out.print(pmatrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    }

    public static int findrow(char c)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(pmatrix[i][j]==c)
    			{
    				return i;
    			}
    		}
    	}
    	return -1;
    }

    public static int findcolumn(char c)
    {
    	for(int i=0;i<5;i++)
    	{
    		for(int j=0;j<5;j++)
    		{
    			if(pmatrix[i][j]==c)
    			{
    				return j;
    			}
    		}
    	}
    	return -1;
    }

    public static String encrypt(String pairs)
    {
    	char a=pairs.charAt(0);
    	char b=pairs.charAt(1);
    	String ciphert="";
    	int r1,r2,c1,c2;
    	r1=findrow(a);
    	c1=findcolumn(a);
    	r2=findrow(b);
    	c2=findcolumn(b);
    	//if present in same column
    	if(c1==c2)
    	{
    		++r1;
    		++r2;
    		if(r1>4)
    			r1=0;
    		if(r2>4)
    			r2=0;
    		ciphert+=pmatrix[r1][c2];
    		ciphert+=pmatrix[r2][c1];
    	}
    	//if present in same row
    	else if(r1==r2)
    	{
    		++c1;
    		++c2;
    		if(c1>4)
    			c1=0;
    		if(c2>4)
    			c2=0;
    		ciphert+=pmatrix[r1][c1];
    		ciphert+=pmatrix[r2][c2];
    	}
    	else
    	{
    		ciphert+=pmatrix[r1][c2];
    		ciphert+=pmatrix[r2][c1];
    	}
    	System.out.print(ciphert+" ");
    	return ciphert;
    }

     public static void decrypt(String pairs)
    {
    	char a=pairs.charAt(0);
    	char b=pairs.charAt(1);
    	String plaint="";
    	int r1,r2,c1,c2;
    	r1=findrow(a);
    	c1=findcolumn(a);
    	r2=findrow(b);
    	c2=findcolumn(b);
    	//if present in same column
    	if(c1==c2)
    	{
    		--r1;
    		--r2;
    		if(r1<0)
    			r1=4;
    		if(r2<0)
    			r2=4;
    		plaint+=pmatrix[r1][c2];
    		plaint+=pmatrix[r2][c1];
    	}
    	//if present in same row
    	else if(r1==r2)
    	{
    		--c1;
    		--c2;
    		if(c1<0)
    			c1=4;
    		if(c2<0)
    			c2=4;
    		plaint+=pmatrix[r1][c1];
    		plaint+=pmatrix[r2][c2];
    	}
    	else
    	{
    		plaint+=pmatrix[r1][c2];
    		plaint+=pmatrix[r2][c1];
    	}
    	System.out.print(plaint+" ");
    }

    public static void digram(String str)
    {
    	String st=str.toUpperCase();
    	int len=st.length();
    	if(st.length()%2!=0)
    	{
    		st=st.concat("X");
    		++len;
    	}
    	String dg="";
    	for(int i=0;i<len-1;i=i+2)
    	{
    		dg+=st.substring(i,i+2);
    		dg+=" ";
    	}
    	System.out.println("DIGRAMS    : "+dg);
    	String en="";
    	System.out.print("ENCRYPTION : ");
    	for(int k=0;k<len-1;k=k+2)
    	{
    		en+=encrypt(st.substring(k,k+2));
    	}
    	System.out.println("");
    	System.out.print("DECRYPTION : ");
    	for(int k=0;k<len-1;k=k+2)
    	{
    		decrypt(en.substring(k,k+2));
    	}
    }

    public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a keyword :");
		String key = scanner.nextLine();
		char[] keystr=key.toUpperCase().toCharArray();
		System.out.println("KEY STRING:"+Arrays.toString(keystr));
		createMatrix(keystr);
		System.out.println("PLAYFAIR MATRIX :");
		System.out.println("------------------------------");
		printMatrix();
		System.out.println("------------------------------");
		String plain;
		System.out.println("Enter a Plain Text :");
		plain = scanner.nextLine();
		digram(plain);
    }
}