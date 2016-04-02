import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Panel;

public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		JButton clearButton = new JButton("Clear");
		panel.add(clearButton);
		
		contentPane.setVisible(true);
	}

}
