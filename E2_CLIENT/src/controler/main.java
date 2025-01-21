package controler;

import resources.views;
import view.BesteOrdutegiaView;
import view.BilerakView;
import view.LoginView;
import view.MainMenuView;
import view.OrdutegiaView;

public class main {

	public static void main(String[] args) {
		
		
		
		try {
			views.loginView = new LoginView();
			views.loginView.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        try {
        	views.besteOrdutegiaView = new BesteOrdutegiaView();
        	views.besteOrdutegiaView.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		try {
			views.ordutegiaView = new OrdutegiaView();
			views.ordutegiaView.setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			views.mainMenuView = new MainMenuView();
			views.mainMenuView.setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			views.bilerakView = new BilerakView();
			views.bilerakView.setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
