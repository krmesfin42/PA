/**
 *Name: Kirubel Negash
 * CptS 233: PA #1
 * Date: 09/16/2020
 * gitRepo url: https://github.com/krmesfin42/PA.git
 * The program reads an input file that contains integer values. Insert the integers into a singly linked list.
 * Find the minimum from the list and print the timing to get the integer.
 * Find the maximum from the list and print the timing to get the integer.
 * Find the median from the list and print the timing to get the integer.
 */
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class Benchmarking{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> num = new LinkedList<Integer>();
        System.out.println("Enter the name of the file: ");
        String filename = input.nextLine();
        File file = new File(filename);
        Scanner newFile = new Scanner(file);
        int sum = 0;// created to find the index for median numbers
        Long start1 = System.nanoTime();
        while (newFile.hasNext()) {//reads the integers and pass it to the minMaxMed method one at a time
            int number = newFile.nextInt();
            sortList(num,number);
            sum+=1;
        }
        Long end1 = System.nanoTime();
        double time_insert = (double) (end1 - start1) / 1000000;
        Long start2 = System.nanoTime();
        System.out.println("Total numbers: "+ sum);
        double time_med=0.0;
        if(sum%2==0){//if the size of the list is even, the two middle integers need to be added and divided by two.
            int mid1 = sum/2;//To get one of the middle integer's index
            double med = (double)(num.get(mid1) + num.get(mid1-1))/2;
            System.out.println("Med: "+ med);
            Long end2 = System.nanoTime();
            time_med = (double) (end2 - start2) / 1000000;
        }else{//for size of odd list
            Long start3 = System.nanoTime();
            int med =num.get(sum/2);
            System.out.println("Med: "+ med);
            Long end3 = System.nanoTime();
            time_med = (double) (end3 - start3) / 1000000;
        }
        Long start4 = System.nanoTime();
        System.out.println("min: "+num.peekFirst());
        Long end4 = System.nanoTime();
        double time_min = (double) (end4 - start4) / 1000000;
        Long start5 = System.nanoTime();
        System.out.println("Max: "+num.peekLast());
        Long end5 = System.nanoTime();
        double time_max = (double) (end5 - start5) / 1000000;
        System.out.println("time_insert: "+time_insert+ " milliseconds.");
        System.out.println("time_min: "+time_min+ " milliseconds.");
        System.out.println("time_max: "+time_max+ " milliseconds.");
        System.out.println("time_med: "+time_med+ " milliseconds.");
    }
    /**
     *sortList method sorts the integers in order into the singly linked list by comparing one by one
     * after accepting as a parameter
     */
    private static boolean sortList(LinkedList<Integer> linkedList, int newNumber) {
        ListIterator<Integer> intListIterator = linkedList.listIterator();
        while (intListIterator.hasNext()) {
            int mini = Integer.compare(intListIterator.next(),newNumber);//determine whether its greater/equal/less(1,0,-1)
            if (mini == 0) {
                //if its equal, it won't add
                return false;
            } else if (mini > 0) {//If its greater, it'll add after the smaller number
                int x = intListIterator.nextIndex();//get the index of next()
                int y = linkedList.get(x-1);//work like previous() but without pointer just assign the next()
                intListIterator.set(newNumber);//replace the next() by newNumber
                intListIterator.add(y);//add next() after newNumber
                return true;
            } else if(mini < 0){
               //go to the next number
            }
        }
        intListIterator.add(newNumber);
        return true;
    }
}




