
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.OSMTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.WaypointPainter;

//Martin Steiger wrote the code to create the actual map (adding TileFactoryInfo)
//and getting it to display on a JFrame
//Source: https://github.com/msteiger/jxmapviewer2

public class Map extends JFrame implements ActionListener {

	public static University[] universityArray = new University[17];
	FontClass fonts = new FontClass();
	MenuBar menuBar = new MenuBar();
	
	JLabel mapTitle = new JLabel("The Map to Your Future!");
	// Make a new map
	public static JXMapViewer mapViewer = new JXMapViewer();
	JPanel filterPanel = new JPanel();
	JLabel filterTitle = new JLabel("Filter");
	JButton allUniButton = new JButton("All Universities");
	public static Set<SwingWaypoint> waypoints = new HashSet<SwingWaypoint>();

	JButton savedUniButton = new JButton("Saved Universities");
	JButton within100kmButton = new JButton("Within 100 km");
	JButton selectUniButton = new JButton("Select University");
	Color buttonColor = new Color(57, 90, 154);

	JPanel uniPanel = new JPanel();
	JLabel uniNameLabel = new JLabel();
	JLabel addressLabel = new JLabel("Address: ");
	JLabel phoneLabel = new JLabel("Phone Number: ");
	JButton learnMore = new JButton("Learn More");

	public Map() {

		// Create a TileFactoryInfo for OpenStreetMap

		TileFactoryInfo info = new OSMTileFactoryInfo();
		// info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
		// info = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.HYBRID);
		// info = new
		// VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.SATELLITE);
		DefaultTileFactory tileFactory = new DefaultTileFactory(info);

		mapViewer.setTileFactory(tileFactory);

		// Use 8 threads in parallel to load the tiles
		tileFactory.setThreadPoolSize(8);

		// Set the focus
		GeoPosition toronto = new GeoPosition(43.637909, -78.8761158);
		mapViewer.setZoom(12);
		mapViewer.setAddressLocation(toronto);

		// Saindhavi: Allow the user to be able to drag around the map
		MouseInputListener mm = new PanMouseInputListener(mapViewer);
		mapViewer.addMouseListener(mm);
		mapViewer.addMouseMotionListener(mm);
		mapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(mapViewer));

		// Saindhavi: Set the bounds for the map
		mapViewer.setBounds(25, 160, 950, 500);

		// Display the viewer in a JFrame
		setTitle("The Map to Your Future!");
		setLayout(null);
		getContentPane().add(mapViewer);
		getContentPane().setBackground(Color.WHITE);
		setSize(1280, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Everything after this is Saindhavi's work

		// Creating the title of the map page
		mapTitle.setFont(FontClass.semibold50);
		mapTitle.setBounds(350, 100, 1000, 50);
		add(mapTitle);
		
		menuBar.setBounds(0, 0, 1280, 100);
		menuBar.setVisible(true);
		add(menuBar);
		//menuBar.setVisible(true);

		// Creating a filter panel where the filter buttons will go
		filterPanel.setBounds(975, 160, 280, 500);
		filterPanel.setLayout(null);
		filterPanel.setBackground(new Color(243, 243, 245));
		add(filterPanel);

		// Creating the title of the filter section
		filterTitle.setFont(FontClass.medium25);
		filterTitle.setBounds(110, 25, 200, 25);
		filterPanel.add(filterTitle);

		// Creating all the buttons for the filter panel
		allUniButton.setFont(FontClass.medium25);
		allUniButton.setBounds(0, 65, 280, 100);
		allUniButton.setBackground(buttonColor);
		allUniButton.setBorderPainted(false);
		allUniButton.setOpaque(true);
		allUniButton.setForeground(Color.white);
		allUniButton.addActionListener(this);
		filterPanel.add(allUniButton);

		savedUniButton.setFont(FontClass.medium25);
		savedUniButton.setBounds(0, 175, 280, 100);
		savedUniButton.setBackground(buttonColor);
		savedUniButton.setBorderPainted(false);
		savedUniButton.setOpaque(true);
		savedUniButton.setForeground(Color.white);
		savedUniButton.addActionListener(this);
		filterPanel.add(savedUniButton);

		within100kmButton.setFont(FontClass.medium25);
		within100kmButton.setBounds(0, 285, 280, 100);
		within100kmButton.setBackground(buttonColor);
		within100kmButton.setBorderPainted(false);
		within100kmButton.setOpaque(true);
		within100kmButton.setForeground(Color.white);
		within100kmButton.addActionListener(this);
		filterPanel.add(within100kmButton);

		selectUniButton.setFont(FontClass.medium25);
		selectUniButton.setBounds(0, 395, 280, 100);
		selectUniButton.setBackground(buttonColor);
		selectUniButton.setBorderPainted(false);
		selectUniButton.setOpaque(true);
		selectUniButton.setForeground(Color.white);
		selectUniButton.addActionListener(this);
		filterPanel.add(selectUniButton);

		//Create our university objects
		new UniversityInput();
		
		//create waypoints (points) on the map for each university in the university arrat
		for (University university:universityArray) {
			waypoints.add(new SwingWaypoint(university.getName(), university.getCoordinates()));
		}
		// Set the overlay painter
		WaypointPainter<SwingWaypoint> swingWaypointPainter = new SwingWaypointOverlayPainter();
		swingWaypointPainter.setWaypoints(waypoints);
		mapViewer.setOverlayPainter(swingWaypointPainter);

		// Add the JButtons to the map viewer
		for (SwingWaypoint w : waypoints) {
			mapViewer.add(w.getUniLogo());
			// added this so that if the waypoints were set visible to false before
			// they would be set to true when added
			w.getUniLogo().setVisible(true);
		}

	}

	public void setUpPoints() {
		// If the waypoints were set visible to false before
		// they would be set to true
		for (SwingWaypoint w : waypoints) {
			w.getUniLogo().setVisible(true);
		}

	}

	//This method will clear the map of all the points
	public static void clearMap() {
		for (SwingWaypoint w : waypoints) {
			w.removeWaypoint();
		}
	}

	public static void main(String[] args) {
		new Map();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectUniButton) {
			new SelectUniversity();
			SelectUniversity.submitButton.addActionListener(this);
		} else if (e.getSource() == allUniButton) {
			setUpPoints();
		} else if (e.getSource() == within100kmButton) {
			//clearMap();
		}

	}
}