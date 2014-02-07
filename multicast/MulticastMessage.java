package multicast;

import ipc.TimeStampedMessage;

public class MulticastMessage extends TimeStampedMessage {
	private static final long serialVersionUID = -6266905058526960435L;

	public MulticastMessage(String dest, String kind, Object data) {
		super(dest, kind, data);
	}
}
