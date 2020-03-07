import java.io.IOException;

public class Levels {

    private int level;
//    private LevelsFromFiles lff;
//    Levels() throws IOException {
//        level = 1;
//        lff = new LevelsFromFiles();
//    }
    public int[][] firstLevel()
    {
        int[][] desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 1, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return desktop;
    }
    public int[][] secondLevel()
    {
        int[][] desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 3, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 1, 3, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 0, 0, 4, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 4, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 4, 0, 2},
                {2, 0, 3, 0, 0, 0, 0, 4, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return desktop;
    }
    public int[][] thirdLevel()
    {
        int[][] desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 3, 3, 4, 4, 0, 0, 2},
                {2, 0, 0, 1, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 3, 3, 4, 4, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return desktop;
    }

    public int[][] nextLevel()
    {
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
            default:
                desktop = firstLevel();
                break;
        }

        level++;
        return desktop;
    }
}
