package pt.everis.petstore.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.swagger.petstore.model.Pet;
import pt.everis.swagger.petstore.model.Pet.StatusEnum;

@Component
@Qualifier("GetPets")
public class GetPets implements Supplier<List<Pet>> {

	@Override
	public List<Pet> get() {
		Pet pet = new Pet();
		pet.setName("Dog");
		pet.setId(1904L);
		pet.setPrice(1234L);
		pet.setRace("Bulldog");
		pet.setStatus(StatusEnum.AVAILABLE);
		return Arrays.asList(pet);
	}

}
