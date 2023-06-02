package fnafModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class window extends JPanel implements ActionListener{
	public JFrame frame = new JFrame();
	private final int width = 800;
	private final int height = 400;
	
	private static final int graphWidth = 32;
	private static final int aWidth = 12;
	
	private static final Color GRAPH_POINTS = Color.black;
	private static final Color GRAPH_LINES = Color.gray;
	
	private static JButton rClose = new JButton("Close Right");
	private static JButton lClose = new JButton("Close Left");
	
	public static boolean rC = false;
	public static boolean lC = false;
	
	
	private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
	public static List<Point> graphPoints = new ArrayList<>();
	public static int[] aPos = new int[3];
	
	public LinkedList<Integer>[] rooms;
	
	public window(LinkedList<Integer>[] graph, int[] POS) {
		this.rooms = graph;
		
		for(int i = 0; i < 3; i++) {
			try {
				window.aPos[i] = POS[i];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println(rC + " " + lC);
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Graphics2D animatronics = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		
		int x1 = 400; int y1 = 100;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 400; y1 = 200;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 300; y1 = 200;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 500; y1 = 200;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 350; y1 = 250;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 350; y1 = 300;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 300; y1 = 250;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 450; y1 = 250;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 450; y1 = 300;
		graphPoints.add(new Point(x1, y1));
		
		x1 = 400; y1 = 300;
		graphPoints.add(new Point(x1, y1));
		
		Stroke oStroke = g2.getStroke();
		g2.setColor(GRAPH_POINTS);
		g2.setStroke(oStroke);
		
		int x = graphPoints.get(0).x;
		int y = graphPoints.get(0).y;
		int x2 = graphPoints.get(1).x;
		int y2 = graphPoints.get(1).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(1).x;
		y = graphPoints.get(1).y;
		x2 = graphPoints.get(2).x;
		y2 = graphPoints.get(2).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(1).x;
		y = graphPoints.get(1).y;
		x2 = graphPoints.get(3).x;
		y2 = graphPoints.get(3).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(1).x;
		y = graphPoints.get(1).y;
		x2 = graphPoints.get(4).x;
		y2 = graphPoints.get(4).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(1).x;
		y = graphPoints.get(1).y;
		x2 = graphPoints.get(7).x;
		y2 = graphPoints.get(7).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(4).x;
		y = graphPoints.get(4).y;
		x2 = graphPoints.get(6).x;
		y2 = graphPoints.get(6).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(4).x;
		y = graphPoints.get(4).y;
		x2 = graphPoints.get(5).x;
		y2 = graphPoints.get(5).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(7).x;
		y = graphPoints.get(7).y;
		x2 = graphPoints.get(8).x;
		y2 = graphPoints.get(8).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(5).x;
		y = graphPoints.get(5).y;
		x2 = graphPoints.get(9).x;
		y2 = graphPoints.get(9).y;
		g2.drawLine(x, y, x2, y2);
		
		x = graphPoints.get(8).x;
		y = graphPoints.get(8).y;
		x2 = graphPoints.get(9).x;
		y2 = graphPoints.get(9).y;
		g2.drawLine(x, y, x2, y2);
		
		g2.setStroke(oStroke);
		g2.setColor(GRAPH_LINES);
		
		for(int i = 0; i < graphPoints.size(); i++) {
			x = graphPoints.get(i).x - graphWidth/2;
			y = graphPoints.get(i).y - graphWidth/2;
			int ovalW = graphWidth;
			int ovalH = graphWidth;
			
			g2.fillOval(x, y, ovalW, ovalH);
		}
		
		g2.setStroke(oStroke);
		g2.setColor(Color.black);
		if(rC) {
			g2.drawLine(430, 280, 430, 320);
		}
		
		if(lC) {
			g2.drawLine(370, 280, 370, 320);
		}
		
		animatronics.setColor(Color.red);
		x = graphPoints.get(aPos[0]).x;
		y = graphPoints.get(aPos[0]).y;
		animatronics.fillOval(x-11, y-12, aWidth, aWidth);
		
		animatronics.setColor(Color.blue);
		x = graphPoints.get(aPos[1]).x;
		y = graphPoints.get(aPos[1]).y;
		animatronics.fillOval(x+2, y-12, aWidth, aWidth);
		
		animatronics.setColor(Color.yellow);
		x = graphPoints.get(aPos[2]).x;
		y = graphPoints.get(aPos[2]).y;
		animatronics.fillOval(x-11, y+2, aWidth, aWidth);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	
	private void showGui(LinkedList<Integer>[] r, int[] anPos) {
		window m = new window(r, anPos);
		
		m.setPreferredSize(getPreferredSize());
		rClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rC) {
					rC = false;
					System.out.println("Closed Right");
				}
				else {
					rC = true;
					System.out.println("Open Right");
				}
			}
		});
		
		lClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lC) {
					lC = false;
					System.out.println("Closed Left");
				}
				else {
					lC = true;
					System.out.println("Open Left");
				}
			}
		});
		
		m.add(rClose);
		m.add(lClose);
		
		frame.add(m);
				
		JLabel l = new JLabel("Stage");
		l.getPreferredSize();
		l.setBounds(400, 65, 40, 20);
		frame.add(l);
		
		l = new JLabel("Main Dining");
		l.getPreferredSize();
		l.setBounds(410, 170, 110, 20);
		frame.add(l);
		
		l = new JLabel("Backroom");
		l.getPreferredSize();
		l.setBounds(310, 170, 70, 20);
		frame.add(l);
		
		l = new JLabel("Bathrooms");
		l.getPreferredSize();
		l.setBounds(510, 170, 75, 20);
		frame.add(l);
		
		l = new JLabel("W Upper");
		l.getPreferredSize();
		l.setBounds(365, 235, 150, 20);
		frame.add(l);
		
		l = new JLabel("W Lower");
		l.getPreferredSize();
		l.setBounds(295, 315, 150, 20);
		frame.add(l);
		
		l = new JLabel("E Upper");
		l.getPreferredSize();
		l.setBounds(467, 233, 150, 20);
		frame.add(l);
		
		l = new JLabel("E Lower");
		l.getPreferredSize();
		l.setBounds(450, 315, 150, 20);
		frame.add(l);
		
		l = new JLabel("Closet");
		l.getPreferredSize();
		l.setBounds(295, 215, 50, 20);
		frame.add(l);
		
		l = new JLabel("Office");
		l.getPreferredSize();
		l.setBounds(385, 315, 150, 20);
		frame.add(l);
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(m);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public void updateA(int[] animPos) {
		for(int i = 0; i < animPos.length; i++) {
			window.aPos[i] = animPos[i];
		}
		frame.repaint();
		frame.validate();
	}
	
	public void run(LinkedList<Integer>[] r, int[] anPos) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				showGui(r, anPos);
				repaint();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
