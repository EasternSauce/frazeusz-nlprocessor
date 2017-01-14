package com.frazeusz.nlprocessor;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by kamil on 15.12.2016.
 */
public class WordDatabase {
    private static WordDatabase instance = new WordDatabase();
    private LinkedList<LinkedList<String>> inflections = new LinkedList<LinkedList<String>>();
    private LinkedList<LinkedList<String>> synonyms = new LinkedList<LinkedList<String>>();
    private String inflectionsFileName;
    private String synonymsFileName;
    private boolean startedLoading;

    private WordDatabase() {
        inflectionsFileName = "odm-demo.txt";
        synonymsFileName = "...";
        startedLoading = false;
    }

    private void loadWords(String inflectionsFile, String synonymsFile) throws FileNotFoundException {


        //load inflections
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ", ";

        try{

            br = new BufferedReader(new FileReader(inflectionsFile));
            while ((line = br.readLine()) != null) {

                String[] words = line.split(cvsSplitBy);
                LinkedList<String> wordsList = new LinkedList<String>(Arrays.asList(words));

                inflections.add(wordsList);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void startLoading() throws FileNotFoundException {
        if(!instance.startedLoading) {
            instance.startedLoading = true;
            instance.loadWords(instance.inflectionsFileName, instance.synonymsFileName);
        }

    }

    static LinkedList<LinkedList<String>> getInflections(){
        return instance.inflections;
    }
    static LinkedList<LinkedList<String>> getSynonyms(){
        return instance.synonyms;
    }



}
