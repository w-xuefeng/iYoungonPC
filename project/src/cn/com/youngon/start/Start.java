package cn.com.youngon.start;

import javax.swing.JOptionPane;
import cn.com.youngon.util.NetState;
import cn.com.youngon.view.LoginView;

public class Start {
	public static void main(String[] args) {
		if (!((new NetState()).isConnect(false))) {
			JOptionPane.showMessageDialog(null, "网络连接失败，请检查网络连接后重试.", "网络错误", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			LoginView loginView = new LoginView();
			loginView.launch();
		}
	}
}
