package multicast;

import ipc.MessagePasser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;

public class GroupManager {
	private int id;
	private String name; // groupName
	private String localName; // node name
	private LinkedBlockingQueue<RQueueElement> reliabilityQueue;
	private LinkedBlockingQueue<MulticastMessage> casualOrderingQueue;
	private ArrayList<String> members;

	public GroupManager(String localName, int id, String name, ArrayList<String> members) {
		this.id = id;
		this.name = name;
		this.localName = localName;
		this.reliabilityQueue = new LinkedBlockingQueue<RQueueElement>();
		this.casualOrderingQueue = new LinkedBlockingQueue<MulticastMessage>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedBlockingQueue<RQueueElement> getReliabilityQueue() {
		return reliabilityQueue;
	}

	public void setReliabilityQueue(
			LinkedBlockingQueue<RQueueElement> reliabilityQueue) {
		this.reliabilityQueue = reliabilityQueue;
	}

	public LinkedBlockingQueue<MulticastMessage> getCasualOrderingQueue() {
		return casualOrderingQueue;
	}

	public void setCasualOrderingQueue(
			LinkedBlockingQueue<MulticastMessage> casualOrderingQueue) {
		this.casualOrderingQueue = casualOrderingQueue;
	}

	public void send(MulticastMessage message, MessagePasser mp) {
		MulticastMessage originalMessage = new MulticastMessage(message);
		HashSet<String> remainingNodes = new HashSet<String>();
		
		for (String m : members) {
			if (!m.equals(localName)) {
				remainingNodes.add(m);
				message.setDest(m);
				mp.send(new MulticastMessage(message));
			} 
		}
		
		RQueueElement rqElem = new RQueueElement(remainingNodes, System.currentTimeMillis(), 
				originalMessage);
		// acquire a lock here!
		try {
			reliabilityQueue.put(rqElem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}

	public void checkReliabilityQueue(MulticastMessage message) {
		// acquire a lock here!
		
	}

	public void checkTimeOut(long timeout, MessagePasser mp) {
		long curTime = System.currentTimeMillis();
		for (RQueueElement rqElem : reliabilityQueue) {
			// resend
			if (curTime - rqElem.getReceivedTime() >= 0) {
				// message is organic from this node
				MulticastMessage message;
				MulticastMessage originalMessage = rqElem.getMessage();
				if (localName.equals(originalMessage.getSource())) {
					message = new MulticastMessage(rqElem.getMessage());
				} else {
					message = new MulticastMessage(localName, originalMessage.getKind(), 
							new MulticastMessage(originalMessage), id, null);
				}
				for (String name : rqElem.getRemainingNodes()) {
					message.setDest(name);
					mp.send(new MulticastMessage(message));
				}
			}
		}
	}
}
