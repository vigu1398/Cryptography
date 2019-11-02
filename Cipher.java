import java.util.Scanner;

class Cipher
{
	public static String encrypt(String s,int k)
	{
		StringBuilder c = new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			if (Character.isUpperCase(s.charAt(i)))
			{
				char ch=(char)(((int)s.charAt(i) + k - 65) % 26 + 65); 
			    c.append(ch);
			}
			else
			{
				char ch=(char)(((int)s.charAt(i) + k - 97) % 26 + 97); 
			    c.append(ch);
			}	
			
		}
        return c.toString();
	}
	public static String decrypt(String s,int k)
	{
		StringBuilder d = new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			if (Character.isUpperCase(s.charAt(i)))
			{
				char ch=(char)(((int)s.charAt(i) - k - 65) % 26 + 65); 
			    d.append(ch);
			}
			else
			{
				char ch=(char)(((int)s.charAt(i) - k - 97) % 26 + 97); 
			    d.append(ch);
			}	
			
		}
        return d.toString();
	}
	public static void main(String[]args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string :");
		String string = scanner.nextLine();
		int key;
		System.out.println("Enter a key :");
		key = scanner.nextInt();
		String cipherText = encrypt(string,key);
		System.out.println("Cipher Text :"+cipherText);
		String plainText = decrypt(cipherText,key);
		System.out.println("Plain Text :"+plainText);
	}
} 