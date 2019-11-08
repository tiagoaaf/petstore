package pt.everis.petstore.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.swagger.petstore.model.ModelApiResponse;
import pt.everis.swagger.petstore.model.Pet;

@Component
@Qualifier("AddPet")
public class AddPet implements Function<Pet, ModelApiResponse> {

	@Override
	public ModelApiResponse apply(Pet pet) {

		ModelApiResponse response = new ModelApiResponse();
		response.setMessage("Pet added successful!");

		return response;
	}

}
