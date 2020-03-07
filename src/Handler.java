import java.awt.Graphics;
import java.util.LinkedList;

//handles the updating all the objects
public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>(); //stores the objects
	
	//to ensure key inputs work properly:
	private boolean up = false, down = false, right = false, left = false;
	
	//getters and setters:
	
	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void tick() {
		for(int i = 0; i < object.size(); i++) { //runs through all our objects
			GameObject tempObject = object.get(i); //gets the object
			
			tempObject.tick(); 
			
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) { //runs through all our objects
			GameObject tempObject = object.get(i); //gets the object
			
			tempObject.render(g); 
	}
}
	
	//be able to add or remove objects from the list:
	public void addObject(GameObject tempObject) {
		object.add(tempObject);
	}
	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}
}
