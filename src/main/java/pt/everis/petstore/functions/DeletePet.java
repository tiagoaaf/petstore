package pt.everis.petstore.functions;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("DeletePet")
public class DeletePet implements Consumer<Long> {

	@Override
	public void accept(Long petId) {

	}

}
