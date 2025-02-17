package GUI;

import javax.swing.*;
import java.awt.*;
import Subclass.Worker;
import MainSys.GymManagementSystem;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkerFrame extends JFrame {
    private JPanel contentPane;
    private JComboBox<String> comboPosition;
    private JLabel lblSuccessMessage;

    private static final String[] SPECIALIZATIONS = {"Janitor", "Bartender", "Cashier"};

    public WorkerFrame(int id, String name, int enterYear) {
        setTitle("Worker Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 316);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Worker Details");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblID = new JLabel("ID: " + id);
        JLabel lblName = new JLabel("Name: " + name);
        JLabel lblEnterYear = new JLabel("Enter Year: " + enterYear);
        JLabel lblPosition = new JLabel("Specialization:");
        JLabel lblSalaryLabel = new JLabel("Salary:");

        DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>(SPECIALIZATIONS);

        comboPosition = new JComboBox<>(comboModel);
        lblSuccessMessage = new JLabel("");

        lblSuccessMessage.setFont(new Font("Arial", Font.BOLD, 14));
        lblSuccessMessage.setForeground(new Color(34, 139, 34));
        
      
        JButton btnSave = new JButton("Save");
        btnSave.setBackground(new Color(60, 179, 113));
        btnSave.setForeground(Color.WHITE);
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));
        
        JTextArea taSalary = new JTextArea();
  
        JButton btnReturn = new JButton("Return");
        btnReturn.setBackground(new Color(220, 20, 60));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 14));

        taSalary.setText("1750");
        
        btnSave.addActionListener(e -> {
        	
        	 String specialization = (String) comboPosition.getSelectedItem();
        	 double salary; 
            if (comboPosition.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please fill all fields before saving.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
        
           
            	if(specialization.equalsIgnoreCase("janitor"))
            		salary= 1750;
            	else if(specialization.equalsIgnoreCase("bartender"))
					salary= 2000;
            	else
            		salary= 1500;             
            	
            	salary=Double.parseDouble(taSalary.getText());
                Worker worker = new Worker(id, name, enterYear, salary, specialization);
                GymManagementSystem.addWorker(worker);

                lblSuccessMessage.setText("Worker added successfully!");
                btnSave.setEnabled(false);  
            }
        });

        btnReturn.addActionListener(e -> {
            dispose();
            new AddFrame().setVisible(true);
        });
        
      
        
        
        comboPosition.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String specialization = (String) comboPosition.getSelectedItem();
        		if(specialization.equalsIgnoreCase("janitor"))
            		taSalary.setText("1750");
            	else if(specialization.equalsIgnoreCase("bartender"))
            		taSalary.setText("2000");
            	else
            		taSalary.setText("1500"); 
        		
        	}
        });
      

        GroupLayout layout = new GroupLayout(contentPane);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(18, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblSuccessMessage)
        				.addComponent(lblTitle)
        				.addComponent(lblID, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lblEnterYear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblPosition)
        						.addComponent(lblSalaryLabel)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(51)
        							.addComponent(btnSave)))
        					.addGap(98)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(taSalary, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnReturn)
        						.addComponent(comboPosition, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
        			.addGap(12))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTitle)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblID)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblName)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblEnterYear)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPosition)
        				.addComponent(comboPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSalaryLabel)
        				.addComponent(taSalary, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        			.addComponent(lblSuccessMessage)
        			.addGap(44)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnReturn)
        				.addComponent(btnSave))
        			.addContainerGap(114, Short.MAX_VALUE))
        );
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        setLocationRelativeTo(null);
    }
}
