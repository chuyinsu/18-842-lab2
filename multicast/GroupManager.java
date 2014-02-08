package multicast;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class GroupManager {
	private int id;
	private String name;
	private LinkedBlockingQueue<RQueueElement> reliabilityQueue;
	private LinkedBlockingQueue<MulticastMessage> casualOrderingQueue;
	private ArrayList<String> members;

	public GroupManager(int id, String name, ArrayList<String> members) {
		this.id = id;
		this.name = name;
		this.reliabilityQueue = new LinkedBlockingQueue<RQueueElement>();
		this.casualOrderingQueue = new LinkedBlockingQueue<MulticastMessage>();
		this.members = members;
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
}
