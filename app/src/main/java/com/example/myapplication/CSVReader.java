package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    Context context;
    String fileName;
    List<List<String>> rows = new ArrayList<List<String>>();

    public CSVReader(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    public List<List<String>> readCSV() throws IOException {
        InputStream is = context.getAssets().open(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        String csvSplitBy = ",";

        br.readLine();

        while ((line = br.readLine()) != null) {
            List <String> tmpList = new ArrayList<String>();
            String[] row = line.split(csvSplitBy);
            tmpList = Arrays.asList(row);
            rows.add(tmpList);
        }
        return rows;
    }
}