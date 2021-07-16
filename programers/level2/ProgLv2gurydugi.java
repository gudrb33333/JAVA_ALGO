package level2;

import java.awt.Point;
import java.util.*;

public class ProgLv2gurydugi {

	public static void main(String[] args) {
		
		String[] s = {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"};
		char[][] room = new char[5][5]; 
		
		for(int j=0; j<5; j++){
            for(int k=0; k<5; k++){
                room[j][k] = s[j].charAt(k);
            }
         }
		
		int row_length = room.length;
		int column_length = room[0].length;
		
		for(int y=0; y<row_length; y++){
			for(int x=0; x<column_length; x++) {
				if(room[y][x] != 'P') continue;
					
				Queue<Point> q = new LinkedList<Point>();
				boolean[][] visited = new boolean[row_length][column_length];
				int level = 0;
				int size = 0;
				q.add(new Point(y,x));
				
				while(q.isEmpty()==false) {
					if(level == 2) break;
					size = q.size();
					level++;		
					for(int i=0; i<size; i++) {				
						int qy = q.peek().x;
						int qx = q.peek().y;
						q.remove();
								
						visited[y][x] = true;
						//哭率
						if(qx>0 && !visited[qy][qx-1] && (room[qy][qx-1]=='O' || room[qy][qx-1]=='P')) {
							if(room[qy][qx-1]=='P') {
								q.clear();
								System.out.println("0");
								break;
							}else {
								q.add(new Point(qy,qx-1));
							}
						}
						
						//坷弗率
						if(qx<row_length-1 && !visited[qy][qx+1] &&  (room[qy][qx+1]=='O' || room[qy][qx+1]=='P')) {
							if(room[qy][qx+1]=='P') {
								q.clear();
								System.out.println("0");
								break;
							}else {
								q.add(new Point(qy,qx+1));
							}
						}
						
						//困率
						if(qy>0 && !visited[qy-1][qx] &&  (room[qy-1][qx]=='O' || room[qy-1][qx]=='P')) {
							if(room[qy-1][qx]=='P') {
								q.clear();
								System.out.println("0");
								break;
							}else {
								q.add(new Point(qy-1,qx+1));
							}
						}
						
						//酒阀率
						if(qy<column_length && !visited[qy+1][qx] && (room[qy+1][qx]=='O' || room[qy+1][qx]=='P')) {
							if(room[qy+1][qx]=='P') {
								q.clear();
								System.out.println("0");
								break;
							}else {
								q.add(new Point(qy+1,qx));
							}
						}
					}
						
				}
			}
		}
	}	
		
	

}
