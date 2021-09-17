package demo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class MyJsonParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" **** Student JSON Parser Demo ****");

		// showAllStudents();
		List<JSONObject> studentsList = getStudentsWithMarksMoreThan(80);
		if (studentsList.isEmpty()) {
			System.out.println("********NO STUDENTS FOUND*************");
		}
		if (studentsList != null || !studentsList.isEmpty()) {
			showFilteredStudentsList(studentsList);
		}
	}

	static List<JSONObject> showAllStudents() {
		List<JSONObject> studentsList = new ArrayList<JSONObject>();

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(
					"/Users/prashantchandra/Documents/Learninng/dev/workspace/demo/src/main/java/demo/student.json"));

			JSONObject jsonObject = (JSONObject) obj;

			JSONArray studentList = (JSONArray) jsonObject.get("students");

			Iterator<JSONObject> iterator = studentList.iterator();
			while (iterator.hasNext()) {
				// System.out.println(iterator.next());

				JSONObject studentObj = (JSONObject) iterator.next();
				long rollNo = (long) studentObj.get("roll_no");

				System.out.println("Roll No::" + rollNo);
				JSONObject studenntDetailObj = (JSONObject) studentObj.get("details");

				String name = (String) studenntDetailObj.get("name");

				System.out.println("Student Name::" + name);

				long marks = (long) studenntDetailObj.get("marks");
				System.out.println("Student Marks::" + marks);
				long age = (long) studenntDetailObj.get("age");
				System.out.println("Student Age::" + age);

				System.out.println("********************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentsList;

	}

	static void showFilteredStudentsList(List<JSONObject> studentsList) {

		JSONParser parser = new JSONParser();

		try {
			if (studentsList != null) {
				Iterator<JSONObject> iterator = studentsList.iterator();
				while (iterator.hasNext()) {
					// System.out.println(iterator.next());

					JSONObject studentObj = (JSONObject) iterator.next();
					long rollNo = (long) studentObj.get("roll_no");

					System.out.println("Roll No::" + rollNo);
					JSONObject studenntDetailObj = (JSONObject) studentObj.get("details");

					String name = (String) studenntDetailObj.get("name");

					System.out.println("Student Name::" + name);

					long marks = (long) studenntDetailObj.get("marks");
					System.out.println("Student Marks::" + marks);
					long age = (long) studenntDetailObj.get("age");
					System.out.println("Student Age::" + age);

					System.out.println("********************************");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static List<JSONObject> getStudentsWithMarksMoreThan(int marksInput) {
		List<JSONObject> studentsList = new ArrayList<JSONObject>();

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader(
					"/Users/prashantchandra/Documents/Learninng/dev/workspace/demo/src/main/java/demo/student.json"));

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray studentList = (JSONArray) jsonObject.get("students");
			Iterator<JSONObject> iterator = studentList.iterator();
			while (iterator.hasNext()) {
				JSONObject studentObj = (JSONObject) iterator.next();
				JSONObject studenntDetailObj = (JSONObject) studentObj.get("details");
				long marks = (long) studenntDetailObj.get("marks");
				if (marks > marksInput) {
					studentsList.add(studentObj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentsList;

	}

}
