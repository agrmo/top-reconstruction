package zahlen;

public class Counter {
    private int count;
    
    public Counter() { }
    
    public Counter(int init) {
	count = init;
    }
    
    public int getCount() {
	return count;
    }

    public void increment() {
	count++;
    }

    public void increment(int delta) {
	count += delta;
    }

    public void reset() {
	count = 0;
    }
}
