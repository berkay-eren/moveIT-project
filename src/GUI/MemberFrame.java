package GUI;

import javax.swing.*;
import java.awt.*;

import Subclass.Exercise;
import Subclass.Member;
import MainSys.GymManagementSystem;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberFrame extends JFrame {
    private JPanel contentPane;
    private JTextField tfWeight, tfHeight;
    private JLabel lblPayment, lblSuccessMessage;

    private static final int YEARLY = 3000;
    private static final int MONTHLY = 500;
    private static final int DAILY = 150;
    private JTextField tfDuration;

    public MemberFrame(int id, String name, int enterYear) {
        setTitle("Member Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 364);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);

        JComboBox cbPlan = new JComboBox();
      
        cbPlan.setBounds(243, 170, 122, 18);
        contentPane.add(cbPlan);

        setLocationRelativeTo(null);
        cbPlan.addItem("Yearly");
        cbPlan.addItem("Monthly");
        cbPlan.addItem("Daily");
        
        JLabel lblTitle = new JLabel("Member Details");
        lblTitle.setBounds(119, 16, 169, 26);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblID = new JLabel("ID: " + id);
        lblID.setBounds(20, 52, 128, 17);
        JLabel lblName = new JLabel("Name: " + name);
        lblName.setBounds(20, 75, 128, 17);
        JLabel lblEnterYear = new JLabel("Enter Year: " + enterYear);
        lblEnterYear.setBounds(20, 98, 153, 17);
        JLabel lblWeight = new JLabel("Weight:");
        lblWeight.setBounds(20, 121, 54, 17);
        JLabel lblHeight = new JLabel("Height:");
        lblHeight.setBounds(20, 146, 51, 17);
        JLabel lblMembershipPlan = new JLabel("Membership Plan:");
        lblMembershipPlan.setBounds(20, 171, 127, 17);
        JLabel lblPaymentLabel = new JLabel("Payment:");
        lblPaymentLabel.setBounds(20, 219, 68, 17);

        lblID.setFont(new Font("Arial", Font.BOLD, 14));
        lblName.setFont(new Font("Arial", Font.BOLD, 14));
        lblEnterYear.setFont(new Font("Arial", Font.BOLD, 14));
        lblWeight.setFont(new Font("Arial", Font.BOLD, 14));
        lblHeight.setFont(new Font("Arial", Font.BOLD, 14));
        lblMembershipPlan.setFont(new Font("Arial", Font.BOLD, 14));
        lblPaymentLabel.setFont(new Font("Arial", Font.BOLD, 14));

        tfWeight = new JTextField();
        tfWeight.setBounds(243, 121, 122, 19);
        tfHeight = new JTextField();
        tfHeight.setBounds(243, 146, 122, 19);
        lblPayment = new JLabel("0.0");
        lblPayment.setBounds(98, 219, 67, 14);
        lblPayment.setFont(new Font("Tahoma", Font.BOLD, 11));

        tfWeight.setColumns(10); 
        tfHeight.setColumns(10);
        
        JComboBox cbExercise = new JComboBox();
        cbExercise.setBounds(138, 193, 67, 18);
        contentPane.add(cbExercise);
        cbExercise.addItem("Yoga");
        cbExercise.addItem("Lifting");
        cbExercise.addItem("Running");
        
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(80, 247, 67, 25);
        JButton btnReturn = new JButton("Return");
        btnReturn.setBounds(214, 247, 95, 25);

        btnSave.setBackground(new Color(60, 179, 113));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));

        btnReturn.setBackground(new Color(220, 20, 60));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 14));

        lblSuccessMessage = new JLabel("");
        lblSuccessMessage.setBounds(20, 219, 0, 0);
        lblSuccessMessage.setFont(new Font("Arial", Font.BOLD, 14));
        lblSuccessMessage.setForeground(new Color(34, 139, 34));

        lblPayment.setText("3000.0");
        
        btnSave.addActionListener(e -> {
          
        	Exercise ex;
            if (tfWeight.getText().isEmpty() || tfHeight.getText().isEmpty()|| tfDuration.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields before saving.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                double payment = calculatePayment(cbPlan.getSelectedItem().toString());
                String exe=cbExercise.getSelectedItem().toString();
                
                
				if(exe.equalsIgnoreCase("yoga"))
                	ex=new Exercise("Yoga",Integer.parseInt(tfDuration.getText()));
				else if(exe.equalsIgnoreCase("Running"))
					ex=new Exercise("Running",Integer.parseInt(tfDuration.getText()));
				else
					ex=new Exercise("Lifting",Integer.parseInt(tfDuration.getText()));
				
				Member member = new Member(id, name, enterYear,
                        Double.parseDouble(tfWeight.getText()),
                        Double.parseDouble(tfHeight.getText()),
                        cbPlan.getSelectedItem().toString(),
                        payment,ex);
				

                GymManagementSystem.addMember(member);
                lblSuccessMessage.setText("Member added successfully!");
                btnSave.setEnabled(false);
                
            }
        });
        
        cbPlan.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 lblPayment.setText(String.valueOf(calculatePayment(cbPlan.getSelectedItem().toString())));
        		
        	}
        });

      
        btnReturn.addActionListener(e -> {
            dispose();  
            new AddFrame().setVisible(true); 
        });
        contentPane.setLayout(null);
        contentPane.add(lblID);
        contentPane.add(lblName);
        contentPane.add(lblEnterYear);
        contentPane.add(lblSuccessMessage);
        contentPane.add(lblWeight);
        contentPane.add(lblHeight);
        contentPane.add(lblMembershipPlan);
        contentPane.add(btnSave);
        contentPane.add(tfHeight);
        contentPane.add(tfWeight);
        contentPane.add(lblPaymentLabel);
        contentPane.add(lblPayment);
        contentPane.add(lblTitle);
        contentPane.add(btnReturn);
        
        JLabel lblExerciseType = new JLabel("Exercise type:");
        lblExerciseType.setFont(new Font("Arial", Font.BOLD, 14));
        lblExerciseType.setBounds(21, 193, 127, 17);
        contentPane.add(lblExerciseType);
        
        JLabel lblDuration = new JLabel("Duration:");
        lblDuration.setFont(new Font("Arial", Font.BOLD, 14));
        lblDuration.setBounds(226, 193, 75, 17);
        contentPane.add(lblDuration);
        
        tfDuration = new JTextField();
        tfDuration.setBounds(302, 194, 74, 17);
        contentPane.add(tfDuration);
        tfDuration.setColumns(10);
     
      
        
      
    }

    public double calculatePayment(String plan) {
        double payment = 0;

        if (plan.equalsIgnoreCase("yearly")) {
            payment = YEARLY;
        } else if (plan.equalsIgnoreCase("monthly")) {
            payment = MONTHLY;
        } else if (plan.equalsIgnoreCase("daily")) {
            payment = DAILY;
        }

        return payment;
    }
}
