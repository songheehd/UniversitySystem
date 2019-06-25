package view.personnelManagement;

import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class SearchPanel extends JPanel 
{
	JTextField textFieldName;
	JButton btnSearch;
	JButton btnEdit;
	JButton btnDelete;
	JButton btnAdd;
	private JTextField textFieldNumber;
	
	DefaultTableModel searchStudentModel;
	JTable searchStudentTable;
	
	String[] header;
	String[][] contents;
	
	/**
	 * Create the panel.
	 */
	
	public SearchPanel() 
	{

		setLayout(null);

		JLabel label = new JLabel("이름");
		label.setBounds(267, 46, 44, 18);
		add(label);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(429, 42, 105, 27);
		add(btnSearch);
		
		btnAdd = new JButton("추가");
		btnAdd.setBounds(309, 388, 68, 27);
		add(btnAdd);
		
		btnEdit = new JButton("수정");
		btnEdit.setBounds(391, 388, 68, 27);
		add(btnEdit);

		btnDelete = new JButton("삭제");
		btnDelete.setBounds(473, 388, 68, 27);
		add(btnDelete);

		textFieldName = new JTextField();
		textFieldName.setBounds(302, 43, 105, 24);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel label_1 = new JLabel("학번/교수번호");
		label_1.setBounds(31, 46, 105, 18);
		add(label_1);
		
		textFieldNumber = new JTextField();
		textFieldNumber.setColumns(10);
		textFieldNumber.setBounds(130, 43, 129, 24);
		add(textFieldNumber);
		
		searchStudentModel = new DefaultTableModel(contents, header);
		searchStudentTable = new JTable(searchStudentModel);
		
		
		JScrollPane scrollPane = new JScrollPane(searchStudentTable);
		scrollPane.setBounds(38, 86, 492, 263);
		add(scrollPane);
		
	}
	
	// 이벤트 리스너 등록
	public void addListener(MouseListener listener)
	{
		btnAdd.addMouseListener(listener);
		btnSearch.addMouseListener(listener);
		btnEdit.addMouseListener(listener);
		btnDelete.addMouseListener(listener);
	}

	public JTextField getTextFieldSearch() {
		return textFieldName;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JTextField getTextFieldNumber() {
		return textFieldNumber;
	}

	public void setTextFieldNumber(JTextField textFieldNumber) {
		this.textFieldNumber = textFieldNumber;
	}

	public DefaultTableModel getSearchStudentModel() {
		return searchStudentModel;
	}

	public void setSearchStudentModel(DefaultTableModel searchStudentModel) {
		this.searchStudentModel = searchStudentModel;
	}

	public JTable getSearchStudentTable() {
		return searchStudentTable;
	}

	public void setSearchStudentTable(JTable searchStudentTable) {
		this.searchStudentTable = searchStudentTable;
	}
}
