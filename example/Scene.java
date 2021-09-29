package example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        Line line = new Line(7);
        line.put(Gourd.ONE, 6);
        line.put(Gourd.TWO, 3);
        line.put(Gourd.THREE, 1);
        line.put(Gourd.FOUR, 5);
        line.put(Gourd.FIVE, 2);
        line.put(Gourd.SIX, 4);
        line.put(Gourd.SEVEN, 0);

        //#region for test
        System.out.println(Gourd.ONE.toString());
        System.out.println(Gourd.TWO.toString()); 
        System.out.println(Gourd.THREE.toString()); 
        System.out.println(Gourd.FOUR.toString()); 
        System.out.println(Gourd.FIVE.toString()); 
        System.out.println(Gourd.SIX.toString());      
        System.out.println(Gourd.SEVEN.toString()); 
        //#endregion

        Geezer theGeezer = Geezer.getTheGeezer();

        Sorter sorter = new BubbleSorter();

        theGeezer.setSorter(sorter);

        String log = theGeezer.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
