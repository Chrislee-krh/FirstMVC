package org.zerock.member.model;

public class SampleDTO {

	private String name;
	private int age;
	
	public SampleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public SampleDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "SampleDTO [name=" + name + ", age=" + age + "]";
	}
	
}
