package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralFrame extends JFrame {
    public GeneralFrame() {
      
        setTitle("General Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 483);

       
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);  
        contentPanel.setBackground(new Color(240, 248, 255)); 
        setContentPane(contentPanel);

        
        JLabel titleLabel = new JLabel("Welcome to MoveIT");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(143, 28, 308, 40); 
        contentPanel.add(titleLabel);

    
        JButton addPersonButton = new JButton("Add a Record");
        JButton removePersonButton = new JButton("Remove a Record");
        JButton displayButton = new JButton("Display");
        JButton financeButton = new JButton("Finances");
        JButton assignTrainerButton = new JButton("Assign Trainer to Member");

       
        addPersonButton.setBounds(200, 100, 200, 40);  
        removePersonButton.setBounds(200, 160, 200, 40);  
        displayButton.setBounds(200, 285, 200, 40); 
        financeButton.setBounds(200, 346, 200, 40);  
        assignTrainerButton.setBounds(200, 222, 200, 40);  

       
        addPersonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddFrame().setVisible(true); 
            }
        });

        removePersonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RemoveFrame().setVisible(true);
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DisplayFrame().setVisible(true); 
            }
        });

        financeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CalculationFrame().setVisible(true); 
            }
        });

        
        assignTrainerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AssignFrame().setVisible(true); 
            }
        });

      
        contentPanel.add(addPersonButton);
        contentPanel.add(removePersonButton);
        contentPanel.add(displayButton);
        contentPanel.add(financeButton);
        contentPanel.add(assignTrainerButton);  
       
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GeneralFrame().setVisible(true);
            }
        });
    }
}
