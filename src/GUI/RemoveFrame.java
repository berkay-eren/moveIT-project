package GUI;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import MainSys.GymManagementSystem;
import Subclass.Member;
import Subclass.Trainer;
import Subclass.Worker;
import Superclass.Person;

import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveFrame extends JFrame {
	private JCheckBox[] checkboxes;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFrame frame = new RemoveFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RemoveFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(28, 65, 334, 327);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		
		JButton removeButton = new JButton("Remove");
		removeButton.setBackground(new Color(0, 128, 255));
		removeButton.setForeground(new Color(255, 255, 255));
		removeButton.setBounds(26, 411, 112, 38);
		contentPane.add(removeButton);
		
		JButton returnButton = new JButton("Return");
		returnButton.setForeground(new Color(255, 255, 255));
		returnButton.setBackground(new Color(220, 20, 60));
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		returnButton.setBounds(238, 411, 124, 38);
		contentPane.add(returnButton);
		
		JLabel lblNewLabel = new JLabel("RECORD LIST");
		lblNewLabel.setBackground(new Color(255, 128, 128));
		lblNewLabel.setBounds(157, 17, 98, 38);
		contentPane.add(lblNewLabel);
		
		
		Set<Member> members = GymManagementSystem.getMembers();
		Set<Trainer> trainers = GymManagementSystem.getTrainers();
		Set<Worker> workers = GymManagementSystem.getWorkers();

		TreeSet<Person> allEntities = new TreeSet<Person>();
		Map<JCheckBox, Person> checkboxPersonMap = new HashMap<>();
		
		allEntities.addAll(members);
		allEntities.addAll(trainers);
		allEntities.addAll(workers);
		
		JCheckBox[] checkboxes = new JCheckBox[allEntities.size()];
	
		int i=0;
		for (Person entity : allEntities) {
			checkboxes[i]=new JCheckBox(String.valueOf("ID: "+entity.getId()+" Name: "+entity.getName()+" Type:"+entity.getClass().toString().substring(entity.getClass().toString().length() - 7)));
		    panel.add(checkboxes[i] );
		    checkboxPersonMap.put(checkboxes[i], entity);
		    i++;
		}
	
		
		
	
		
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              
                for (JCheckBox checkbox : checkboxes) {
                    if (checkbox.isSelected()) {
                        Person m = checkboxPersonMap.get(checkbox);
                        if (m instanceof Member)
                            GymManagementSystem.removeMember(m.getId());
                        else if (m instanceof Worker)
                            GymManagementSystem.removeWorker(m.getId());
                        else
                            GymManagementSystem.removeTrainer(m.getId());
                    }
                }

              
                panel.removeAll();

                Set<Member> members = GymManagementSystem.getMembers();
                Set<Trainer> trainers = GymManagementSystem.getTrainers();
                Set<Worker> workers = GymManagementSystem.getWorkers();

                TreeSet<Person> allEntities = new TreeSet<Person>();
                allEntities.addAll(members);
                allEntities.addAll(trainers);
                allEntities.addAll(workers);
            
                int i = 0;
                for (Person entity : allEntities) {
                    checkboxes[i] = new JCheckBox("ID: " + entity.getId() + " Name: " + entity.getName() + " Type: " + entity.getClass().toString().substring(entity.getClass().toString().length() - 7));
                    panel.add(checkboxes[i]);
                    checkboxPersonMap.put(checkboxes[i], entity);
                    i++;
                }

                panel.revalidate();
                panel.repaint();
            }

		});
		
	}
}
