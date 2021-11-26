package com.example.myapplication;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.example.myapplication.Graph.Node;


public class Dijkstra extends ResultControler
{
	public Dijkstra(int v, int e, List<ArrayList<Node>> graph)
	{
		super(v, e, graph);

		this.graph = graph;
		this.v = v;
		this.e = e;
	}

	// 입력값에 대해 다익스트라 알고리즘 계산 후 결과값 출력(수정 예정)
	@RequiresApi(api = Build.VERSION_CODES.N)
	public String DijkstraAlgorithmFull(int startStn, int endStn) throws IOException
	{
		/*for(int i = 0; i < 4; i++)
		{
			super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i));
			//super.meetUpStation(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i)); // 중간 역 출력
		}*/
		return super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, 0));


	}

	// 다익스트라 알고리즘
	@RequiresApi(api = Build.VERSION_CODES.N)
	public int[] DijkstraAlgorithm(int startStn, int endStn, int costIndex) throws IOException
	{
		int[] dist = new int[v+1];
		int[] prev = new int[e]; // 경로 저장할 배열

		for (int i=0; i<v+1; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1; // 경로 저장 배열 -1로 초기화
		}
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.costArr[costIndex],  o2.costArr[costIndex]));
		q.offer(new Node(startStn, 0, 0, 0, 0, 0));
		dist[startStn] = 0;
		while (!q.isEmpty())
		{
			Node curNode = q.poll();
			if (dist[curNode.end] < curNode.costArr[costIndex])
				continue;
			for (int i=0; i<graph.get(curNode.end).size(); i++)
			{
				Node nextNode = graph.get(curNode.end).get(i);
				if (dist[nextNode.end] > curNode.costArr[costIndex] + nextNode.costArr[costIndex])
				{
					prev[nextNode.end] = curNode.end; // #######
					dist[nextNode.end] = curNode.costArr[costIndex] + nextNode.costArr[costIndex];


					switch(costIndex) { // i가 0이면 시간, 거리, 비용, 추천
						case 0: q.offer(new Node(nextNode.end, dist[nextNode.end], 0, 0, 0, 0)); break;
						case 1: q.offer(new Node(nextNode.end, 0, dist[nextNode.end], 0, 0, 0)); break;
						case 2: q.offer(new Node(nextNode.end, 0, 0, dist[nextNode.end], 0, 0)); break;
						case 3: q.offer(new Node(nextNode.end, 0, 0, 0, dist[nextNode.end], 0)); break;
					}

				}
			}
		}

		return prev;
	}
}
