package at.fhsalzburg.its.nos.automobilefactory;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class PriceList extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private BMWOne one, one1;
	private BMWFour four;
	private BMWSeven seven;

	public PriceList(BMWOne one, BMWOne one1, BMWFour four, BMWSeven seven) {
		this.one = one;
		this.one1 = one1;
		this.four = four;
		this.seven = seven;
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font fontHeader = new Font("Times New Roman", Font.BOLD, 18);
		Font fontContent = new Font("Times New Roman", Font.PLAIN, 17);
		
		String[][] content = { {one.getBMW1(), one.getID(), one.getPS(), one.getColor(), one.getExtras(), 
								one.getExtras1(), one.getTires(), String.valueOf(one.getPrice()) + ",--"},
							   {four.getBMW4(), four.getID(), four.getPS(), four.getColor(), four.getExtras(), 
								four.getExtras1(), four.getTires(), String.valueOf(four.getPrice()) + ",--"},
							   {seven.getBMW7(), seven.getID(), seven.getPS(), seven.getColor(), seven.getExtras(), 
								seven.getExtras1(), seven.getTires(), String.valueOf(seven.getPrice()) + ",--"},
							   {one1.getBMW1(), one1.getID(), one1.getPS(), one1.getColor(), one1.getExtras(), 
								one1.getExtras1(), one1.getTires(), String.valueOf(one1.getPrice()) + ",--"} };
		
		String[] title = {"Typ", "Fahrgestell", "PS", "Farbe", "Extra 1", "Extra 2", "Bereifung", "Preis/Euro"};
		JTable table = new JTable(content, title);;
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		
		final int INDEX_COLUMN1 = 0, INDEX_COLUMN2 = 1, INDEX_COLUMN3 = 2, INDEX_COLUMN4 = 3, INDEX_COLUMN5 = 4;
		final int INDEX_COLUMN6 = 5, INDEX_COLUMN7 = 6, INDEX_COLUMN8 = 7;
		
		TableColumn col1 = table.getColumnModel().getColumn(INDEX_COLUMN1);		//Typ
		col1.setPreferredWidth(100);
		TableColumn col2 = table.getColumnModel().getColumn(INDEX_COLUMN2);		//Fahrgestell
		col2.setPreferredWidth(220);
		TableColumn col3 = table.getColumnModel().getColumn(INDEX_COLUMN3);		//PS
		col3.setPreferredWidth(100);
		TableColumn col4 = table.getColumnModel().getColumn(INDEX_COLUMN4);		//Farbe
		col4.setPreferredWidth(100);
		TableColumn col5 = table.getColumnModel().getColumn(INDEX_COLUMN5);		//Extra
		col5.setPreferredWidth(230);
		TableColumn col6 = table.getColumnModel().getColumn(INDEX_COLUMN6);		//Extra1
		col6.setPreferredWidth(230);
		TableColumn col7 = table.getColumnModel().getColumn(INDEX_COLUMN7);		//Reifen
		col7.setPreferredWidth(150);
		TableColumn col8 = table.getColumnModel().getColumn(INDEX_COLUMN8);		//Preis
		col8.setPreferredWidth(120);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(fontHeader);
		header.setBackground(new Color(255,9,165));
		table.setFont(fontContent);
		table.setRowHeight(30);
		table.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));
		header.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
		JLabel renderer = ((JLabel)table.getDefaultRenderer(Object.class));
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>(4);
		sortKeys.add(new RowSorter.SortKey(7, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);

		setTitle("Preisliste");
		add(new JScrollPane(table));
		setSize(1260, 280);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public BMWOne getOne() {
		return one;
	}

	public void setOne(BMWOne one) {
		this.one = one;
	}

	public BMWOne getOne1() {
		return one1;
	}

	public void setOne1(BMWOne one1) {
		this.one1 = one1;
	}

	public BMWFour getFour() {
		return four;
	}

	public void setFour(BMWFour four) {
		this.four = four;
	}

	public BMWSeven getSeven() {
		return seven;
	}

	public void setSeven(BMWSeven seven) {
		this.seven = seven;
	}
}
