package com.example.termproject;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CanRiskFile {
    private  String file_name;

    private Context mContext;

    private File file;

    public CanRiskFile(Context c) {
        this.file_name = "CanriskSurvey.txt";
        this.mContext = c;
        this.file =  c.getApplicationContext().getFileStreamPath(this.file_name);
    }
    public void writeDataToFile(String gender, int totalPoints) {
        try {
            FileOutputStream fos = mContext.openFileOutput(file_name, Context.MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            // Write the gender and total points to the file
            osw.write(gender + " " + totalPoints +   "\n");
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Riskclass> readDataFromFile() {

        ArrayList<Riskclass> a = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(mContext.openFileInput(file_name)));
            String line;

            while ((line = reader.readLine()) != null) {
                a.add(new Riskclass(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;

    }
}
