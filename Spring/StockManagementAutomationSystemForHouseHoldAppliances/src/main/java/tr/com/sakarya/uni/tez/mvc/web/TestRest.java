package tr.com.sakarya.uni.tez.mvc.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestRest {

	@GetMapping("alien/{aid}")
	public ResponseEntity<String> getAlien(@PathVariable("aid") int aid) 
	{
		System.out.println("TestRest.getAlien()");
		//return "serdar";
		return ResponseEntity.ok("serdar");
	}
	
}
