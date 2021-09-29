package hw02;

public class QuickSorter implements Sorter{
    private String plan = "";
    private int[] elements;


    private void swap(int i, int j){
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        plan += elements[i] + "<->" + elements[j] + "\n";
    }

    private void quickSort(int[] a, int left, int right){
        if(a.length < 2 || left >= right) return;

        int pivot = a[left];
        int i = left, j = right;
        while(i < j){
            while(a[j] >= pivot && j > i){
                j--;
            }
            while(a[i] <= pivot && i < j){
                i++;
            }
            if(i < j){
                swap(i,j);
            }
        }
        swap(left, i);
        quickSort(a, left, i-1);
        quickSort(a, i+1, right);
    }

    @Override
    public void load(int []array){
        this.elements = array;
    }

    @Override
    public void sort(){
        this.quickSort(this.elements, 0, elements.length-1);
    }

    @Override
    public String getPlan(){
        return this.plan;
    }

    @Override
    public void printArray(){
        for(int element : elements){
            System.out.printf("%d ", element);
        }
        System.out.printf("\n");
    }
}