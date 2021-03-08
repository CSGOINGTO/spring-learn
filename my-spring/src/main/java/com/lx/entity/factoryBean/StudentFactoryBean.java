package com.lx.entity.factoryBean;

import com.lx.entity.Student;
import org.springframework.beans.factory.FactoryBean;

public class StudentFactoryBean implements FactoryBean<Student> {

	private String studentInfo;

	@Override
	public Student getObject() throws Exception {
		if (this.studentInfo == null) {
			throw new IllegalArgumentException("studentInfo is null...");
		}
		String[] splitStudentInfo = studentInfo.split(",");
		if (splitStudentInfo == null || splitStudentInfo.length != 3) {
			throw new IllegalArgumentException("studentInfo argument is error");
		}
		Student student = new Student();
		student.setName(splitStudentInfo[0]);
		student.setAge(Integer.parseInt(splitStudentInfo[1]));
		student.setTeacherName(splitStudentInfo[2]);
		return student;
	}

	@Override
	public Class<?> getObjectType() {
		return Student.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setStudentInfo(String studentInfo) {
		this.studentInfo = studentInfo;
	}

	@Override
	public String toString() {
		return "StudentFactoryBean{" +
				"studentInfo='" + studentInfo + '\'' +
				'}';
	}
}
