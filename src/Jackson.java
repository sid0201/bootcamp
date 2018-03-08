import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.sun.istack.internal.NotNull;

public class Jackson {
	public static void main(String args[]) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

		// map json to student

		try {
			Student student = mapper.readValue(jsonString, Student.class);

			System.out.println(student);

			mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(student);

			System.out.println(jsonString);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Student {
	private String name;
	private int age;
	private int rollNo;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", rollNo=" + rollNo + "]";
	}

	//http://www.java2s.com/Code/Jar/j/Downloadjacksonall190jar.htm
}