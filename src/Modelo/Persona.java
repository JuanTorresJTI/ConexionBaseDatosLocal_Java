package Modelo;

public class Persona {
	int id, age;
	String name, address, hora1, hora2;
	float salary;

	public Persona(int id, String name, int age, String address, float salary, String hora1, String hora2) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
		this.hora1 = hora1;
		this.hora2 = hora2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHora1() {
		return hora1;
	}

	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}

	public String getHora2() {
		return hora2;
	}

	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
