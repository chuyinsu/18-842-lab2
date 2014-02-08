package multicast;

import java.util.concurrent.LinkedBlockingQueue;

public class Group implements Runnable {
	private int id;
	private String name;
	private LinkedBlockingQueue<RQueueElement> reliabilityQueue;
	private LinkedBlockingQueue<MulticastMessage> casualOrderingQueue;
	private LinkedBlockingQueue<MulticastMessage> deliverQueue;

	public Group(int id, String name) {
		this.id = id;
		this.name = name;
		this.reliabilityQueue = new LinkedBlockingQueue<RQueueElement>();
		this.casualOrderingQueue = new LinkedBlockingQueue<MulticastMessage>();
		this.deliverQueue = new LinkedBlockingQueue<MulticastMessage>();
	}

	public void run() {
		// loops on reliabilityQueue to check timeout messages
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
}
