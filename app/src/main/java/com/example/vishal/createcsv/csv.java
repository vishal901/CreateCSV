package com.example.vishal.createcsv;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Created by vishal on 29/06/2016.
 */
public class csv extends AppCompatActivity {

    private static boolean writeCSVToConsole = true;
    private static boolean writeCSVToFile = true;

    private static boolean sortTheList = true;
    private static final String IMAGE_DIRECTORY_NAME = "MyData";
    public static String timeStamp;
    public static final int MEDIA_TYPE_IMAGE = 1;
    File mediaFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        List<String> sampleList = createSampleList();

        convertAndPrint(sampleList, writeCSVToConsole, writeCSVToFile, sortTheList);

    }


    private void convertAndPrint(List<String> sampleList,
                                 boolean writeToConsole, boolean writeToFile, boolean sortTheList) {

        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                // MyApplication.getInstance().showLog("TAG", "Oops! Failed create " + IMAGE_DIRECTORY_NAME + " directory");

            }
        }

        timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());


        mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "file_" + timeStamp + ".csv");

        String commaSeparatedValues = "";

        /** If the list is not null and the list size is not zero, do the processing**/
        if (sampleList != null) {
            /** Sort the list if sortTheList was passed as true**/
            if (sortTheList) {
                Collections.sort(sampleList);
            }
            /**Iterate through the list and append comma after each values**/
            Iterator<String> iter = sampleList.iterator();
            while (iter.hasNext()) {
                commaSeparatedValues += iter.next() + ",";
            }
            /**Remove the last comma**/
            if (commaSeparatedValues.endsWith(",")) {
                commaSeparatedValues = commaSeparatedValues.substring(0,
                        commaSeparatedValues.lastIndexOf(","));
            }
        }
        /** If writeToConsole flag was passed as true, output to console**/
        if (writeToConsole) {
            System.out.println(commaSeparatedValues);
        }
        /** If writeToFile flag was passed as true, output to File**/
        if (writeToFile) {

            Log.e("calling","method");
            try {
                FileWriter fstream = new FileWriter(mediaFile, false);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(commaSeparatedValues);
                out.close();
                System.out.println("*** Also wrote this information to file: " + mediaFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {

            Log.e("calling","method");
        }

    }


    private List<String> createSampleList() {
        List<String> sampleList = new ArrayList<String>();
        sampleList.add("Nebraska");
        sampleList.add("Iowa");
        sampleList.add("Illinois");
        sampleList.add("Idaho");
        return sampleList;
    }


}