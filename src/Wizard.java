import java.awt.Graphics;
import java.awt.Rectangle;

public class Wizard extends GameObject{

	public Wizard(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
