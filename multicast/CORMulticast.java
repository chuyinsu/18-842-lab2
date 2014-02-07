package multicast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Casual-Ordering Reliable Multicast (CORMulticast). Implementation details:
 * (1) Reliability Tools #1 in the lecture slides (R-multicast and R-deliver on
 * the book, Figure 15-9). (2) Causal ordering using vector timestamps on the
 * book (Figure 15.15).
 * 
 * @author Hao Gao
 * @author Yinsu Chu
 * 
 */
public class CORMulticast {
	private static final String GROUP_NAME = "name";
	private static final String GROUP_MEMBER = "members";

	// each group is represented as a HashMap, inside which key GROUP_NAME has
	// the group's name as a String value, key GROUP_MEMBER has the group's
	// members as an ArrayList<String> value
	private ArrayList<HashMap<String, Object>> groups;
}
