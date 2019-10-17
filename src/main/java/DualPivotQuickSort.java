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
        int temp;
        if(right-left>=1){
            int lp = A[left];
            int rp = A[right];
            if(lp>rp){
                temp = lp;
                lp = rp;
                rp = temp;

                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
            int l = left+1;
            int g = right-1;
            int k = l;
            while(k<=g){
                if(A[k]<lp){
                   temp = A[k];
                   A[k] = A[l];
                   A[l] = temp;
                    l++;
                }
                else{
                    if(A[k]>rp){
                        while(A[g]>lp && k<g)
                            g--;
                        temp = A[k];
                        A[k]= A[g];
                        A[g] = temp;
                        g--;
                        if(A[k]<lp){
                            temp = A[k];
                            A[k] = A[l];
                            A[l] = temp;
                            l++;
                        }

                    }
                }
                k++;
            }
            l--;
            g++;
            temp = A[left];
            A[left] = A[l];
            A[l] = temp;

            temp = A[right];
            A[right] = A[g];
            A[g] = temp;
            quickSort(A,left,l-1);
            quickSort(A,l+1,g-1);
            quickSort(A,g+1,right);
        }

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
