package com.telstra.optimisepath.algorithmTest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.telstra.optimisepath.algorithm.BellmanHeldKarpAlgorithm;
import com.telstra.optimisepath.dto.PathDTO;

public class TestBellmanHeldKarpAlgorithm {
	BellmanHeldKarpAlgorithm algorithm; 
	PathDTO pathDTO;
	@Before
      public void setUp() throws Exception {
		algorithm = new BellmanHeldKarpAlgorithm();
		  String adjacencyMatrix = "0 12 10 19 8\n" + 
		  							"12 0 3 7 2\n" + 
		  							"10 3 0 6 20\n" + 
		  							"19 7 6 0 4\n" + 
		  							"8 2 20 4 0";
		   pathDTO = new PathDTO(5,adjacencyMatrix,"",0);

  }

	@Test
	public void testCalculateDistance() throws IOException {
		pathDTO=algorithm.getOptimisedPath(pathDTO);
		 assertEquals(32, (int)pathDTO.getOptimalTotalDistance());

	}

}
