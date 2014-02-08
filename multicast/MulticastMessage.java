package multicast;

import ipc.TimeStampedMessage;

import java.util.Arrays;

public class MulticastMessage extends TimeStampedMessage {
	private static final long serialVersionUID = -6266905058526960435L;

	// which group this message belongs to
	private int groupId;

	// for casual ordering
	private int[] seqVector;

	public MulticastMessage(String dest, String kind, Object data, int groupId,
			int[] seqVector) {
		super(dest, kind, data);
		this.groupId = groupId;
		this.seqVector = seqVector;
	}

	public MulticastMessage(MulticastMessage message) {
		super(message.getDest(), message.getKind(), message.getData());
		this.groupId = message.getGroupId();
		this.seqVector = message.getSeqVector();
	}

	@Override
	public String toString() {
		return "[src] " + getSource() + " [dst] " + getDest() + " [kind] "
				+ getKind() + " [seq] " + getSequenceNumber() + " [dup] "
				+ (isDupe() ? "true" : "false") + " [time] "
				+ getTimeStamp().toString() + " [multicast_seq_vector] "
				+ Arrays.toString(seqVector) + " [data] "
				+ getData().toString();
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int[] getSeqVector() {
		return seqVector;
	}

	public void setSeqVector(int[] seqVector) {
		this.seqVector = seqVector;
	}
}
