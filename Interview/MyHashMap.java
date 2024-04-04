import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap m = new MyHashMap();
		m.put(1, 1);
		m.put(2, 2);
		m.get(1);
		m.remove(2);
		m.get(2);
	}

	LinkedList<Entry>[] buckets;
	int size = 1000;

	MyHashMap() {
		buckets = new LinkedList[size];
	}

	public void put(int key, int value) {
		int index = key % size;
		LinkedList<Entry> list = buckets[index];
		if (list == null) {
			list = new LinkedList<>();
			list.add(new Entry(key, value));
			buckets[index] = list;
		} else {
			for (Entry e : list) {
				if (e.key == key) {
					e.value = value;
					return;
				}
			}
		}
	}

	public int get(int key) {
		int index = key % size;
		int val = -1;
		LinkedList<Entry> list = buckets[index];
		if (list != null) {
			for (Entry e : list) {
				if (e.key == key) {
					val = e.value;
					break;
				}
			}
		}
		return val;
	}

	public void remove(int key) {
		int index = key % size;
		LinkedList<Entry> list = buckets[index];
		Entry obslete = null;
		if (list == null) {
			return;
		} else {
			for (Entry e : list) {
				if (e.key == key) {
					obslete = e;
					break;
				}
			}
		}
		if (obslete != null) {
			
			list.remove(obslete);
		}
		ArrayList<Integer> res = new ArrayList<>();
		res.set(index, null)
	}
}

class Entry {
	int key;
	int value;

	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}