import java.util.Scanner;
import java.io.File;


public class ReadCode {
    public static void main(String[] args) {
        try {
            // initialize leftistHeap, file reader, and console reader objects
            LeftistSkewHeap<Term> h = new LeftistSkewHeap<>();
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

//            // iterate through termlist until first target word is found and insert all matching words into leftist heap
//            boolean done = false;
//            int thisIndex = 0;
//            int heapSize = 0;
//            while (!done){
//                if (thisIndex >= termList.length - 1){
//                    System.out.println("couldn't find");
//                    done = true;
//                }
//                else if (termList[thisIndex].word.startsWith(subString)){
//                    while(termList[thisIndex].word.startsWith(subString)){
//                        h.insert(termList[thisIndex]);
//                        heapSize++;
//                        thisIndex++;
//                    }
//                    done = true;
//                }
//                else {thisIndex++;}
//            }
            // find any one of the terms needed and iterate left and right to find all words that start with subString
            BinarySearch bs = new BinarySearch();

            int heapSize = 0;
            boolean doneUp = false;
            int foundIndex = bs.binarySearch(termList, subString);
            int upIndex = foundIndex;
            if (foundIndex != -1) {
                while (!doneUp) {
                    if (upIndex < termList.length - 1 && termList[upIndex].word.startsWith(subString)) {
                        h.insert(termList[upIndex]);
                        upIndex++;
                        heapSize++;
                    } else {
                        doneUp = true;
                    }
                }
                boolean doneDown = false;
                int downIndex = foundIndex - 1;
                while (!doneDown) {
                    if (upIndex < termList.length - 1 && termList[downIndex].word.startsWith(subString)) {
                        h.insert(termList[downIndex]);
                        downIndex--;
                        heapSize++;
                    } else {
                        doneDown = true;
                    }


                }
            }





            // print to console matching words
            for (int i=0; i<heapSize && i < count; i++){
            System.out.println( "" + h.deleteMax().word);}

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}