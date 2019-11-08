package pt.everis.petstore.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.swagger.petstore.model.Pet;

@Component
@Qualifier("GetPetsbyId")
public class GetPetsbyId implements Function<Long, Pet> {

	@Override
	public Pet apply(Long t) {
		Pet pet = new Pet();
		pet.setName("XINHA");
		return pet;
	}

}
