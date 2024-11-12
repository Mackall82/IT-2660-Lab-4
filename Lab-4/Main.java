import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

  
    public static void main(String[] args) {

      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      long startTime = System.nanoTime();
    
      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(bubbleSortedList);

      long endTime = System.nanoTime();

    long elasped = (endTime - startTime);
    System.out.println(elasped);

      long startTime2 = System.nanoTime();

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(insertionSortedList);

      long endTime2 = System.nanoTime();
      long elasped2 =(endTime2 - startTime2);
      System.out.println(elasped2);
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for(int i = 1; i < integerList.size(); i++){

      int currentElement = integerList.get(i);
      int k = i - 1;
      while( k >= 0 && integerList.get(k) > currentElement){
        integerList.set(k + 1, integerList.get(k));
        k--;

      }
    integerList.set(k + 1, currentElement);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    boolean swap = true;

    while(swap){

      swap = false;
      for(int i = 0; i < integerList.size()-1; i++){
        if(integerList.get(i) > integerList.get(i + 1)){
          swap = true;
          int temp = integerList.get(i);
          integerList.set(i, integerList.get(i + 1));
          integerList.set(i + 1, temp);
        }

      }
    }
   
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}

 // 1. the insertion sort seems like it would be easier to implement in a new language

 // 2. the bubble took longer to complete. 

 // 3. I belive Insertion has an easier implementation to understand 
