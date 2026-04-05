import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DisplayCalendar {

    private JFrame frame;
    private Map<Integer, StringBuilder> eventsMap = new HashMap<>();
    private int year;
    private int month;

    public DisplayCalendar() {
        frame = new JFrame("Calendar Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new GridLayout(6, 7));
        Calendar today = Calendar.getInstance();
        year = today.get(Calendar.YEAR);
        month = today.get(Calendar.MONTH);

        displayCalendar(year, month);

        frame.setVisible(true);
    }

    public void setEventText(String eventText) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        eventsMap.computeIfAbsent(day, k -> new StringBuilder()).append(eventText).append("\n");
    }

    public void setDate(int year, int month) {
        this.year = year;
        this.month = month;
        displayCalendar(year, month);
    }

    private void displayCalendar(int year, int month) {
        frame.getContentPane().removeAll();

        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : dayNames) {
            frame.add(new JLabel(day, JLabel.CENTER));
        }

        Calendar calendar = new GregorianCalendar(year, month, 1);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int dayOfMonth = 1; dayOfMonth <= daysInMonth; dayOfMonth++) {
            JButton dayButton = new JButton(String.valueOf(dayOfMonth));
            dayButton.setBackground(new Color(102, 186, 181));
            dayButton.addActionListener(new DayButtonListener(dayOfMonth));
            frame.add(dayButton);
        }

        frame.validate();
        frame.repaint();
    }

    private class DayButtonListener implements ActionListener {
        private int dayOfMonth;

        private DayButtonListener(int dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (eventsMap.containsKey(dayOfMonth)) {
                String eventsText = eventsMap.get(dayOfMonth).toString().trim();
                JOptionPane.showMessageDialog(frame, eventsText);
            } else {
                JOptionPane.showMessageDialog(frame, "There are no events for today!");
            }
        }
    }
    public void addEvent(int day, String eventText) {
    eventsMap.computeIfAbsent(day, k -> new StringBuilder())
             .append(eventText)
             .append("\n");
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DisplayCalendar::new);
    }
}
