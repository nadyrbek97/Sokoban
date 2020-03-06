import java.awt.*;

public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;


    public Model(Viewer viewer){
        System.out.println("I am Model Constructor");
        this.viewer = viewer;
        desktop = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 1, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 3, 4, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        indexX = 3;
        indexY = 3;
    }

    public int[][] getDesktop(){
        return desktop;
    }

    public void move(String direction){
        System.out.println(direction);
        switch (direction){
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
        viewer.update();
    }

    private void print(){
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                System.out.print(desktop[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void moveRight(){
        desktop[indexX][indexY] = 0;
        indexY += 1;
        desktop[indexX][indexY] = 1;
    }

    private void moveLeft(){
        desktop[indexX][indexY] = 0;
        indexY -= 1;
        desktop[indexX][indexY] = 1;
    }

    private void moveUp(){
        desktop[indexX][indexY] = 0;
        indexX -= 1;
        desktop[indexX][indexY] = 1;
    }

    private void moveDown(){
        desktop[indexX][indexY] = 0;
        indexX += 1;
        desktop[indexX][indexY] = 1;
    }
}