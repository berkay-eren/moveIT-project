package GUI;

import javax.swing.*;
import java.awt.*;
import Subclass.Trainer;
import MainSys.GymManagementSystem;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrainerFrame extends JFrame {
    private JPanel contentPane;
    private JTextField tfSalary;
    private JComboBox<String> comboSpecialization;
    private JLabel lblSuccessMessage;

    public TrainerFrame(int id, String name, int enterYear) {
        setTitle("Trainer Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 316);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Trainer Details");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblID = new JLabel("ID: " + id);
        JLabel lblName = new JLabel("Name: " + name);
        JLabel lblEnterYear = new JLabel("Enter Year: " + enterYear);
        JLabel lblSpecialization = new JLabel("Specialization:");
        JLabel lblSalaryLabel = new JLabel("Salary:");

        lblID.setFont(new Font("Arial", Font.BOLD, 14));
        lblName.setFont(new Font("Arial", Font.BOLD, 14));
        lblEnterYear.setFont(new Font("Arial", Font.BOLD, 14));
        lblSpecialization.setFont(new Font("Arial", Font.BOLD, 14));
        lblSalaryLabel.setFont(new Font("Arial", Font.BOLD, 14));

        comboSpecialization = new JComboBox<>();
        comboSpecialization.addItem("Lifting");
        comboSpecialization.addItem("Yoga");
        comboSpecialization.addItem("Running");

        tfSalary = new JTextField();
        tfSalary.setColumns(10);

        lblSuccessMessage = new JLabel("");
        lblSuccessMessage.setFont(new Font("Arial", Font.BOLD, 14));
        lblSuccessMessage.setForeground(new Color(34, 139, 34));

        JButton btnSave = new JButton("Save");
        JButton btnReturn = new JButton("Return");

        btnSave.setBackground(new Color(60, 179, 113));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));

        btnReturn.setBackground(new Color(220, 20, 60));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 14));
        
        tfSalary.setText("3400");
        
        btnSave.addActionListener(e -> {
            if (tfSalary.getText().isEmpty() || comboSpecialization.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please fill all fields before saving.", "Error", JOptionPane.ERROR_MESSAGE);
                
            } else {
                double salary = Double.parseDouble(tfSalary.getText());
                String specialization = (String) comboSpecialization.getSelectedItem();

                Trainer trainer = new Trainer(id, name, enterYear, specialization, salary);
                GymManagementSystem.addTrainer(trainer);

                lblSuccessMessage.setText("Trainer added successfully!");
                btnSave.setEnabled(false);          
                
            }
        });

        btnReturn.addActionListener(e -> {
            dispose();
            new AddFrame().setVisible(true);
        });

        
        comboSpecialization.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String specialization = (String) comboSpecialization.getSelectedItem();
        		
        		if(specialization.equalsIgnoreCase("Running"))
        			tfSalary.setText("3000");
        		else if(specialization.equalsIgnoreCase("Lifting"))
        			tfSalary.setText("3400");
        		else
        			tfSalary.setText("3200");
        		
        	}
        });
        
       
        
        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblSuccessMessage)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblSpecialization)
        						.addGroup(layout.createSequentialGroup()
        							.addContainerGap()
        							.addComponent(lblSalaryLabel)))
        					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(tfSalary)
        						.addComponent(comboSpecialization, 0, 105, Short.MAX_VALUE))))
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(58)
        			.addComponent(btnSave)
        			.addPreferredGap(ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
        			.addComponent(btnReturn)
        			.addGap(59))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblName)
        			.addContainerGap(234, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(107, Short.MAX_VALUE)
        			.addComponent(lblTitle)
        			.addGap(107))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblID)
        			.addContainerGap(330, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblEnterYear)
        			.addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(6)
        			.addComponent(lblTitle)
        			.addGap(10)
        			.addComponent(lblID)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblName)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblEnterYear)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSpecialization)
        				.addComponent(comboSpecialization, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblSuccessMessage)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(tfSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addComponent(lblSalaryLabel))
        							.addGap(18))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(66)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnSave)
        						.addComponent(btnReturn))))
        			.addContainerGap(114, Short.MAX_VALUE))
        );

        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setLocationRelativeTo(null);
    }
}
