package am.aua.set.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SetBoard extends JFrame implements ActionListener {
    
    private JPanel titlePanel = new JPanel();
    private JLabel titleText = new JLabel();
    private JPanel cardsPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JButton[][] setCards = new JButton[3][4];

    public SetBoard() {
        super("Set Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 100);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridLayout());

        titlePanel.setBackground(Color.YELLOW);
        titleText.setBackground(Color.BLACK);

        cardsPanel.setBackground(Color.GRAY);
        cardsPanel.setLayout(new GridLayout(3,4));
        
        titlePanel.add(titleText);
        add(titlePanel);
        add(cardsPanel);
        setVisible(true);
    }
    


    public void actionPerformed(ActionEvent e) {
        JButton setCards = (JButton) e.getSource();
        
    }
    public void setVisible(boolean b) {
        System.out.println(1);
    }
}
