import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
	private boolean isRunning = false;
	private Thread thread; //initialize a thread
	private Handler handler; //initilaze a handler
	
	
	public Game() { //constructor
		new Window(1000,563, "Wizard Game", this); //create an instance of the window
		start(); //calls start method
		
		handler = new Handler();

	}
	
	
	private void start() { //starts thread
		isRunning = true;
		thread = new Thread(this); //create new thread object
		thread.start(); //starts thread
	}
	
	private void stop() { //stops thread
		isRunning = false;
		try {
			thread.join(); //surround by try & catch because it could fail
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() { //starting a thread calls this run method
		//standard game loop:
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
		
	}
	
	public void tick() { //updates everything in the game (gets updates 60 times a second)
		handler.tick();
	}
	
	public void render() { //renders everything in game (gets updated a couple thousand times a second)
		BufferStrategy bs = this.getBufferStrategy(); //when initially created equals null, buffer strategy is used for drawing graphics
		if(bs == null) { //check that if it is null, create it with 3 arguments
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		///////////////////////////
		
		//this is where we can draw things to our game
		
		handler.render(g);
		
		///////////////////////
		
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String args[]) { //main method
		new Game();
	}
}
