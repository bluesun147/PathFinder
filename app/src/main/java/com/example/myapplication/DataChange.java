package com.example.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 데이터 변환을 담당하는 클래스
public class DataChange 
{
	
	
	static List<List<String>> ret = new ArrayList<List<String>>();
	
	// 엑셀 파일로부터 데이터를 가져오는 메소드
	// 반환값 
	// ret : 엑셀 파일로부터 가져온 데이터를 저장하는 리스트
	public static List<List<String>> func() throws IOException
	{	
		BufferedReader br = null;
		br = Files.newBufferedReader(Paths.get("C:\\Users\\blues\\OneDrive\\바탕화~1-DESKTOP-9RO8JPH-8531-DESKTOP-9RO8JPH\\팀프로젝트1\\1123\\stations.csv"));
		String line = "";
			
		while ((line = br.readLine()) != null) 
		{
			List <String> tmpList = new ArrayList<String>();
			String array[] = line.split(",");
			tmpList = Arrays.asList(array);
			// System.out.println(tmpList);
			ret.add(tmpList);
		}
		
		return ret;
	}
	
	// 역번호를 배열번호로 변환하는 메소드
	public static int stnToNum(int stationNum)
	{
		// 각 호선의 간선 수를 저장한 배열
		int[] numList = {0,23,17,8,17,7,22,7,6,4};
		
		int line = stationNum / 100;
		int stnNum = stationNum - line * 100;
		int num = 0;
		
		for (int i = 0; i != line; i++)
		{
			num += numList[i];
		}
		
		num += stnNum;
		
		return num;
	}
	
	// 배열번호를 역번호로 변환하는 메소드
	public static int numToStn(int num)
	{
		// 각 호선의 간선 수의 누적 합을 저장한 배열
		int[] numList = {0,23,40,48,65,72,94,101,107,111};
		
		int line = 0;
		int stnNum = 0;
		int stationNum = 0;
		
		for (int i = 0; num > numList[i]; i++)
		{
			line++;
		}
		
		stnNum = num - numList[line-1];
		stationNum += line * 100 + stnNum;
		
		return stationNum;
	}
}
