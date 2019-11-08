package pt.everis.petstore.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.petstore.mongodb.IPetRepository;
import pt.everis.swagger.petstore.model.Pet;

@Component
@Qualifier("GetPetsbyId")
public class GetPetsbyId implements Function<Long, Pet> {

	private IPetRepository petRepo;

	@Autowired
	public GetPetsbyId(@Qualifier("PetRepository") IPetRepository petRepo) {
		super();

		this.petRepo = petRepo;
	}

	@Override
	public Pet apply(Long petId) {
		return petRepo.getPetById(petId);
	}

}
