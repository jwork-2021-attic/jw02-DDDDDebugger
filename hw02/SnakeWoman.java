package hw02;

public final class SnakeWoman extends Bogy{

    private static SnakeWoman theSnakeWoman;

    private Sorter m_Sorter;

    private SnakeWoman(final int r, final int g, final int b) {
        super("SnakeWoman", 0, r, g, b);
    }

    public static SnakeWoman getTheSnakeWoman() {
        if (theSnakeWoman == null) {
            theSnakeWoman = new SnakeWoman(104, 34, 139);
        }
        return theSnakeWoman;
    }

    public void setSorter(final Sorter sorter) {
        this.m_Sorter = sorter;
    }

    private String[] parsePlan(final String plan) {
        return plan.split("\n");
    }

    private void execute(final String step) {
        final String[] couple = step.split("<->");
        Bogy.getBogyByRank(Integer.parseInt(couple[0]))
            .swapPosition(Bogy.getBogyByRank(Integer.parseInt(couple[1])));
    }

    public String lineUp(final Line line) {

        String log = new String();

        if (m_Sorter == null) {
            return null;
        }

        final Linable[] linables = line.toArray();
        final int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        m_Sorter.load(ranks);
        m_Sorter.sort();

        final String[] sortSteps = this.parsePlan(m_Sorter.getPlan());

        for (final String step : sortSteps) {
            this.execute(step);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    public String lineUp(final Matrix matrix){
        String log = new String();

        if (m_Sorter == null) {
            return null;
        }

        final Linable[] linables = matrix.toArray();
        final int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        m_Sorter.load(ranks);
        m_Sorter.sort();

        final String[] sortSteps = this.parsePlan(m_Sorter.getPlan());

        for (final String step : sortSteps) {
            this.execute(step);
            System.out.println(matrix.toString());
            log += matrix.toString();
            log += "\n[frame]\n";
        }

        return log;
    }
    
}