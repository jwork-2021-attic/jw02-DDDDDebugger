package hw02;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Scene {

    static int bogynum = 256;
    public static void main(String[] args) throws IOException {

        int[] colors = ReadColor.getColor("./c256.png");
        /*Line line = new Line(bogynum);
        for line test*/
        Matrix matrix = new Matrix(16, 16);//for matrix test
        Random random = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < bogynum; ++i){
            array.add(i, i);
        }
        
        int j = 0;
        while(array.size() > 0 && j<bogynum){
            int index = random.nextInt(array.size());
            int i = array.get(index);
            array.remove(index);
            Bogy bogy = new Bogy(Integer.toString(i+1), i+1, (colors[i] >> 16), ((colors[i] & 0x00ff00) >> 8), (colors[i] & 0x0000ff));
            matrix.put(bogy, j++);
        }
       
        

        SnakeWoman snakeWoman = SnakeWoman.getTheSnakeWoman();

        Sorter sorter = new SelectSorter();

        snakeWoman.setSorter(sorter);

        String log = snakeWoman.lineUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter(".\\hw02\\out\\matrixresult(SelectSort).txt"));
        writer.write(log);
        writer.flush();
        writer.close();

        
    }
}