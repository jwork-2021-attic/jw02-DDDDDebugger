package hw02;
import hw02.Line.Position;

public class Bogy implements Linable{
    private final int rgb_R;
    private final int rgb_G; 
    private final int rgb_B;
    private final int rank;
    private String name;
    private Position position;
    static Bogy[] bogys = new Bogy[257];//256 littlebogy + 1 theSnakeWoman 

    Bogy(String _name, int _rank, int color_r, int color_g, int color_b){
        rgb_R = color_r;
        rgb_B = color_b;
        rgb_G = color_g;
        name = _name;
        rank = _rank;
        bogys[_rank] = this;       
    }

    public int getRank(){
        return rank;
    }

    public static Bogy getBogyByRank(int _rank) {
        return bogys[_rank];
	}

    public void swapPosition(Bogy another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public String toString(){
        String result;
        result = "\033[48;2;" + this.rgb_R + ";" + this.rgb_G + ";" + this.rgb_B
        + ";38;2;" + (256 - this.rgb_R) + ";" + (256 - this.rgb_G) + ";" + (256 - this.rgb_B) + "0m ";
        /*int i = this.name.length();
        while(i < 3){
            result += " ";
            ++i;
        }*/
        return result + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getValue() {
        return this.getRank();
    }
    

}