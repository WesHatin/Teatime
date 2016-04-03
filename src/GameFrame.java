import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		addMouseListener(new MouseAdapter());
		addMouseMotionListener(new MouseAdapter());
		setBackground(Color.LIGHT_GRAY);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setVisible(true);
		
		GameBoard canvas = new GameBoard();
		canvas.setBackground(Color.YELLOW);
		canvas.addMouseListener(new MouseAdapter());
		canvas.addMouseMotionListener(new MouseAdapter());
		canvas.setVisible(true);
		
		contentPane.add(canvas, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton runButton = new JButton("Run");
		runButton.addActionListener(new MouseAdapter());
		panel.add(runButton);
		
		JButton previousStage = new JButton("Previous Stage");
		previousStage.addActionListener(new MouseAdapter());
		panel.add(previousStage);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new MouseAdapter());
		panel.add(clearButton);
		
		JButton btnNextStage = new JButton("Next Stage");
		btnNextStage.addActionListener(new MouseAdapter());
		panel.add(btnNextStage);
		
		contentPane.setVisible(true);
	}

}
