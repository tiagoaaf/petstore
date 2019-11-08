package pt.everis.petstore.mongodb;

import java.util.List;

import pt.everis.swagger.petstore.model.Pet;

public interface IPetRepository {

	public void addPet(Pet pet);

	public List<Pet> getPets();

	public Pet getPetById(Long id);

	public void updatePet(Pet pet);

	public void deletePet(Long id);
}
