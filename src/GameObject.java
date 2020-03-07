import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject { //this class is a skeleton for all objects, something that they all must have

	protected int x,y;
	protected float velX = 0, velY = 0; //the speed at which the enemies move
	protected ID id; //from enum class

	
	//constructor:
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	//every object needs to update their positioning:
	public abstract void tick();
	//every object needs to be seen:
	public abstract void render(Graphics g);
	

	//every objects need to have dimenions
	public abstract Rectangle getBounds();

	//getters and setters
	
	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
	
}
