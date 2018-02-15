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

public class TeacherUI extends JFrame {
	
	JTextArea teachers = new JTextArea();
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
	
	private LinkedList<Teacher> teacherList = new LinkedList<Teacher> ();
	
	
	public TeacherUI () {
		
		JPanel flowPanel1 = new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel flowPanel2 = new JPanel (new FlowLayout (FlowLayout.CENTER));
		JPanel gridPanel = new JPanel (new GridLayout (2,1));
		
		teachers.setEditable(false);
		
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
		add(teachers, BorderLayout.CENTER);
		
		addButton.addActionListener(event -> addTeacher());
		exitButton.addActionListener(event -> exitApplication());
		deleteButton.addActionListener(event -> deleteTeacher());
	}

	private boolean teacherListCheck(String teacherId) {
		boolean listCheck = false;
		
		for(Teacher teacher : teacherList) {
			
			if(teacher.getId().compareTo(idTextField.getText()) == 0) {
				listCheck = true;
			}
		}
		
		return listCheck;
	}
	
	private void refresh() {
		teachers.setText("");
		
		for(Teacher teacher : teacherList) {
			teachers.append(teacher + "\n");
		}
	}
	
	private void exitApplication() {
		System.exit(0);
	}
	
	private void addTeacher() {
				
		if(teacherListCheck(idTextField.getText()) == true) {
			JOptionPane.showMessageDialog(null, "Teacher already in database");
				
		} else {
			teacherList.add (new Teacher (nameTextField.getText(), idTextField.getText(), topicTextField.getText(), timeTextField.getText()));
			
			teachers.setText("");
			
			for(Teacher teacher : teacherList) {
				teachers.append(teacher + "\n");
			}
		}
		refresh();
		
		idTextField.setText("");
		nameTextField.setText("");
		topicTextField.setText("");
		timeTextField.setText("");
	}
	
	private void deleteTeacher() {
		if(teacherListCheck(idTextField.getText()) == false) {
			JOptionPane.showMessageDialog(null, "Teacher not in database");
				
		} else {
			for(int i = 0; i < teacherList.size(); i++) {
				
				String teacherId = teacherList.get(i).getId();
				if(teacherId.compareTo(idTextField.getText()) == 0) {
					teacherList.remove(i);
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
		TeacherUI app = new TeacherUI();
		app.setVisible(true);
		app.setSize(500,500);
		app.setLocation(200,100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
