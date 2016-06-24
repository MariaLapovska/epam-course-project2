import com.epam.controller.Controller;
import com.epam.model.Parser;
import com.epam.view.View;

public class Main {

    public static void main(String[] args) {
        Parser parser = new Parser();
        View view = new View();
        Controller controller = new Controller(parser, view);

        //Run
        controller.processUser();
    }
}
