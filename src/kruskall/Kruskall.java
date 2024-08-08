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
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

class Kruskal {
    Vector<HashSet<String>> Groups = new Vector<>();
    TreeSet<Edge> Edges = new TreeSet<>();

    public TreeSet<Edge> getEdges() {                 
        return Edges;                                   
    }

    HashSet<String> find(String vertex) {               
        for (HashSet<String> Group : Groups) {          
            if (Group.contains(vertex)) {              
                return Group;
            }
        }
        return null;                                    
    }

    public void union(Edge edge) {                      
        String from = edge.getFrom();                  
        String to = edge.getTo();                      

        HashSet<String> From = find(from);              
        HashSet<String> To = find(to);               

        if (From == null) {                             
            Edges.add(edge);                            
            if (To == null) {                           
                HashSet<String> New = new HashSet<>();  
                New.add(from);                         
                New.add(to);
                Groups.add(New);                        
            } else {
                To.add(from);                      
            }                                           
        } else {
            if (To == null) {                           
                From.add(to);                           
                Edges.add(edge);
            } else if (From != To) {                    
                From.addAll(To);                        
                Groups.remove(To);                     
                Edges.add(edge);
            }
        }
    }
}
