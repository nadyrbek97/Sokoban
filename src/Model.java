public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;
    private Levels levels;
    private int[][] arrayIndexies;


    public Model(Viewer viewer) {
        // System.out.println("I am Model Constructor");
        this.viewer = viewer;

        levels = new Levels();
        desktop = levels.nextLevel();

        indexX = 4;
        indexY = 3;

        initialization();
    }

    public void initialization() {
        int counterFour = 0;
        for(int i = 0; i < desktop.length;i++) {
            for(int j = 0; j < desktop[i].length;j++) {

                if(desktop[i][j] == 4) {
                    counterFour = counterFour + 1;
                }

            }
        }

        arrayIndexies = new int[2][counterFour];

        int count = 0;
        for(int i = 0; i < desktop.length;i++) {
            for(int j = 0; j < desktop[i].length;j++) {
                if(desktop[i][j] == 4) {
                    arrayIndexies[0][count] = i;
                    arrayIndexies[1][count] = j;
                    count++;
                }
            }
        }

        for(int i = 0; i < arrayIndexies.length;i++) {
            for(int j = 0; j < arrayIndexies[i].length;j++) {
                System.out.print(arrayIndexies[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


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
        print();
        check();
        viewer.update();
        won();
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

    /**
     * Handle intersection of target place
     * check() if it becomes 0 (empty) replace it with 4(target)
     */
    private void check() {
        int t = 0;
        for(int j = 0; j < arrayIndexies[0].length;j++) {
            int x = arrayIndexies[0][t];
            int y = arrayIndexies[1][t];
            if (desktop[x][y] == 0) {
                desktop[x][y] = 4;
                break;
            }
            t++;
        }
    }

    private void won()
    {
        boolean flag = true;
        int t =0;
        for(int i = 0; i < arrayIndexies[0].length; i++ )
        {
            int x = arrayIndexies[0][t];
            int y = arrayIndexies[1][t];
            if(desktop[x][y]!=3){
                flag = false;
                break;
            }
            t++;
        }
        if(flag){
            javax.swing.JOptionPane.showMessageDialog(viewer.getMyFrame(), "You won!");
            desktop = levels.nextLevel();
            indexX = 4;
            indexY = 3;
            initialization();
            viewer.update();
        }

    }
}