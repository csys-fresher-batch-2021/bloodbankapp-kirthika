package in.kirthika.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DonorTest 
{
	@Test
	public void test1() {
	
		boolean valid=DonorManager.displayDonor("Kirthika");
		assertTrue(valid);
		
	}
	@Test
	public void test2()
	{
		boolean valid=DonorManager.displayDonor("vinay");
		assertFalse(valid);
		
	}
	@Test
	
		public void test3()
		{
			
			boolean valid=DonorManager.displayDonor("Swetha");
			assertTrue(valid);
		}
	@Test
	
	public void test4()
	{
		
		boolean valid=DonorManager.displayDonor("anu");
		assertFalse(valid);
	}
}


