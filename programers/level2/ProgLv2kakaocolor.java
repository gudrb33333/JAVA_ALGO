package level2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ProgLv2kakaocolor {

	static class Point{
		int y;
		int x;
		int value;
		
		Point(int y,int x,int value){
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		int[][] picture = {
				{1, 2, 3, 4},
				{1, 30, 3, 3}, 
				{1, 3, 0, 3}};

		int X = picture[0].length;
		int Y = picture.length;
		int max = 0;
		int division = 0;
		
		boolean[][] visited = new boolean[Y][X];
		Queue<Point> que = new LinkedList<Point>();
		HashSet<String> set = new HashSet<String>();
		
		for(int y=0; y<Y; y++) {
			for(int x=0; x<X; x++) {
				if(visited[y][x]==false && picture[y][x]>0) {
					division++;
					int cnt = 0;
					que.add(new Point(y,x,picture[y][x]));
					 
					while(que.isEmpty()==false) {
						int size = que.size();
						set.clear();
						for(int i=0; i<size; i++) {
							
							int qy = que.peek().y;
							int qx = que.peek().x;
							int qval = que.peek().value;
							que.remove();
							cnt++;
							
							 if(visited[qy][qx]==true) continue;
							
							 visited[qy][qx]=true;
							//오른쪽 이동
							if(qx+1<X && picture[qy][qx+1]==qval && 
							   visited[qy][qx+1]==false && 
							   !set.contains(String.valueOf(qy)+String.valueOf(qx+1))) 
							{
								que.add(new Point(qy,qx+1,qval));	
								set.add(String.valueOf(qy)+String.valueOf(qx+1));
							}
							
							//왼쪽 이동
							if(qx-1>-1 && picture[qy][qx-1]==qval && visited[qy][qx-1]==false && !set.contains(String.valueOf(qy)+String.valueOf(qx-1))) {
								que.add(new Point(qy,qx-1,qval));
								set.add(String.valueOf(qy)+String.valueOf(qx-1));
							}
							//위로 이동
							if(qy-1>-1 && picture[qy-1][qx]==qval && visited[qy-1][qx]==false && !set.contains(String.valueOf(qy-1)+String.valueOf(qx))) {
								que.add(new Point(qy-1,qx,qval));
								set.add(String.valueOf(qy-1)+String.valueOf(qx));
							}
							
							//아래로 이동
							if(qy+1<Y && picture[qy+1][qx]==qval && visited[qy+1][qx]==false && !set.contains(String.valueOf(qy+1)+String.valueOf(qx))) { 
								que.add(new Point(qy+1,qx,qval));
								set.add(String.valueOf(qy+1)+String.valueOf(qx));
							}
						}	
			
					}
					
					if(cnt>max)
						max = cnt;
				}
				
			}
		}
		System.out.println(division);
		System.out.println(max);
	}

}
