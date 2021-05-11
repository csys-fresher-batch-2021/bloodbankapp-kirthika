package in.kirthika.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DonorTest 
{
	@Test
	public void test() {
		DonorDetails.donorAdd();
		boolean valid=DonorDetails.displayDonor("O+");
		assertTrue(valid);
		
	}
	@Test
	public void test1()
	{
		boolean valid=DonorDetails.displayDonor("A+");
		assertTrue(valid);
		
	}
	@Test
	
		public void test2()
		{
			
			boolean valid=DonorDetails.displayDonor("B+");
			assertTrue(valid);
		}
	@Test
	
	public void test3()
	{
		
		boolean valid=DonorDetails.displayDonor("A1B+");
		assertFalse(valid);
	}
}


