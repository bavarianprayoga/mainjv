import javax.swing.JOptionPane;
//import ini buat bikin gui

public class entah {
    public static void main(String[] args)   {

        String name = JOptionPane.showInputDialog("nama");
        JOptionPane.showMessageDialog(null, "Hello "+name);

        int age = Integer.parseInt(JOptionPane.showInputDialog("umur"));
        JOptionPane.showMessageDialog(null, "You're "+age+" years old, "+name+".");

        int vincent = Integer.parseInt(JOptionPane.showInputDialog("ambil berapa pa vincen"));
        JOptionPane.showMessageDialog(null, vincent+"? banyak amat pa");

        //*parse ini buat convert data type, sesuain sama data type yg mau lo pake 

        double height = Double.parseDouble(JOptionPane.showInputDialog("tinggi"));
        JOptionPane.showMessageDialog(null, "You're "+height+" cm, "+name+".");

        JOptionPane.getRootFrame().dispose();
    }
}
