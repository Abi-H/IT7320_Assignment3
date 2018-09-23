package Assignment3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ComputeImplementationTest {

	ComputeImplementation obj;
	ICompute mockObj;
	Employee employee;
	int amount;
	
	@Before
	public void setUp() throws Exception {
		obj = new ComputeImplementation();
		employee = new Employee();
		mockObj = Mockito.mock(ICompute.class);
		amount = 70000;
		obj.setObj(mockObj);
		
		Mockito.when(mockObj.computeTax(amount)).thenReturn((amount/33)*100);
		Mockito.when(mockObj.weeklySalary(employee)).thenReturn(amount/52);
		Mockito.when(mockObj.fortnightSalary(employee)).thenReturn(amount/26);
		Mockito.when(mockObj.computeKiwiSaver(employee)).thenReturn((amount/3)*100);		
	}
	
	@After
	public void tearDown() throws Exception {
		obj = null;
		mockObj = null;
		employee = null;
	}

	@Test
	public void test() {
		assertEquals((amount/33)*100, obj.computeTax(amount));
		assertEquals(amount/52, obj.weeklySalary(employee));
		assertEquals(amount/26, obj.fortnightSalary(employee));
		assertEquals((amount/3)*100, obj.computeKiwiSaver(employee));
	}

}
