package hw02;

public class SelectSorter implements Sorter{
    private String plan = "";
    private int[] elements;


    private void swap(int i, int j){
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        plan += elements[i] + "<->" + elements[j] + "\n";
    }

    @Override
    public void load(int []array){
        this.elements = array;
    }

    @Override
    public void sort(){
        for(int i = 0; i<elements.length; ++i){
            int min = i;
            for(int j = i + 1; j<elements.length; ++j){
                if(elements[min] > elements[j]){
                    min = j;
                }
            }
            if( min!=i ){
                swap(min,i);
            }
        }
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