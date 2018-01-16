import java.awt.event.ActionEvent;
import javax.swing.*;
    public class main {
    public static void main(String[]args){
        Gui_calculator g = new Gui_calculator() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        g.setSize(300, 400);
        g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        g.setVisible(true);
        g.setResizable(false);
        
    }
}