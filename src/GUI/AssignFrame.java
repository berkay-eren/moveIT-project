package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import MainSys.GymManagementSystem;
import Subclass.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignFrame extends JFrame {
    private JComboBox<String> memberComboBox;
    private JComboBox<String> trainerComboBox;

    public AssignFrame() {
        setTitle("Assign Trainer to Member");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        getContentPane().setLayout(null);  

        
        JLabel titleLabel = new JLabel("Member");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(169, 11, 64, 30);
        getContentPane().add(titleLabel);

       
        Set<Member> members = GymManagementSystem.getMembers();
        Set<Trainer> trainers = GymManagementSystem.getTrainers();

        
        String[] memberStrings = new String[members.size()];
        String[] trainerStrings = new String[trainers.size()];

        int i = 0;
        for (Member m : members) {
            memberStrings[i++] = m.getId() + " - " + m.getName();  
        }

        i = 0;
        for (Trainer t : trainers) {
            trainerStrings[i++] = t.getId() + " - " + t.getName();  
        }

       
        DefaultComboBoxModel<String> memberModel = new DefaultComboBoxModel<>(memberStrings);
        DefaultComboBoxModel<String> trainerModel = new DefaultComboBoxModel<>(trainerStrings);

     
        memberComboBox = new JComboBox<>(memberModel);
        trainerComboBox = new JComboBox<>(trainerModel);

        memberComboBox.setBounds(100, 65, 200, 30);
        trainerComboBox.setBounds(100, 157, 200, 30);

        getContentPane().add(memberComboBox);
        getContentPane().add(trainerComboBox);

       
        JButton assignButton = new JButton("Assign");
        assignButton.setForeground(new Color(255, 255, 255));
        assignButton.setBackground(new Color(0, 128, 64));
        assignButton.setFont(new Font("Arial", Font.BOLD, 14));
        assignButton.setBounds(61, 222, 100, 30);
        getContentPane().add(assignButton);
        
        JLabel lblTrainer = new JLabel("Trainer");
        lblTrainer.setFont(new Font("Arial", Font.BOLD, 16));
        lblTrainer.setBounds(169, 116, 64, 30);
        getContentPane().add(lblTrainer);
        
        JButton btnReturn = new JButton("Return");
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 14));
        btnReturn.setBackground(new Color(220, 20, 60));
        btnReturn.setBounds(235, 223, 94, 28);
        getContentPane().add(btnReturn);

       
        assignButton.addActionListener(e -> {
            String selectedMemberString = (String) memberComboBox.getSelectedItem();
            String selectedTrainerString = (String) trainerComboBox.getSelectedItem();

           
            Integer selectedMemberId = Integer.parseInt(selectedMemberString.split(" - ")[0]);
            Integer selectedTrainerId = Integer.parseInt(selectedTrainerString.split(" - ")[0]);

            Member selectedMember = GymManagementSystem.getMemberById(selectedMemberId);
            Trainer selectedTrainer = GymManagementSystem.getTrainerById(selectedTrainerId);

            
            if (selectedMember != null && selectedTrainer != null) {
                selectedMember.setAssignedTrainer(selectedTrainer);
                JOptionPane.showMessageDialog(this, "Trainer assigned to member successfully!");
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Please select both a member and a trainer.");
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AssignFrame().setVisible(true));
    }
}
