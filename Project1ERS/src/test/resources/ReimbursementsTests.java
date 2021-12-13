package com.revature.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ReimbursementsTests {
	
	@Mock
	private ReimbursementsDao rd;
	
	@InjectMocks
	private ReimbursementServices rs;
	
	@Test
	public void submitMyRequestTest() {
		Mockito.when(rs.submitMyRequest(null).thenReturn(true));
		boolean expected = true;
		boolean actual = rs.submitMyRequest(null);
		assertEquals(expected, actual);
	}
	
	public void
}
