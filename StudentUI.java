package com.ct;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentUI extends JFrame {
	
	JTextArea students = new JTextArea();
	JLabel idLabel = new JLabel ("ID: ");
	JTextField idTextField = new JTextField (10);
	JLabel nameLabel = new JLabel ("Name: ");
	JTextField nameTextField = new JTextField (10);
	JLabel topicLabel = new JLabel ("Topic: ");
	JTextField topicTextField = new JTextField (10);
	JLabel timeLabel = new JLabel ("Date: ");
	JTextField timeTextField = new JTextField (10);
	
	JButton addButton = new JButton("Add");
	JButton deleteButton = new JButton("Delete");
	JButton exitButton = new JButton("Exit");
	
	private LinkedList<Student> studentList = new LinkedList<Student> ();
	
	
	public StudentUI () {
		
		JPanel flowPanel1 = new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel flowPanel2 = new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel gridPanel = new JPanel (new GridLayout (2,1));
		
		students.setEditable(false);
		
		flowPanel1.add(idLabel);
		flowPanel1.add(idTextField);
		flowPanel1.add(nameLabel);
		flowPanel1.add(nameTextField);
		flowPanel1.add(topicLabel);
		flowPanel1.add(topicTextField);
		flowPanel1.add(timeLabel);
		flowPanel1.add(timeTextField);
		
		flowPanel2.add(addButton);
		flowPanel2.add(deleteButton);
		flowPanel2.add(exitButton);
		
		gridPanel.add(flowPanel1);
		gridPanel.add(flowPanel2);
		
		add(gridPanel, BorderLayout.NORTH);
		add(students, BorderLayout.CENTER);
		
		addButton.addActionListener(event -> addStudent());
		exitButton.addActionListener(event -> exitApplication());
		deleteButton.addActionListener(event -> deleteStudent());
	}

	private boolean studentListCheck(String studentId) {
		boolean listCheck = false;
		
		for(Student student : studentList) {
			
			if(student.getId().compareTo(idTextField.getText()) == 0) {
				listCheck = true;
			}
		}
		
		return listCheck;
	}
	
	private void refresh() {
		students.setText("");
		
		for(Student student : studentList) {
			students.append(student + "\n");
		}
	}
	
	private void exitApplication() {
		System.exit(0);
	}
	
	private void addStudent() {
				
		if(studentListCheck(idTextField.getText()) == true) {
			JOptionPane.showMessageDialog(null, "Student already in database");
				
		} else {
			studentList.add (new Student (nameTextField.getText(), idTextField.getText(), topicTextField.getText(), timeTextField.getText()));
			
			students.setText("");
			
			for(Student student : studentList) {
				students.append(student + "\n");
			}
		}
		refresh();
		
		idTextField.setText("");
		nameTextField.setText("");
		topicTextField.setText("");
		timeTextField.setText("");
	}
	
	private void deleteStudent() {
		if(studentListCheck(idTextField.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Student not in database");
				
		} else {
			for(int i = 0; i < studentList.size(); i++) {
				
				String studentId = studentList.get(i).getId();
				if(studentId.compareTo(idTextField.getText()) == 0) {
					studentList.remove(i);
				}
			}
		}
		refresh();
		
		idTextField.setText("");
		nameTextField.setText("");
		topicTextField.setText("");
		timeTextField.setText("");
	}
	
	public static void main(String[] args) {
		StudentUI app = new StudentUI();
		app.setVisible(true);
		app.setSize(500,500);
		app.setLocation(200,100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
