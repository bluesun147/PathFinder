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
	public String[] DijkstraAlgorithmFull(int startStn, int endStn) throws IOException
	{ // 경로-경로(lineStrArr) 문자열 배열 반환
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];
		String[] alarmCount = new String[3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 2)
			{
				super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i, alarmCount);
			}
			else
			{
				super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i, alarmCount);
			}
		}

		return lineStrArr;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public int[][] DijkstraAlgorithmFull2(int startStn, int endStn) throws IOException
	{ // 각 경로의 시간, 거리, 비용 반환. int[][] 반환
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];
		String[] alarmCount = new String[3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 2)
			{
				super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i, alarmCount);
			}
			else
			{
				super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i, alarmCount);
			}
		}

		return dataDarr;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public String[] DijkstraAlgorithmFull3(int startStn, int endStn) throws IOException
	{ // 각 경로의 시간, 거리, 비용 반환. int[][] 반환
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];
		String[] alarmCount = new String[3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 2)
			{
				super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i, alarmCount);
			}
			else
			{
				super.calculateData(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i, alarmCount);
			}
		}

		return alarmCount;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public String[] DijkstraMeetUpMyStr(int startStn, int endStn) throws IOException
	{
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 1)
			{
				super.meetUpStationMe(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i);
			}
			else
			{
				super.meetUpStationMe(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i);
			}
		}
		return lineStrArr;
	}
	@RequiresApi(api = Build.VERSION_CODES.N)
	public int[][] DijkstraMeetUpMyData(int startStn, int endStn) throws IOException
	{
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 1)
			{
				super.meetUpStationMe(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i);
			}
			else
			{
				super.meetUpStationMe(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i);
			}
		}

		return dataDarr;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public String[] DijkstraMeetUpYourStr(int startStn, int endStn) throws IOException
	{
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 1)
			{
				super.meetUpStationYou(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i);
			}
			else
			{
				super.meetUpStationYou(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i);
			}
		}

		return lineStrArr;
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public int[][] DijkstraMeetUpYourData(int startStn, int endStn) throws IOException
	{
		String[] lineStrArr = new String[3];
		int[][] dataDarr = new int[3][3];

		for(int i = 0; i < 3; i++)
		{
			if (i != 1)
			{
				super.meetUpStationYou(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i), lineStrArr, dataDarr, i);
			}
			else
			{
				super.meetUpStationYou(startStn, endStn, DijkstraAlgorithm(startStn, endStn, i+1), lineStrArr, dataDarr, i);
			}
		}

		return dataDarr;
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


					switch(costIndex) {
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
