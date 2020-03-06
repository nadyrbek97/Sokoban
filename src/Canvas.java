import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Canvas object
 * this object added to main JFrame
 * all paintings happens here
 */
public class Canvas extends JPanel{
    private Model model;

    // Images
    private Image imageGamer;
    private Image imageWall;
    private Image imageTarget;
    private Image imageBox;

    public Canvas(Model model){
        this.model = model;
        setBackground(Color.black);
        // System.out.println("I am Canvas constructor");
        // add button
//        JButton button = new JButton("Restart");
//        button.setBackground(Color.green);
//        button.setSize(100,50);
//        button.setLocation(0,0);
//        this.add(button);

        // Files
        File fileNameGamer = new File("src/images/marioDown.png");
        File fileNameWall = new File("src/images/wall.png");
        File fileNameTarget = new File("src/images/target.png");
        File fileNameBox = new File("src/images/box.png");

        try{
            imageGamer = ImageIO.read(fileNameGamer);
            imageWall = ImageIO.read(fileNameWall);
            imageTarget = ImageIO.read(fileNameTarget);
            imageBox = ImageIO.read(fileNameBox);
        } catch (IOException e){
            System.out.println("Error " + e);
        }
    }

    /**
     * paint using Graphics object
     * replace array number with images
     * 1 - Player
     * 2 - Wall
     * 3 - Box
     * 4 - Target
     * @param graphics
     */
    public void paint(Graphics graphics){
        super.paint(graphics);
        graphics.setColor(Color.white);
        int x = 50;
        int y = 50;
        int width = 50;
        int height = 50;
        int offset = 5;

        int[][] desktop = model.getDesktop();
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if(desktop[i][j] == 1){
                    graphics.drawImage(imageGamer,x, y, null);
                } else if(desktop[i][j] == 2){
                    graphics.drawImage(imageWall, x, y, null);
                } else if(desktop[i][j] == 3){
                    graphics.drawImage(imageBox, x, y, null);
                } else if(desktop[i][j] == 4){
                    graphics.drawImage(imageTarget, x, y, null);
                }
                else {
                    graphics.setColor(Color.white);
                    graphics.drawRect(x, y, width, height);
                }
                x = x + width + offset;
            }
            x = 50;
            y = y + height + offset;
        }
    }
}
