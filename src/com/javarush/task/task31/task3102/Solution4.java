package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution4 {
    public static List<String> getFileTree(String root) throws IOException {
        File dDirectory = new File(root);
        Queue<File> queue = new LinkedList<File>(Arrays.asList(dDirectory.listFiles()));
        ArrayList<File> files = new ArrayList<>();
        File[] filesFromDirectory;
        while (queue.size() != 0){
            File file = queue.poll();
            if (file.isFile()) files.add(file);
            else {
                filesFromDirectory = file.listFiles();
                for (File file1:filesFromDirectory) {
                    queue.add(file1);
                }
            }
        }
        List<String> strings = new ArrayList<>();
        for (File file : files) {
            strings.add(file.getPath());
        }

        return strings;

    }

    public static void main(String[] args)  {
        try {
            System.out.println(Solution4.getFileTree("C:\\JavaRush\\JavaRushTasks\\"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
