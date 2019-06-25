package view.courseManagement;

import javax.swing.JPanel;

import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ClassManagerTuitionPanel extends JPanel 
{
	private JTextField textFieldId;
	private JTextField textFieldName;

	JButton btnSearch;
	JButton btnPrint;
	
	DefaultTableModel billModel;
	JTable billTable;
	
	/**
	 * Create the panel.
	 */
	
	public ClassManagerTuitionPanel() 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("수강료 청구서 발급");
		lblNewLabel.setBounds(290, 40, 124, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("학번 : ");
		lblNewLabel_1.setBounds(129, 98, 45, 15);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("이름 : ");
		label.setBounds(290, 98, 45, 15);
		add(label);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(171, 95, 100, 21);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(335, 95, 100, 21);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		btnSearch = new JButton("조회");
		btnSearch.setBounds(469, 94, 97, 23);
		add(btnSearch);
		
		btnPrint = new JButton("발급");
		btnPrint.setBounds(301, 473, 97, 23);
		add(btnPrint);
		
		billModel = new DefaultTableModel()
		// 마우스 클릭으로 수정 불가
		{ public boolean isCellEditable(int i, int c) { return false; } };
		billTable = new JTable(billModel);		
		
		JScrollPane scrollPane = new JScrollPane(billTable);
		scrollPane.setBounds(129, 145, 437, 301);
		add(scrollPane);

	}
	
	public void addListener(MouseListener listener)
	{
		btnSearch.addMouseListener(listener);
		btnPrint.addMouseListener(listener);
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnPrint() {
		return btnPrint;
	}

	public DefaultTableModel getBillModel() {
		return billModel;
	}

	public JTable getBillTable() {
		return billTable;
	}
	
	
}
