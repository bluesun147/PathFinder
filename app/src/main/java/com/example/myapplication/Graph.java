package com.example.myapplication;

import android.app.Activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Graph extends Activity
{
	// 노드와 비용을 포함하는 객체를 미리 만들어준다.
	static public class Node 
	{
		int end;// 연결되는 정점
		
		// 노선 데이터 저장 배열
		// [0] : 시간, [1] : 거리, [2] : 비용, [3] : 추천 알고리즘 데이터
		int[] costArr = new int[4];
		
		int line; // 호선

		// 노드의 생성자 메소드
		Node(int end, int cT, int cD, int cC, int cR, int l) 
		{
			this.end = end;
			this.costArr[0] = cT;
			this.costArr[1] = cD;
			this.costArr[2] = cC;
			this.costArr[3] = cR;
			this.line = l;
		}

		@Override
		public String toString() 
		{
			return "[" + end + "]";
		}
	}

	// 인접리스트 그래프를 생성하여 반환하는 메소드
	// 반환값
	// graph : 인접리스트 그래프
	static public List<ArrayList<Node>> graph() throws IOException
	{
		DataChange d1 = new DataChange();
		List<List<String>> ret = d1.func();
		
		// V = 정점의 개수, E = 간선의 개수.
		int V = 111;
		int E = 139;
		
		// 1차원 리스트를 만든다.
		// 인덱스의 번호 = 노드의 번호 이기 때문에, 1차원 리스트의 크기를 임의로 1 늘려서 정의한다(스킬).
		List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < V + 1; i++) 
		{
			graph.add(new ArrayList<Node>());
		}

		int a;
		int b;
		int cT;
		int cD;
		int cC;
		int cR;
		int l;
		for (int i = 0; i < E; i++) 
		{
			// 역번호를 배열번호로 변환하여 저장
			a = DataChange.stnToNum(Integer.parseInt(ret.get(i).get(0)));
			b = DataChange.stnToNum(Integer.parseInt(ret.get(i).get(1)));			
			cT = Integer.parseInt(ret.get(i).get(2));
			cD = Integer.parseInt(ret.get(i).get(3));
			cC = Integer.parseInt(ret.get(i).get(4));
			cR = Integer.parseInt(ret.get(i).get(5));
			l = Integer.parseInt(ret.get(i).get(6));
			
			graph.get(a).add(new Node(b, cT, cD, cC, cR, l));
			// 만일, 무향 그래프라면 반대의 상황도 추가해 준다.
			graph.get(b).add(new Node(a, cT, cD, cC, cR, l));
		}
		
		return graph;
	}
}
