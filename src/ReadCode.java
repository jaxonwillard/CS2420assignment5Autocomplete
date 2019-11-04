import java.util.Scanner;
import java.io.File;


public class ReadCode {
    public static void main(String[] args) {
        try {
            // initialize leftistHeap, file reader, and console reader objects
            LeftistHeap<Term> h = new LeftistHeap<>();
            String filename = "SortedWords.txt";
            Scanner reader = new Scanner( new File( filename ) );
            int fileLinesCount = reader.nextInt();
            Scanner consoleReader = new Scanner(System.in);

            // insert every line from file into an array
            Term[] termList = new Term[fileLinesCount];
            int index = 0;
            while ((reader.hasNext()))  {
                String word = reader.next();
                long freq = reader.nextInt();
                termList[index] = new Term(word,freq);
                index++;
            }

            // get word input from user
            System.out.print("Substring: ");
            String subString = consoleReader.next();
            System.out.print("Count: ");
            int count = consoleReader.nextInt();

            // iterate through termlist until first target word is found and insert all matching words into leftist heap
            boolean done = false;
            int thisIndex = 0;
            int heapSize = 0;
            while (!done){
                if (thisIndex >= termList.length - 1){
                    System.out.println("couldn't find");
                    done = true;
                }
                else if (termList[thisIndex].word.startsWith(subString)){
                    while(termList[thisIndex].word.startsWith(subString)){
                        h.insert(termList[thisIndex]);
                        heapSize++;
                        thisIndex++;
                    }
                    done = true;
                }
                else {thisIndex++;}
            }

            // print to console matching words
            for (int i=0; i<heapSize && i < count; i++){
            System.out.println( "" + h.deleteMax().word );}

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}