import javax.swing.*;

/**
 * This is out Viewer component
 * It draws whole project
 */
public class Viewer {

    Canvas canvas;

    /**
     * We draw our frame in our constructor
     * While creating Viewer() object our program will start
     */
    public Viewer(){

        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        /**
         * This is our main Frame
         */
        JFrame frame = new JFrame("Nadyrbek's 'Sokoban' Game");
        frame.setSize(800, 800);
        frame.setLocation(200, 0);
        frame.addKeyListener(controller);
        frame.setVisible(true);
        // add canvas to viewer
        frame.add(canvas);

    }

    public void update(){
        canvas.repaint();
    }
}