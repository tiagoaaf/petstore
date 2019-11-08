package pt.everis.petstore.functions;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.petstore.mongodb.IPetRepository;

@Component
@Qualifier("DeletePet")
public class DeletePet implements Consumer<Long> {

	private IPetRepository petRepo;

	@Autowired
	public DeletePet(@Qualifier("PetRepository") IPetRepository petRepo) {
		super();

		this.petRepo = petRepo;
	}

	@Override
	public void accept(Long petId) {
		petRepo.deletePet(petId);
	}

}
