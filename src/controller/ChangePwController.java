package controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.User;
import view.ChangePwPanel;

public class ChangePwController extends Controller 
{
	MainController mainController;	
	
	User user;
	
	ChangePwPanel view;
	Container contentPane;
	CardLayout cards;
	
	public ChangePwController(User user, ChangePwPanel changePwPanel, MainController controller) 
	{	
		mainController = controller;
		
		this.user = user;
				
		// 메인 컨트롤러에서 카트레이아웃과 패널을 가져옴
		contentPane = mainController.getMainContentPane();
		cards = mainController.getMainCards();
		
		// 뷰를 생성
		view = new ChangePwPanel();		
		
		// 내부 클래스를 가져와 뷰에 이벤트 리스너 등록
		view.addListener(new MListener());	
	}
	
	public ChangePwPanel getView()
	{
		return view;
	}
	
	
	public void setUser(User user) 
	{
		this.user = user;
	}
	
	/***** 이벤트 리스너용 내부 클래스  *****/
	
	// 버튼 클릭 이벤트 리스너
	class MListener extends MouseAdapter
	{
		@Override
		public void mouseClicked(MouseEvent e) 
		{	
			// 변경하기 버튼 클릭 시
			String result = user.changePw(
					view.getPasswordFieldNow().getPassword(),
					view.getPasswordFieldNew().getPassword(),
					view.getPasswordFieldNewConfirm().getPassword());
			
			// 실행 결과에 따라 메세지 출력
			switch(result) 
			{
				// 변경 성공 시
				case "sucess" :
					JOptionPane.showMessageDialog(null, "비밀번호 변경 완료", "UIS",
							JOptionPane.INFORMATION_MESSAGE);
					// 패스워드 필드 초기화
					view.getPasswordFieldNow().setText("");
					view.getPasswordFieldNew().setText("");
					view.getPasswordFieldNewConfirm().setText("");
					break;
					
				// 현재 비밀번호 입력 틀림
				case "pw error" :
					JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다!", "UIS",
							JOptionPane.ERROR_MESSAGE);
					// 패스워드 필드 초기화
					view.getPasswordFieldNow().setText("");
					break;
					
				// 새 비밀번호 확인 입력 틀림
				case "confirm error" :
					JOptionPane.showMessageDialog(null, "새 비밀번호 확인 입력이 틀립니다!", "UIS",
							JOptionPane.ERROR_MESSAGE);
					// 패스워드 필드 초기화
					view.getPasswordFieldNew().setText("");
					view.getPasswordFieldNewConfirm().setText("");
					break;
					
				// 데이터베이스 업데이트 에러
				case "update error" :
					JOptionPane.showMessageDialog(null, "데이터베이스 업데이트에 실패했습니다!", "UIS",
							JOptionPane.ERROR_MESSAGE);
					break;
				default : 
					JOptionPane.showMessageDialog(null, "알 수 없는 문제로 실패했습니다!", "UIS",
							JOptionPane.ERROR_MESSAGE);
					break;					
			}
		}
	}
}
