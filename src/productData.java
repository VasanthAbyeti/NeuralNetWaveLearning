import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class productData {

	
	public void produce(String fileName) throws IOException
	{
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
			
		String[] arr = new String[118];
		String line;
		int i;
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				arr=line.split(",");
				i=1;
				while(i<=107)
				{
					System.out.println(arr[i]+" "+arr[i]+" ");
				}
			}
	}
	
}
