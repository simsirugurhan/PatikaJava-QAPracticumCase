package firstCaseOfEbebek;

public class Employee {

	public Employee(String name, double salary, int workHours, int hireYear) {
		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}

	String name;
	double salary;
	int workHours;
	int hireYear;

	double tax() {
		if (salary < 1000) {
			return 0;
		} else {
			return salary * 0.03;
		}

	}

	double bonus() {
		/*
		 * 
		 * E�er maa�lar ayl�ksa, bu �al��ma saatlerinin haftal�k olmas�ndan dolay� maa�
		 * haftal�k bir art�� g�sterecek bu y�zden 4 hafta boyunca olmas� gereken bonus
		 * yerine 1 hafta olarak hesaplanacak. Bu durum �nemsenmeden ele al�nm��t�r.
		 * 
		 */
		if (workHours > 40) {
			int workBonus = (workHours - 40) * 30;
			return workBonus;
		} else {
			return 0;
		}

	}

	double raiseSalary() {
		int nowYear = 2021; // �uan y�l 2021 kabul edilmi�tir.
		int yearEmployer = nowYear - hireYear;

		/*
		 * 
		 * vergi maa�tan d���lm��t�r. Bonus ise maa�a eklenmi�tir.
		 * 
		 */
		double sum = (salary - tax()) + bonus();

		if (yearEmployer < 10) {
			return sum * 0.05;
		} else if (yearEmployer > 9 && yearEmployer < 20) {
			return sum * 0.10;
		} else {
			return sum * 0.15;
		}

	}
	
	 public String toString(){
		double totalSalary = salary + bonus();
		double totalSalaryWithTax = salary - tax() + bonus();
		double salaryIncrease = totalSalaryWithTax - salary; // maa� art��� vergi dahil olandan hesaplanm��t�r.
		
		return "ad�: " + name + "\nmaa��: " + salary + "\n�al��ma saati: "
		+ workHours + "\nba�lang�� y�l�: " + hireYear + "\nvergi: " + tax()
		+ "\nbonus: " + bonus() + "\ntoplam maa�: " + totalSalary
		+ "\nvergi ve bonuslarla birlikte maa�: " + totalSalaryWithTax + "\nmaa� art���: " + salaryIncrease;
	}
	 /*
	  * 
	  * ekrana basma i�lemi burada yap�lacaksa parametreli, 
	  * main'de ise parametresiz String d�n��l� metodu �a��r�n.
	  * 
	  * */
	void toString(Employee employee) {

		double totalSalary = employee.salary + employee.bonus();
		double totalSalaryWithTax = employee.salary - employee.tax() + employee.bonus();
		double salaryIncrease = totalSalaryWithTax - employee.salary; // maa� art��� vergi dahil olandan hesaplanm��t�r.

		System.out.println("ad�: " + employee.name + "\nmaa��: " + employee.salary + "\n�al��ma saati: "
				+ employee.workHours + "\nba�lang�� y�l�: " + employee.hireYear + "\nvergi: " + employee.tax()
				+ "\nbonus: " + employee.bonus() + "\ntoplam maa�: " + totalSalary
				+ "\nvergi ve bonuslarla birlikte maa�: " + totalSalaryWithTax + "\nmaa� art���: " + salaryIncrease);

	}

}
