import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorMatcher {

	private static int numberOfRows = 15;
	static int colors = 6;
	private static int trysLeft;
	private static Color[][] allCoordinates = new Color[numberOfRows][numberOfRows];
	private static ArrayList<xySet> conquered = new ArrayList<xySet>();
	private static ArrayList<xySet> adjacent = new ArrayList<xySet>();
	private static JPanel displayPanel;
	private static JPanel buttonPanel;
	private static JFrame frame;
	private static JLabel trysLabel;
	private static JLabel trysLeftLabel;
	private static JLabel numberOfRowsLabel;
	private static JLabel numberOfColorsLabel;
	private static JTextField numberOfColorsField;
	private static JTextField numberOfRowsField;
	private static JLabel youLoseLabel;

	public static void main(String args[]) {
		initialize();
	}

	private static Color randomizeColor(int x) {
		int i = 0;
		Random generator = new Random();
		i = generator.nextInt(x);

		switch (i) {
		case 0:
			return Color.GREEN;
		case 1:
			return Color.BLUE;
		case 2:
			return Color.YELLOW;
		case 3:
			return Color.RED;
		case 4:
			return Color.BLACK;
		case 5:
			return Color.WHITE;
		default:
			return Color.WHITE;
		}
	}

	// puts buttons in the initial display screen
	private static void populateGrid() {
		allCoordinates = new Color[numberOfRows][numberOfRows];
		Color c;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfRows; j++) {
				JButton displayButton = new JButton();
				c = randomizeColor(colors);
				displayButton.setBackground(c);
				GridBagConstraints gbc_button = new GridBagConstraints();
				Dimension preferred = new Dimension(600 / numberOfRows,
						600 / numberOfRows);
				displayButton.setPreferredSize(preferred);
				displayButton.setEnabled(false);
				gbc_button.gridx = i;
				gbc_button.gridy = j;
				displayPanel.add(displayButton, gbc_button);
				allCoordinates[i][j] = c;
			}
		}
	}

	private static void conquer(int x, int y, Color c, Color c1) {
		Color prev = c1;

		if (!isInBounds(x, y))
			return;

		if (allCoordinates[x][y] == prev) {
			allCoordinates[x][y] = c;

			JButton displayButton = new JButton();
			displayButton.setBackground(c);
			GridBagConstraints gbc_button1 = new GridBagConstraints();
			Dimension preferred1 = new Dimension(600 / numberOfRows,
					600 / numberOfRows);
			displayButton.setPreferredSize(preferred1);
			gbc_button1.gridx = x;
			gbc_button1.gridy = y;
			displayPanel.add(displayButton, gbc_button1);

			conquered.add(new xySet(x, y, c));
		} else {
			if (allCoordinates[x][y] == c)
				conquered.add(new xySet(x, y, c));
			return;
		}
		if (!isInList(x + 1, y, conquered))
			conquer(x + 1, y, c, prev);
		if (!isInList(x, y + 1, conquered))
			conquer(x, y + 1, c, prev);
		if (!isInList(x - 1, y, conquered))
			conquer(x - 1, y, c, prev);
		if (!isInList(x, y - 1, conquered))
			conquer(x, y - 1, c, prev);
	}

	private static boolean isAdjacent(Color r) {
		for (xySet xy : adjacent) {
			if (xy.c == r)
				return true;
		}
		return false;
	}

	private static void updateAdjacentList() {
		adjacent.clear();
		int x;
		int y;
		Color c = allCoordinates[0][0];

		for (xySet xy : conquered) {
			x = xy.x;
			y = xy.y;
			if (isInBounds(x + 1, y) && allCoordinates[xy.x + 1][xy.y] != c) {
				adjacent.add(new xySet(xy.x + 1, xy.y,
						allCoordinates[xy.x + 1][xy.y]));
			}
			if (isInBounds(x, y + 1) && allCoordinates[xy.x][xy.y + 1] != c) {
				adjacent.add(new xySet(xy.x, xy.y + 1,
						allCoordinates[xy.x][xy.y + 1]));
			}
			if (isInBounds(x - 1, y) && allCoordinates[xy.x - 1][xy.y] != c) {
				adjacent.add(new xySet(xy.x - 1, xy.y,
						allCoordinates[xy.x - 1][xy.y]));
			}
			if (isInBounds(x, y - 1) && allCoordinates[xy.x][xy.y - 1] != c) {
				adjacent.add(new xySet(xy.x, xy.y - 1,
						allCoordinates[xy.x][xy.y - 1]));
			}
		}
	}

	private static void initializeConquered(int x, int y) {
		Color c = allCoordinates[0][0];

		if (!(x < numberOfRows))
			return;
		if (!(y < numberOfRows))
			return;
		if (x < 0)
			return;
		if (y < 0)
			return;

		if (allCoordinates[x][y] == c && isInList(x, y, conquered) == false) {
			conquered.add(new xySet(x, y, c));

			initializeConquered(x + 1, y);
			initializeConquered(x, y + 1);
			initializeConquered(x - 1, y);
			initializeConquered(x, y - 1);
		} else {

		}
	}

	private static boolean isInList(int x, int y, ArrayList<xySet> aList) {
		for (xySet a : aList) {
			if (x == a.x && y == a.y)
				return true;
		}
		return false;
	}

	private static void youLose() {
		trysLeftLabel.setText("You Lose!");
	}

	private static void youWin() {
		trysLeftLabel.setText("You Win!");
	}

	private static boolean won() {
		if (adjacent.size() == 0) {
			return true;
		} else
			return false;
	}

	private static boolean isInBounds(int x, int y) {
		if (!(x < numberOfRows))
			return false;
		if (!(y < numberOfRows))
			return false;
		if (x < 0)
			return false;
		if (y < 0)
			return false;

		return true;
	}

	private static void initialize() {
		trysLeft = (3 * numberOfRows + 6) / (8 - colors);
		frame = new JFrame("Color Matcher!");
		frame.setSize(1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FlowLayout fL = new FlowLayout();
		frame.setLayout(fL);
		frame.setVisible(true);

		// set up display panel
		displayPanel = new JPanel();
		Dimension dimension2 = new Dimension();
		dimension2.setSize(600, 600);
		displayPanel.setPreferredSize(dimension2);
		displayPanel.setBackground(Color.WHITE);
		GridBagLayout gLayout = new GridBagLayout();
		displayPanel.setLayout(gLayout);
		frame.add(displayPanel);
		populateGrid();
		initializeConquered(0, 0);
		updateAdjacentList();

		// set up button panel
		buttonPanel = new JPanel();
		Dimension dimension1 = new Dimension();
		dimension1.setSize(175, 350);
		buttonPanel.setPreferredSize(dimension1);
		FlowLayout fL1 = new FlowLayout();
		buttonPanel.setLayout(fL1);
		frame.add(buttonPanel);

		JButton reset = new JButton("New Game");
		buttonPanel.add(reset);
		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				initialize();
			}
		});
		// set up labels and text areas for input
		trysLeftLabel = new JLabel();
		trysLeftLabel.setText("Tries Left: " + Integer.toString(trysLeft));
		buttonPanel.add(trysLeftLabel);

		numberOfRowsLabel = new JLabel();
		numberOfRowsLabel.setText("Number of Rows");
		buttonPanel.add(numberOfRowsLabel);

		numberOfRowsField = new JTextField();
		numberOfRowsField.setText(Integer.toString(numberOfRows));
		buttonPanel.add(numberOfRowsField);

		numberOfColorsLabel = new JLabel();
		numberOfColorsLabel.setText("Number of Colors");
		buttonPanel.add(numberOfColorsLabel);

		numberOfColorsField = new JTextField();
		numberOfColorsField.setText(Integer.toString(colors));
		buttonPanel.add(numberOfColorsField);

		// set up button to enter changes in row number and color number
		JButton setValues = new JButton("Set Rows and Colors");
		buttonPanel.add(setValues);
		setValues.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int temp = Integer.valueOf(numberOfColorsField.getText());
				int temp1 = Integer.valueOf(numberOfRowsField.getText());
				if ((temp > 6 || temp < 3) && temp1 < 1) {
				} else {
					ColorMatcher.colors = temp;
					ColorMatcher.numberOfRows = temp1;
					initialize();
				}
			}
		});

		JButton green = new JButton();
		green.setBackground(Color.GREEN);
		Dimension dimension = new Dimension();
		dimension.setSize(65, 50);
		green.setPreferredSize(dimension);
		buttonPanel.add(green);
		green.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isAdjacent(Color.GREEN)) {
					displayPanel.remove(displayPanel);
					conquered.clear();
					conquer(0, 0, Color.GREEN, allCoordinates[0][0]);
					displayPanel.revalidate();
					// printAdjList();
					updateAdjacentList();
					// printAdjList();

					trysLeft--;
					if (won()) {
						youWin();
					} else if (trysLeft <= 0 && !won()) {
						youLose();
					} else
						trysLeftLabel.setText("Tries Left: "
								+ Integer.toString(trysLeft));
				}
			}
		});

		JButton yellow = new JButton();
		yellow.setBackground(Color.YELLOW);
		yellow.setPreferredSize(dimension);
		buttonPanel.add(yellow);
		yellow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isAdjacent(Color.YELLOW)) {
					displayPanel.remove(displayPanel);
					conquered.clear();
					conquer(0, 0, Color.YELLOW, allCoordinates[0][0]);
					displayPanel.revalidate();
					// printAdjList();
					updateAdjacentList();
					// printAdjList();
					trysLeft--;
					if (won()) {
						youWin();
					} else if (trysLeft <= 0 && !won()) {
						youLose();
					} else
						trysLeftLabel.setText("Tries Left: "
								+ Integer.toString(trysLeft));
				}
			}
		});

		JButton red = new JButton();
		red.setBackground(Color.RED);
		red.setPreferredSize(dimension);
		buttonPanel.add(red);
		red.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isAdjacent(Color.RED)) {
					displayPanel.remove(displayPanel);
					conquered.clear();
					conquer(0, 0, Color.RED, allCoordinates[0][0]);
					displayPanel.revalidate();
					// printAdjList();
					updateAdjacentList();
					// printAdjList();
					trysLeft--;
					if (won()) {
						youWin();
					} else if (trysLeft <= 0 && !won()) {
						youLose();
					} else
						trysLeftLabel.setText("Tries Left: "
								+ Integer.toString(trysLeft));
				}
			}
		});

		JButton blue = new JButton();
		blue.setBackground(Color.BLUE);
		blue.setPreferredSize(dimension);
		buttonPanel.add(blue);
		blue.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isAdjacent(Color.BLUE)) {
					displayPanel.remove(displayPanel);
					conquered.clear();
					conquer(0, 0, Color.BLUE, allCoordinates[0][0]);
					displayPanel.revalidate();
					// printAdjList();
					updateAdjacentList();
					// printAdjList();
					trysLeft--;
					if (won()) {
						youWin();
					} else if (trysLeft <= 0 && !won()) {
						youLose();
					} else
						trysLeftLabel.setText("Tries Left: "
								+ Integer.toString(trysLeft));
				}
			}
		});

		JButton black = new JButton();
		black.setBackground(Color.BLACK);
		black.setPreferredSize(dimension);
		buttonPanel.add(black);
		black.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isAdjacent(Color.BLACK)) {
					displayPanel.remove(displayPanel);
					conquered.clear();
					conquer(0, 0, Color.BLACK, allCoordinates[0][0]);
					displayPanel.revalidate();
					// printAdjList();
					updateAdjacentList();
					// printAdjList();
					trysLeft--;
					if (won()) {
						youWin();
					} else if (trysLeft <= 0 && !won()) {
						youLose();
					} else
						trysLeftLabel.setText("Tries Left: "
								+ Integer.toString(trysLeft));
				}
			}
		});

		JButton white = new JButton("");
		white.setBackground(Color.WHITE);
		white.setPreferredSize(dimension);
		buttonPanel.add(white);
		white.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (isAdjacent(Color.WHITE)) {
					displayPanel.remove(displayPanel);
					conquered.clear();
					conquer(0, 0, Color.WHITE, allCoordinates[0][0]);
					displayPanel.revalidate();
					// printAdjList();
					updateAdjacentList();
					// printAdjList();
					trysLeft--;
					if (won()) {
						youWin();
					} else if (trysLeft <= 0 && !won()) {
						youLose();
					} else
						trysLeftLabel.setText("Tries Left: "
								+ Integer.toString(trysLeft));
				}
			}
		});

		frame.pack();
	}

	public static void printAdjList() {
		System.out.println("Adjacent List");
		for (xySet xy : adjacent) {
			System.out.printf("%s %s " + xy.c, xy.x, xy.y);
			System.out.println();
		}

		System.out.println("Conquered List");
		for (xySet xy : conquered) {
			System.out.printf("%s %s " + xy.c, xy.x, xy.y);
			System.out.println();
		}
	}
}

class xySet {
	int x;
	int y;
	Color c;

	xySet(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
}