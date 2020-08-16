import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ProductsTypes.GenericFoodType;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class AddNewFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametext;
	private JTextField destext;
	static AddNewFrame frame;
	private JTextField qu;
	private JTextField bc;
	private JTextField Sc;
	private JTextField tx;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { frame = new AddNewFrame(args);
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
	public AddNewFrame(String[] ar) {
		setType(Type.UTILITY);
		setTitle("Add New Element");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel TopPanel = new JPanel();
		contentPane.add(TopPanel, BorderLayout.NORTH);
		
		JPanel LPanel = new JPanel();
		contentPane.add(LPanel, BorderLayout.WEST);
		
		JPanel RPanel = new JPanel();
		contentPane.add(RPanel, BorderLayout.EAST);
		
		JPanel BotPanel = new JPanel();
		contentPane.add(BotPanel, BorderLayout.SOUTH);
		
		JPanel CenterP = new JPanel();
		contentPane.add(CenterP, BorderLayout.CENTER);
		CenterP.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 110, 38);
		CenterP.add(lblNewLabel);
		
		nametext = new JTextField();
		nametext.setBounds(10, 49, 204, 38);
		CenterP.add(nametext);
		nametext.setColumns(10);
		
		JLabel DesText = new JLabel("Description");
		DesText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DesText.setBounds(10, 84, 110, 38);
		CenterP.add(DesText);
		
		destext = new JTextField();
		destext.setBackground(new Color(255, 255, 255));
		destext.setColumns(10);
		destext.setBounds(10, 118, 374, 121);
		CenterP.add(destext);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       frame.dispose();}});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(353, 363, 193, 53);
		CenterP.add(btnCancel);
		
		Choice ManCat = new Choice();
		ManCat.setFont(new Font("Blackadder ITC", Font.PLAIN, 12));
		ManCat.setBounds(451, 49, 176, 53);
		String[] txt1 = {"Frezer","Dry","Cocked","Cooling","Generic"};
		for(int x=0;x<5;x++) {ManCat.add(txt1[x]);}
		CenterP.add(ManCat);
		
		Choice SubCat = new Choice();
		SubCat.setFont(new Font("Blackadder ITC", Font.PLAIN, 12));
		SubCat.setBounds(451, 84, 176, 22);
		String[] txt = {"Meat","Dairy","Snack","Fried","Other"};
		for(int x=0;x<5;x++) {SubCat.add(txt[x]);}
		CenterP.add(SubCat);
		
		JRadioButton IsSolidB = new JRadioButton("Is Solid");
		IsSolidB.setSelected(true);
		IsSolidB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubCat.removeAll();
				if(IsSolidB.isSelected()) {
					String[] txt = {"Meat","Dairy","Snack","Fried","Other"};
					for(int x=0;x<5;x++) {SubCat.add(txt[x]);}
				}			
				else {
					String[] txt = {"Milk","Sauce","Alcohol","Juice","EnergyD","Other"};
					for(int x=0;x<6;x++) {SubCat.add(txt[x]);}
				}	
			}});
		IsSolidB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IsSolidB.setBounds(483, 11, 110, 38);
		CenterP.add(IsSolidB);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(394, 118, 60, 22);
		CenterP.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Buy Cost");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(394, 143, 60, 27);
		CenterP.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sell Cost");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(394, 171, 60, 22);
		CenterP.add(lblNewLabel_3);
		
		qu = new JTextField();
		qu.setBounds(464, 118, 86, 20);
		CenterP.add(qu);
		qu.setColumns(10);
		
		bc = new JTextField();
		bc.setBounds(464, 143, 86, 20);
		CenterP.add(bc);
		bc.setColumns(10);
		
		Sc = new JTextField();
		Sc.setBounds(464, 168, 86, 20);
		CenterP.add(Sc);
		Sc.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("      Tax");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(394, 201, 60, 22);
		CenterP.add(lblNewLabel_3_1);
		
		tx = new JTextField();
		tx.setColumns(10);
		tx.setBounds(464, 198, 86, 20);
		CenterP.add(tx);
		JButton Final = new JButton("Create");
		Final.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam,des; nam=nametext.getText(); des=destext.getText();
				
			   int mc,sc,price,iva,cost,quan;
			   mc=ManCat.getSelectedIndex();sc=SubCat.getSelectedIndex();
			   try{cost=Integer.parseInt(bc.getText());}
			   catch(NumberFormatException ex){cost=0;}
			   try{iva=Integer.parseInt(tx.getText());}
			   catch(NumberFormatException ex){iva=0;}			   
			   try{quan=Integer.parseInt(qu.getText());}
			   catch(NumberFormatException ex){quan=0;}
			   try{price=Integer.parseInt(Sc.getText());}
			   catch(NumberFormatException ex){price=0;}			   
			   boolean solid=IsSolidB.isSelected();
				Main.AddProduct(new GenericFoodType(mc,sc,quan,0, price, iva, cost,nam, des, solid));
				frame.dispose();
			   }});
		
		Final.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Final.setBounds(110, 363, 193, 53);
		CenterP.add(Final);		
	}
}
