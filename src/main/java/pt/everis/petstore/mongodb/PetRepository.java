package pt.everis.petstore.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import pt.everis.swagger.petstore.model.Pet;

@Repository
@Qualifier("PetRepository")
public class PetRepository implements IPetRepository {

	private static final String COLLECTION = "pets";

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void addPet(Pet pet) {
		mongoTemplate.insert(pet, COLLECTION);
	}

	@Override
	public List<Pet> getPets() {
		return (List<Pet>) mongoTemplate.findAll(Pet.class, COLLECTION);
	}

	@Override
	public Pet getPetById(Long id) {
		return mongoTemplate.findById(id, Pet.class, COLLECTION);
	}

	@Override
	public void updatePet(Pet pet) {
		if (mongoTemplate.findById(pet.getId(), Pet.class, COLLECTION) != null) {
			mongoTemplate.remove(pet, COLLECTION);
			mongoTemplate.insert(pet, COLLECTION);
		}
	}

	@Override
	public void deletePet(Long id) {
		mongoTemplate.remove(mongoTemplate.findById(id, Pet.class, COLLECTION), COLLECTION);
	}

}
