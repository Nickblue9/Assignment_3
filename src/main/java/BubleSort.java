import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class BubleSort {

    private void BubbleSort(int[] A) {
        int BOUND = A.length;
        for (int i = 0; i < BOUND-1; i++)
            for (int j = 0; j < BOUND-i-1; j++)
                if (A[j] > A[j+1])
                {
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
    }

    public static void main (String [] args){
        BubleSort sort = new BubleSort();

        try {
            File f = new File(args[0]);
            int[] array = sort.getValues(f);
            sort.BubbleSort(array);
            sort.print(array);
        }catch(IOException e){e.printStackTrace();}
    }

    private int[] getValues(File f) throws IOException {
        Scanner fScanner = new Scanner(f);
        ArrayList<Integer> arr = new ArrayList<>();
        while (fScanner.hasNextInt()) {
            arr.add(fScanner.nextInt());
        }

        int[] array = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++)
            array[k] = arr.get(k);
        fScanner.close();
        return array;
    }

    private void print(int[] A){
        for(int k: A){
            System.out.print(k);
            if(k!=A[A.length-1])
                System.out.print(" ");
        }
    }

    private static void swap(int[] A, int j, int i){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
