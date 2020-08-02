package com.mr.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.mr.service.ScoreRecorder;
import com.mr.service.Sound;

public class MainFrame extends JFrame {
	public MainFrame() {
		restart();
		setBounds(340,150,820，260);
		setTitle("奔跑吧！小恐龙");
		Sound.background();
		ScoreRecorder.init();
		addListener();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		
	}

	private void addListener() {
		addWindowListener(new WindowAdapater() {
			public void windowClosing(WindowEvent e) {
				ScoreRecorder.saveScore();
			}
		}
	}

	private void restart() {
		Container c = getContentPane();
		c.removeAll();
		GamePanel panel = new GamePanel();
		c.add(panel);
		addKeyListener(panel);
		c.validate();

	}
	
	

}
