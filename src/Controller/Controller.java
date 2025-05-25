package Controller;

import Model.Crypto;
import View.MyView;

public class Controller {
    private Crypto model;
    private MyView view;

    public Controller(MyView view, Crypto model) throws Exception {
        this.view = view;
        this.model = model;
        model.createKey(view.getParametr(model.listBlockSize));
        int codeOperation;

        while(true){
            codeOperation = view.menu();
            if(codeOperation == -1) break;
            if(codeOperation == 0) {
                String path = view.shifr();
                model.encryptFile(path);
                view.shifrUspeh(path);
            }

            if(codeOperation == 1) {
                String path = view.deshifr();
                model.decryptFile(path);
                view.deshifrUspeh(path);
            }
        }
    }

}
