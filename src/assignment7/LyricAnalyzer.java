package assignment7;/*
Since you have not learned File class yet, I have written the main method for you
to test your written code. Please don't forget to change the file path
"/Users/luqifei/IdeaProjects/untitled/Paint/test1.txt" to test 4 test txt
files. The 4 test txt files are already saved in assignment 7 zip. The deadline
for this assignment is 15 Mach 2017.
*/

import java.io.*;
import java.util.*;

public class LyricAnalyzer {

    public static void add(HashMap<String, ArrayList<Integer>> map, String lyricWord, int wordPosition) {
        if (map.containsKey(lyricWord)) {
            map.get(lyricWord).add(wordPosition);
        } else {
            map.put(lyricWord, new ArrayList<>());
            map.get(lyricWord).add(wordPosition);
        }
    }

    public static void displayWords(HashMap<String, ArrayList<Integer>> map) {
        SortedSet<String> words = new TreeSet<>(map.keySet());

        Iterator iter = words.iterator();
        while (iter.hasNext()) {
            Object sortedWord = iter.next();
            System.out.print(sortedWord.toString() + ": ");
            ArrayList<Integer> tempArr = new ArrayList<>(map.get(sortedWord));
            for (int i = 0; i < tempArr.size() - 1; i++) {
                System.out.print(tempArr.get(i) + ", ");
            }
            System.out.println(tempArr.get(tempArr.size() - 1));
        }
    }

    public static void displayLyrics(HashMap<String, ArrayList<Integer>> map) {
        int lyricsSize = 1;
        for (String word : map.keySet()) {
            lyricsSize += map.get(word).size();
        }

        String[] lyrics = new String[lyricsSize];
        for (int i = 0; i < lyricsSize; i++) {
            lyrics[i] = "";
        }

        for (String word : map.keySet()) {
            ArrayList<Integer> positionList = map.get(word);
            for (Integer position : positionList) {
                if (position > 0) {
                    lyrics[position] = word + " ";
                } else {
                    lyrics[position * (-1)] = word + "\n";
                }
            }
        }

        for (String line : lyrics) {
            System.out.print(line);
        }
    }

    public static int count(HashMap<String, ArrayList<Integer>> map) {
        return map.keySet().size();
    }

    public static String mostFrequentWord(HashMap<String, ArrayList<Integer>> map) {
        String mostFrequentWord = "";
        int frequency = 0;

        for (String word : map.keySet()) {
            if (map.get(word).size() > frequency) {
                frequency = map.get(word).size();
                mostFrequentWord = word;
            }
            if (map.get(word).size() == frequency) {
                if (mostFrequentWord.compareTo(word) >= 0) {
                    mostFrequentWord = word;
                }
            }
        }

        return mostFrequentWord;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        int position = 1;  //word position index start from 1

        String pathname = "src/assignment7/test1.txt";
        File f = new File(pathname);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        String line = "";
        while (true) {
            line = br.readLine();
            if (line == null || line.length() == 0) {
                break;
            }
            String[] arr = line.trim().split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1) {
                    add(map, arr[i].toUpperCase(), position++);
                } else {
                    add(map, arr[i].toUpperCase(), (-1) * position);
                    position++;
                }
            }
        }
        br.close();

        displayLyrics(map);
        System.out.println();
        displayWords(map);
        System.out.println();
        System.out.println("The number of unique words in the lyric is: " + count(map));
        System.out.println();
        System.out.println("Most frequent word: " + mostFrequentWord(map));
    }

}

