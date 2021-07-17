package level2;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class ProgLv2Gamemap {

	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}};

		
		  int X = maps[0].length;
	      int Y = maps.length;
	      boolean[][] visited = new boolean[Y][X];
	      Queue<Point> q = new LinkedList<Point>();
	      int x = 0;
	      int y = 0;
	      int size = 0;
	      int cnt = 0;
	      
	      Point p = new Point();
	      q.add(new Point(Y-1,X-1));
	      
	      while(q.isEmpty()==false) {
	    	  size = q.size();
	          cnt++;
	          for(int i=0;i<size;i++) {
	        	  p = q.peek();
	        	  x = p.y;
	              y = p.x;
	              q.remove();
	              
	              if(visited[y][x]==true) continue;
	              maps[y][x] = 0;
	              visited[y][x] = true;
	              
	              if(x==0 && y==0) System.out.println(cnt);
	              
	              if(x-1>-1 && maps[y][x-1]==1) q.add(new Point(y,x-1)); //¿ÞÂÊ ÇÑÄ­
	              
	              if(x+1<X && maps[y][x+1]==1) q.add(new Point(y,x+1)); //¿À¸¥ÂÊ ÇÑÄ­
	              
	              if(y-1>-1 && maps[y-1][x]==1) q.add(new Point(y-1,x));

	              if(y+1<Y && maps[y+1][x]==1) q.add(new Point(y+1,x));  //¾Æ·¡ÂÊ ÇÑÄ­ 
	              
	              
	              
	          }
	      }
	}

}
