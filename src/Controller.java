import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This is Controller
 * It pass all action from Viewer to Model
 * implements KeyListener Interface
 */
public class Controller implements KeyListener {
    private Model model;

    public Controller(Viewer viewer){
        // System.out.println("I am Controller constructor");
        model = new Model(viewer);
    }

    public Model getModel(){
        return model;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int keyCode = keyEvent.getKeyCode();
//        System.out.println(keyCode);
        String direction = null;

        switch (keyCode){
            case 39:
            case 68:
                direction = "Right";
                break;
            case 37:
            case 65:
                direction = "Left";
                break;
            case 38:
            case 87:
                direction = "Up";
                break;
            case 40:
            case 83:
                direction = "Down";
                break;
            default:
                return;
        }
        model.move(direction);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
