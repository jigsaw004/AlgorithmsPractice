//http://stackoverflow.com/questions/29376069/lexographically-smallest-path-in-a-nm-grid/39692211#39692211

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

class Range{
	int a, b, c, d;
	Range left, right;
	Range(int a, int b, int c, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		left = right = null;
	}
	public boolean isInRange(int e, int f){
		return (e >= a && e <= c && f >= b && f <= d);
	}
	public boolean hasNoChild(){
		return (left == null && right == null);
	}
}
public class Solution{
	
	public static void main(String args[]){
		int[][] arr = {
				{6,18,13,11,2},
				{20,19,24,10,5},
				{25,12,1,17,9},
				{8,23,4,21,22},
				{3,15,16,14,7},
		};
		int[][] arr2 = {{4,3},{5,1}};
		System.out.println(Arrays.toString(shortestPath(arr)));
	}
	public static int[] shortestPath(int[][] arr){
		int row = arr.length;
		int col = arr[0].length;
		int[][] index = new int[row*col+1][2];
		//HashMap<Integer,Point> map = new HashMap<Integer,Point>();
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				index[arr[i][j]][0]=i;
				index[arr[i][j]][1]=j;
				//map.put(arr[i][j], new Point(i,j));
			}
		}
		Range root = new Range(0,0,row-1,col-1);
		for(int i = 1; i < index.length; i++){
		//SortedSet<Integer> keys = new TreeSet<Integer>(map.keySet());
		//for(Integer entry : keys){
			Range temp = root;
			
			while(temp.isInRange(index[i][0], index[i][1])){
				if(temp.hasNoChild()){
					temp.left = new Range(temp.a,temp.b,index[i][0], index[i][1]);
					temp.right = new Range(index[i][0], index[i][1],temp.c,temp.d);
					break;
				}
				if(temp.left.isInRange(index[i][0], index[i][1])){
					temp = temp.left;
				}
				else if(temp.right.isInRange(index[i][0], index[i][1])){
					temp = temp.right;
				}
				else{
					index[i][0] = -1;
					break;
				}
			}
			
			//int x = map.get(entry).x, y = map.get(entry).y;
			
			int x = index[i][0], y = index[i][1];
			while(temp.isInRange(x, y)){
				if(temp.hasNoChild()){
					temp.left = new Range(temp.a,temp.b,x, y);
					temp.right = new Range(x, y,temp.c,temp.d);
					break;
				}
				if(temp.left.isInRange(x, y)){
					temp = temp.left;
				}
				else if(temp.right.isInRange(x, y)){
					temp = temp.right;
				}
				else{
					//map.get(entry).x = -1;
					index[i][0]=-1;
					break;
				}
			}
			
		}
		int[] solution = new int[row+col-1];
		int count = 0;
		for(int i = 0 ; i < row; i++){
			for(int j = 0; j < col; j++){
				if(index[arr[i][j]][0] >= 0){
				//if(map.get(arr[i][j]).x >= 0){
					solution[count++] = arr[i][j];
				}
			}
		}
		return solution;
	}
	
	
}
