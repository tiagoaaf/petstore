package pt.everis.petstore.controllers;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;
import pt.everis.swagger.petstore.api.PetApiController;
import pt.everis.swagger.petstore.model.ModelApiResponse;
import pt.everis.swagger.petstore.model.Pet;

@Controller
public class PetController extends PetApiController {

	private Function<Pet, ModelApiResponse> addPet;
	private Supplier<List<Pet>> getPets;
	private Function<Long, Pet> getPetbyId;
	private Function<Pet, ModelApiResponse> updatePet;
	private Consumer<Long> deletePet;

	@Autowired
	public PetController(@Qualifier("AddPet") Function<Pet, ModelApiResponse> addPet,
			@Qualifier("GetPets") Supplier<List<Pet>> getPets, @Qualifier("GetPetsbyId") Function<Long, Pet> getPetbyId,
			@Qualifier("UpdatePet") Function<Pet, ModelApiResponse> updatePet,
			@Qualifier("DeletePet") Consumer<Long> deletePet) {
		super();

		this.addPet = addPet;
		this.getPets = getPets;
		this.getPetbyId = getPetbyId;
		this.updatePet = updatePet;
		this.deletePet = deletePet;
	}

	@Override
	public ResponseEntity<List<Pet>> getPets() {
		return ResponseEntity.ok(getPets.get());
	}

	@Override
	public ResponseEntity<Pet> getPetById(@ApiParam(required = true) @PathVariable("petId") Long petId) {
		return ResponseEntity.ok(getPetbyId.apply(petId));
	}

	@Override
	public ResponseEntity<ModelApiResponse> addPet(@ApiParam(required = true) @Valid @RequestBody Pet pet) {
		return ResponseEntity.ok(addPet.apply(pet));
	}

	@Override
	public ResponseEntity<ModelApiResponse> updatePet(@ApiParam(required = true) @Valid @RequestBody Pet pet) {
		return ResponseEntity.ok(updatePet.apply(pet));
	}

	@Override
	public ResponseEntity<Void> deletePet(@ApiParam(required = true) @PathVariable("petId") Long petId) {
		deletePet.accept(petId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}