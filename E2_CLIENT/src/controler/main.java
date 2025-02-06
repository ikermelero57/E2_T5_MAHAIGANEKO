package controler;

import resources.Views;
import view.BesteOrdutegiaView;
import view.BilerakView;
import view.LoginView;
import view.MainMenuView;
import view.OrdutegiaView;

public class Main {

	public static void main(String[] args) {
		
		
		
		try {
			Views.loginView = new LoginView();
			Views.loginView.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        try {
        	Views.besteOrdutegiaView = new BesteOrdutegiaView();
        	Views.besteOrdutegiaView.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		try {
			Views.ordutegiaView = new OrdutegiaView();
			Views.ordutegiaView.setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Views.mainMenuView = new MainMenuView();
			Views.mainMenuView.setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		try {
			Views.bilerakView = new BilerakView();
			Views.bilerakView.setVisible(false);
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
