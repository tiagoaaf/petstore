package pt.everis.petstore.functions;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.petstore.mongodb.IPetRepository;
import pt.everis.swagger.petstore.model.Pet;

@Component
@Qualifier("GetPets")
public class GetPets implements Supplier<List<Pet>> {

	private IPetRepository petRepo;

	@Autowired
	public GetPets(@Qualifier("PetRepository") IPetRepository petRepo) {
		super();

		this.petRepo = petRepo;
	}

	@Override
	public List<Pet> get() {
		return petRepo.getPets();
	}

}
