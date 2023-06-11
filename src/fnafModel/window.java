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
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
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
	private static JButton beginGame = new JButton("Start");
	
	public static boolean rC = false;
	public static boolean lC = false;
	
	public static int[] graphLines = {0, 1, 1, 2, 1, 3, 1, 4, 1, 7, 4, 5, 4, 6, 7, 8, 5, 9, 8, 9, 1, 11};
	
	public static List<Point> graphPoints = new ArrayList<>();
	public static int[] aPos = new int[4];
	public static int[] aLevel = new int[4];
	public static JLabel k, time;
	public static int bar, power, startUp = 1;
	public static boolean game = false, camOn, rJam = false, lJam = false;
	
	private static Color[] c = {Color.red, Color.blue, Color.yellow, Color.orange};
	private static int[] offsetX = {11, -2, 11, 0};
	private static int[] offsetY = {12, 12, -2, 0};
	
	private static JSpinner FredSpin = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
	private static JSpinner BonSpin = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
	private static JSpinner ChicSpin = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
	private static JSpinner FoxySpin = new JSpinner(new SpinnerNumberModel(0, 0, 20, 1));
	
	
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
		super.paintComponent(g);
		if(window.game){
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
			
			for(int i = 0; i < graphLines.length; i+=2) {
				g2.drawLine(graphPoints.get(graphLines[i]).x, graphPoints.get(graphLines[i]).y, graphPoints.get(graphLines[i+1]).x, graphPoints.get(graphLines[i+1]).y);
			}
			
			g2.setStroke(oStroke);
			g2.setColor(GRAPH_LINES);
			
			for(int i = 0; i < graphPoints.size(); i++) {
				g2.fillOval(graphPoints.get(i).x - graphWidth/2, graphPoints.get(i).y - graphWidth/2, graphWidth, graphWidth);
			}
			
			g2.setStroke(oStroke);
			g2.setColor(Color.black);
			if(rC) {
				g2.drawLine(430, 280, 430, 320);
			}
			
			if(lC) {
				g2.drawLine(370, 280, 370, 320);
			}
			
			
			for(int i = 0; i < 4; i++){
				animatronics.setColor(c[i]);
				animatronics.fillOval(graphPoints.get(aPos[i]).x - offsetX[i], graphPoints.get(aPos[i]).y - offsetY[i], aWidth, aWidth);
			}
			
			
			g2.setColor(Color.yellow);
			g2.fillRect(20, 550, power * 4, 25);
			
			if(window.bar >= 1) {
				g2.setColor(Color.green);
				g2.fillRect(20, 500, 30, 20);
			}
			if(window.bar >= 2) {
				g2.setColor(Color.yellow);
				g2.fillRect(20, 470, 30, 20);
			}
			if(window.bar == 3) {
				g2.setColor(Color.yellow);
				g2.fillRect(20, 440, 30, 20);
			}
		}
		else if(!(window.game) && window.startUp == 1) {
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.orange);
			g2d.fillRect(0, 0, 800, 600);
		}
		else {
			Graphics2D g2dEnd = (Graphics2D) g;
			g2dEnd.setColor(Color.red);
			g2dEnd.fillRect(0, 0, 800, 600);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	
	private void showGui(int[] anPos) {
		window m = new window(anPos);
		m.setPreferredSize(getPreferredSize());
		
		if(window.game) {
			rClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rC) {
						rC = false;
						bar--;
					}
					else if(!rJam){
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
					else if(!lJam){
						lC = true;
						bar++;
					}
				}
			});
			
			m.add(lClose);
			m.add(rClose);
					
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
			
			l = new JLabel("Kitchen");
			l.getPreferredSize();
			l.setBounds(550, 260, 150, 20);
			frame.add(l);
			
			l = new JLabel("Pirate's Cove");
			l.getPreferredSize();
			l.setBounds(225, 150, 150, 20);
			frame.add(l);
			
			k.setText("Power: " + power);
			k.getPreferredSize();
			k.setBounds(20, 525, 150, 20);
			frame.add(k);
			
			time.setText("12 A.M.");
			time.getPreferredSize();
			time.setBounds(20, 20, 150, 20);
			frame.add(time);
			
			frame.add(m);
		}
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
		System.out.println("");
		frame.repaint();
		frame.validate();
	}
	
	public void startGame(int[] anPos) {
		window m = new window(anPos);
		m.setPreferredSize(getPreferredSize());
		frame.repaint();
		
		JLabel Fred = new JLabel("Freddy");
		Fred.getPreferredSize();
		Fred.setBounds(50, 20, 50, 20);
		frame.add(Fred);
		
		JLabel added = new JLabel("(Red Circle)");
		added.getPreferredSize();
		added.setBounds(50, 80, 100, 20);
		frame.add(added);
		
		JLabel Bon = new JLabel("Bonnie");
		Bon.getPreferredSize();
		Bon.setBounds(225, 20, 50, 20);
		frame.add(Bon);
		
		added = new JLabel("(Blue Circle)");
		added.getPreferredSize();
		added.setBounds(225, 80, 100, 20);
		frame.add(added);
		
		JLabel Chic = new JLabel("Chica");
		Chic.getPreferredSize();
		Chic.setBounds(555, 20, 50, 20);
		frame.add(Chic);
		
		added = new JLabel("(Yellow Circle)");
		added.getPreferredSize();
		added.setBounds(525, 80, 100, 20);
		frame.add(added);
		
		JLabel Foxy = new JLabel("Foxy");
		Foxy.getPreferredSize();
		Foxy.setBounds(730, 20, 50, 20);
		frame.add(Foxy);
		
		added = new JLabel("(Orange Circle)");
		added.getPreferredSize();
		added.setBounds(700, 80, 100, 20);
		frame.add(added);
		
		FredSpin.setBounds(50, 40, 50, 40);
		frame.add(FredSpin);
		
		BonSpin.setBounds(225, 40, 50, 40);
		frame.add(BonSpin);
		
		ChicSpin.setBounds(555, 40, 50, 40);
		frame.add(ChicSpin);
		
		FoxySpin.setBounds(730, 40, 50, 40);
		frame.add(FoxySpin);
		
		beginGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aLevel[0] = (int) FredSpin.getValue();
				aLevel[1] = (int) BonSpin.getValue();
				aLevel[2] = (int) ChicSpin.getValue();
				aLevel[3] = (int) FoxySpin.getValue();
				frame.getContentPane().removeAll();
				startUp = 0;
				window.game = true;
				m.remove(beginGame);
				frame.validate();
			}
		});
		beginGame.setBounds(375, 200, 50, 20);
		
		m.add(beginGame);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(m);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
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