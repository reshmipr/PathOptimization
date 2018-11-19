package com.telstra.optimisepath.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.optimisepath.dto.PathDTO;
import com.telstra.optimisepath.service.OptimisePathService;
import com.telstra.optimisepath.utils.Constants;

@RestController
@RequestMapping("/path")
public class OptimisePathController {
		@Autowired
		OptimisePathService service;

		@RequestMapping(method = RequestMethod.POST, value = Constants.OPTIMIAL_PATH)
		public PathDTO optimisePath(@RequestBody PathDTO pathDTO) {
			System.out.println("pathhh"+pathDTO);
			return service.optimisePath(pathDTO);
		}
		
		

}
