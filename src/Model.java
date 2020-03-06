public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;


    public Model(Viewer viewer) {
        // System.out.println("I am Model Constructor");
        this.viewer = viewer;
        desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 1, 3, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
                {2, 0, 0, 0, 3, 0, 0, 0, 0, 2},
                {2, 0, 4, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 4, 0, 0, 0, 0, 3, 4, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        indexX = 3;
        indexY = 3;
    }

    /**
     * Getter for desktop 2d array, to paint map for the game
     * @return
     */
    public int[][] getDesktop() {
        return desktop;
    }

    /**
     * This function listens the move directions from controller
     * @param direction
     */
    public void move(String direction) {
        // System.out.println(direction);
        switch (direction) {
            case "Right":
                moveRight();
                break;
            case "Left":
                moveLeft();
                break;
            case "Up":
                moveUp();
                break;
            case "Down":
                moveDown();
                break;
        }
        // print();
        viewer.update();
    }

    private void print() {
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                System.out.print(desktop[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4){
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }
        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4){
            desktop[indexX][indexY] = 0;
            indexY += 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4){
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY -= 1;
            desktop[indexX][indexY] = 1;
        }
    }


    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4){
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX -= 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4){
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX += 1;
            desktop[indexX][indexY] = 1;
        }
    }
}