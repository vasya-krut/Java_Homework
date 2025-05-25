import Controller.Controller;
import Model.Crypto;
import View.MyView;

public class Main {
        public static void main(String[] args) throws Exception {
            Crypto crypto = new Crypto();
            MyView view = new MyView();
            Controller controller = new Controller(view, crypto);
        }


}