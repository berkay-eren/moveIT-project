package GUI;

import javax.swing.*;
import Comparator.MemberComparator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Subclass.*;
import Superclass.Person;
import MainSys.GymManagementSystem;

public class DisplayFrame extends JFrame {
    private DefaultListModel<String> model;

    public DisplayFrame() {
        setTitle("Display List");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 615, 580);
        getContentPane().setLayout(null); 

       
        JLabel titleLabel = new JLabel("Display List");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(250, 10, 150, 30); 
        getContentPane().add(titleLabel);

       
        JRadioButton allRadioButton = new JRadioButton("All");
        JRadioButton membersRadioButton = new JRadioButton("Members");
        JRadioButton trainersRadioButton = new JRadioButton("Trainers");
        JRadioButton workersRadioButton = new JRadioButton("Workers");

        ButtonGroup group = new ButtonGroup();
        group.add(allRadioButton);
        group.add(membersRadioButton);
        group.add(trainersRadioButton);
        group.add(workersRadioButton);

        allRadioButton.setBounds(100, 60, 100, 30);
        membersRadioButton.setBounds(200, 60, 100, 30);
        trainersRadioButton.setBounds(300, 60, 100, 30);
        workersRadioButton.setBounds(400, 60, 100, 30);

        getContentPane().add(allRadioButton);
        getContentPane().add(membersRadioButton);
        getContentPane().add(trainersRadioButton);
        getContentPane().add(workersRadioButton);

        JCheckBox chckbxByName = new JCheckBox("By Name");
        chckbxByName.setEnabled(false);

       
        model = new DefaultListModel<>();
        JList<String> displayList = new JList<>(model);
        displayList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(displayList);
        scrollPane.setBounds(50, 150, 500, 300); 
        getContentPane().add(scrollPane);

    
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(450, 480, 100, 30);
        returnButton.setBackground(new Color(128, 128, 192));
        returnButton.setForeground(Color.WHITE);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                new GeneralFrame().setVisible(true); 
                dispose(); 
            }
        });
        getContentPane().add(returnButton);

    
        allRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplayList("All");
                chckbxByName.setEnabled(false);
            }
        });

        membersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chckbxByName.setEnabled(true);
                updateDisplayList("Members");
            }
        });

        trainersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplayList("Trainers");
                chckbxByName.setEnabled(false);
            }
        });

        workersRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplayList("Workers");
                chckbxByName.setEnabled(false);
            }
        });

        chckbxByName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.clear();
                Set<Member> members = GymManagementSystem.getMembers();
                if (chckbxByName.isSelected()) {
                    TreeSet<Member> memberSet = new TreeSet<>(new MemberComparator());
                    memberSet.addAll(members);
                    for (Member m : memberSet) {
                        model.addElement(m.toString());
                    }
                }
            }
        });
        chckbxByName.setBounds(200, 109, 93, 21);
        getContentPane().add(chckbxByName);

        allRadioButton.setSelected(true); 
        updateDisplayList("All");

        setLocationRelativeTo(null); 
    }

    private void updateDisplayList(String type) {
        model.clear();

        switch (type) {
            case "All":
                Set<Member> members = GymManagementSystem.getMembers();
                Set<Trainer> trainers = GymManagementSystem.getTrainers();
                Set<Worker> workers = GymManagementSystem.getWorkers();

                TreeSet<Person> allEntities = new TreeSet<>();

                allEntities.addAll(members);
                allEntities.addAll(trainers);
                allEntities.addAll(workers);

                for (Object entity : allEntities) {
                    model.addElement(entity.toString());
                }
                break;

            case "Members":
                Set<Member> memberSet = GymManagementSystem.getMembers();
                List<Member> memberList = new ArrayList<>(memberSet);
                Collections.sort(memberList, Comparator.comparingInt(Member::getId));
                for (Member m : memberList) {
                    model.addElement(m.toString());
                }
                break;

            case "Trainers":
                Set<Trainer> trainerSet = GymManagementSystem.getTrainers();
                List<Trainer> trainerList = new ArrayList<>(trainerSet);
                Collections.sort(trainerList, Comparator.comparingInt(Trainer::getId));
                for (Trainer t : trainerList) {
                    model.addElement(t.toString());
                }
                break;

            case "Workers":
                Set<Worker> workerSet = GymManagementSystem.getWorkers();
                List<Worker> workerList = new ArrayList<>(workerSet);
                Collections.sort(workerList, Comparator.comparingInt(Worker::getId));
                for (Worker w : workerList) {
                    model.addElement(w.toString());
                }
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DisplayFrame().setVisible(true);
            }
        });
    }
}
