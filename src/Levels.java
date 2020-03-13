import java.io.IOException;

public class Levels {

    private int level;
    private Viewer viewer;
    private Parser parser;
    Levels(Viewer viewer) {
        this.viewer = viewer;
        level = 1;
        parser = new Parser();
    }

    public int[][] nextLevel() throws IOException {
        int[][] desktop = null;

        switch (level) {
            case 1:
                desktop = firstLevel();
                break;
            case 2:
                desktop = secondLevel();
                break;
            case 3:
                desktop = thirdLevel();
                break;
            case 4:
                desktop = parser.parse("src/levels/level4.soc");
                break;
            case 5:
                desktop = parser.parse("src/levels/level5.soc");
                break;
            case 6:
                desktop = parser.parse("src/levels/level6.soc");
                break;
            case 7:
                desktop = parser.parse("src/levels/levelFromServer7.soc");
                break;
            case 8:
                desktop = parser.parse("src/levels/levelFromServer8.soc");
                break;
            case 9:
                desktop = parser.parse("src/levels/levelFromServer9.soc");
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(viewer.getMyFrame(), "You've finished all levels, Press ok to start again");
                level = 1;
                desktop = firstLevel();
                break;
        }

        level++;
        return desktop;
    }


    private int[][] firstLevel()
    {
        int[][] desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 1, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
                {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return desktop;
    }

    private int[][] secondLevel()
    {
        int[][] desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
                {2, 1, 0, 0, 0, 2, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 0, 4, 0, 2},
                {2, 0, 0, 0, 3, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 3, 0, 0, 0, 4, 2},
                {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return desktop;
    }

    private int[][] thirdLevel()
    {
        int[][] desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 4, 2, 2, 0, 2},
                {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 0, 4, 0, 0, 2},
                {2, 0, 0, 1, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return desktop;
    }
}
