package com.telstra.optimisepath.algorithmTest;

import org.junit.Before;
import org.junit.Test;

import com.telstra.optimisepath.algorithm.BellmanHeldKarpAlgorithm;

public class TestBellmanHeldKarpAlgorithm {
	BellmanHeldKarpAlgorithm algorithm = new BellmanHeldKarpAlgorithm();
	
	  @Before
      public void setUp() throws Exception {
      	
             int noOfNodes = 5;
             Integer[][] costMatrix = new Integer[noOfNodes][noOfNodes];
             for (Integer[] row : costMatrix) java.util.Arrays.fill(row, 10000);
             costMatrix[0][1] = 12;
             costMatrix[0][2] = 10;
             costMatrix[0][3] = 19;
             costMatrix[0][4] = 8;
                
             costMatrix[1][0] = 12;
             costMatrix[1][2] = 3;
             costMatrix[1][3] = 7;
             costMatrix[1][4] = 2;
                
             costMatrix[2][0] = 10;
             costMatrix[2][1] = 3;
             costMatrix[2][3] = 6;
             costMatrix[2][4] = 20;
                
             costMatrix[3][0] = 19;
             costMatrix[3][1] = 7;
             costMatrix[3][2] = 6;
             costMatrix[3][4] = 4;
                
             costMatrix[4][0] = 8;
             costMatrix[4][1] = 2;
             costMatrix[4][2] = 20;
             costMatrix[4][3] = 4;
             
  	
  	  

  }
	@Test
    public void testCalculateDistance() {
        //assertEquals(32, algorithm.calculateDistance(0,new int[4],"",0));
      
    }

}
