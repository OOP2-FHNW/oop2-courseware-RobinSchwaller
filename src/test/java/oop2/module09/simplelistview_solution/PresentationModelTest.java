package oop2.module09.simplelistview_solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Dieter Holz
 */
class PresentationModelTest {

	@Test
	void testAdd() {
		//given
		PresentationModel pm = new PresentationModel();

		//then
        assertEquals(0, pm.getElements().size());

		//when
		pm.addNewElement();

		//then
		assertEquals(1, pm.getElements().size());
	}

}