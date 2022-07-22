
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Backend 
{
    static public String merge(File f1,File f2)
    {
        try 
        {
            List<String> listOfStrings= new ArrayList<String>();


            FileReader fr= new FileReader(f1);
			BufferedReader br= new BufferedReader(fr);
			
			 
			 String line= br.readLine();
			 
		
			 while (line!=null)
			 {
				 listOfStrings.add(line);
				 line=br.readLine();
			 }

             br.close();
			 fr.close();

             listOfStrings.add("\n");

            FileReader fr2= new FileReader(f2);
			BufferedReader br2= new BufferedReader(fr2);
			
			 
			 String line2= br2.readLine();
			 
		
			 while (line2!=null)
			 {
				 listOfStrings.add(line2);
				 line2=br2.readLine();
			 }

             br2.close();
			 fr2.close();

            //  LocalTime lTime= LocalTime.now();
            //  LocalDate lDate= LocalDate.now();
 
             String f3= "file"+f1.getName()+f2.getName()+".txt";
 
 
             File myObj = new File(f3);
             if (myObj.createNewFile()) 
             {
                 System.out.println("File created: " + myObj.getName());
            


                FileWriter fw= new FileWriter(f3,true);
                BufferedWriter bw= new BufferedWriter(fw);

                for(String str: listOfStrings)
                {
                    bw.write(str);
                }
			 
                bw.close();
                fw.close();

                System.out.println(f3);

                return f3;

            } 
            else 
            {
                System.out.println("File already exists");
                return "Error File already exists";
            }

        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    static public int countChar (File f1)
    {
        try 
        {
            String s1="";


            FileReader fr= new FileReader(f1);
			BufferedReader br= new BufferedReader(fr);
			
			 
			 String line= br.readLine();
			 
		
			 while (line!=null)
			 {
				 s1=s1+line;
				 line=br.readLine();
			 }

             br.close();
			 fr.close();

             int c1=s1.length();

             return c1;

        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    static public int compareFiles (File f1,File f2)
    {
        try 
        {
            String s1="";


            FileReader fr= new FileReader(f1);
			BufferedReader br= new BufferedReader(fr);
			
			 
			 String line= br.readLine();
			 
		
			 while (line!=null)
			 {
				 s1=s1+line;
				 line=br.readLine();
			 }

             br.close();
			 fr.close();

             int c1=s1.length();

             String s2="";

            FileReader fr2= new FileReader(f2);
			BufferedReader br2= new BufferedReader(fr2);
			
			 
			 String line2= br2.readLine();
			 
		
			 while (line2!=null)
			 {
				 s2=s2+line2;
				 line2=br2.readLine();
			 }

             br2.close();
			 fr2.close();

             int c2=s2.length();

             return lcs(s1.toCharArray(), s2.toCharArray(), c1, c2);

        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

        static int lcs( char[] X, char[] Y, int m, int n )
        {
            if (m == 0 || n == 0)
            return 0;
            if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
            else
            return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
        }
 
        
        static int max(int a, int b)
        {
            return (a > b)? a : b;
        }
}
