package mx.tec.lab.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.tec.lab.entity.Dragon;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DragonRepositoryTest {
	@Resource
	private DragonRepository dragonRepository;

	@Test
	public void givenDragon_whenSave_thenRetrieveSame() {
		Dragon dragon = new Dragon(1, "Meraxes");
		dragonRepository.save(dragon);
		
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertEquals("Meraxes", retrievedDragon.getName());
	}
	
	@Test
	public void givenDragon_whenModified_thenRetrieveChange() { 
		//given
		Dragon dragon = new Dragon(2, "Dragoncito");
		dragonRepository.save(dragon); 
		
		//when
		Dragon retrievedDragon = dragonRepository.findById(2L).orElse(null);
		retrievedDragon.setName("Dragonsote");
		dragonRepository.save(retrievedDragon);
		//then
		Dragon retrievedChangedDragon = dragonRepository.findById(2L).orElse(null);
		assertEquals("Dragonsote", retrievedChangedDragon.getName());
	}
	
	@Test
	public void givenDragon_whenRemoved_thenRetrieveNull() { 
		//given
		Dragon dragon = new Dragon(3, "Chivigon");
		dragonRepository.save(dragon); 

		//when
		dragonRepository.deleteById(3L);
		
		//then
		Dragon retrievedDeletedDragon = dragonRepository.findById(3L).orElse(null);
		assertNull(retrievedDeletedDragon);
		
	}


}
