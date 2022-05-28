import java.util.*;
public class TestStudent 
{
	public static void main(String[] args) 
	{
		String Studentname;
		int quizzes_number = 0;
		double grade = 0;
		Scanner kb = new Scanner(System.in);
		try
		{
		System.out.println("Enter the student name: ");
		Studentname = kb.nextLine();
		int length = Studentname.length();
		char SFNC = Studentname.toUpperCase().charAt(0);
		String fname = SFNC+Studentname.substring(1, length);
		if (Studentname.contains(" ")) {
		int space = Studentname.indexOf(" ");
		String firstname = SFNC+Studentname.substring(1,space);
		char FLNC =  Studentname.toUpperCase().charAt(space+1);
		String lastname = FLNC+Studentname.substring(space+2, length);
		Studentname = firstname + " " + lastname;
		}
		else
		{
			Studentname = fname;	
		}
		Student student = new Student(Studentname);
		System.out.println("Enter the number of quizzes taken: ");
		quizzes_number = kb.nextInt();
		for (int count = 1; count<=quizzes_number; count++ )
		{
			System.out.printf("Enter the grade of quiz#%d for %s: ", count, Studentname);
			grade = kb.nextDouble();
			student.addQuiz(grade);
		}
		kb.close();
		System.out.printf("Name: %s, Quiz average: %.2f",Studentname, student.getAverage());
		}
		catch ( InputMismatchException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e+": Score is negative");
		}
		catch (UnsupportedOperationException e)
		{
			System.out.println(e+": Number of quizzes is zere");
		}
	}
}
class Student{
	private String name;
	private double totalScore = 0;
	private int numberOfQuizzes = 0;
	public Student(String name) throws IllegalArgumentException
	{
		if (name.equals(null))
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.name = name;
		}
	}
	public String getName()
	{
		{
			return name;	
		}
	}
	public double getTotalScore()
	{
		return this.totalScore;
	}
	public double getAverage(){   
		double average = 0;
		if (this.numberOfQuizzes <= 0)
		{
			 throw new UnsupportedOperationException();
		}
		else 
		{
			average = this.totalScore / this.numberOfQuizzes;
		}
		return average;
	}
	public void addQuiz(double grade) 
	{
		if (grade < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.totalScore += grade;
			this.numberOfQuizzes++;
		}
	}
	}
