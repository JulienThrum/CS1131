import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab12 {
    public static void main(String[] args){
        File file = new File(args[0]);
        Scanner inFile = null;

        try {
            inFile = new Scanner(file);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        inFile.useDelimiter("");
        String max = inFile.next();
        max += inFile.next();

        Queue<Character> queue =  new Queue(Integer.parseInt(max));

        while(inFile.hasNext()) {
            if(queue.isFull()) {
                System.out.println(queue.toString());
                while(!queue.isEmpty()) {
                    try {
                        queue.dequeue();
                    } catch(QueueEmptyException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    char[] c = inFile.next().substring(0, 1).toCharArray();
                    queue.enqueue(c[0]);
                } catch(QueueFullException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(queue.toString());

    }
}

/*
Our group worked together to first write a class for the queue that would construct
 the maximum allowed number of elements in the queue. Later, we used data from the text
  files in our Lab12 class to determine the integer sent to the Queue constructor. We then used
   the File.io Java class to scan through the text files from the command line arguments
   to store the text in the queue and print it out to form an image.
 */