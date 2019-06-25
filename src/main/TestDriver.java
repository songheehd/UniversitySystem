package main;


import java.util.ArrayList;

import controller.ChangePwController;
import controller.ClassManagementController;
import controller.Controller;
import controller.CourseManagementController;
import controller.LoginController;
import controller.MainController;
import controller.MainMenuController;
import controller.PersonnelManagementController;
import controller.TopController;
import controller.classManagement.AddClassController;
import controller.classManagement.ManageClassController;
import controller.classManagement.OpenClassController;
import controller.courseManagement.ClassManagerTuitionController;
import controller.courseManagement.ProfessorAttendanceController;
import controller.courseManagement.ProfessorLectureManagementController;
import controller.courseManagement.StudentCourseApplyController;
import controller.courseManagement.StudentGradeController;
import controller.personnelManagement.AddEditController;
import controller.personnelManagement.SearchController;
import db.DBConnection;
import model.ClassManager;
import model.PersonnelManager;
import model.Professor;
import model.Student;
import model.User;
import view.ChangePwPanel;
import view.ClassManagementPanel;
import view.CourseManagementPanel;
import view.LoginPanel;
import view.MainFrame;
import view.MainMenuPanel;
import view.PersonnelManagementPanel;
import view.TopPanel;
import view.classManagement.AddClassPanel;
import view.classManagement.ManageClassPanel;
import view.classManagement.OpenClassPanel;
import view.courseManagement.ClassManagerTuitionPanel;
import view.courseManagement.ProfessorAttendancePanel;
import view.courseManagement.ProfessorLectureManagementPanel;
import view.courseManagement.StudentCourseApplyPanel;
import view.courseManagement.StudentGradePanel;
import view.personnelManagement.AddEditPanel;
import view.personnelManagement.SearchPanel;


public class TestDriver 
{		
	//Launch the application.
	
	public static void main(String[] args) 
	{		                 
		// DB 연결
        DBConnection.connect();                        
        
        // 모델 생성
        User user = new User();
        Student student = new Student();
        Professor professor = new Professor();
        PersonnelManager pm = new PersonnelManager();
        ClassManager cm = new ClassManager();        
        
        // 탑 패널 뷰, 컨트롤러 생성
        TopPanel topPanel = new TopPanel();        
        TopController topController = new TopController(user, topPanel);
        
        // 뷰 생성        
        MainFrame mainFrame = new MainFrame(topController.getView());
        LoginPanel loginPanel = new LoginPanel();
        MainMenuPanel mainMenuPanel = new MainMenuPanel();
        PersonnelManagementPanel pmPanel = new PersonnelManagementPanel();
        ClassManagementPanel clmPanel = new ClassManagementPanel();
        CourseManagementPanel comPanel = new CourseManagementPanel();
        ChangePwPanel changePwPanel = new ChangePwPanel();
           
        // 학사 관리 뷰 생성
        AddEditPanel addEditPanel = new AddEditPanel();
        SearchPanel searchPanel = new SearchPanel();
        
        // 수업 관리 뷰 생성
        AddClassPanel addClassPanel = new AddClassPanel();
        ManageClassPanel manageClassPanel = new ManageClassPanel();
        OpenClassPanel openClassPanel = new OpenClassPanel();
        
        // 수강 관리 뷰 생성
        StudentCourseApplyPanel studentCourseApplyPanel = new StudentCourseApplyPanel();
        StudentGradePanel studentGradePanel = new StudentGradePanel();
        ProfessorLectureManagementPanel professorLectureManagementPanel = new ProfessorLectureManagementPanel();
        ProfessorAttendancePanel professorAttendancePanel = new ProfessorAttendancePanel();
        ClassManagerTuitionPanel cmTuitionPanel = new ClassManagerTuitionPanel();
        
        // 컨트롤러 생성 ( 뷰에 유저 데이터와 리스너를 등록 )
        ArrayList<Controller> controllers = new ArrayList<Controller>();
        ArrayList<Controller> pmControllers = new ArrayList<Controller>();
        ArrayList<Controller> comControllers = new ArrayList<Controller>();
        ArrayList<Controller> clmControllers = new ArrayList<Controller>();
        
        MainController mainController = new MainController(user, mainFrame, controllers);
        LoginController loginController = new LoginController(user, loginPanel, mainController);
        MainMenuController mainMenuController = new MainMenuController(user, mainMenuPanel, mainController);                             
        PersonnelManagementController pmController = new PersonnelManagementController(pm, pmPanel, pmControllers);
        ClassManagementController clmController = new ClassManagementController(cm, clmPanel, controllers);
        CourseManagementController comController = new CourseManagementController(user, comPanel, comControllers);
        ChangePwController changePwController = new ChangePwController(user, changePwPanel, mainController);
        
        // 학사 관리 컨트롤러 생성
        AddEditController addEditController = new AddEditController(pm, addEditPanel, pmController);
        SearchController searchController = new SearchController(pm, searchPanel, pmController);
        
        // 수업 관리 컨트롤러 생성
        AddClassController addClassController = new AddClassController(cm, addClassPanel, clmController);
        ManageClassController manageClassController = new ManageClassController(cm, manageClassPanel, clmController);
        OpenClassController openClassController = new OpenClassController(cm, openClassPanel, clmController);
                
        // 수강 관리 컨트롤러 생성        
        StudentCourseApplyController studentCourseApplyController = 
        		new StudentCourseApplyController(student, studentCourseApplyPanel, comController);
        StudentGradeController studentGradeController = 
        		new StudentGradeController(student, studentGradePanel, comController);
        ProfessorLectureManagementController professorLectureManagementController = 
        		new ProfessorLectureManagementController(professor, professorLectureManagementPanel, comController);
        ProfessorAttendanceController professorAttendanceController = 
        		new ProfessorAttendanceController(professor, professorAttendancePanel, comController);
        ClassManagerTuitionController classManagerTuitionController = 
        		new ClassManagerTuitionController(cm, cmTuitionPanel, comController);
        
        // 탑 패널 설정
        topController.setContentPane(mainController.getMainContentPane());
        topController.setCards(mainController.getMainCards());
        
        
        
        // 메인컨트롤러의 컨트롤러 리스트에 추가        
        controllers.add(topController);
        controllers.add(loginController);
        controllers.add(mainMenuController);
        controllers.add(pmController);
        controllers.add(clmController);
        controllers.add(comController);
        controllers.add(changePwController);     
        mainController.setControllers(controllers);
        
        
        //학사 관리 컨트롤러의 컨트롤러 리스트에 추가
        pmControllers.add(addEditController);
        pmControllers.add(searchController);
        pmController.setControllers(pmControllers);

        
        
        //강좌 관리 컨트롤러의 컨트롤러 리스트에 추가 
        clmControllers.add(addClassController);
        clmControllers.add(manageClassController);
        clmControllers.add(openClassController);
        clmController.setControllers(clmControllers);
        
       
        
        // 강좌컨트롤러의 컨트롤러 리스트에 추가
        comControllers.add(studentCourseApplyController);
        comControllers.add(studentGradeController);
        comControllers.add(professorLectureManagementController);
        comControllers.add(professorAttendanceController);
        comControllers.add(classManagerTuitionController);
        comController.setControllers(comControllers);
      
        
        // 메인 카드레이아웃에 패널들을 등록
        mainController.addContentPaneView(loginController.getView(), "login");
        mainController.addContentPaneView(mainMenuController.getView(), "main menu");
        mainController.addContentPaneView(pmController.getView(), "personnel management");
        mainController.addContentPaneView(clmController.getView(), "class management");
        mainController.addContentPaneView(comController.getView(), "course management");
        mainController.addContentPaneView(changePwController.getView(), "change password");
        
        // 학사 관리 카드레이아웃에 패널들을 등록
        pmController.addContentPaneView(searchController.getView(), "search");
        pmController.addContentPaneView(addEditController.getView(), "add edit");
        
        // 수업 관리 카드레이아웃에 패널들을 등록
        clmController.addContentPaneView(addClassController.getView(), "add class");
        clmController.addContentPaneView(manageClassController.getView(), "manage class");
        clmController.addContentPaneView(openClassController.getView(), "open class");
        
        // 수강 관리 카드레이아웃에 패널들을 등록
        comController.addContentPaneView(studentCourseApplyController.getView(), "student course apply");
        comController.addContentPaneView(studentGradeController.getView(), "student grade");
        comController.addContentPaneView(professorLectureManagementController.getView(), "professor lecture management");
        comController.addContentPaneView(professorAttendanceController.getView(), "professor attendance");
        comController.addContentPaneView(classManagerTuitionController.getView(), "class manager tuition");
        
        
        
        // GUI 시작
        mainController.start();
		
	
		// DB 연결 종료

	}

}
