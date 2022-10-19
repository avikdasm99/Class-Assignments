package lab;
class CountryNotValidException extends Exception{
	CountryNotValidException(String massage){
		super(massage);
	}
}
class EmployeeNameInvalidException extends Exception{
	EmployeeNameInvalidException(String massage){
		super(massage);
	}
}
class TaxNotEligibleException extends Exception{
	TaxNotEligibleException(String massage){
		super(massage);
	}
}
class TaxCalculator   {
	public double calculateTax(String empName,boolean isIndian,double empSal) throws Exception {
		double amount = 0;
        if (isIndian == false) { 
            throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
        } else if (empName == null) {
            throw new EmployeeNameInvalidException("The employee name cannot be empty");
        } else if (empSal > 100000 && isIndian == true) {
            amount = (empSal * 8) / 100; 
        } else if (empSal > 50000 && empSal < 100000 && isIndian == true) {
            amount = (empSal * 6) / 100;
        } else if (empSal > 30000 && empSal < 50000 && isIndian == true) {
            amount = (empSal * 5) / 100;
        } else if (empSal > 10000 && empSal < 300000 && isIndian == true) {
            amount = (empSal * 4) / 100;
        } else { 
            throw new TaxNotEligibleException("The employee does not need to pay tax :");
        }
        return amount;
    }
}

public class CalculatorSimulator{
	public static void main(String[] args) throws Exception{
		TaxCalculator obj=new TaxCalculator();
		
		     System.out.println("\nTest Case 1");
			try {   System.out.println( obj.calculateTax("ron",false,34000));  }
		    catch(Exception e)   {  System.out.println(e.getMessage());   } 
			
			
			System.out.println("\nTest Case 2");
			try {  System.out.println( obj.calculateTax("Tim",true,10000));   }
			catch(Exception e){  System.out.println(e.getMessage());    } 
			
			
			System.out.println("\nTest Case 3");
			try {   System.out.println( obj.calculateTax("Jack",true,55000));    }
			catch(Exception e){  System.out.println(e.getMessage());  } 
			
			
			System.out.println("\nTest Case 4");
			try { System.out.println( obj.calculateTax(null, true, 30000));  }
			catch(Exception e){  System.out.println(e.getMessage());   } 
	}
}

