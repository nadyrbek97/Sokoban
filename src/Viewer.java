import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * This is out Viewer component
 * It draws whole project
 */
public class Viewer {

    Canvas canvas;
    /**
     * This is our main Frame
     */
    JFrame frame = new JFrame("Nadyrbek's 'Sokoban' Game");


    /**
     * We draw our frame in our constructor
     * While creating Viewer() object our program will start
     */
    public Viewer(){

        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        frame.setSize(650, 700);
        frame.setLocation(200, 0);
        frame.addKeyListener(controller);
        frame.setVisible(true);
        // add canvas to viewer
        frame.add(canvas);
    }

    /**
     * This function updates the state of screen by calling canvas.repaint()
     */
    public void update(){
        canvas.repaint();
    }

    public JFrame getMyFrame() {
        return frame;
    }
}
