package Comparator;

import java.util.Comparator;
import Subclass.Member;

public class MemberComparator implements Comparator<Member> {
	
    @Override
    public int compare(Member m1, Member m2) {
       
        int nameComparison = m1.getName().compareTo(m2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(m1.getId(), m2.getId());
    }
}
