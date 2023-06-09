package fnafModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class window extends JPanel implements ActionListener{
	public JFrame frame = new JFrame();
	
	private static final int graphWidth = 32;
	private static final int aWidth = 12;
	
	private static final Color GRAPH_POINTS = Color.black;
	private static final Color GRAPH_LINES = Color.gray;
	
	private static JButton rClose = new JButton("Close Right");
	private static JButton lClose = new JButton("Close Left");
	
	public static boolean rC = false;
	public static boolean lC = false;
	
	
	public static List<Point> graphPoints = new ArrayList<>();
	public static int[] aPos = new int[4];
	public static int power;
	public static JLabel k;
	public static JLabel time;
	public static int bar;
	public static boolean game = true;
	public static int startUp = 1;
	public static boolean camOn;
	
	public window(int[] POS) {
		window.k = new JLabel();
		window.time = new JLabel();
		window.bar = 1;
		
		for(int i = 0; i < 4; i++) {
			try {
				window.aPos[i] = POS[i];
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if(window.game) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			Graphics2D animatronics = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			graphPoints.add(new Point(400, 100)); //Point 0 - Stage
			graphPoints.add(new Point(400, 200)); //Point 1 - Main Dining
			graphPoints.add(new Point(300, 200)); //Point 2 - Backroom
			graphPoints.add(new Point(540, 200)); //Point 3 - Bathrooms
			graphPoints.add(new Point(350, 250)); //Point 4 - W Upper
			graphPoints.add(new Point(350, 300)); //Point 5 - W Lower
			graphPoints.add(new Point(300, 250)); //Point 6 - Closet
			graphPoints.add(new Point(450, 250)); //Point 7 - E Upper
			graphPoints.add(new Point(450, 300)); //Point 8 - E Lower
			graphPoints.add(new Point(400, 300)); //Point 9 - Office
			graphPoints.add(new Point(325, 160)); //Point 10 - Pirate's Cove
			graphPoints.add(new Point(540, 250)); //Point 11 - Kitchen
			
			g2.setColor(Color.blue);
			g2.fillRect(0, 0, 800, 600);
			
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
			x2 = graphPoints.get(5).x;
			y2 = graphPoints.get(5).y;
			g2.drawLine(x, y, x2, y2);
			
			x = graphPoints.get(4).x;
			y = graphPoints.get(4).y;
			x2 = graphPoints.get(6).x;
			y2 = graphPoints.get(6).y;
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
			
			x = graphPoints.get(1).x;
			y = graphPoints.get(1).y;
			x2 = graphPoints.get(11).x;
			y2 = graphPoints.get(11).y;
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
			
			animatronics.setColor(Color.orange);
			x = graphPoints.get(aPos[3]).x;
			y = graphPoints.get(aPos[3]).y;
			animatronics.fillOval(x, y, aWidth, aWidth);
			
			g2.setColor(Color.yellow);
			g2.fillRect(20, 550, power * 4, 25);
			
			g2.setColor(Color.green);
			g2.fillRect(20, 500, 30, 20);
			
			if(window.bar == 1) {
				g2.setColor(Color.green);
				g2.fillRect(20, 500, 30, 20);
			}
			else if(window.bar == 2) {
				g2.setColor(Color.green);
				g2.fillRect(20, 500, 30, 20);
				
				g2.setColor(Color.yellow);
				g2.fillRect(20, 470, 30, 20);
			}
			else if(window.bar == 3) {
				g2.setColor(Color.green);
				g2.fillRect(20, 500, 30, 20);
				
				g2.setColor(Color.yellow);
				g2.fillRect(20, 470, 30, 20);
				
				g2.setColor(Color.yellow);
				g2.fillRect(20, 440, 30, 20);
			}
			
		}
		else if(!window.game) {
			
		}
		else {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.black);
			g2.fillRect(0, 0, 800, 600);
		}
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	
	private void showGui(int[] anPos) {
		window m = new window(anPos);
		
		m.setPreferredSize(getPreferredSize());
		
		if(startUp == 0) {
			
		}
		else if(window.game) {
			rClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rC) {
						rC = false;
						bar--;
					}
					else {
						rC = true;
						bar++;
					}
				}
			});
			
			lClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(lC) {
						lC = false;
						bar--;
					}
					else {
						lC = true;
						bar++;
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
			
			k.setText("Power: " + power);
			k.getPreferredSize();
			k.setBounds(20, 525, 150, 20);
			frame.add(k);
			
			time.setText("12 A.M.");
			time.getPreferredSize();
			time.setBounds(20, 20, 150, 20);
			frame.add(time);
		}
		
		frame.add(m);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(m);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	public void updateA(int[] animPos, int p) {
		for(int i = 0; i < animPos.length; i++) {
			window.aPos[i] = animPos[i];
		}
		power = p;
		k.setText("Power: " + power);
		if(power <= 0) {
			window.lC = false;
			window.rC = false;
		}
		frame.repaint();
		frame.validate();
	}
	
	public void endOfGame(int o) {
		window.game = false;
		frame.getContentPane().removeAll();
		if(o == 1) {
			k = new JLabel("YOU LOSE");
			k.getPreferredSize();
			k.setBounds(150, 100, 400, 300);
			k.setFont(new Font("Serif", Font.PLAIN, 36));
			frame.add(k);
		}
		else {
			k = new JLabel("YOU WIN");
			k.getPreferredSize();
			k.setBounds(150, 100, 400, 300);
			k.setFont(new Font("Serif", Font.PLAIN, 36));
			frame.add(k);
		}
		
		frame.repaint();
		frame.validate();
	}
	
	public void changeTime(int t) {
		if(t < 180) {
			time.setText("12 A.M.");
		}
		else if(t >= 180 && t < 358) {
			time.setText("1 A.M.");
		}
		else if(t >= 358 && t < 536) {
			time.setText("2 A.M.");
		}
		else if(t >= 536 && t < 714) {
			time.setText("3 A.M.");
		}
		else if(t >= 714 && t < 892) {
			time.setText("4 A.M.");
		}
		else if(t >= 892 && t < 1070) {
			time.setText("5 A.M.");
		}
	}
	
	public void run(int[] anPos) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				showGui(anPos);
				repaint();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}