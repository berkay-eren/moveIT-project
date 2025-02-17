package GUI;

import javax.swing.*;
import java.awt.*;
import Subclass.Member;
import Subclass.Trainer;
import Subclass.Worker;
import MainSys.GymManagementSystem;

public class AddFrame extends JFrame {
    private JPanel contentPane;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField tfID, tfName, tfEnterYear;
    private JLabel lblError;  

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AddFrame frame = new AddFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AddFrame() {
        setTitle("Add a New Person");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new Color(240, 248, 255));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Add a New Person");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblID = new JLabel("ID:");
        JLabel lblName = new JLabel("Name:");
        JLabel lblEnterYear = new JLabel("Enter Year:");

        lblID.setFont(new Font("Arial", Font.PLAIN, 14));
        lblName.setFont(new Font("Arial", Font.PLAIN, 14));
        lblEnterYear.setFont(new Font("Arial", Font.PLAIN, 14));

        tfID = new JTextField();
        tfName = new JTextField();
        tfEnterYear = new JTextField();

        JRadioButton rdbtnMember = new JRadioButton("Member");
        JRadioButton rdbtnTrainer = new JRadioButton("Trainer");
        JRadioButton rdbtnWorker = new JRadioButton("Worker");

        buttonGroup.add(rdbtnMember);
        buttonGroup.add(rdbtnTrainer);
        buttonGroup.add(rdbtnWorker);
        rdbtnMember.setSelected(true);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(new Color(60, 179, 113));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnReturn = new JButton("Return");
        btnReturn.setBackground(new Color(220, 20, 60));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 14));

     
        lblError = new JLabel("");
        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Arial", Font.ITALIC, 12));

        btnAdd.addActionListener(e -> {
        
            if (tfID.getText().isEmpty() || tfName.getText().isEmpty() || tfEnterYear.getText().isEmpty()) {
                lblError.setText("Error: All fields must be filled out!");
                
                if(tfID.getText().isEmpty())
                	lblID.setForeground(new Color(255, 0, 0));
                else
                	lblID.setForeground(new Color(0, 0, 0));
                if(tfName.getText().isEmpty())
                	lblName.setForeground(new Color(255, 0, 0));
                else
                	lblName.setForeground(new Color(0, 0, 0));
                
                if(tfEnterYear.getText().isEmpty())
                	lblEnterYear.setForeground(new Color(255, 0, 0));
                else
                	lblEnterYear.setForeground(new Color(0, 0, 0));   
                
                return;  
            }

            
            int id;
            int enterYear;
            try {
                id = Integer.parseInt(tfID.getText());
                enterYear = Integer.parseInt(tfEnterYear.getText());
            } catch (NumberFormatException ex) {
                lblError.setText("Error: ID and Enter Year must be valid numbers.");
                return;
            }
     
            if (idExists(id)) {
                lblError.setText("Error: ID already exists!");
                return;  
            }

            
            if (rdbtnMember.isSelected()) {
                MemberFrame memberFrame = new MemberFrame(id, tfName.getText(), enterYear);
                memberFrame.setVisible(true);  
            } else if (rdbtnTrainer.isSelected()) {
                TrainerFrame trainerFrame = new TrainerFrame(id, tfName.getText(), enterYear);
                trainerFrame.setVisible(true);  
            } else if (rdbtnWorker.isSelected()) {
                WorkerFrame workerFrame = new WorkerFrame(id, tfName.getText(), enterYear);
                workerFrame.setVisible(true);  
            }
            dispose(); 
        });

        btnReturn.addActionListener(e -> dispose());

        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(lblTitle)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblID)
                        .addComponent(lblName)
                        .addComponent(lblEnterYear))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tfID)
                        .addComponent(tfName)
                        .addComponent(tfEnterYear)))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(rdbtnMember)
                    .addComponent(rdbtnTrainer)
                    .addComponent(rdbtnWorker))
                .addComponent(lblError)  
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnAdd)
                    .addComponent(btnReturn))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(tfID))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnterYear)
                    .addComponent(tfEnterYear))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnMember)
                    .addComponent(rdbtnTrainer)
                    .addComponent(rdbtnWorker))
                .addComponent(lblError)  
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnReturn))
        );
    }

    
    private boolean idExists(int id) {
       
        
        for (Member member : GymManagementSystem.getMembers()) {
            if (member.getId() == id) {
                return true; 
            }
        }
        
  
        for (Trainer trainer : GymManagementSystem.getTrainers()) {
            if (trainer.getId() == id) {
                return true; 
            }
        }
        
     
        for (Worker worker : GymManagementSystem.getWorkers()) {
            if (worker.getId() == id) {
                return true;
            }
        }

        return false; 
    }
}
