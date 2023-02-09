package level2;

import java.util.Arrays;
import java.util.Comparator;

import level2.ProgLv2Spicy.LinkedList.Node;

public class ProgLv2Spicy {
	
	
	static class LinkedList<E>{
		
	static class  Node<E>{
			private E data;
			private Node<E> prev;
			private Node<E> next;
			
			Node(E data,Node<E> prev,Node<E> next){
				this.data = data;
				this.prev = prev;
				this.next = next;
			}
		}
		
		private int size;
		private Node<E> head;
		private Node<E> crnt;
		 
		public LinkedList() {
			this.size = 0;
			head = crnt = null;
		}
		
		// ��� �˻�
		public Node<E> search(E obj, Comparator<? super E> c) {
			Node<E> ptr = head;							// ���� ��ĵ����  ���

			while (ptr != null) {
				if (c.compare(obj, ptr.data) == 0) {	// �˻� ����
					crnt = ptr;
					//System.out.println(ptr.data);
					return ptr;
				}		
				ptr = ptr.next;							// ���� ��带 ����
			}
			return null;								// �˻� ����
		}
		
		// �Ӹ��� ��� ����
		public void addFirst(E obj) {
			if(head == null) {
				Node<E> ptr = head;						// ���� ���� �Ӹ� ���
				this.size++;
				head = crnt = new Node<E>(obj, null, ptr);
			}else {
				Node<E> ptr = head;						// ���� ���� �Ӹ� ���
				this.size++;
				head = crnt = ptr.prev= new Node<E>(obj, null, ptr);
			}
		}
		
		public void addLast(E obj) {
			if(head == null) {
				addFirst(obj);
			}else {
				Node<E> ptr = head;
				while(ptr.next != null)
					ptr = ptr.next;
				this.size++;
				ptr.next = crnt = new Node<E>(obj, ptr ,null);
			}
		}
		
		public void add(E obj, Node<E> ptr) {
				if(ptr == head) {
					addFirst(obj);
				}else {
					ptr.prev = ptr.prev.next = new Node<E>(obj, ptr.prev, ptr);
					this.size++;
				}
			
		}
		
		public E removeFirst() {
			if(head != null) {
				E data = head.data;
				head = crnt = head.next;
				this.size--;
				return data;
			}
			return null;
		}
		
		// ��� ��带 ���
		public void dump() {
			Node<E> ptr = head;

			while (ptr != null) {
				System.out.println(ptr.data);
				ptr = ptr.next;
			}
		}

		
	}

	private static class MyComparator implements Comparator<Integer> {
		public int compare(Integer d1, Integer d2) {
			return (d1 > d2)? -1:0;
		}
	}
	
	
	public static void main(String[] args) {
		int answer = 0;
		
		int[] scoville	= {0, 0, 3, 9, 10, 12};
		int K = 7000;
		int test;
		int test1;
		
		Arrays.sort(scoville);
		LinkedList<Integer> list = new LinkedList<Integer>();
		Comparator<Integer> c =	 new MyComparator();

	
		
		for(int i=scoville.length-1; i >= 0; i--) {
			list.addFirst(scoville[i]);
		}
		
		do {
		 if(list.size < 2) break;
		 test = list.removeFirst();
		 test1 = list.removeFirst();

		int temp = test + (test1 *2);
		
		Node<Integer> ptr = list.search(temp, c);
		
		if(ptr != null) {
			list.add(temp,ptr);
		}else {
			list.addLast(temp);
		}
		System.out.println("------------------------");
		list.dump();
		System.out.println("------------------------");
		
		answer++;
		//System.out.println(test);
		//System.out.println(test1);
		}while(list.head.data < K);
		
		if(list.head.data < K) answer = -1;
		
		System.out.println(answer);
	}

}
