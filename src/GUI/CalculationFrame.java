package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

import Subclass.Trainer;
import Subclass.Worker;
import Subclass.Member;
import MainSys.GymManagementSystem;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculationFrame extends JFrame {
    private JPanel contentPane;
    private JLabel lblTotalSalary, lblTotalPayment, lblTotalProfit;
    
    private static final int YEARLY = 3000;
    private static final int MONTHLY = 500;
    private static final int DAILY = 150;
    private JButton btnReturn;

    public CalculationFrame() {
        setTitle("Gym Profit Calculation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        JLabel lblTitle = new JLabel("Gym Financial Overview");
        lblTitle.setBounds(64, 10, 262, 26);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        lblTotalSalary = new JLabel("Total Salary: 0.0");
        lblTotalSalary.setBounds(10, 60, 112, 17);
        lblTotalSalary.setFont(new Font("Arial", Font.BOLD, 14));

        lblTotalPayment = new JLabel("Total Membership Payments: 0.0");
        lblTotalPayment.setBounds(10, 95, 230, 17);
        lblTotalPayment.setFont(new Font("Arial", Font.BOLD, 14));

        lblTotalProfit = new JLabel("Total Profit: 0.0");
        lblTotalProfit.setBounds(10, 130, 106, 17);
        lblTotalProfit.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(149, 202, 97, 25);
        btnCalculate.setBackground(new Color(60, 179, 113));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFont(new Font("Arial", Font.BOLD, 14));
        
        
        btnCalculate.addActionListener(e -> calculateFinances());
        contentPane.setLayout(null);
        contentPane.add(lblTotalProfit);
        contentPane.add(lblTotalPayment);
        contentPane.add(lblTotalSalary);
        contentPane.add(btnCalculate);
        contentPane.add(lblTitle);
        
        btnReturn = new JButton("Return");
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Arial", Font.BOLD, 14));
        btnReturn.setBackground(new Color(220, 20, 60));
        btnReturn.setBounds(256, 309, 95, 25);
        contentPane.add(btnReturn);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateFinances() {
        double totalSalary = 0.0;
        double totalPayment = 0.0;
        
        Set<Trainer> trainers = GymManagementSystem.getTrainers();
        for (Trainer trainer : trainers) {
            totalSalary += trainer.getSalary();
        }

        Set<Worker> workers = GymManagementSystem.getWorkers();
        for (Worker worker : workers) {
            totalSalary += worker.getSalary();
        }

        Set<Member> members = GymManagementSystem.getMembers();
        for (Member member : members) {
            totalPayment += member.getPayment();
        }

        double totalProfit = totalPayment - totalSalary;

        lblTotalSalary.setText("Total Salary: " + totalSalary);
        lblTotalPayment.setText("Total Membership Payments: " + totalPayment);
        lblTotalProfit.setText("Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        new CalculationFrame();
    }
}
