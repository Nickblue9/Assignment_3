import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DualPivotQuickSort {
    public static void main (String [] args){
        DualPivotQuickSort sort = new DualPivotQuickSort();
        File f = new File(args[0]);
        try{
            int[] array = sort.getValues(f);
            sort.quickSort(array,0,array.length-1);
            sort.print(array);
        }catch(IOException e){e.printStackTrace();}
    }
    private void quickSort(int[] A, int left, int right){
        if(right<=left)
            return;
        int lp = left, rp = right;
        int v = A[left];
        int i = left +1;
        while(i<=rp){
            if(v<A[i])
                swap(A,lp++,i++);
            else if (v>A[i])
                swap(A,i,rp--);
            else
                i++;
        }
        quickSort(A,left,lp-1);
        quickSort(A,rp+1,right);

    }


    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int[] getValues(File f) throws IOException{
        Scanner fScanner = new Scanner(f);
        ArrayList<Integer> arr = new ArrayList<>();
        while (fScanner.hasNextInt()) {
            arr.add(fScanner.nextInt());
        }

        int[] array = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++)
            array[k] = arr.get(k);

        return array;
    }

    private void print(int[] A){
        for(int k: A){
            System.out.print(k);
            if(k!=A[A.length-1])
                System.out.print(" ");
        }
    }
}
