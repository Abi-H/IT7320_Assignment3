// Student ID: 2151241

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
	int income, tax, weeksAnnual, weeksFortnight, kiwisaver;
	
	@Before
	public void setUp() throws Exception {
		obj = new ComputeImplementation();
		income = 70000;
		tax = 33;
		weeksAnnual = 52;
		weeksFortnight = 26;
		kiwisaver = 3;
		
		employee = new Employee(income, kiwisaver);
		mockObj = Mockito.mock(ICompute.class);	
		obj.setObj(mockObj);
		
		Mockito.when(mockObj.computeTax(employee.getIncome())).thenReturn((employee.getIncome()/tax)*100);
		Mockito.when(mockObj.weeklySalary(employee)).thenReturn(employee.getIncome()/weeksAnnual);
		Mockito.when(mockObj.fortnightSalary(employee)).thenReturn(employee.getIncome()/weeksFortnight);
		Mockito.when(mockObj.computeKiwiSaver(employee)).thenReturn((employee.getIncome()/employee.getKiwisaver())*100);		
	}
	
	@After
	public void tearDown() throws Exception {
		obj = null;
		mockObj = null;
		employee = null;
	}

	@Test
	public void test() {
		assertEquals((employee.getIncome()/tax)*100, obj.computeTax(income));
		assertEquals(employee.getIncome()/weeksAnnual, obj.weeklySalary(employee));
		assertEquals(employee.getIncome()/weeksFortnight, obj.fortnightSalary(employee));
		assertEquals((employee.getIncome()/employee.getKiwisaver())*100, obj.computeKiwiSaver(employee));
	}

}
