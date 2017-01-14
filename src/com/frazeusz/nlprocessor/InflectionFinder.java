package com.frazeusz.nlprocessor;

import java.util.LinkedList;

/**
 * Created by kamil on 15.12.2016.
 */

class InflectionFinder implements WordProcessor {
    public LinkedList<String> processWord(String word) {
        LinkedList<LinkedList<String>> inflections = WordDatabase.getInflections();

        for(LinkedList<String> words : inflections){

            if(words.contains(word)) return words;
        }

        return new LinkedList<String>();
    }
}
