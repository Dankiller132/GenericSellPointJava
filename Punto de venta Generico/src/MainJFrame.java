import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

@SuppressWarnings({"serial","rawtypes"})
public class MainJFrame extends JFrame {

	public JPanel contentPane;
	public static JList NameList;
	public static JList Quantity;
	public static JList LastBuy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainJFrame frame= new MainJFrame(args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public MainJFrame(String [] args) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Main.SaveList();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		String[] values1;
		if(args.length==0) { values1 = new String[] {"None"};}
		else {values1=Main.NameList(); }
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		NameList = new JList();
		NameList.setToolTipText("");
		NameList.setModel(new AbstractListModel() {
              String[] D=values1;		
			public int getSize() {
				return D.length;
			}
			public Object getElementAt(int index) {
				return D[index];
			}
		});
		String[] values2;
		panel.add(NameList);
		Quantity = new JList();
		if(args.length==0) { values2 = new String[] {"None"};}
		else {values2=Main.QuantityList(); }
		Quantity.setModel(new AbstractListModel() {
			String[] D= values2;
			public int getSize() {
				return D.length;
			}
			public Object getElementAt(int index) {
				return D[index];
			}
		});
		panel.add(Quantity);
		LastBuy = new JList();		
		String[] values3;
		if(args.length==0) { values3 = new String[] {"None"};}
		else {values3=Main.LastSellList(); }
		LastBuy.setModel(new AbstractListModel() {
			String[] D =values3;
			public int getSize() {
				return D.length;
			}
			public Object getElementAt(int index) {
				return D[index];
			}
		});
		panel.add(LastBuy);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setForeground(Color.RED);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		JLabel DescriptionLavel = new JLabel("");
		panel_1.add(DescriptionLavel);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("");
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("");
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("");
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("");
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("");
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("");
		panel_2.add(label_9);
		JButton btnNewButton_2 = new JButton("Delete Item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DescriptionLavel.setText(Main.DeleteProduct(NameList.getSelectedIndex()));
				panel.remove(NameList);
				panel.setBackground(Color.black);
				String[] values;
				if(Main.GFoodList.size()==0) { values = new String[] {"None"};}
				else {values=Main.NameList();; }
				//list = new JList();
				NameList.setModel(new AbstractListModel() {
					String[] D=values;
					public int getSize() {
						return D.length;
					}
					public Object getElementAt(int index) {
						return D[index];
					}
				});
				
				panel.add(NameList);
				panel.setBackground(Color.WHITE);
			}
		});
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("information");
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DescriptionLavel.setText(Main.GetSelected(NameList.getSelectedIndex()));
				
			
			
			}});
		JButton btnNewButton_1 = new JButton("Add new");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNewFrame.main(null);
			}
		});
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

	
}
