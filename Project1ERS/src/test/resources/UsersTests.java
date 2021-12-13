package com.revature.services

import org.mockito.Mockito;

import com.revature.repositories.UsersDao;

@ExtendWith(MockitoExtension.class)
public class UsersTests {
	
	@Mock
	private UsersDao ud;
	
	@InjectMocks
	private UsersServices us;
	
	@Test
	public void loginSystemTest() {
		Mockito.when(ud.loginSystem(null).thenReturn(true));
		boolean expected = true;
		boolean actual = us.loginSystem(null);
		assertEquals(expected, actual);
	}
	

	

}
