package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import model.ClassManager;
import model.PersonnelManager;
import model.Professor;
import model.Student;
import model.User;
import view.LoginPanel;

public class LoginController extends Controller
{
	User user;
	
	LoginPanel view;
	Container contentPane;
	CardLayout cards;
	
	MainController mainController;

	public LoginController(User user, LoginPanel loginPanel, MainController controller)
	{
		mainController = controller;
		this.user = user;
		view = loginPanel;
		

		contentPane = mainController.getMainContentPane();
		cards = mainController.getMainCards();
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new MListener(), new KListener());					
	}
	
	// 로그인 버튼을 클릭하거나 엔터 입력시 실행할 메소드
	public void loginClickOrEnter()
	{			
		String id;
		char[] pw; 
		
		
		id = view.getTextFieldId().getText();
		pw = view.getPasswordFieldPw().getPassword();

		if (user.login(id, pw)) 
		{
			// 로그인에 성공
			
			// 권한에 따라 User 객체를 변환
			switch(user.getAuthority())
			{
				case "S" :
					user = new Student(user);					
					break;
				case "P" :
					user = new Professor(user);					
					break;
				case "H" :
					user = new PersonnelManager(user);					
					break;
				case "G" :
					user = new ClassManager(user);					
					break;
				default :
					break;
			}
			// 로그인 사용자 정보 컨드롤러에 등록
			mainController.setUser(user);
			
			// 로그인 사용자 정보로 top 패널 갱신
			mainController.getTopController().refresh();
			mainController.getTopPanel().setVisible(true);			
			
			// 패널 초기화			
			view.getTextFieldId().setText("");
			view.getPasswordFieldPw().setText("");		
			
			// 다음 패널로 전환
			cards.show(contentPane, "main menu");			
		} 
		else 
		{
			// 로그인 실패
			JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.\n아이디와 비밀번호를 확인해주세요.", "Login Error",
					JOptionPane.ERROR_MESSAGE);
			view.getTextFieldId().setText("");
			view.getPasswordFieldPw().setText("");
			view.getBtnLogin().transferFocus();
		}
	}
	
	public LoginPanel getView()
	{
		return view;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 로그인 버튼 클릭 시
	class MListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{
			loginClickOrEnter();
		}				
	}
	
	// 로그인 버튼 엔터 키 입력 시
	class KListener extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e) 
		{
			if (e.getKeyCode() == KeyEvent.VK_ENTER) 
			{				
				loginClickOrEnter();					
			}			
		}
	}
}
	
