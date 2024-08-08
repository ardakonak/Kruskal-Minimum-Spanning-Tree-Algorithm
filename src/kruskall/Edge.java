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
class Edge implements Comparable<Edge> {
    String from, to;                                            
    int cost;                                                   

    public Edge(String from, String to, int cost) {
        this.from = from;                                       
        this.to = to;
        this.cost = cost;
    }

    public String getFrom() {                                   
        return from;                                            
    }

    public String getTo() {
        return to;                                              
    }

    public int getCost() {
        return cost;                                            
    }

    public String toString() {                                 
        return "From " + from + " to " + to + " with cost of " + cost + ".";
    }

    public int compareTo(Edge edge) {                          
        if (this.cost < edge.cost)
            return -1;
        else
            return 1;
    }
}
