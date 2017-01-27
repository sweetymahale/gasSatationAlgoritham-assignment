package project3;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex>
{
    public final String name;
   
  //  public int [] fuelStation = {v1, v3};
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge
{
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class problem1
{
    public static void computePaths(Vertex source)
    {
    	 int distFullTank = 5;
    	    int firstTimeDist = 5 ;
    	    double NDf = 0;
    	    double Df = 0;
    	    int invalid = 0;
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
      	vertexQueue.add(source);
      	int flag = 0;
      	while (!vertexQueue.isEmpty()) {
    	    Vertex u = vertexQueue.poll();

                // Visit each edge exiting u
                for (Edge e : u.adjacencies)
                {
                    Vertex v = e.target;
                    double weight = e.weight;
                    double distanceThroughU = u.minDistance + weight;
    		if (distanceThroughU < v.minDistance) {
    		    vertexQueue.remove(v);
    		    v.minDistance = distanceThroughU ;
    		    v.previous = u;
    		    vertexQueue.add(v);
    		}
                }
            }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
    //   System.out.println("!!"+target );
    
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
        {	
            path.add(vertex);
            System.out.println("***"+target );
        }
  
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args)
    {
    
		Vertex v0 = new Vertex("v0");
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
	
/*	Vertex v7 = new Vertex("Yellowville");
	Vertex v8 = new Vertex("Pinkville");
	Vertex v9 = new Vertex("Greyville");*/

	v0.adjacencies = new Edge[]{ new Edge(v1, 4),
	                           //  new Edge(v6, 10),
	                             new Edge(v2, 5) };
	v1.adjacencies = new Edge[]{ new Edge(v0, 4),
	                             new Edge(v2, 3)
	                              };
	
	v2.adjacencies = new Edge[]{ new Edge(v3, 2),
                               new Edge(v1, 3),
                               new Edge(v0, 5)};
	
	v3.adjacencies = new Edge[]{ new Edge(v4, 2),
	                             new Edge(v2, 2) };
	
	v4.adjacencies = new Edge[]{ new Edge(v1, 9),
                               new Edge(v5, 3) };
	
	v5.adjacencies = new Edge[]{ new Edge(v6, 4),
            new Edge(v4, 3) };

	v6.adjacencies = new Edge[]{ new Edge(v5, 4)
						//		, new Edge(v0, 10)
								  };
	
/*	v7.adjacencies = new Edge[]{ new Edge(v6, 6),
								 new Edge(v8, 7) };
	
	v8.adjacencies = new Edge[]{ new Edge(v6, 2),
								 new Edge(v9, 2),
								 new Edge(v7, 7)  };
	
	v9.adjacencies = new Edge[]{ new Edge(v4, 9),
								 new Edge(v8, 2) };*/
	
	    Vertex[] vertices = { v0, v1, v2, v3, v4, v5,v6 };   //,v5,v6,v7,v8,v9 
     //   computePaths(v0);
	    v0.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
      	vertexQueue.add(v0);
      	int flag = 0;
      	while (!vertexQueue.isEmpty()) {
    	    Vertex u = vertexQueue.poll();

                // Visit each edge exiting u
                for (Edge e : u.adjacencies)
                {
                    Vertex v = e.target;
                    double weight = e.weight;
                    double distanceThroughU = u.minDistance + weight;
                //    System.out.println(v+"Distance to " +  u.minDistance+ ":## " + weight);
                    if (e.target  == v1 || e.target  == v3 ||e.target  == v5 )
                    {
                    	// vertexQueue.remove(v);
                    	double finalDist = distanceThroughU;
                    	v.minDistance = distanceThroughU ;
                    	 v.previous = e.target;
                    	  vertexQueue.add(v); 
 		    		    
                    }
                    else if(e.target  == v0 || e.target  == v2 ||e.target  == v4 ||e.target  == v6 )
                    {
                   
            		 if (distanceThroughU < v.minDistance)
              		   {  
            			 //System.out.println("Distance to " + e.target+ ": " + v.minDistance);
            			 double finalDist =  distanceThroughU;
            			 vertexQueue.remove(v);
 		    		    v.minDistance = distanceThroughU ;
 		    		    v.previous = u;
 		    		  vertexQueue.add(v);   
            			 //   vertexQueue.remove(v);
          		    		   // v.minDistance = distanceThroughU ;
          		    		
              		   }
                    }
                  //  vertexQueue.add(v);
                    
                  // System.out.println("Distance to " + e.target+ ": " + v.minDistance);
    		 /*  if (distanceThroughU < v.minDistance)
    		   {
		    		    vertexQueue.remove(v);
		    		    v.minDistance = distanceThroughU ;
		    		    v.previous = u;
		    		    vertexQueue.add(v);
		    		    
    		    }
    		   break;
              */  }
                
            }

     
        //   System.out.println("Distance to " + v + ": " + v.minDistance);
       for (Vertex v : vertices)
		{
    	   if(v == v6)
    	   {
		    System.out.println("Distance to " + v + ": " + v.minDistance);
		    List<Vertex> path = getShortestPathTo(v6);
		    System.out.println("Path: " + path);
    	   }
		}
    }
}