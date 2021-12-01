package com.example.myapplication;


import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 데이터 변환을 담당하는 클래스
public class DataChange extends Activity
{

	static List<List<String>> ret = new ArrayList<List<String>>();

	// 엑셀 파일로부터 데이터를 가져오는 메소드
	// 반환값
	// ret : 엑셀 파일로부터 가져온 데이터를 저장하는 리스트
	@RequiresApi(api = Build.VERSION_CODES.O)
	public List<List<String>> func() throws IOException {

		/*AssetManager am = getResources().getAssets();
		InputStream is = null ;
		is = am.open("stations.csv") ;
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(is));
		String line = "";

		while ((line = br.readLine()) != null)
		{
			List <String> tmpList = new ArrayList<String>();
			String array[] = line.split(",");
			tmpList = Arrays.asList(array);
			// System.out.println(tmpList);
			ret.add(tmpList);
		}*/


		/*try {
			CSVReader reader = new CSVReader(new FileReader("stations.csv"));
			String[] line;
			int i=0;
			while ((line = reader.readNext()) != null) {
				List <String> tmpList = new ArrayList<String>();
				//String array = line[i];
				String array[] = line[i].split(",");
				tmpList = Arrays.asList(array);
				ret.add(tmpList);
				i++;
			}
		} catch (IOException e) {
		}
		return ret;*/

		ArrayList<String> data1 = new ArrayList<>();
		ArrayList<String> data2 = new ArrayList<>();
		ArrayList<String> data3 = new ArrayList<>();
		ArrayList<String> data4 = new ArrayList<>();
		ArrayList<String> data5 = new ArrayList<>();
		ArrayList<String> data6 = new ArrayList<>();
		ArrayList<String> data7 = new ArrayList<>();
		ArrayList<String> data8 = new ArrayList<>();
		ArrayList<String> data9 = new ArrayList<>();
		ArrayList<String> data10 = new ArrayList<>();
		ArrayList<String> data11 = new ArrayList<>();
		ArrayList<String> data12 = new ArrayList<>();
		ArrayList<String> data13 = new ArrayList<>();
		ArrayList<String> data14 = new ArrayList<>();
		ArrayList<String> data15 = new ArrayList<>();
		ArrayList<String> data16 = new ArrayList<>();
		ArrayList<String> data17 = new ArrayList<>();
		ArrayList<String> data18 = new ArrayList<>();
		ArrayList<String> data19 = new ArrayList<>();
		ArrayList<String> data20 = new ArrayList<>();
		ArrayList<String> data21 = new ArrayList<>();
		ArrayList<String> data22 = new ArrayList<>();
		ArrayList<String> data23 = new ArrayList<>();
		ArrayList<String> data24 = new ArrayList<>();
		ArrayList<String> data25 = new ArrayList<>();
		ArrayList<String> data26 = new ArrayList<>();
		ArrayList<String> data27 = new ArrayList<>();
		ArrayList<String> data28 = new ArrayList<>();
		ArrayList<String> data29 = new ArrayList<>();
		ArrayList<String> data30 = new ArrayList<>();
		ArrayList<String> data31 = new ArrayList<>();
		ArrayList<String> data32 = new ArrayList<>();
		ArrayList<String> data33 = new ArrayList<>();
		ArrayList<String> data34 = new ArrayList<>();
		ArrayList<String> data35 = new ArrayList<>();
		ArrayList<String> data36 = new ArrayList<>();
		ArrayList<String> data37 = new ArrayList<>();
		ArrayList<String> data38 = new ArrayList<>();
		ArrayList<String> data39 = new ArrayList<>();
		ArrayList<String> data40 = new ArrayList<>();
		ArrayList<String> data41 = new ArrayList<>();
		ArrayList<String> data42 = new ArrayList<>();
		ArrayList<String> data43 = new ArrayList<>();
		ArrayList<String> data44 = new ArrayList<>();
		ArrayList<String> data45 = new ArrayList<>();
		ArrayList<String> data46 = new ArrayList<>();
		ArrayList<String> data47 = new ArrayList<>();
		ArrayList<String> data48 = new ArrayList<>();
		ArrayList<String> data49 = new ArrayList<>();
		ArrayList<String> data50 = new ArrayList<>();
		ArrayList<String> data51 = new ArrayList<>();
		ArrayList<String> data52 = new ArrayList<>();
		ArrayList<String> data53 = new ArrayList<>();
		ArrayList<String> data54 = new ArrayList<>();
		ArrayList<String> data55 = new ArrayList<>();
		ArrayList<String> data56 = new ArrayList<>();
		ArrayList<String> data57 = new ArrayList<>();
		ArrayList<String> data58 = new ArrayList<>();
		ArrayList<String> data59 = new ArrayList<>();
		ArrayList<String> data60 = new ArrayList<>();
		ArrayList<String> data61 = new ArrayList<>();
		ArrayList<String> data62 = new ArrayList<>();
		ArrayList<String> data63 = new ArrayList<>();
		ArrayList<String> data64 = new ArrayList<>();
		ArrayList<String> data65 = new ArrayList<>();
		ArrayList<String> data66 = new ArrayList<>();
		ArrayList<String> data67 = new ArrayList<>();
		ArrayList<String> data68 = new ArrayList<>();
		ArrayList<String> data69 = new ArrayList<>();
		ArrayList<String> data70 = new ArrayList<>();
		ArrayList<String> data71 = new ArrayList<>();
		ArrayList<String> data72 = new ArrayList<>();
		ArrayList<String> data73 = new ArrayList<>();
		ArrayList<String> data74 = new ArrayList<>();
		ArrayList<String> data75 = new ArrayList<>();
		ArrayList<String> data76 = new ArrayList<>();
		ArrayList<String> data77 = new ArrayList<>();
		ArrayList<String> data78 = new ArrayList<>();
		ArrayList<String> data79 = new ArrayList<>();
		ArrayList<String> data80 = new ArrayList<>();
		ArrayList<String> data81 = new ArrayList<>();
		ArrayList<String> data82 = new ArrayList<>();
		ArrayList<String> data83 = new ArrayList<>();
		ArrayList<String> data84 = new ArrayList<>();
		ArrayList<String> data85 = new ArrayList<>();
		ArrayList<String> data86 = new ArrayList<>();
		ArrayList<String> data87 = new ArrayList<>();
		ArrayList<String> data88 = new ArrayList<>();
		ArrayList<String> data89 = new ArrayList<>();
		ArrayList<String> data90 = new ArrayList<>();
		ArrayList<String> data91 = new ArrayList<>();
		ArrayList<String> data92 = new ArrayList<>();
		ArrayList<String> data93 = new ArrayList<>();
		ArrayList<String> data94 = new ArrayList<>();
		ArrayList<String> data95 = new ArrayList<>();
		ArrayList<String> data96 = new ArrayList<>();
		ArrayList<String> data97 = new ArrayList<>();
		ArrayList<String> data98 = new ArrayList<>();
		ArrayList<String> data99 = new ArrayList<>();
		ArrayList<String> data100 = new ArrayList<>();
		ArrayList<String> data101 = new ArrayList<>();
		ArrayList<String> data102 = new ArrayList<>();
		ArrayList<String> data103 = new ArrayList<>();
		ArrayList<String> data104 = new ArrayList<>();
		ArrayList<String> data105 = new ArrayList<>();
		ArrayList<String> data106 = new ArrayList<>();
		ArrayList<String> data107 = new ArrayList<>();
		ArrayList<String> data108 = new ArrayList<>();
		ArrayList<String> data109 = new ArrayList<>();
		ArrayList<String> data110 = new ArrayList<>();
		ArrayList<String> data111 = new ArrayList<>();
		ArrayList<String> data112 = new ArrayList<>();
		ArrayList<String> data113 = new ArrayList<>();
		ArrayList<String> data114 = new ArrayList<>();
		ArrayList<String> data115 = new ArrayList<>();
		ArrayList<String> data116 = new ArrayList<>();
		ArrayList<String> data117 = new ArrayList<>();
		ArrayList<String> data118 = new ArrayList<>();
		ArrayList<String> data119 = new ArrayList<>();
		ArrayList<String> data120 = new ArrayList<>();
		ArrayList<String> data121 = new ArrayList<>();
		ArrayList<String> data122 = new ArrayList<>();
		ArrayList<String> data123 = new ArrayList<>();
		ArrayList<String> data124 = new ArrayList<>();
		ArrayList<String> data125 = new ArrayList<>();
		ArrayList<String> data126 = new ArrayList<>();
		ArrayList<String> data127 = new ArrayList<>();
		ArrayList<String> data128 = new ArrayList<>();
		ArrayList<String> data129 = new ArrayList<>();
		ArrayList<String> data130 = new ArrayList<>();
		ArrayList<String> data131 = new ArrayList<>();
		ArrayList<String> data132 = new ArrayList<>();
		ArrayList<String> data133 = new ArrayList<>();
		ArrayList<String> data134 = new ArrayList<>();
		ArrayList<String> data135 = new ArrayList<>();
		ArrayList<String> data136 = new ArrayList<>();
		ArrayList<String> data137 = new ArrayList<>();
		ArrayList<String> data138 = new ArrayList<>();
		ArrayList<String> data139 = new ArrayList<>();

		data1.add("101"); data1.add("102"); data1.add("200"); data1.add("500"); data1.add("200"); data1.add("160"); data1.add("1");
		data2.add("102"); data2.add("103"); data2.add("300"); data2.add("400"); data2.add("300"); data2.add("240"); data2.add("1");
		data3.add("103"); data3.add("104"); data3.add("1000"); data3.add("600"); data3.add("500"); data3.add("550"); data3.add("1");
		data4.add("104"); data4.add("105"); data4.add("500"); data4.add("200"); data4.add("340"); data4.add("320"); data4.add("1");
		data5.add("105"); data5.add("106"); data5.add("150"); data5.add("600"); data5.add("450"); data5.add("270"); data5.add("1");
		data6.add("106"); data6.add("107"); data6.add("320"); data6.add("200"); data6.add("120"); data6.add("156"); data6.add("1");
		data7.add("107"); data7.add("108"); data7.add("400"); data7.add("700"); data7.add("650"); data7.add("445"); data7.add("1");
		data8.add("108"); data8.add("109"); data8.add("800"); data8.add("350"); data8.add("200"); data8.add("340"); data8.add("1");
		data9.add("109"); data9.add("110"); data9.add("900"); data9.add("250"); data9.add("430"); data9.add("485"); data9.add("1");
		data10.add("110"); data10.add("111"); data10.add("500"); data10.add("650"); data10.add("120"); data10.add("210"); data10.add("1");
		data11.add("111"); data11.add("112"); data11.add("1000"); data11.add("400"); data11.add("890"); data11.add("745"); data11.add("1");
		data12.add("112"); data12.add("113"); data12.add("2000"); data12.add("500"); data12.add("800"); data12.add("1000"); data12.add("1");
		data13.add("113"); data13.add("114"); data13.add("500"); data13.add("500"); data13.add("700"); data13.add("500"); data13.add("1");
		data14.add("114"); data14.add("115"); data14.add("220"); data14.add("400"); data14.add("540"); data14.add("336"); data14.add("1");
		data15.add("115"); data15.add("116"); data15.add("230"); data15.add("600"); data15.add("330"); data15.add("234"); data15.add("1");
		data16.add("116"); data16.add("117"); data16.add("300"); data16.add("200"); data16.add("280"); data16.add("230"); data16.add("1");
		data17.add("117"); data17.add("118"); data17.add("500"); data17.add("600"); data17.add("800"); data17.add("550"); data17.add("1");
		data18.add("118"); data18.add("119"); data18.add("480"); data18.add("200"); data18.add("1000"); data18.add("644"); data18.add("1");
		data19.add("119"); data19.add("120"); data19.add("500"); data19.add("700"); data19.add("2000"); data19.add("1150"); data19.add("1");
		data20.add("120"); data20.add("121"); data20.add("400"); data20.add("350"); data20.add("700"); data20.add("470"); data20.add("1");
		data21.add("121"); data21.add("122"); data21.add("900"); data21.add("250"); data21.add("650"); data21.add("595"); data21.add("1");
		data22.add("122"); data22.add("123"); data22.add("300"); data22.add("650"); data22.add("440"); data22.add("310"); data22.add("1");
		data23.add("123"); data23.add("101"); data23.add("480"); data23.add("400"); data23.add("200"); data23.add("244"); data23.add("1");
		data24.add("101"); data24.add("201"); data24.add("1000"); data24.add("500"); data24.add("300"); data24.add("450"); data24.add("2");
		data25.add("201"); data25.add("202"); data25.add("250"); data25.add("500"); data25.add("500"); data25.add("325"); data25.add("2");
		data26.add("202"); data26.add("203"); data26.add("480"); data26.add("400"); data26.add("340"); data26.add("314"); data26.add("2");
		data27.add("203"); data27.add("204"); data27.add("400"); data27.add("600"); data27.add("450"); data27.add("345"); data27.add("2");
		data28.add("204"); data28.add("205"); data28.add("250"); data28.add("200"); data28.add("120"); data28.add("135"); data28.add("2");
		data29.add("205"); data29.add("206"); data29.add("500"); data29.add("600"); data29.add("650"); data29.add("475"); data29.add("2");
		data30.add("206"); data30.add("207"); data30.add("320"); data30.add("200"); data30.add("200"); data30.add("196"); data30.add("2");
		data31.add("207"); data31.add("208"); data31.add("250"); data31.add("700"); data31.add("430"); data31.add("290"); data31.add("2");
		data32.add("208"); data32.add("209"); data32.add("300"); data32.add("350"); data32.add("120"); data32.add("150"); data32.add("2");
		data33.add("209"); data33.add("210"); data33.add("150"); data33.add("250"); data33.add("890"); data33.add("490"); data33.add("2");
		data34.add("210"); data34.add("211"); data34.add("900"); data34.add("650"); data34.add("800"); data34.add("670"); data34.add("2");
		data35.add("211"); data35.add("212"); data35.add("320"); data35.add("400"); data35.add("700"); data35.add("446"); data35.add("2");
		data36.add("212"); data36.add("213"); data36.add("150"); data36.add("500"); data36.add("540"); data36.add("315"); data36.add("2");
		data37.add("213"); data37.add("214"); data37.add("500"); data37.add("500"); data37.add("330"); data37.add("315"); data37.add("2");
		data38.add("214"); data38.add("215"); data38.add("210"); data38.add("400"); data38.add("280"); data38.add("203"); data38.add("2");
		data39.add("215"); data39.add("216"); data39.add("150"); data39.add("600"); data39.add("800"); data39.add("445"); data39.add("2");
		data40.add("216"); data40.add("217"); data40.add("500"); data40.add("200"); data40.add("1000"); data40.add("650"); data40.add("2");
		data41.add("207"); data41.add("301"); data41.add("300"); data41.add("600"); data41.add("2000"); data41.add("1090"); data41.add("3");
		data42.add("301"); data42.add("302"); data42.add("300"); data42.add("200"); data42.add("700"); data42.add("440"); data42.add("3");
		data43.add("302"); data43.add("303"); data43.add("480"); data43.add("700"); data43.add("650"); data43.add("469"); data43.add("3");
		data44.add("303"); data44.add("304"); data44.add("400"); data44.add("350"); data44.add("440"); data44.add("340"); data44.add("3");
		data45.add("304"); data45.add("123"); data45.add("250"); data45.add("250"); data45.add("200"); data45.add("175"); data45.add("3");
		data46.add("123"); data46.add("305"); data46.add("300"); data46.add("650"); data46.add("300"); data46.add("240"); data46.add("3");
		data47.add("305"); data47.add("306"); data47.add("250"); data47.add("400"); data47.add("500"); data47.add("325"); data47.add("3");
		data48.add("306"); data48.add("307"); data48.add("900"); data48.add("500"); data48.add("340"); data48.add("440"); data48.add("3");
		data49.add("307"); data49.add("308"); data49.add("480"); data49.add("500"); data49.add("450"); data49.add("369"); data49.add("3");
		data50.add("308"); data50.add("107"); data50.add("400"); data50.add("400"); data50.add("120"); data50.add("180"); data50.add("3");
		data51.add("104"); data51.add("401"); data51.add("1000"); data51.add("600"); data51.add("650"); data51.add("625"); data51.add("4");
		data52.add("401"); data52.add("307"); data52.add("150"); data52.add("200"); data52.add("200"); data52.add("145"); data52.add("4");
		data53.add("307"); data53.add("402"); data53.add("300"); data53.add("600"); data53.add("430"); data53.add("305"); data53.add("4");
		data54.add("402"); data54.add("403"); data54.add("210"); data54.add("200"); data54.add("120"); data54.add("123"); data54.add("4");
		data55.add("403"); data55.add("404"); data55.add("320"); data55.add("700"); data55.add("890"); data55.add("541"); data55.add("4");
		data56.add("404"); data56.add("405"); data56.add("210"); data56.add("350"); data56.add("800"); data56.add("463"); data56.add("4");
		data57.add("405"); data57.add("406"); data57.add("500"); data57.add("250"); data57.add("700"); data57.add("500"); data57.add("4");
		data58.add("406"); data58.add("407"); data58.add("300"); data58.add("650"); data58.add("540"); data58.add("360"); data58.add("4");
		data59.add("407"); data59.add("115"); data59.add("320"); data59.add("400"); data59.add("330"); data59.add("261"); data59.add("4");
		data60.add("115"); data60.add("408"); data60.add("480"); data60.add("500"); data60.add("280"); data60.add("284"); data60.add("4");
		data61.add("408"); data61.add("409"); data61.add("300"); data61.add("340"); data61.add("800"); data61.add("490"); data61.add("4");
		data62.add("409"); data62.add("410"); data62.add("480"); data62.add("500"); data62.add("1000"); data62.add("644"); data62.add("4");
		data63.add("410"); data63.add("411"); data63.add("300"); data63.add("400"); data63.add("2000"); data63.add("1090"); data63.add("4");
		data64.add("411"); data64.add("412"); data64.add("900"); data64.add("600"); data64.add("700"); data64.add("620"); data64.add("4");
		data65.add("412"); data65.add("413"); data65.add("400"); data65.add("200"); data65.add("650"); data65.add("445"); data65.add("4");
		data66.add("413"); data66.add("414"); data66.add("430"); data66.add("600"); data66.add("440"); data66.add("349"); data66.add("4");
		data67.add("414"); data67.add("415"); data67.add("150"); data67.add("200"); data67.add("200"); data67.add("145"); data67.add("4");
		data68.add("415"); data68.add("416"); data68.add("1000"); data68.add("700"); data68.add("300"); data68.add("450"); data68.add("4");
		data69.add("416"); data69.add("417"); data69.add("500"); data69.add("350"); data69.add("500"); data69.add("400"); data69.add("4");
		data70.add("417"); data70.add("216"); data70.add("900"); data70.add("250"); data70.add("340"); data70.add("440"); data70.add("4");
		data71.add("209"); data71.add("501"); data71.add("320"); data71.add("650"); data71.add("450"); data71.add("321"); data71.add("5");
		data72.add("501"); data72.add("502"); data72.add("320"); data72.add("400"); data72.add("120"); data72.add("156"); data72.add("5");
		data73.add("502"); data73.add("503"); data73.add("430"); data73.add("500"); data73.add("650"); data73.add("454"); data73.add("5");
		data74.add("503"); data74.add("504"); data74.add("210"); data74.add("500"); data74.add("200"); data74.add("163"); data74.add("5");
		data75.add("504"); data75.add("122"); data75.add("320"); data75.add("400"); data75.add("430"); data75.add("311"); data75.add("5");
		data76.add("122"); data76.add("505"); data76.add("480"); data76.add("600"); data76.add("120"); data76.add("204"); data76.add("5");
		data77.add("505"); data77.add("506"); data77.add("300"); data77.add("200"); data77.add("890"); data77.add("535"); data77.add("5");
		data78.add("506"); data78.add("403"); data78.add("320"); data78.add("600"); data78.add("800"); data78.add("496"); data78.add("5");
		data79.add("403"); data79.add("507"); data79.add("300"); data79.add("200"); data79.add("700"); data79.add("440"); data79.add("5");
		data80.add("507"); data80.add("109"); data80.add("1000"); data80.add("700"); data80.add("540"); data80.add("570"); data80.add("5");
		data81.add("601"); data81.add("602"); data81.add("150"); data81.add("350"); data81.add("330"); data81.add("210"); data81.add("6");
		data82.add("602"); data82.add("121"); data82.add("700"); data82.add("250"); data82.add("280"); data82.add("350"); data82.add("6");
		data83.add("121"); data83.add("603"); data83.add("500"); data83.add("650"); data83.add("800"); data83.add("550"); data83.add("6");
		data84.add("603"); data84.add("604"); data84.add("300"); data84.add("400"); data84.add("1000"); data84.add("590"); data84.add("6");
		data85.add("604"); data85.add("605"); data85.add("430"); data85.add("200"); data85.add("2000"); data85.add("1129"); data85.add("6");
		data86.add("605"); data86.add("606"); data86.add("480"); data86.add("300"); data86.add("700"); data86.add("494"); data86.add("6");
		data87.add("606"); data87.add("116"); data87.add("320"); data87.add("400"); data87.add("650"); data87.add("421"); data87.add("6");
		data88.add("116"); data88.add("607"); data88.add("250"); data88.add("200"); data88.add("440"); data88.add("295"); data88.add("6");
		data89.add("607"); data89.add("608"); data89.add("500"); data89.add("600"); data89.add("200"); data89.add("250"); data89.add("6");
		data90.add("608"); data90.add("609"); data90.add("700"); data90.add("200"); data90.add("300"); data90.add("360"); data90.add("6");
		data91.add("609"); data91.add("412"); data91.add("320"); data91.add("700"); data91.add("500"); data91.add("346"); data91.add("6");
		data92.add("412"); data92.add("610"); data92.add("1000"); data92.add("350"); data92.add("340"); data92.add("470"); data92.add("6");
		data93.add("610"); data93.add("611"); data93.add("700"); data93.add("250"); data93.add("450"); data93.add("435"); data93.add("6");
		data94.add("611"); data94.add("612"); data94.add("700"); data94.add("650"); data94.add("120"); data94.add("270"); data94.add("6");
		data95.add("612"); data95.add("613"); data95.add("150"); data95.add("400"); data95.add("650"); data95.add("370"); data95.add("6");
		data96.add("613"); data96.add("614"); data96.add("430"); data96.add("200"); data96.add("200"); data96.add("229"); data96.add("6");
		data97.add("614"); data97.add("615"); data97.add("500"); data97.add("300"); data97.add("430"); data97.add("365"); data97.add("6");
		data98.add("615"); data98.add("616"); data98.add("700"); data98.add("400"); data98.add("120"); data98.add("270"); data98.add("6");
		data99.add("616"); data99.add("417"); data99.add("480"); data99.add("200"); data99.add("890"); data99.add("589"); data99.add("6");
		data100.add("417"); data100.add("617"); data100.add("320"); data100.add("600"); data100.add("800"); data100.add("496"); data100.add("6");
		data101.add("617"); data101.add("618"); data101.add("300"); data101.add("200"); data101.add("700"); data101.add("440"); data101.add("6");
		data102.add("618"); data102.add("619"); data102.add("250"); data102.add("700"); data102.add("540"); data102.add("345"); data102.add("6");
		data103.add("619"); data103.add("620"); data103.add("700"); data103.add("350"); data103.add("330"); data103.add("375"); data103.add("6");
		data104.add("620"); data104.add("621"); data104.add("320"); data104.add("250"); data104.add("280"); data104.add("236"); data104.add("6");
		data105.add("621"); data105.add("622"); data105.add("480"); data105.add("650"); data105.add("800"); data105.add("544"); data105.add("6");
		data106.add("622"); data106.add("601"); data106.add("150"); data106.add("400"); data106.add("1000"); data106.add("545"); data106.add("6");
		data107.add("202"); data107.add("303"); data107.add("1000"); data107.add("200"); data107.add("2000"); data107.add("1300"); data107.add("7");
		data108.add("303"); data108.add("503"); data108.add("700"); data108.add("300"); data108.add("700"); data108.add("560"); data108.add("7");
		data109.add("503"); data109.add("601"); data109.add("500"); data109.add("400"); data109.add("650"); data109.add("475"); data109.add("7");
		data110.add("601"); data110.add("701"); data110.add("430"); data110.add("200"); data110.add("440"); data110.add("349"); data110.add("7");
		data111.add("701"); data111.add("702"); data111.add("150"); data111.add("600"); data111.add("200"); data111.add("145"); data111.add("7");
		data112.add("702"); data112.add("703"); data112.add("600"); data112.add("200"); data112.add("300"); data112.add("330"); data112.add("7");
		data113.add("703"); data113.add("704"); data113.add("700"); data113.add("700"); data113.add("500"); data113.add("460"); data113.add("7");
		data114.add("704"); data114.add("705"); data114.add("250"); data114.add("350"); data114.add("340"); data114.add("245"); data114.add("7");
		data115.add("705"); data115.add("706"); data115.add("600"); data115.add("250"); data115.add("450"); data115.add("405"); data115.add("7");
		data116.add("706"); data116.add("416"); data116.add("300"); data116.add("650"); data116.add("120"); data116.add("150"); data116.add("7");
		data117.add("416"); data117.add("707"); data117.add("430"); data117.add("400"); data117.add("650"); data117.add("454"); data117.add("7");
		data118.add("707"); data118.add("614"); data118.add("480"); data118.add("200"); data118.add("200"); data118.add("244"); data118.add("7");
		data119.add("113"); data119.add("801"); data119.add("600"); data119.add("300"); data119.add("430"); data119.add("395"); data119.add("8");
		data120.add("801"); data120.add("802"); data120.add("1000"); data120.add("400"); data120.add("120"); data120.add("360"); data120.add("8");
		data121.add("802"); data121.add("803"); data121.add("700"); data121.add("200"); data121.add("890"); data121.add("655"); data121.add("8");
		data122.add("803"); data122.add("409"); data122.add("600"); data122.add("600"); data122.add("800"); data122.add("580"); data122.add("8");
		data123.add("409"); data123.add("608"); data123.add("500"); data123.add("200"); data123.add("700"); data123.add("500"); data123.add("8");
		data124.add("608"); data124.add("804"); data124.add("700"); data124.add("700"); data124.add("540"); data124.add("480"); data124.add("8");
		data125.add("804"); data125.add("805"); data125.add("150"); data125.add("350"); data125.add("330"); data125.add("210"); data125.add("8");
		data126.add("805"); data126.add("806"); data126.add("210"); data126.add("250"); data126.add("280"); data126.add("203"); data126.add("8");
		data127.add("806"); data127.add("705"); data127.add("600"); data127.add("650"); data127.add("800"); data127.add("580"); data127.add("8");
		data128.add("705"); data128.add("618"); data128.add("250"); data128.add("400"); data128.add("1000"); data128.add("575"); data128.add("8");
		data129.add("618"); data129.add("214"); data129.add("700"); data129.add("200"); data129.add("2000"); data129.add("1210"); data129.add("8");
		data130.add("112"); data130.add("901"); data130.add("600"); data130.add("300"); data130.add("700"); data130.add("530"); data130.add("9");
		data131.add("901"); data131.add("406"); data131.add("300"); data131.add("400"); data131.add("650"); data131.add("415"); data131.add("9");
		data132.add("406"); data132.add("605"); data132.add("210"); data132.add("200"); data132.add("440"); data132.add("283"); data132.add("9");
		data133.add("605"); data133.add("902"); data133.add("480"); data133.add("600"); data133.add("280"); data133.add("284"); data133.add("9");
		data134.add("902"); data134.add("119"); data134.add("430"); data134.add("200"); data134.add("800"); data134.add("529"); data134.add("9");
		data135.add("119"); data135.add("903"); data135.add("1000"); data135.add("700"); data135.add("1000"); data135.add("800"); data135.add("9");
		data136.add("903"); data136.add("702"); data136.add("150"); data136.add("350"); data136.add("2000"); data136.add("1045"); data136.add("9");
		data137.add("702"); data137.add("904"); data137.add("500"); data137.add("250"); data137.add("700"); data137.add("500"); data137.add("9");
		data138.add("904"); data138.add("621"); data138.add("250"); data138.add("650"); data138.add("650"); data138.add("400"); data138.add("9");
		data139.add("621"); data139.add("211"); data139.add("300"); data139.add("400"); data139.add("440"); data139.add("310"); data139.add("9");

		ret.add(data1);
		ret.add(data2);
		ret.add(data3);
		ret.add(data4);
		ret.add(data5);
		ret.add(data6);
		ret.add(data7);
		ret.add(data8);
		ret.add(data9);
		ret.add(data10);
		ret.add(data11);
		ret.add(data12);
		ret.add(data13);
		ret.add(data14);
		ret.add(data15);
		ret.add(data16);
		ret.add(data17);
		ret.add(data18);
		ret.add(data19);
		ret.add(data20);
		ret.add(data21);
		ret.add(data22);
		ret.add(data23);
		ret.add(data24);
		ret.add(data25);
		ret.add(data26);
		ret.add(data27);
		ret.add(data28);
		ret.add(data29);
		ret.add(data30);
		ret.add(data31);
		ret.add(data32);
		ret.add(data33);
		ret.add(data34);
		ret.add(data35);
		ret.add(data36);
		ret.add(data37);
		ret.add(data38);
		ret.add(data39);
		ret.add(data40);
		ret.add(data41);
		ret.add(data42);
		ret.add(data43);
		ret.add(data44);
		ret.add(data45);
		ret.add(data46);
		ret.add(data47);
		ret.add(data48);
		ret.add(data49);
		ret.add(data50);
		ret.add(data51);
		ret.add(data52);
		ret.add(data53);
		ret.add(data54);
		ret.add(data55);
		ret.add(data56);
		ret.add(data57);
		ret.add(data58);
		ret.add(data59);
		ret.add(data60);
		ret.add(data61);
		ret.add(data62);
		ret.add(data63);
		ret.add(data64);
		ret.add(data65);
		ret.add(data66);
		ret.add(data67);
		ret.add(data68);
		ret.add(data69);
		ret.add(data70);
		ret.add(data71);
		ret.add(data72);
		ret.add(data73);
		ret.add(data74);
		ret.add(data75);
		ret.add(data76);
		ret.add(data77);
		ret.add(data78);
		ret.add(data79);
		ret.add(data80);
		ret.add(data81);
		ret.add(data82);
		ret.add(data83);
		ret.add(data84);
		ret.add(data85);
		ret.add(data86);
		ret.add(data87);
		ret.add(data88);
		ret.add(data89);
		ret.add(data90);
		ret.add(data91);
		ret.add(data92);
		ret.add(data93);
		ret.add(data94);
		ret.add(data95);
		ret.add(data96);
		ret.add(data97);
		ret.add(data98);
		ret.add(data99);
		ret.add(data100);
		ret.add(data101);
		ret.add(data102);
		ret.add(data103);
		ret.add(data104);
		ret.add(data105);
		ret.add(data106);
		ret.add(data107);
		ret.add(data108);
		ret.add(data109);
		ret.add(data110);
		ret.add(data111);
		ret.add(data112);
		ret.add(data113);
		ret.add(data114);
		ret.add(data115);
		ret.add(data116);
		ret.add(data117);
		ret.add(data118);
		ret.add(data119);
		ret.add(data120);
		ret.add(data121);
		ret.add(data122);
		ret.add(data123);
		ret.add(data124);
		ret.add(data125);
		ret.add(data126);
		ret.add(data127);
		ret.add(data128);
		ret.add(data129);
		ret.add(data130);
		ret.add(data131);
		ret.add(data132);
		ret.add(data133);
		ret.add(data134);
		ret.add(data135);
		ret.add(data136);
		ret.add(data137);
		ret.add(data138);
		ret.add(data139);
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