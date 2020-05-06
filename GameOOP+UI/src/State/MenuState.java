package State;

import java.awt.Graphics;

import Main.Handler;
import gfx.Assets;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(100, 300, 400, 80, Assets.button_play, new ClickListener() {		//tao nut play
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.background, 0, 0, null);		//hinh nen Menu
		uiManager.render(g);
	}
}