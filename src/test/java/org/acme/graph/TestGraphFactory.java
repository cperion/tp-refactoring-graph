package org.acme.graph;

import org.acme.graph.model.Edge;
import org.acme.graph.model.Graph;
import org.acme.graph.model.Vertex;

import com.vividsolutions.jts.geom.Coordinate;

public class TestGraphFactory {

	/**   
	 *    d
	 *   / 
	 *  / 
	 * a--b--c
	 * 
	 * @return
	 */
	public static Graph createGraph01(){
		Graph graph = new Graph();

		Vertex a = new Vertex();
		a.setId("a");
		a.setCoordinate(new Coordinate(0.0, 0.0));
		graph.getVertices().add(a);
		
		Vertex b = new Vertex();
		b.setId("b");
		b.setCoordinate(new Coordinate(1.0, 0.0));
		graph.getVertices().add(b);
		
		Vertex c = new Vertex();
		c.setId("c");
		c.setCoordinate(new Coordinate(2.0, 0.0));
		graph.getVertices().add(c);
		
		Vertex d = new Vertex();
		d.setId("d");
		d.setCoordinate(new Coordinate(1.0, 1.0));		
		graph.getVertices().add(d);
		
		Edge ab = graph.createEdge(a, b);
		ab.setId("ab");
		
		Edge bc = graph.createEdge(b, c);
		bc.setId("bc");

		Edge ad = graph.createEdge(a, d);
		ad.setId("ad");	
		
		return graph;
	}

	
}
