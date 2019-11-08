package pt.everis.petstore.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pt.everis.swagger.petstore.model.ModelApiResponse;
import pt.everis.swagger.petstore.model.Pet;

@Component
@Qualifier("UpdatePet")
public class UpdatePet implements Function<Pet, ModelApiResponse> {

	@Override
	public ModelApiResponse apply(Pet t) {
		ModelApiResponse response = new ModelApiResponse();
		response.setMessage("Pet updated successful!");

		return response;
	}

}
