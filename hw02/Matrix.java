package hw02;
import hw02.Line.Position;

public class Matrix {
    private Line[] lines;
    private final int m_rows;
    private final int m_columns;

    Matrix(int rows, int columns){
        lines = new Line[rows];
        for(int i = 0; i < rows; ++i){
            lines[i] = new Line(columns);
        }
        m_rows = rows;
        m_columns = columns;
    }

    public void put(Linable linable, int i) {
        int column = i % m_columns;
        int row = (m_rows >= i/m_columns) ? i / m_columns:m_rows;
        lines[row].put(linable, column);    
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.m_columns * this.m_rows];
        for (int i = 0; i < this.m_rows; ++i) {
            for(int j = 0; j < this.m_columns; ++j){
                linables[i*this.m_columns + j] = lines[i].toArray()[j];
            }
        }
        return linables;
    }

    @Override
    public String toString() {       
        String matrixString = "";
        for(Line line : lines){
            matrixString += line.toString();
            matrixString += "\n";
        }       
        return matrixString;
    }

}