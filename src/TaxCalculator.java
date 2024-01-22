import java.text.DecimalFormat;
import java.util.Scanner;

public class TaxCalculator {
    //function to calculate tax in respect to years
    public static double taxCalculate(double taxableIncome, int age, int year) {
        double taxCalculated = 0.0;

        if (year == 2024) {
            if (taxableIncome > 0 && taxableIncome <= 237100) {
                taxCalculated = taxableIncome * 0.18;
            } else if (taxableIncome > 237100 && taxableIncome <= 370500) {
                taxCalculated = 42678 + (taxableIncome - 237100) * 0.26;
            } else if (taxableIncome > 370500 && taxableIncome <= 512800) {
                taxCalculated = 77362 + (taxableIncome - 370500) * 0.31;
            } else if (taxableIncome > 512800 && taxableIncome <= 673000) {
                taxCalculated = 121475 + (taxableIncome - 512800) * 0.36;
            } else if (taxableIncome > 673000 && taxableIncome <= 857900) {
                taxCalculated = 179147 + (taxableIncome - 673000) * 0.39;
            } else if (taxableIncome > 857900 && taxableIncome <= 1817000) {
                taxCalculated = 251258 + (taxableIncome - 857900) * 0.41;
            } else if (taxableIncome > 1817000) {
                taxCalculated = 644489 + (taxableIncome - 1817000) * 0.45;
            } else {
                throw new IllegalArgumentException("Invalid year!");
            }
        } else if (year == 2023) {
            if (taxableIncome > 0 && taxableIncome <= 226000) {
                taxCalculated = taxableIncome * 0.18;
            } else if (taxableIncome > 226000 && taxableIncome <= 353100) {
                taxCalculated = 40680 + (taxableIncome - 226000) * 0.26;
            } else if (taxableIncome > 353100 && taxableIncome <= 488700) {
                taxCalculated = 73726 + (taxableIncome - 353100) * 0.31;
            } else if (taxableIncome > 488700 && taxableIncome <= 641400) {
                taxCalculated = 115762 + (taxableIncome - 488700) * 0.36;
            } else if (taxableIncome > 641400 && taxableIncome <= 817600) {
                taxCalculated = 170734 + (taxableIncome - 641400) * 0.39;
            } else if (taxableIncome > 817600 && taxableIncome <= 1731600) {
                taxCalculated = 239452 + (taxableIncome - 817600) * 0.41;
            } else if (taxableIncome > 1731601) {
                taxCalculated = 614192 + (taxableIncome - 1731601) * 0.45;
            } else {
                throw new IllegalArgumentException("Invalid year!");
            }
        } else if (year == 2022) {
            if (taxableIncome > 0 && taxableIncome <= 216200) {
                taxCalculated = taxableIncome * 0.18;
            } else if (taxableIncome > 216200 && taxableIncome <= 337800) {
                taxCalculated = 38916 + (taxableIncome - 216200)* 0.26;
            } else if (taxableIncome > 337800 && taxableIncome <= 467500) {
                taxCalculated = 70532 + (taxableIncome - 337800) * 0.31;
            } else if (taxableIncome > 467500 && taxableIncome <= 613600) {
                taxCalculated = 110739 + (taxableIncome - 467500) * 0.36;
            } else if (taxableIncome > 613600 && taxableIncome <= 782200) {
                taxCalculated = 163335 + (taxableIncome - 613600) * 0.39;
            } else if (taxableIncome > 782200 && taxableIncome <= 1656600) {
                taxCalculated = 229089 + (taxableIncome - 782200) * 0.41;
            } else if (taxableIncome > 1656601) {
                taxCalculated = 587593 + (taxableIncome - 1656601) * 0.45;
            } else {
                throw new IllegalArgumentException("Invalid year!");
            }
        } else {
            throw new IllegalArgumentException("Invalid year!");
        }
        return taxCalculated;
    }
    //function for tax rebates
    public static double taxRebates(int age, int year) {
        double primaryRebate = 0;
        double secondaryRebate = 0;
        double tertiaryRebate = 0;

        if (year == 2024) {
            primaryRebate = 17235;
            secondaryRebate = 9444;
            tertiaryRebate = 3145;
        } else if (year == 2023) {
            primaryRebate = 16425;
            secondaryRebate = 9000;
            tertiaryRebate = 2997;
        } else if (year == 2022) {
            primaryRebate = 15714;
            secondaryRebate = 8613;
            tertiaryRebate = 2871;
        } else {
            System.out.println("Invalid year.");
            return 0;
        }

        if (age < 65) {
            return primaryRebate;
        } else if (age >= 65 && age < 75) {
            return secondaryRebate;
        } else if (age >= 75) {
            return tertiaryRebate;
        } else {
            System.out.println("Invalid age.");
            return 0;
        }
    }
    //function for tax threshold
    public static double taxThreshhold(int age, int year){
        double threshhold = 0;
        if (year == 2024){
            if (age < 65){
                threshhold =95750;
            } else if (age >= 65 && age < 75) {
                threshhold = 148217;
            } else if (age >= 75) {
                threshhold = 165689;
            }
        } else if (year == 2023) {
            if (age < 65 ){
                threshhold = 91250;
            } else if (age >= 65 && age < 75) {
                threshhold = 141250;
            } else if (age >= 75) {
                threshhold = 157900;
            }
        } else if (year ==2022) {
            if (age < 65){
                threshhold = 87300;
            } else if (age >= 65 && age <75) {
                threshhold = 135150;
            } else if (age >= 75) {
                threshhold = 151100;
            }
        }else {
            throw new IllegalArgumentException("Invalid year!");
        }
        return  threshhold;
    }

    //function to calculate PAYE tax with rebates deduction
    public static double calculatePAYE(double annualSalary, int age, int year) {
        double taxableIncome = Math.max(annualSalary, 0); // Ensure non-negative income

        // Check if the annual income is below the threshold, no tax calculation needed
        double threshold = taxThreshhold(age, year);
        if (taxableIncome < threshold) {
            return 0.0;
        }

        // Calculate tax using the provided taxCalculate function
        double incomeTax = taxCalculate(taxableIncome, age, year);

        // Calculate rebates using the provided taxRebates function
        double taxRebate = taxRebates(age, year);

        // Deduct rebates based on qualification
        if (age < 65) {
            // Primary rebate only
            incomeTax -= taxRebate;
        } else if (age >= 65 && age < 75) {
            // secondary rebates
            incomeTax -= taxRebate; // 65 is the age for secondary rebate
        } else if (age >= 75) {
            // tertiary rebates
            incomeTax -= taxRebate; // 75 is the age for tertiary rebate
        }

        // Final PAYE tax payable
        double payeTax = Math.max(incomeTax, 0); // No negative tax

        return payeTax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("R #,##0.00");

        do {
            double annualSalary;
            while (true) {
                System.out.print("Enter annual salary: ");
                String input = scanner.next().trim();
                if (input.matches("^\\d*\\.?\\d*$")) {
                    try {
                        annualSalary = Double.parseDouble(input);
                        if (annualSalary >= 1) {
                            break;
                        } else {
                            System.out.println("Invalid annual salary. Please enter a value greater than or equal to 1.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid value.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid value.");
                }
            }

            int age;
            while (true) {
                System.out.print("Enter age: ");
                String input = scanner.next().trim();
                if (input.matches("^\\d+$")) {
                    try {
                        age = Integer.parseInt(input);
                        if (age >= 1) {
                            break;
                        } else {
                            System.out.println("Invalid age. Please enter a value greater than or equal to 1.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid value.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid value.");
                }
            }

            int year;
            while (true) {
                System.out.print("Enter year (2022, 2023, or 2024): ");
                String input = scanner.next().trim();
                if (input.matches("^\\d+$")) {
                    try {
                        year = Integer.parseInt(input);
                        if (year >= 2022 && year <= 2024) {
                            break;
                        } else {
                            System.out.println("Invalid year. Please enter 2022, 2023, or 2024.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid value.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid value.");
                }
            }
            double payeTax = calculatePAYE(annualSalary, age, year);
            // Calculate net income
            double netIncome = annualSalary - payeTax;

            // Display the results
            System.out.println("\nPAYE Tax Calculation Results:");
            System.out.println("Annual Salary: " + decimalFormat.format(annualSalary));
            System.out.println("PAYE Tax Payable:  " + decimalFormat.format(payeTax));
            System.out.println("Net Income (Take-Home Pay):  " + decimalFormat.format(netIncome));

            // Ask if the user wants to calculate another tax
            System.out.print("\nDo you want to calculate another tax? (yes/no): ");
            String answer = scanner.next().toLowerCase();

            if (!answer.equals("yes") && !answer.equals("YES")) {
                break; // exit the loop if the answer is not "yes" or "y"
            }

        } while (true); // loop indefinitely until user chooses to exit

        scanner.close();
    }

}
