package pt.everis.petstore.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.petstore.mongodb.IPetRepository;
import pt.everis.swagger.petstore.model.ModelApiResponse;
import pt.everis.swagger.petstore.model.Pet;

@Component
@Qualifier("UpdatePet")
public class UpdatePet implements Function<Pet, ModelApiResponse> {

	private IPetRepository petRepo;

	@Autowired
	public UpdatePet(@Qualifier("PetRepository") IPetRepository petRepo) {
		super();

		this.petRepo = petRepo;
	}

	@Override
	public ModelApiResponse apply(Pet pet) {
		petRepo.updatePet(pet);

		ModelApiResponse response = new ModelApiResponse();
		response.setMessage("Pet updated successful!");

		return response;
	}

}
