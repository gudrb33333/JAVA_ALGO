package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

import algo.ProgLv2MenuRenu.LinkedList.Node;

public class ProgLv2MenuRenu {

	static class LinkedList{
		
		static class Node{
			private String value;
			private Node next;
			
			Node(String value){
				this.value = value;
				this.next = null;
			}
		} 
		
		private Node head;
		private Node tail;
	
		LinkedList(){
			this.head = new Node("head");
			this.tail = new Node("tail");
			head.next = tail;
		}
		
		public void addFirst(Node node){
			node.next = this.head.next;
			this.head.next = node;
		}
		
		public Node peek() {
			return this.head.next;
		}
		
		public Node poll() {
			Node n = this.head.next;
			this.head.next = this.head.next.next;
			return n;
		}
		
	}
	
	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,5};
		
		ArrayList<String> arr = new ArrayList<String>();
		
		LinkedList lList = new LinkedList();
		Comparator<String> myComp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return -1;
				}
				return 0;
			}
		};
		
		Arrays.sort(orders,myComp);
		int z=0;
		while(orders.length != z) {
			lList.addFirst(new Node(orders[z++]));
		}

		
		for(String ordersNum : orders) {
			while(true) {
							
				HashSet<Character> set = new HashSet<Character>();
				Node n = lList.poll();
				Node peek = lList.peek();
				
				int check = 0;
				for(int i=0; i<n.value.length(); i++) {
					set.add(n.value.charAt(i));
				}
				
				while(true) {
					for(int i=0; i<peek.value.length(); i++) {
						if(set.contains(peek.value.charAt(i)))  check++;
					}
					if(check == n.value.length()) {
						arr.add(n.value);
						break;
					}
					if(peek.value.equals("tail")) break;
					peek = peek.next;
					check = 0;
				}

			}
		}
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}

	}

}
