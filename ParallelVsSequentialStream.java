import java.util.List;

public class ParallelVsSequntialStream{

	public static void main(String[] args) {
		List<Student> students = getSampleStudents();
		long t0 = System.nanoTime();
		students.stream()
		.map(s -> "Hello " + s.name() + ", you are a " + s.major())
		.map(String::toUpperCase)
		.forEach(System.err::println);

		long sequentialMs = (System.nanoTime() - t0) / 1_000_000;
		System.out.printf("Sequential took %db/ms%n", sequentialMs);

		long t1 = System.nanoTime();

		students.stream().parallel()        
		.map(s -> "Hello " + s.name() + ", you are a " + s.major())
		.map(String::toUpperCase)
		.forEach(System.err::println);  

		long parallelMs = (System.nanoTime() - t1) / 1_000_000;
		System.out.printf("Parallel took  %db/ms%n", parallelMs);

	}

	// Student record (Java 16+). If using older version, use a regular class with fields and getters
	public record Student(int id, String name, int age, String major, double gpa) {}

	// Static method returning list of students
	public static List<Student> getSampleStudents() {
		return List.of(
		           new Student(1, "Alice", 19, "Computer Science", 3.82),
		           new Student(2, "Brian", 20, "Mechanical Engg.", 3.45),
		           new Student(3, "Chloe", 18, "Physics", 3.66),
		           new Student(4, "Dinesh", 22, "Mathematics", 3.21),
		           new Student(5, "Esha", 21, "Economics", 3.74),
		           new Student(6, "Farhan", 23, "Electrical Engg.", 3.28),
		           new Student(7, "Gabriela", 19, "Psychology", 3.91),
		           new Student(8, "Hiro", 20, "Civil Engg.", 2.98),
		           new Student(9, "Irene", 18, "Biochemistry", 3.56),
		           new Student(10, "Jamal", 24, "History", 3.12),
		           new Student(11, "Kaitlyn", 20, "Business Admin.", 3.67),
		           new Student(12, "Liam", 21, "Sociology", 3.05),
		           new Student(13, "Mei", 22, "Chemistry", 3.49),
		           new Student(14, "Nikhil", 19, "Political Sci.", 3.80),
		           new Student(15, "Olivia", 18, "English Lit.", 3.59),
		           new Student(16, "Pedro", 20, "Statistics", 3.33),
		           new Student(17, "Quinn", 23, "Fine Arts", 3.25),
		           new Student(18, "Riya", 21, "Medicine", 3.88),
		           new Student(19, "Satoshi", 22, "Philosophy", 3.14),
		           new Student(20, "Zara", 21, "Law", 3.47)
		       );
	}
}
