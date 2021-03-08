package com.lx.entity;

public class Student {
	private String name;

	private int age;

	private String teacherName;

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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void say() {
		System.out.println(this.toString() + " say Hello...");
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", teacherName='" + teacherName + '\'' +
				'}';
	}
}
