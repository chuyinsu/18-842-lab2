package multicast;

import ipc.MessagePasser;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class GroupManager {
	private int id;
	private String name;
	private LinkedBlockingQueue<RQueueElement> reliabilityQueue;
	private LinkedBlockingQueue<MulticastMessage> casualOrderingQueue;
	private LinkedBlockingQueue<MulticastMessage> deliverQueue;
	private ArrayList<String> members;

	public GroupManager(int id, String name, ArrayList<String> members) {
		this.id = id;
		this.name = name;
		this.reliabilityQueue = new LinkedBlockingQueue<RQueueElement>();
		this.casualOrderingQueue = new LinkedBlockingQueue<MulticastMessage>();
		this.deliverQueue = new LinkedBlockingQueue<MulticastMessage>();

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

	public LinkedBlockingQueue<MulticastMessage> getDeliverQueue() {
		return deliverQueue;
	}

	public void setDeliverQueue(
			LinkedBlockingQueue<MulticastMessage> deliverQueue) {
		this.deliverQueue = deliverQueue;
	}

	public void send(MulticastMessage message, MessagePasser mp) {
		for (String m : members) {
			message.setSource(m);
			mp.send(new MulticastMessage(message));
		}
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
}
