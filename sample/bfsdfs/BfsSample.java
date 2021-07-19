package bfsdfs;


/**
 *	거리두기 확인하기
 * 
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */

import java.util.*;

public class BfsSample {
	
	static class Node{
		int y;
		int x;
		int level;
		
		Node(int y, int x, int level){
			this.y = y;
			this.x = x;
			this.level = level;
		}
	}
	
	public static void bfs(char[][] room) {
		
		int row_len = room.length;
		int col_len = room[0].length;
	
		
		for(int y=0; y<row_len; y++) {
			for(int x=0; x<col_len; x++) {
				if(room[y][x] != 'P') continue;
				
				Queue<Node> que = new LinkedList<Node>();
				que.add(new Node(y,x,0));
				boolean[][] visited = new boolean[row_len][col_len];
		
				while(que.size()>0) {
					int size = que.size();
					
					for(int i=0; i<size; i++) {
						int qy = que.peek().y;
						int qx = que.peek().x;
						int qlevel = que.peek().level;
						que.remove();
						
						if(visited[qy][qx] == true) continue;
						visited[qy][qx] = true;
						
						if(qlevel !=0 && room[qy][qx] == 'P') {
							System.out.println('p');
							return;
						}
						
						//왼쪽
						if(qx>0 && visited[qx-1][qy]==false && room[qx-1][qy] !='X' && qlevel<2 ) {
							que.add(new Node(qx-1,qy,qlevel+1));
						}
						
						//오른쪽
						if(qx<col_len-1 && visited[qx+1][qy]==false && room[qx+1][qy] !='X' && qlevel<2 ) {
							que.add(new Node(qx+1,qy,qlevel+1));
						}
						
						//위
						if(qy>0 && visited[qx][qy-1]==false && room[qx][qy-1] !='X' && qlevel<2 ) {
							que.add(new Node(qx,qy-1,qlevel+1));
						}
						
						//아래
						if(qy<row_len-1 && visited[qx][qy+1]==false && room[qx][qy+1] !='X' && qlevel<2 ) {
							que.add(new Node(qx,qy+1,qlevel+1));
						}
						
					}
					
				}
			}
		}
			
	}
	
	public static void main(String[] args) {

		String[] arr = {
				"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"};
		int n = arr.length;
		
		char[][] room = new char[5][5];
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				room[i][j] = arr[i].charAt(j);
			}
		}

		bfs(room);
		
	}

}
