/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskall;

/**
 *
 * @author ardakonak
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Edge> edges = new TreeSet<>();                              

        try {
            FileReader file = new FileReader("/Users/ardakonak/Desktop/related_file.txt");                  
            BufferedReader buff = new BufferedReader(file);
            String line = buff.readLine();
            while (line != null) {                                         
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                String from = stringTokenizer.nextToken();                 
                String to = stringTokenizer.nextToken();                   
                int cost = Integer.valueOf(stringTokenizer.nextToken());   
                edges.add(new Edge(from, to, cost));                      
                line = buff.readLine();                                     
            }
            buff.close();
        } catch (IOException e) {                                           
            System.out.println("Something wrong with the given text file...");
            System.out.println(e.getMessage());
        }

        Kruskal kruskal = new Kruskal();                                    

        edges.forEach(kruskal::union);                                      

        int Totalcost = 0;                                                  
        int loop = 1;
        for (Edge edge : kruskal.getEdges()) {                              
            System.out.println(loop++ + ") " + edge.toString());            
            Totalcost += edge.getCost();
        }                                                                   
        System.out.println("\nCost of the  minimal spanning tree in the text file: " + Totalcost);
    }
}