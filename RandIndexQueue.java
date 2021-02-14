package project1;

import java.util.Random;
@SuppressWarnings("unchecked")
public class RandIndexQueue<T>
implements MyQ<T>, Indexable<T>, Shufflable{
	private T[] data;
	private Random Rand = new Random();
	private T[] newData;
	private int first;
	private int last;
	private int moves;
	private int size;
	private T removed;
	public RandIndexQueue(int size){
		data = (T[]) new Object[size];
	}
	public T[] getData() {
		return data;
	}
	public void setData(T[] newData) {
		data = newData;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int newFirst) {
		this.first = newFirst;
	}
	public T getRemoved() {
		return removed;
	}
	public void setRemoved(T removed) {
		this.removed = removed;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int newLast) {
		this.last = newLast;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int newSize) {
		this.size = newSize;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int newMoves) {
		this.moves = newMoves;
	}
	public T dequeue() {
		if(data[first] != null) {
			removed = data[first];
			data[first] = null;
			if(first == data.length - 1) {
				first = 0;
			} else {
				first++;
			}
			moves++;
			size--;
		return data[first];
		}
		else {
			return null;
		}
	}
	public void enqueue(T newEntry) {
		if(last < data.length-1) {
			last++;
		} else if (last == first - 1) {
			newData = (T[]) new Object[2 * data.length];
			for(int i = 0; i < size; i++) {
				newData[i] = this.get(i);
			}
			first = 0;
			data = newData;
			last = size;
		}
		else {
			last = 0;
		}
		moves++;
		size++;
		data[last] = newEntry;
	}
	public T getFront() {
		while(data[first] == null) {
			first = first + 1 % data.length;
		}
		return data[first];
	}
	public RandIndexQueue(RandIndexQueue<T> old) {
		this.data = old.getData();
	}
	public boolean equals(RandIndexQueue<T> rhs) {
		return this.data == rhs.getData();
	}
	public String toString() {
		String fill = null;
		int i = first;
		while (i < size) {
			if(i < data.length - 1){
				fill += data[i].toString();
				i++;
			} else {
				i = 0;
				fill += data[i].toString();
				i++;
			}
		}
		return fill;
	}
	@Override
	public boolean isEmpty() {
		if (data[first] == null) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void clear() {
		for(int i = 0; i < data.length; i++) {
			data[i] = null;
		}
		size = 0;
		first = 0;
		last = 0;
	}
	public void shuffle() {
		for(int n = 0; n < size; n++) {
			data[Rand.nextInt(size-1)] = data[n];
		}
		
	}
	public int size() {
		return size;
	}
	public int capacity() {
		return data.length;
	}
	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void set(int i, T item) {
		// TODO Auto-generated method stub
		
	}
}
