package graphs;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
/**
 * 
 * @author vaneMB
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDijkstra {


	static Logger log = Logger.getLogger("graphs");
	
	static GraphNode A;
	static GraphNode B;
	static GraphNode C;
	static GraphNode D;
	static GraphNode E;

	 @BeforeClass
	 public static void setUpBeforeClass()
	            throws Exception {
		A = new GraphNode("A");
		assertNotNull("No se encuentra A", A);
		B = new GraphNode("B");
		assertNotNull("No se encuentra B", B);
		C = new GraphNode("C");
		assertNotNull("No se encuentra C", C);
		D = new GraphNode("D");
		assertNotNull("No se encuentra D", D);
		E = new GraphNode("E");
		assertNotNull("No se encuentra E", E);
	 }

	// @AfterClass
	    public static void tearDownAfterClass()
	            throws Exception {
	        System.out.println("tearDownAfterClass");
	    }

	// @Before
	    public void setUp()
	            throws Exception {
	        System.out.println("setUp");
	    }

	// @After
	    public void tearDown()
	            throws Exception {
	    }
	    
	   @Test
	    public void addOutgoingEdge(){
		   A.AddOutgoingEdge(B, 5);
		   A.AddOutgoingEdge(C, 20);
		   Assert.assertTrue("No hay 2 objetos", A.getOutGoingEdges().size() == 2);
		   B.AddOutgoingEdge(D, 1);
		   Assert.assertTrue("No hay 1 objeto", B.getOutGoingEdges().size() == 1);
		   C.AddOutgoingEdge(D, 3);
		   C.AddOutgoingEdge(E, 1);
		   Assert.assertTrue("No hay 2 objetos", C.getOutGoingEdges().size() == 2);
		   D.AddOutgoingEdge(E, 100);		   
		   Assert.assertTrue("No hay 1 objeto", D.getOutGoingEdges().size() == 1);
	    }
	   
	  // @Test
	   public void graph(){
		   Graph myGraph = new Graph(A);
		   Dijkstra dAlg = new Dijkstra(myGraph);
		   dAlg.go();
		   dAlg.PrintStatusOfPriorityQ();
		   myGraph.print();
	   }	
}
 