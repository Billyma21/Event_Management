package poo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberTest {
	private Member m;
	
	@BeforeEach
	void setUp() throws Exception {
		m = new Member("Bob","Sull",'h',"bob");
	}

	@Test
	void testMemberStringStringCharString() {
		assertTrue(m instanceof Person);
		assertEquals(Status.MEMBER, m.getStatus());
		
		assertEquals("Bob", m.getFirstname());
		assertEquals("Sull", m.getLastname());
		assertEquals('h', m.getGender());
		assertEquals("bob", m.getLogin());
		assertEquals(0d, m.getMoney());
		assertNotNull(m.getEvents());
		assertEquals(0, m.getEvents().size());
	}
	
	@Test
	void testToString() {
		@SuppressWarnings("unused")
		String result = "Bob Sull (VIP)\n"
				+ "\t- Concert\n"
				+ "\t- Party\n";
		
	}



}
