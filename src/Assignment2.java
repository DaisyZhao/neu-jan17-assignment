/*
score: 10
comments: perfect work!
*/
/**
 * @author Xueying Zhao
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary; // salary per month

    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void raiseSalary(double byPercent) {
        this.salary = salary * (1 + byPercent);
    }

}

enum Gender {
    MALE,
    FEMALE
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */

    public double socialSecurityTax(Employee employee) {                            //correct
        double socialSecTax;

        if (employee.salary <= 8900) {
            socialSecTax = employee.salary * 0.062;
        } else {
            socialSecTax = 106800 * 0.062;
        }

        System.out.println("The social security tax of " + employee.getName() + " is " + socialSecTax);
        return socialSecTax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive),
     * rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60,
     * rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {                              //correct
        double contributionInsurance = 0; 

        if (employee.age < 35) {
            contributionInsurance = 0.03 * employee.salary;
        } else if (employee.age >= 35 && employee.age <= 50) {
            contributionInsurance = 0.04 * employee.salary;
        } else if (employee.age > 50 && employee.age < 60) {
            contributionInsurance = 0.05 * employee.salary;
        } else if (employee.age >= 60) {
            contributionInsurance = 0.06 * employee.salary;
        }

        System.out.println(employee.getName() + "'s contribution for insurance coverage is " + contributionInsurance);
        return contributionInsurance;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {                  //correct

        String message = "Salary from low to high: ";

        Employee[] employees = {e1, e2, e3};

        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (employees[i].salary > employees[j].salary) {
                    Employee tmp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = tmp;
                }
            }
        }

        System.out.println(message + employees[0].getName() + ", " + employees[1].getName() + ", "
                + employees[2].getName());
    }


    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {                    //correct                
        employee.raiseSalary(2);
    }


    // Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) {                                //correct
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {                 //correct
        int digit = 0;

        while (n != 0) {
            digit += n % 10;

            while (digit / 10 != 0) {
                digit = digit % 10 + digit / 10;
            }

            n /= 10;
        }

        return digit;
    }

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {              //correct

        if (n <= 0) {
            return false;
        }

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }

        return true;
    }


    //Extra credit
    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     *
     //correct
     /** Java copies and passes reference by value. In the main() method, a and b are object references.
     When Java passes a and b to the swap() method, it actually copies the original references.
     It means that a and x point to the same object, while b and y point to the same object.
     In the swap() method, references x and y are swapped, but not the original references a and b,
     because references x and y just the copies of original references a and b. So swapping objects a and b failed.
     If you want to swap the values of objects in Java, you need to swap all the values of their fields one by one.
     */

    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}

