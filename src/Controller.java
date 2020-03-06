import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private Model model;

    public Controller(Viewer viewer){
        System.out.println("I am Controller constructor");
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
        System.out.println(keyCode);
        String direction = null;

        switch (keyCode){
            case 37:
                direction = "Left";
                break;
            case 38:
                direction = "Up";
                break;
            case 39:
                direction = "Right";
                break;
            case 40:
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
