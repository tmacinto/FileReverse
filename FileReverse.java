//Tyler MacIntosh, tmacinto, 12m, 1/25/18
//FileReverse.java
//copies the characters from input file onto output file in reverse
import java.io.*;
import java.util.Scanner;

class FileReverse {

        public static String stringReverse(String s, int n) {
                if(n <= 1){
                        return s;
                }else{
                        return stringReverse((s.substring(1)+ s.charAt(0)), n-1);
                }
        }
        public static void main(String[] args) throws IOException{

                Scanner in = null;
                PrintWriter out = null;
                String line = null;
                String[]  word = null;
                int i, n = 0;

                //check number of command line arguments is at least 2
                if(args.length < 2){
                        System.out.println("Usage: FileReverse <input file> <output file>");
                        System.exit(1);
                }

                //open files
                in = new Scanner(new File(args[0]));
                out = new PrintWriter(new FileWriter(args[1]));

                //read lines from  in, extract tokens (words)
                while( in.hasNextLine() ) {

                        //trim  leading and trailing spaces, then add one trailing space so
                        //split works on blank lines

                        line = in.nextLine().trim() + " ";

                        //split line around white space
                        word = line.split("\\s+");

                        n = word.length;
                        for(i=0; i<n; i++) {
                                int letters = word[i].length();
                                out.println(stringReverse(word[i], letters));
                        }
                }

                //close files
                in.close();
                out.close();
        }
}
