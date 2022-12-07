

class sQueue { // offer(저장) poll(추출)
	private int maxsize;
	private int offercount;
	private int pollindex;
	private Object queuearr[];
	
	public sQueue(int maxsize) {
		offercount = -1;
		pollindex = 0;
		this.maxsize = maxsize;
		queuearr = new Object[maxsize];
	}
	
	public boolean isEmpty() {
		return (offercount == -1);
	}
	
	public boolean isFull() {
		return (offercount == maxsize - 1);
	}
	
	public void offer(Object obj) {
		if (isFull()) {
			System.out.println("full");
		} else { 
			queuearr[++offercount] = obj;
		}
	}
	
	public Object poll() {
		Object value = null;
		
		if (isEmpty()) {
			System.out.println("empty");
		} else {
			value = queuearr[pollindex++];
			offercount--;
		}
		return value;
	}
	
}

public class Study_Stack {
	
	public static void main(String[] args) {
		
		sQueue squeue = new sQueue(3);
		squeue.offer(10);
		squeue.offer(20);
		squeue.offer(30);
		squeue.offer(40);
		
		System.out.println(squeue.poll());
		System.out.println(squeue.poll());
		System.out.println(squeue.poll());
		System.out.println(squeue.poll());

	}

}
