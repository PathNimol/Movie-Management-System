package BasicJava;

import javax.swing.JOptionPane;

public class GUI {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("What's your name? : ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you? : "));
        if(age<18){
            JOptionPane.showMessageDialog(null,"Welcome " + name + " you are not old enough to use this program!");
        }else{
            JOptionPane.showMessageDialog(null,"Welcome " + name + " to this program!");
        }
    }
}
