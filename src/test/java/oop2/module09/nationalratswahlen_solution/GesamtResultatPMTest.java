package oop2.module09.nationalratswahlen_solution;

import javafx.collections.ObservableList;
import oop2.module09.nationalratswahlen_solution.presentationmodels.GemeindeResultatPM;
import oop2.module09.nationalratswahlen_solution.presentationmodels.GesamtResultatPM;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Dieter Holz
 */
class GesamtResultatPMTest {

	private GesamtResultatPM sut;

	@BeforeEach
	void setUp() {
		sut = new GesamtResultatPM();
	}

	@Test
	void testGetResulate() {
		//given
		ObservableList<GemeindeResultatPM> resulate = sut.getAlleResultate();

		//then
		assertTrue(resulate.size() > 1);
		assertEquals("Aeugst am Albis"    , resulate.get(0).getGemeindeNamen());
		assertEquals("GE-CH de l'étranger", resulate.get(resulate.size() - 1).getGemeindeNamen());
	}

	@Test
	void testSave() {
		//given

		//when
		sut.getAlleResultate().get(0).setGemeindeNamen("NNN");
		sut.save();

		GesamtResultatPM secondPM = new GesamtResultatPM();

		//then
		assertEquals(sut.getAlleResultate().size(), secondPM.getAlleResultate().size());
		assertEquals("NNN", secondPM.getAlleResultate().get(0).getGemeindeNamen());

		for (int i = 1; i < sut.getAlleResultate().size(); i++) {
			assertEquals(sut.getAlleResultate().get(i).getGemeindeNamen(), secondPM.getAlleResultate().get(i).getGemeindeNamen());
		}

		//after
		sut.getAlleResultate().get(0).setGemeindeNamen("Aeugst am Albis");
		sut.save();
	}

}