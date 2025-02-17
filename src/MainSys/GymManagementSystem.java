package MainSys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import Subclass.Member;
import Subclass.Trainer;
import Subclass.Worker;

public class GymManagementSystem {

    private static Set<Member> members = new TreeSet<>();
    private static Set<Trainer> trainers = new HashSet<>();
    private static Set<Worker> workers = new HashSet<>();
    
    public static boolean addMember(Member m) {
        if (!members.contains(m)) {
            members.add(m);
            return true;
        }
        return false;
    }

    public static boolean addTrainer(Trainer t) {
        if (!trainers.contains(t)) {
            trainers.add(t);
            return true;
        }
        return false;
    }

    public static boolean addWorker(Worker w) {
        if (!workers.contains(w)) {
            workers.add(w);
            return true;
        }
        return false;
    }

    public static boolean removeMember(int id) {
        Member m = searchMember(id);
        if (m != null) {
            members.remove(m);
            return true;
        }
        return false;
    }

    public static boolean removeTrainer(int id) {
        Trainer t = searchTrainer(id);
        if (t != null) {
            trainers.remove(t);
            return true;
        }
        return false;
    }

    public static boolean removeWorker(int id) {
        Worker w = searchWorker(id);
        if (w != null) {
            workers.remove(w);
            return true;
        }
        return false;
    }

    public static Member searchMember(int id) {
        for (Member m : members) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public static Trainer searchTrainer(int id) {
        for (Trainer t : trainers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
    
    public static Worker searchWorker(int id) {
        for (Worker w : workers) {
            if (w.getId() == id) {
                return w;
            }
        }
        return null;
    }

    public static Set<Member> getMembers() {
		return members;
	}

	public static Set<Trainer> getTrainers() {
		return trainers;
	}

	public static Set<Worker> getWorkers() {
		return workers;
	}
	
	public static HashSet<Integer> getTrainerIds() {
        HashSet<Integer> trainerIds = new HashSet<>();
        for (Trainer trainer : trainers) {
            trainerIds.add(trainer.getId());  
        }
        return trainerIds;
    }

	public static String displayAllMembers() {
        StringBuilder sb = new StringBuilder("Members:\n");
        for (Member member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
   
    public static String displayAllTrainers() {
        StringBuilder sb = new StringBuilder("Trainers:\n");
        for (Trainer t : trainers) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    public static String displayAllWorkers() {
        StringBuilder sb = new StringBuilder("Workers:\n");
        for (Worker w : workers) {
            sb.append(w.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public static boolean assignTrainerToMember(int trainerId, int memberId) {
        Trainer selectedTrainer = null;
        Member selectedMember = null;
    
        for (Trainer trainer : trainers) {
            if (trainer.getId() == trainerId) {
                selectedTrainer = trainer;
                break;
            }
        }

        for (Member member : members) {
            if (member.getId() == memberId) {
                selectedMember = member;
                break;
            }
        }

        if (selectedTrainer == null || selectedMember == null) {
            return false;  
        }

        if (selectedTrainer.getAssignedMember() != null) {
            return false;  
        }

        selectedTrainer.setAssignedMember(selectedMember);
        selectedMember.setAssignedTrainer(selectedTrainer);
        return true;
    }

    public static double calculateMembershipPlan() {
        double total = 0;
        for (Member m : members) {
            total += m.calculatePayment(m.getMembershipPlan());
        }
        return total;
    }

    public static double calculateTrainerSalaries() {
        double total = 0;
        for (Trainer t : trainers) {
            total += t.getSalary();
        }
        return total;
    }

    public static double calculateWorkerSalaries() {
        double total = 0;
        for (Worker w : workers) {
            total += w.getSalary();
        }
        return total;
    }

    public static double summariseProfit() {
        double revenue = calculateMembershipPlan();
        double salaries = calculateTrainerSalaries() + calculateWorkerSalaries();
        return revenue - salaries;
    }

    public static Member getMemberById(Integer selectedMemberId) {

        Set<Member> members = GymManagementSystem.getMembers();
        
        for (Member member : members) {
            if (member.getId()==selectedMemberId) {
                return member; 
            }
        }
        
        return null;
    }

    public static Trainer getTrainerById(Integer selectedTrainerId) {
        Set<Trainer> trainers = GymManagementSystem.getTrainers();
        
        for (Trainer trainer : trainers) {
            if (trainer.getId()==selectedTrainerId) {
                return trainer; 
            }
        }
        
        return null;
    }

}
