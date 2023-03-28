package flora;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloraController {
    
	private final FloraRepository repository;

	FloraController(FloraRepository repository) {
		this.repository = repository;
	}


	// Aggregate root
	// tag::get-aggregate-root[]
	@GetMapping("/Floras")
	List<Flora> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/Floras")
	Flora newFlora(@RequestBody Flora newFlora) {
		return repository.save(newFlora);
	}

	// Single item
	
	@GetMapping("/Floras/{id}")
	Flora one(@PathVariable Long id) {
		
		return repository.findById(id)
			.orElseThrow(() -> new FloraNotFoundException(id));
	}

	@PutMapping("/Floras/{id}")
	Flora replaceFlora(@RequestBody Flora newFlora, @PathVariable Long id) {
		
		return repository.findById(id)
			.map(Flora -> {
				Flora.setName(newFlora.getName());
				Flora.setRole(newFlora.getRole());
				return repository.save(Flora);
			})
			.orElseGet(() -> {
				newFlora.setId(id);
				return repository.save(newFlora);
			});
	}

	@DeleteMapping("/Floras/{id}")
	void deleteFlora(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
