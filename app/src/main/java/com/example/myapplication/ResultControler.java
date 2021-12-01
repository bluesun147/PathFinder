package com.example.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import com.example.myapplication.Graph.Node;

public class ResultControler
{
	int v = 111;
	int e = 139;
	List<ArrayList<Node>> graph;

	// 생성자
	public ResultControler(int v, int e, List<ArrayList<Node>> graph)
	{
		this.graph = graph;
		this.v = v;
		this.e = e;
	}

	// 다익스트라 알고리즘의 결과값을 받아 데이터를 계산 & 출력하는 클래스
	public void calculateData(int startStn, int endStn, int[] stnList, String[] lineStrArr, int[][] dataDarr, int index, String[] alarmCount)
	{
		alarmCount[index] = "";
		//System.out.println(DataChange.numToStn(startStn) + "역 에서 " + DataChange.numToStn(endStn) + "역 으로 가는 노선");
		int[][] dataArr = makeDataArr(endStn, stnList);
		int count = getCount(dataArr);

		// 데이터 출력
		//printStation(count, 0, dataArr);
		//printData(0, count, dataArr);

		lineStrArr[index] = getPrintStation(count, 0, dataArr);


		dataDarr[index][0] = getTimeData(0, count, dataArr); // 시간
		dataDarr[index][1] = getDistData(0, count, dataArr); // 거리
		dataDarr[index][2] = getCostData(0, count, dataArr); // 비용

		// 환승역 인덱스 번호 저장한 배열
		int[] transferStationArr = findTransferStation(count, 0, dataArr);
		int transferStationNumber = 0;

		int pre = transferStationArr[transferStationNumber];
		int next = count;

		// 환승역 사이 데이터 출력
		while (true)
		{
			if (pre != 0)
			{
				alarmCount[index] += printData(pre, next, dataArr);
				next = pre;
				pre = transferStationArr[++transferStationNumber];

			}
			else
			{
				alarmCount[index] += printData(0, next, dataArr);
				//printData(0, next, dataArr);
				//System.out.println(0 + " " + next);
				break;
			}
		}
	}

	// 다익스트라 알고리즘의 결과값을 받아 중간역 관련 데이터를 계산 & 출력하는 클래스
	public void meetUpStation(int startStn, int endStn, int[] stnList)
	{
		System.out.println(DataChange.numToStn(startStn) + "역 에서 " + DataChange.numToStn(endStn) + "역 으로 가는 노선");

		int[][] dataArr = makeDataArr(endStn, stnList);
		int count = getCount(dataArr);
		int myIdx = findMiddleIndex(count, dataArr);

		System.out.println("중간역은 " + DataChange.numToStn(dataArr[0][myIdx]) + "역 입니다.");
		System.out.println();

		System.out.println("나의 노선");
		printStation(count, myIdx, dataArr);
		printData(0, myIdx, dataArr);

		System.out.println("상대의 노선");
		printStationR(0, myIdx, dataArr);
		printData(myIdx, count, dataArr);
	}

	// 입력받은 시작 역과 종착 역에 대응하는 간선을 반환
	public int findMainLine(int startStn, int endStn)
	{
		for(int i = 0; i < 10; i++)
		{
			if (graph.get(startStn).get(i).end == endStn)
			{
				return i;
			}
		}
		return -1;
	}

	// 매개변수로 전달받은 노선의 관한 데이터를 저장한 이차원 배열을 생성하고 반환하는 메소드
	public int[][] makeDataArr(int endStn, int[] stnList)
	{
		int[][] dataArr = new int[5][e];
		int nextStn = -1;

		int count = 0;

		while (endStn != -1)
		{
			nextStn = stnList[endStn];
			dataArr[0][count] = endStn;
			if (nextStn != -1)
			{
				dataArr[1][count] = graph.get(endStn).get(findMainLine(endStn,nextStn)).costArr[0];
				dataArr[2][count] = graph.get(endStn).get(findMainLine(endStn,nextStn)).costArr[1];
				dataArr[3][count] = graph.get(endStn).get(findMainLine(endStn,nextStn)).costArr[2];
				dataArr[4][count] = graph.get(endStn).get(findMainLine(endStn,nextStn)).line;
				dataArr[4][count+1] = graph.get(endStn).get(findMainLine(endStn,nextStn)).line;
			}

			endStn = nextStn;
			count++;
		}

		dataArr[4][e-1] = count;
		return dataArr;
	}

	// count 값을 반환(꼼수)
	public int getCount(int[][] dataArr)
	{
		return dataArr[4][e-1];
	}

	// 노선 출력
	public void printStation(int startIdx, int endIdx, int[][] dataArr)
	{
		for (int i = startIdx - 1; i > endIdx - 1; i--)
		{
			System.out.print(DataChange.numToStn(dataArr[0][i]));
			if (i != endIdx)
			{
				if (dataArr[4][i] != dataArr[4][i-1])
				{
					System.out.print("(환승)");
				}
				System.out.print(" > ");
			}
		}
	}

	public String getPrintStation(int startIdx, int endIdx, int[][] dataArr)
	{
		String result = "";
		for (int i = startIdx - 1; i > endIdx - 1; i--)
		{
			result += (DataChange.numToStn(dataArr[0][i]));
			if (i != endIdx)
			{
				if (dataArr[4][i] != dataArr[4][i-1])
				{
					result += "(환승)";
				}
				result += " > ";
			}
		}
		return result;
	}

	// 노선 출력 (중간 역 출력 중 상대방의 노선 출력 시 사용)
	public void printStationR(int startIdx, int endIdx, int[][] dataArr)
	{
		for (int i = startIdx; i < endIdx + 1; i++)
		{
			System.out.print(DataChange.numToStn(dataArr[0][i]));
			if (i != endIdx)
			{
				if (dataArr[4][i] != dataArr[4][i+1])
				{
					System.out.print("(환승)");
				}
				System.out.print(" > ");
			}
		}
	}

	public int[] findTransferStation(int startIdx, int endIdx, int[][] dataArr)
	{
		int[] transferStationArr = new int[startIdx];
		int transferStationCount = 0;

		for (int i = startIdx - 1; i > endIdx - 1; i--)
		{
			if (i != endIdx)
			{
				if (dataArr[4][i] != dataArr[4][i-1])
				{
					transferStationArr[transferStationCount++] = i;
				}
			}
		}

		return transferStationArr;
	}

	// 노선 관련 데이터 출력
	public String printData(int startIdx, int endIdx, int[][] dataArr)
	{
		int time = 0;
		int dist = 0;
		int cost = 0;

		String result = "";

		for (int i = startIdx; i < endIdx; i++)
		{
			time += dataArr[1][i];
			dist += dataArr[2][i];
			cost += dataArr[3][i];
		}

		/*System.out.println();
		System.out.println("총 시간 : " + time);
		System.out.println("총 거리 : " + dist);
		System.out.println("총 비용 : " + cost);
		System.out.println();*/
		return result = result + time + "(초!)";
	}

	public int getTimeData(int startIdx, int endIdx, int[][] dataArr)
	{
		int time = 0;

		for (int i = startIdx; i < endIdx; i++)
		{
			time += dataArr[1][i];
		}

		return time;
	}

	public int getDistData(int startIdx, int endIdx, int[][] dataArr)
	{
		int dist = 0;

		for (int i = startIdx; i < endIdx; i++)
		{
			dist += dataArr[2][i];
		}

		return dist;
	}

	public int getCostData(int startIdx, int endIdx, int[][] dataArr)
	{
		int cost = 0;

		for (int i = startIdx; i < endIdx; i++)
		{
			cost += dataArr[3][i];
		}

		return cost;
	}

	// 중간역의 인덱스 값을 반환
	public int findMiddleIndex(int count, int[][] dataArr)
	{
		int myTime = 0;
		int totalTime = 0;

		for (int i = 0; i < count; i++)
		{
			totalTime += dataArr[1][i];
		}

		for (int i = 0; true; i++)
		{
			myTime += dataArr[1][i];
			if (myTime >= totalTime / 2)
			{
				if (myTime - totalTime / 2 >= totalTime / 2 - myTime - dataArr[1][i])
				{
					return i;
				}
				else
				{
					return i + 1;
				}
			}
		}
	}
}