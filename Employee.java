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
		 * Eðer maaþlar aylýksa, bu çalýþma saatlerinin haftalýk olmasýndan dolayý maaþ
		 * haftalýk bir artýþ gösterecek bu yüzden 4 hafta boyunca olmasý gereken bonus
		 * yerine 1 hafta olarak hesaplanacak. Bu durum önemsenmeden ele alýnmýþtýr.
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
		int nowYear = 2021; // þuan yýl 2021 kabul edilmiþtir.
		int yearEmployer = nowYear - hireYear;

		/*
		 * 
		 * vergi maaþtan düþülmüþtür. Bonus ise maaþa eklenmiþtir.
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
		double salaryIncrease = totalSalaryWithTax - salary; // maaþ artýþý vergi dahil olandan hesaplanmýþtýr.
		
		return "adý: " + name + "\nmaaþý: " + salary + "\nçalýþma saati: "
		+ workHours + "\nbaþlangýç yýlý: " + hireYear + "\nvergi: " + tax()
		+ "\nbonus: " + bonus() + "\ntoplam maaþ: " + totalSalary
		+ "\nvergi ve bonuslarla birlikte maaþ: " + totalSalaryWithTax + "\nmaaþ artýþý: " + salaryIncrease;
	}
	 /*
	  * 
	  * ekrana basma iþlemi burada yapýlacaksa parametreli, 
	  * main'de ise parametresiz String dönüþlü metodu çaðýrýn.
	  * 
	  * */
	void toString(Employee employee) {

		double totalSalary = employee.salary + employee.bonus();
		double totalSalaryWithTax = employee.salary - employee.tax() + employee.bonus();
		double salaryIncrease = totalSalaryWithTax - employee.salary; // maaþ artýþý vergi dahil olandan hesaplanmýþtýr.

		System.out.println("adý: " + employee.name + "\nmaaþý: " + employee.salary + "\nçalýþma saati: "
				+ employee.workHours + "\nbaþlangýç yýlý: " + employee.hireYear + "\nvergi: " + employee.tax()
				+ "\nbonus: " + employee.bonus() + "\ntoplam maaþ: " + totalSalary
				+ "\nvergi ve bonuslarla birlikte maaþ: " + totalSalaryWithTax + "\nmaaþ artýþý: " + salaryIncrease);

	}

}
