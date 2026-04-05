import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Adding extends DisplayCalendar {

    public Adding() {
        JFrame a = new JFrame("Add");
        JButton b = new JButton("Add Event");
        JPanel c = new JPanel();

        c.add(b);
        a.add(c);

        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a.setBounds(200, 600, 400, 150);

        c.setLayout(null);
        b.setBounds(100, 20, 260, 50);

        JTextField d = new JTextField();
        d.setBounds(100, 80, 260, 50);
        c.add(d);
        a.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredText = d.getText();
                setEventText(enteredText);
                JOptionPane.showMessageDialog(a, "Entered Text: " + enteredText);
            }
        });

        JFrame a1 = new JFrame("Add Date");
        JButton b1 = new JButton("Date");
        JPanel c1 = new JPanel();

        c1.add(b1);
        a1.add(c1);

        a1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a1.setBounds(0, 600, 300, 150);

        c1.setLayout(null);
        b1.setBounds(0, 20, 260, 50);

        JTextField d1 = new JTextField();
        d1.setBounds(0, 80, 260, 50);
        c1.add(d1);
        a1.setVisible(true);

       b1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int chosenDay = Integer.parseInt(d1.getText());
            String enteredText = d.getText();
            addEvent(chosenDay, enteredText);
            JOptionPane.showMessageDialog(a1, 
                "Added event to day " + chosenDay + ":\n" + enteredText);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(a1, 
                "Please enter a valid number for the day.");
        }
    }
});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Adding::new);
    }
}
