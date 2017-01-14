package com.frazeusz.nlprocessor;


import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * Created by kamil on 15.12.2016.
 */
public class NLProcessor {
    private WordProcessor inflectionFinder, synonymFinder;

    public NLProcessor() {
        inflectionFinder = new InflectionFinder();
        synonymFinder = new SynonymFinder();
    }

    public LinkedList<String> getInflections(String word) {
        LinkedList<String> words = null;

        words = inflectionFinder.processWord(word);

        return words;
    }

    public LinkedList<String> getSynonyms(String word) {
        LinkedList<String> words = null;

        words = synonymFinder.processWord(word);

        return words;
    }

    public static void main(String[] args) {
        NLProcessor proc = new NLProcessor();

        try {
            WordDatabase.startLoading();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Loaded everything");

        LinkedList<String> infl = proc.getInflections("przodkach");


        for(String word : infl) {
            System.out.println(word);
        }


    }




}
