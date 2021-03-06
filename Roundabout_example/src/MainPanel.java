import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.RenderingHints;


public class MainPanel extends Applet implements Runnable{
	int carnums;
	//int lane0, lane1, lane2, lane3, lane4, lane5,lane6, lane7;
	int carlength = 20;
	int carheight = 15;
	int speed = 2;
	int gap = 5;
	CarNode cars[] ;
	int roadlength;
	int lane0x,lane0y,lane1x,lane1y,lane2x,lane2y,lane3x,lane3y,lane4x,lane4y,lane5x,lane5y,lane6x,lane6y,lane7x,lane7y;
	int arcRadius;
	int laneWidth;
	Thread panelThread;
	double initTheta ;
	//int flag = 0;
	
	public MainPanel(TrafficSIM sim, int num){
		carnums = num;
		
	}
	@Override
	public void run() {
	
		// TODO Auto-generated method stub
		//initCars();
		while (true) {
		moveCar(cars);
		    try {
			Thread.sleep(50);
		    } catch (InterruptedException e) {
			break;
		    }
		}
	}
	synchronized void moveCar(CarNode[] car){
		for(int k=0; k<carnums;k++){
			
			if(car[k].initlane==0){
				
				if(car[k].sx + car[k].carlength < 405+400){
					if(!car[k].driving_out){
					car[k].sx +=speed;
					}
					else{
						car[k].driving_out = true;
						car[k].flag++;
						car[k].sx -=speed;
						if(car[k].sx<=400){
							car[k].sx=-10;
						}
					}
				}
			
				else{
					if(car[k].dest_lane==1){
						if(car[k].theta<Math.PI/2-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							//car[k].theta=Math.PI/2;
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sy -=speed;
						}
					}
					else if(car[k].dest_lane==3){
						if(car[k].theta<Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sx +=speed;
						}
					}
					else if(car[k].dest_lane==5){
						if(car[k].theta<Math.PI*1.5-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sy +=speed;
						}
					}
					else if(car[k].dest_lane==7){
						if(car[k].theta<Math.PI*2-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sx -=speed;
						}
					}
					
				
				}
				
			}
			else if(car[k].initlane==2){
				
				if(car[k].sy  < 225){
					if(!car[k].driving_out){
					car[k].sy +=speed;
					}
					else{
						car[k].driving_out = true;
						car[k].flag++;
						car[k].sy-=speed;
						
					}
				}
			
				else{
					
					if(car[k].dest_lane==1){
						if(car[k].theta<Math.PI/2+2*Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
						
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sy -=speed;
						}
					}
					else if(car[k].dest_lane==3){
						if(car[k].theta<Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
							
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sx +=speed;
						}
					}
					else if(car[k].dest_lane==5){
						if(car[k].theta<Math.PI*1.5-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
							
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sy +=speed;
						}
					}
					else if(car[k].dest_lane==7){
						if(car[k].theta<Math.PI*2-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
							
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sx -=speed;
							if(car[k].sx<=400){
								car[k].sx=-10;
							}
						}
					}
					
					
				}
				
			}
			else if(car[k].initlane==4){

				
				if(car[k].sx > 1100){
					if(!car[k].driving_out){
					car[k].sx -=speed;
					}
					else{
						car[k].driving_out = true;
						car[k].flag++;
						car[k].sx+=speed;
						
					}
				}
			
				else{
					if(car[k].dest_lane==1){
						if(car[k].theta<Math.PI/2+2*Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							//car[k].theta=Math.PI/2;
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sy -=speed;
						}
					}
					else if(car[k].dest_lane==3){
						if(car[k].theta<Math.PI+2*Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sx +=speed;
						}
					}
					else if(car[k].dest_lane==5){
						if(car[k].theta<Math.PI*1.5-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sy +=speed;
						}
					}
					else if(car[k].dest_lane==7){
						if(car[k].theta<Math.PI*2-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
						}
						else{
							
							car[k].driving_out = true;
							car[k].flag++;
							car[k].sx -=speed;
						}
					}
					
				
				}
				
			
			}
			else if(car[k].initlane==6){

				
				if(car[k].sy  > 525){
					if(!car[k].driving_out){
					car[k].sy -=speed;
					}
					else{
						car[k].driving_out = true;
						car[k].flag++;
						car[k].sy+=speed;
						
					}
				}
			
				else{
					
					if(car[k].dest_lane==1){
						if(car[k].theta<Math.PI/2+2*Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
						
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sy -=speed;
						}
					}
					else if(car[k].dest_lane==3){
						if(car[k].theta<Math.PI+2*Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
							
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sx +=speed;
						}
					}
					else if(car[k].dest_lane==5){
						if(car[k].theta<Math.PI*1.5+2*Math.PI-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
							
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sy +=speed;
						}
					}
					else if(car[k].dest_lane==7){
						if(car[k].theta<Math.PI*2-0.15){
							car[k].theta += (double)6/150;
							car[k].sx = 425+125+400 - 140 * Math.cos(car[k].theta);
							car[k].sy = 250+125 - 140 * Math.sin(car[k].theta);
							
						}
						else{
							
							car[k].driving_out = true;
							
							car[k].flag++;
							car[k].sx -=speed;
							if(car[k].sx<=400){
								car[k].sx=-10;
							}
						}
					}
					
					
				}
				
			
			}
		}

		
		
		repaint();
		
		
	}
	public void init(){
	
	}
	public void start(){
		
		cars = new CarNode[50];
		initRoads();
		initCars();
		panelThread = new Thread(this);
		panelThread.start();
		
		
//		
	}
	public void initRoads(){
		roadlength = 400;
		laneWidth = 25;
		arcRadius =125;
		lane0x = 0;
		lane0y = 350;
		lane1x = 525;
		lane1y = 225;
		initTheta = 25/125;
		
		
	}
	private void initCars() {
		int temp_startlane, temp_destlane;
		int lane0 = 0,lane2=0,lane4=0,lane6=0;
		
		for(int i=0; i<carnums; i++){
		
			CarNode n = new CarNode();
		int x=0,x1 = 0;
		int start_lanes[] = {0,2,4,6};
		int dest_lanes[] = {1,3,5,7};
		java.util.Random r=new java.util.Random(); 
		x=r.nextInt(start_lanes.length);
		x1=r.nextInt(dest_lanes.length);
		temp_startlane = start_lanes[x];
		temp_destlane = dest_lanes[x1];
		System.out.println("dsa"+temp_destlane);

		if(temp_startlane==0){
			
 			n.sx = 2+400 - lane0*(gap+carlength);
 			n.sy = 355;
 			n.carlength = carlength;
 			n.carheight = carheight;
 			n.initlane = temp_startlane;
 			n.flag = 0;
 			n.theta = initTheta;
 			n.driving_out = false;
 			n.dest_lane = temp_destlane;
 			lane0++;
 			cars[i] = n;
		}
		else if(temp_startlane==2){
			n.sx = 970;
			n.sy = 2 - lane2*(gap+carlength);
			n.carlength = carlength;
 			n.carheight = carheight;
 			n.initlane = temp_startlane;
 			n.flag = 0;
 			n.driving_out = false;
 			n.dest_lane = temp_destlane;
 			n.theta = Math.PI/2;
 			lane2++;
 			cars[i] = n;
		}
		else if(temp_startlane==4){
			n.sx = 1078+400+lane4*(gap+carlength);
			n.sy = 380;
			n.carlength = carlength;
 			n.carheight = carheight;
 			n.initlane = temp_startlane;
 			n.flag = 0;
 			n.driving_out = false;
 			n.dest_lane = temp_destlane;
 			n.theta = Math.PI;
 			lane4++;
 			cars[i] = n;
		}
		else if(temp_startlane==6){
			//930, 900+lane6*(gap+carlength)

			n.sx = 930;
			n.sy = 900+lane6*(gap+carlength);
			n.carlength = carlength;
 			n.carheight = carheight;
 			n.initlane = temp_startlane;
 			n.flag = 0;
 			n.driving_out = false;
 			n.dest_lane = temp_destlane;
 			n.theta = Math.PI*3/2;
 			lane6++;
 			cars[i] = n;
 			System.out.println(Math.PI*3/2);
 			
		} 
		
			
			
		}
		
		
		
		
	}
	public void drawDottedLine(Graphics g, int x1, int y1, int x2, int y2, int s, int r) {
    	double d = Math.sqrt((double)(x1 - x2) * (x1 - x2) + (double)(y1 - y2) * (y1 - y2));
    	int x = x1, y = y1;
    	int n = 0;
    	boolean f = true;
    	do {
    	int dx = (int)((n * (s+r) + s - 1) * (x2 - x1) / d + x1 + 0.5);
    	int dy = (int)((n * (s+r) + s - 1) * (y2 - y1) / d + y1 + 0.5);
    	if (Math.abs(dx - x1) > Math.abs(x2 - x1)) {
    	dx = x2;
    	f = false;
    	}
    	if (Math.abs(dy - y1) > Math.abs(y2 - y1)) {
    	dy = y2;
    	f = false;
    	}
    	g.drawLine(x, y, dx, dy);
    	n++;
    	x = (int)(n * (s + r) * (x2 - x1) / d + x1 + 0.5);
    	y = (int)(n * (s + r) * (y2 - y1) / d + y1 + 0.5);	
    	} while(f);	
    	}
	@Override
	public void paint (Graphics g){
		drawRoad(g);
		//cars = initCars();
		for(int i=0;i<carnums;i++){
			System.out.println(cars[i].theta);
			drawCar(g,cars[i]);
			
		}
	}
	public void drawCar(Graphics g, CarNode car){
		
		int lane = car.initlane;
		int sx = (int)car.sx;
	  	int sy = (int)car.sy;
	  	
	  	
	  	double carRearLeftX = 0;
		double carRearLeftY=0;
		// right rear
		double carRearRightX=0;
		double carRearRightY=0;
		// left head
		double carHeadLeftX=0;
		double carHeadLeftY=0;
		// right head
		double carHeadRightX=0;
		double carHeadRightY=0;
	     Color edgeColor = Color.black;
	     Color nodeColor = new Color(250, 220, 100);
	     if(lane==0){

	   	    
	   		if(car.theta <= initTheta ){
				
	   		
				// left rear
				carRearLeftX = sx;
				carRearLeftY = sy ;
				// right rear
				carRearRightX = sx;
				carRearRightY = sy + carheight;
				// car head middle point
			
				// left head
				carHeadLeftX = sx + carlength;
				carHeadLeftY = sy ;
				// right head
				carHeadRightX = sx + carlength;
				carHeadRightY = sy + carheight;
				
			}
			else{
		
				if(car.driving_out){
					if(car.dest_lane==1){
	   				if(car.flag<=1){
	   				car.sx = 930;
					car.sy = 225;
					}
	   				// left rear
					carRearLeftX = sx;
					carRearLeftY = sy ;
					// right rear
					carRearRightX = sx+carheight;
					carRearRightY = sy ;
					// car head middle point
				
					// left head
					carHeadLeftX = sx ;
					carHeadLeftY = sy -carlength;
					// right head
					carHeadRightX = sx + carheight;
					carHeadRightY = sy -carlength;
					}
					if(car.dest_lane==3){
		   				if(car.flag<=1){
		   				car.sx = 1100-carlength;
						car.sy = 355;
						}
		   				carRearLeftX = sx;
						carRearLeftY = sy ;
						// right rear
						carRearRightX = sx;
						carRearRightY = sy + carheight;
						// car head middle point
					
						// left head
						carHeadLeftX = sx + carlength;
						carHeadLeftY = sy ;
						// right head
						carHeadRightX = sx + carlength;
						carHeadRightY = sy + carheight;
						
						}
					if(car.dest_lane==5){
		   				if(car.flag<=1){
		   				car.sx = 970;
						car.sy = 525-carlength;
						System.out.println("sy"+sy);
						}
		   				// left rear
						carRearLeftX = sx;
						carRearLeftY = sy ;
						// right rear
						carRearRightX = sx-carheight;
						carRearRightY = sy ;
						// car head middle point
					
						// left head
						carHeadLeftX = sx ;
						carHeadLeftY = sy +carlength;
						// right head
						carHeadRightX = sx - carheight;
						carHeadRightY = sy +carlength;
						//System.out.println(sy);
						}
					if(car.dest_lane==7){
		   				if(car.flag<=1){
		   				car.sx = 800+carlength;
						car.sy = 395;
						
						}
		   				carRearLeftX = sx;
						carRearLeftY = sy ;
						// right rear
						carRearRightX = sx;
						carRearRightY = sy - carheight;
						// car head middle point
					
						// left head
						carHeadLeftX = sx - carlength;
						carHeadLeftY = sy ;
						// right head
						carHeadRightX = sx - carlength;
						carHeadRightY = sy - carheight;
						//System.out.println(sx);
						}
	   			}
				else{
					double carRearX = sx - carlength/2 * Math.sin(car.theta);
					double carRearY = sy + carlength/2 * Math.cos(car.theta);
				// left rear
					carRearLeftX = carRearX - carheight/2 * Math.cos(car.theta);
					carRearLeftY = carRearY - carheight/2 * Math.sin(car.theta);
				// right rear
					carRearRightX = carRearX + carheight/2 * Math.cos(car.theta);
					carRearRightY = carRearY + carheight/2 * Math.sin(car.theta);
				// car head middle point
					double carHeadX = sx + carlength/2 * Math.sin(car.theta);
					double carHeadY = sy - carlength/2 * Math.cos(car.theta);
				// left head
					carHeadLeftX = carHeadX - carheight/2 * Math.cos(car.theta);
					carHeadLeftY = carHeadY - carheight/2 * Math.sin(car.theta);
				// right head
					carHeadRightX = carHeadX + carheight/2 * Math.cos(car.theta);
					carHeadRightY = carHeadY + carheight/2 * Math.sin(car.theta);
				}
			
			}
	   		
	   		int xpoints[] = {(int)carRearLeftX, (int)carRearRightX, (int)carHeadRightX, (int)carHeadLeftX};
			int ypoints[] = {(int)carRearLeftY, (int)carRearRightY, (int)carHeadRightY, (int)carHeadLeftY};
			int npoints = 4;
			int xpoints2[] = {(int)carRearLeftX-1, (int)carRearRightX-1, (int)carHeadRightX-1, (int)carHeadLeftX-1};
			int ypoints2[] = {(int)carRearLeftY-1, (int)carRearRightY-1, (int)carHeadRightY-1, (int)carHeadLeftY-1};
			g.setColor(nodeColor); 
			g.fillPolygon(xpoints, ypoints, npoints);
	   	    g.setColor(edgeColor);
	   	    g.drawPolygon(xpoints2, ypoints2, npoints);
	   	    
	     }
	     if(lane==2){

		   	    
		   		if(car.theta <= Math.PI/2 ){
					
		   		
					// left rear
					carRearLeftX = sx;
					carRearLeftY = sy ;
					// right rear
					carRearRightX = sx-carheight;
					carRearRightY = sy ;
					// car head middle point
				
					// left head
					carHeadLeftX = sx ;
					carHeadLeftY = sy +carlength;
					// right head
					carHeadRightX = sx - carheight;
					carHeadRightY = sy + carlength;
					
				}
				else{
			
					if(car.driving_out){
						if(car.dest_lane==1){
		   				if(car.flag<=1){
		   				car.sx = 930;
						car.sy = 225;
						}
		   				// left rear
						carRearLeftX = sx;
						carRearLeftY = sy ;
						// right rear
						carRearRightX = sx+carheight;
						carRearRightY = sy ;
						// car head middle point
					
						// left head
						carHeadLeftX = sx ;
						carHeadLeftY = sy -carlength;
						// right head
						carHeadRightX = sx + carheight;
						carHeadRightY = sy -carlength;
						}
						if(car.dest_lane==3){
			   				if(car.flag<=1){
			   				car.sx = 1100-carlength;
							car.sy = 355;
							}
			   				carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx;
							carRearRightY = sy + carheight;
							// car head middle point
						
							// left head
							carHeadLeftX = sx + carlength;
							carHeadLeftY = sy ;
							// right head
							carHeadRightX = sx + carlength;
							carHeadRightY = sy + carheight;
							
							}
						if(car.dest_lane==5){
			   				if(car.flag<=1){
			   				car.sx = 970;
							car.sy = 525-carlength;
							System.out.println("sy"+sy);
							}
			   				// left rear
							carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx-carheight;
							carRearRightY = sy ;
							// car head middle point
						
							// left head
							carHeadLeftX = sx ;
							carHeadLeftY = sy +carlength;
							// right head
							carHeadRightX = sx - carheight;
							carHeadRightY = sy +carlength;
							//System.out.println(sy);
							}
						if(car.dest_lane==7){
			   				if(car.flag<=1){
			   				car.sx = 800+carlength;
							car.sy = 395;
							
							}
			   				carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx;
							carRearRightY = sy - carheight;
							// car head middle point
						
							// left head
							carHeadLeftX = sx - carlength;
							carHeadLeftY = sy ;
							// right head
							carHeadRightX = sx - carlength;
							carHeadRightY = sy - carheight;
							//System.out.println(sx);
							}
		   			}
					else{
						double carRearX = sx - carlength/2 * Math.sin(car.theta);
						double carRearY = sy + carlength/2 * Math.cos(car.theta);
					// left rear
						carRearLeftX = carRearX - carheight/2 * Math.cos(car.theta);
						carRearLeftY = carRearY - carheight/2 * Math.sin(car.theta);
					// right rear
						carRearRightX = carRearX + carheight/2 * Math.cos(car.theta);
						carRearRightY = carRearY + carheight/2 * Math.sin(car.theta);
					// car head middle point
						double carHeadX = sx + carlength/2 * Math.sin(car.theta);
						double carHeadY = sy - carlength/2 * Math.cos(car.theta);
					// left head
						carHeadLeftX = carHeadX - carheight/2 * Math.cos(car.theta);
						carHeadLeftY = carHeadY - carheight/2 * Math.sin(car.theta);
					// right head
						carHeadRightX = carHeadX + carheight/2 * Math.cos(car.theta);
						carHeadRightY = carHeadY + carheight/2 * Math.sin(car.theta);
					}
				
				}
		   		
		   		int xpoints[] = {(int)carRearLeftX, (int)carRearRightX, (int)carHeadRightX, (int)carHeadLeftX};
				int ypoints[] = {(int)carRearLeftY, (int)carRearRightY, (int)carHeadRightY, (int)carHeadLeftY};
				int npoints = 4;
				int xpoints2[] = {(int)carRearLeftX-1, (int)carRearRightX-1, (int)carHeadRightX-1, (int)carHeadLeftX-1};
				int ypoints2[] = {(int)carRearLeftY-1, (int)carRearRightY-1, (int)carHeadRightY-1, (int)carHeadLeftY-1};
				g.setColor(nodeColor); 
				g.fillPolygon(xpoints, ypoints, npoints);
		   	    g.setColor(edgeColor);
		   	    g.drawPolygon(xpoints2, ypoints2, npoints);
		   	    
		     }
	     if(lane==4){


		   	    
		   		if(car.theta <= Math.PI ){
					
		   		
					// left rear
					carRearLeftX = sx+carlength;
					carRearLeftY = sy+carheight ;
					// right rear
					carRearRightX = sx+carlength;
					carRearRightY = sy  ;
					// car head middle point
				
					// left head
					carHeadLeftX = sx ;
					carHeadLeftY = sy+carheight ;
					// right head
					carHeadRightX = sx ;
					carHeadRightY = sy ;
					
				}
				else{
			
					if(car.driving_out){
						if(car.dest_lane==1){
		   				if(car.flag<=1){
		   				car.sx = 930;
						car.sy = 225;
						}
		   				// left rear
						carRearLeftX = sx;
						carRearLeftY = sy ;
						// right rear
						carRearRightX = sx+carheight;
						carRearRightY = sy ;
						// car head middle point
					
						// left head
						carHeadLeftX = sx ;
						carHeadLeftY = sy -carlength;
						// right head
						carHeadRightX = sx + carheight;
						carHeadRightY = sy -carlength;
						}
						if(car.dest_lane==3){
			   				if(car.flag<=1){
			   				car.sx = 1100-carlength;
							car.sy = 355;
							}
			   				carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx;
							carRearRightY = sy + carheight;
							// car head middle point
						
							// left head
							carHeadLeftX = sx + carlength;
							carHeadLeftY = sy ;
							// right head
							carHeadRightX = sx + carlength;
							carHeadRightY = sy + carheight;
							
							}
						if(car.dest_lane==5){
			   				if(car.flag<=1){
			   				car.sx = 970;
							car.sy = 525-carlength;
							System.out.println("sy"+sy);
							}
			   				// left rear
							carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx-carheight;
							carRearRightY = sy ;
							// car head middle point
						
							// left head
							carHeadLeftX = sx ;
							carHeadLeftY = sy +carlength;
							// right head
							carHeadRightX = sx - carheight;
							carHeadRightY = sy +carlength;
							//System.out.println(sy);
							}
						if(car.dest_lane==7){
			   				if(car.flag<=1){
			   				car.sx = 800+carlength;
							car.sy = 395;
							
							}
			   				carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx;
							carRearRightY = sy - carheight;
							// car head middle point
						
							// left head
							carHeadLeftX = sx - carlength;
							carHeadLeftY = sy ;
							// right head
							carHeadRightX = sx - carlength;
							carHeadRightY = sy - carheight;
							//System.out.println(sx);
							}
		   			}
					else{
						double carRearX = sx - carlength/2 * Math.sin(car.theta);
						double carRearY = sy + carlength/2 * Math.cos(car.theta);
					// left rear
						carRearLeftX = carRearX - carheight/2 * Math.cos(car.theta);
						carRearLeftY = carRearY - carheight/2 * Math.sin(car.theta);
					// right rear
						carRearRightX = carRearX + carheight/2 * Math.cos(car.theta);
						carRearRightY = carRearY + carheight/2 * Math.sin(car.theta);
					// car head middle point
						double carHeadX = sx + carlength/2 * Math.sin(car.theta);
						double carHeadY = sy - carlength/2 * Math.cos(car.theta);
					// left head
						carHeadLeftX = carHeadX - carheight/2 * Math.cos(car.theta);
						carHeadLeftY = carHeadY - carheight/2 * Math.sin(car.theta);
					// right head
						carHeadRightX = carHeadX + carheight/2 * Math.cos(car.theta);
						carHeadRightY = carHeadY + carheight/2 * Math.sin(car.theta);
					}
				
				}
		   		
		   		int xpoints[] = {(int)carRearLeftX, (int)carRearRightX, (int)carHeadRightX, (int)carHeadLeftX};
				int ypoints[] = {(int)carRearLeftY, (int)carRearRightY, (int)carHeadRightY, (int)carHeadLeftY};
				int npoints = 4;
				int xpoints2[] = {(int)carRearLeftX-1, (int)carRearRightX-1, (int)carHeadRightX-1, (int)carHeadLeftX-1};
				int ypoints2[] = {(int)carRearLeftY-1, (int)carRearRightY-1, (int)carHeadRightY-1, (int)carHeadLeftY-1};
				g.setColor(nodeColor); 
				g.fillPolygon(xpoints, ypoints, npoints);
		   	    g.setColor(edgeColor);
		   	    g.drawPolygon(xpoints2, ypoints2, npoints);
		   	    
		     
	     }
	     if(lane==6){

	    	 
		   	    
		   		if(car.theta <= Math.PI*3/2 ){
					
		   		
					// left rear
					carRearLeftX = sx;
					carRearLeftY = sy+carlength ;
					// right rear
					carRearRightX = sx+carheight;
					carRearRightY = sy+carlength ;
					// car head middle point
				
					// left head
					carHeadLeftX = sx ;
					carHeadLeftY = sy ;
					// right head
					carHeadRightX = sx +carheight;
					carHeadRightY = sy ;
					System.out.println(sy);
				}
				else{
			
					if(car.driving_out){
						if(car.dest_lane==1){
		   				if(car.flag<=1){
		   				car.sx = 930;
						car.sy = 225;
						}
		   				// left rear
						carRearLeftX = sx;
						carRearLeftY = sy ;
						// right rear
						carRearRightX = sx+carheight;
						carRearRightY = sy ;
						// car head middle point
					
						// left head
						carHeadLeftX = sx ;
						carHeadLeftY = sy -carlength;
						// right head
						carHeadRightX = sx + carheight;
						carHeadRightY = sy -carlength;
						}
						if(car.dest_lane==3){
			   				if(car.flag<=1){
			   				car.sx = 1100-carlength;
							car.sy = 355;
							}
			   				carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx;
							carRearRightY = sy + carheight;
							// car head middle point
						
							// left head
							carHeadLeftX = sx + carlength;
							carHeadLeftY = sy ;
							// right head
							carHeadRightX = sx + carlength;
							carHeadRightY = sy + carheight;
							
							}
						if(car.dest_lane==5){
			   				if(car.flag<=1){
			   				car.sx = 970;
							car.sy = 525-carlength;
							System.out.println("sy"+sy);
							}
			   				// left rear
							carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx-carheight;
							carRearRightY = sy ;
							// car head middle point
						
							// left head
							carHeadLeftX = sx ;
							carHeadLeftY = sy +carlength;
							// right head
							carHeadRightX = sx - carheight;
							carHeadRightY = sy +carlength;
							//System.out.println(sy);
							}
						if(car.dest_lane==7){
			   				if(car.flag<=1){
			   				car.sx = 800+carlength;
							car.sy = 395;
							
							}
			   				carRearLeftX = sx;
							carRearLeftY = sy ;
							// right rear
							carRearRightX = sx;
							carRearRightY = sy - carheight;
							// car head middle point
						
							// left head
							carHeadLeftX = sx - carlength;
							carHeadLeftY = sy ;
							// right head
							carHeadRightX = sx - carlength;
							carHeadRightY = sy - carheight;
							//System.out.println(sx);
							}
		   			}
					else{
						double carRearX = sx - carlength/2 * Math.sin(car.theta);
						double carRearY = sy + carlength/2 * Math.cos(car.theta);
					// left rear
						carRearLeftX = carRearX - carheight/2 * Math.cos(car.theta);
						carRearLeftY = carRearY - carheight/2 * Math.sin(car.theta);
					// right rear
						carRearRightX = carRearX + carheight/2 * Math.cos(car.theta);
						carRearRightY = carRearY + carheight/2 * Math.sin(car.theta);
					// car head middle point
						double carHeadX = sx + carlength/2 * Math.sin(car.theta);
						double carHeadY = sy - carlength/2 * Math.cos(car.theta);
					// left head
						carHeadLeftX = carHeadX - carheight/2 * Math.cos(car.theta);
						carHeadLeftY = carHeadY - carheight/2 * Math.sin(car.theta);
					// right head
						carHeadRightX = carHeadX + carheight/2 * Math.cos(car.theta);
						carHeadRightY = carHeadY + carheight/2 * Math.sin(car.theta);
					}
				
				}
		   		
		   		int xpoints[] = {(int)carRearLeftX, (int)carRearRightX, (int)carHeadRightX, (int)carHeadLeftX};
				int ypoints[] = {(int)carRearLeftY, (int)carRearRightY, (int)carHeadRightY, (int)carHeadLeftY};
				int npoints = 4;
				int xpoints2[] = {(int)carRearLeftX-1, (int)carRearRightX-1, (int)carHeadRightX-1, (int)carHeadLeftX-1};
				int ypoints2[] = {(int)carRearLeftY-1, (int)carRearRightY-1, (int)carHeadRightY-1, (int)carHeadLeftY-1};
				g.setColor(nodeColor); 
				g.fillPolygon(xpoints, ypoints, npoints);
		   	    g.setColor(edgeColor);
		   	    g.drawPolygon(xpoints2, ypoints2, npoints);
		   	    
		     
	     }
	}
	private void drawRoad(Graphics g) {
//		  Graphics2D g2D = (Graphics2D) g;
//          RenderingHints qualityHints = new RenderingHints(
//                                            RenderingHints.KEY_ANTIALIASING,
//                                            RenderingHints.VALUE_ANTIALIAS_ON);
//          qualityHints.put(RenderingHints.KEY_RENDERING,
//                          RenderingHints.VALUE_RENDER_QUALITY);
//          g2D.setRenderingHints(qualityHints);
//		 
//          g.drawLine(lane0x, lane0y, roadlength, lane0y);
//          drawDottedLine(g,lane0x,lane0y+laneWidth,roadlength,lane0y+laneWidth,10,10);
//          g.drawLine(lane0x, lane0y+laneWidth, roadlength, lane0y+laneWidth);
//          g.drawArc(roadlength, lane1y, arcRadius*2, arcRadius*2, 180, -90);
//      
//          g.drawLine(lane1x, 0, lane1x, lane1y);
//          drawDottedLine(g,lane1x+laneWidth,0,lane1x+laneWidth,lane1y,10,10);
//          g.drawLine(lane1x+2*laneWidth, 0, lane1x+2*laneWidth, lane1y);
//          g.drawArc(lane1x+2*laneWidth-arcRadius, lane1y, arcRadius*2, arcRadius*2, 0, 90);
//        
//          g.drawLine(lane1x+2*laneWidth+arcRadius, lane1y+arcRadius, lane1x+2*laneWidth+arcRadius+roadlength,  lane1y+arcRadius);
//          drawDottedLine(g,lane1x+2*laneWidth+arcRadius,lane1y+arcRadius+laneWidth,lane1x+2*laneWidth+arcRadius+roadlength,lane1y+arcRadius+laneWidth,10,10);
//          g.drawLine(lane1x+2*laneWidth+arcRadius, lane1y+2*arcRadius, lane1x+2*laneWidth+arcRadius+roadlength, lane1y+2*arcRadius);
//          g.drawArc(lane1x+2*laneWidth-arcRadius, lane1y+arcRadius, arcRadius*2, arcRadius*2, 0, -90);
//       
//          g.drawLine(lane1x+2*laneWidth, lane1y+3*arcRadius, lane1x+2*laneWidth, 800);
//          drawDottedLine(g,lane1x+laneWidth,lane1y+3*arcRadius,lane1x+laneWidth,800,10,10);
//          g.drawLine(lane1x, lane1y+3*arcRadius, lane1x, 800);
//          g.drawArc(lane1x-arcRadius, lane1y+arcRadius, arcRadius*2, arcRadius*2, 180, 90);
//          
//       
//          
//          g.drawOval(425, 250, 250, 250);
//          g.drawString("sda", 425, 250);
//          g.drawString("sda", 425+125, 250+125);
//          //g.drawOval(420, 245, 245, 245);


		
		  Graphics2D g2D = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(
                                          RenderingHints.KEY_ANTIALIASING,
                                          RenderingHints.VALUE_ANTIALIAS_ON);
        qualityHints.put(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
        g2D.setRenderingHints(qualityHints);
       // g.setColor(Color.red);
        g.drawArc(400+400, 225, 250, 250, 180, -90);
    
        g.drawLine(525+400, 0, 525+400, 225);
        drawDottedLine(g,550+400,0,550+400,225,10,10);
        g.drawLine(575+400, 0, 575+400, 225);
        g.drawArc(450+400, 225, 250, 250, 0, 90);
      
        g.drawLine(700+400, 350, 1100+400, 350);
        drawDottedLine(g,700+400,375,1100+400,375,10,10);
        g.drawLine(700+400, 400, 1100+400, 400);
        g.drawArc(450+400, 275, 250, 250, 0, -90);
     
        g.drawLine(575+400, 525, 575+400, 900);
        drawDottedLine(g,550+400,525,550+400,900,10,10);
        g.drawLine(525+400, 525, 525+400, 900);
        g.drawArc(400+400, 275, 250, 250, 180, 90);
        
        g.drawLine(0+400, 350, 400+400, 350);
        drawDottedLine(g,0+400,375,400+400,375,10,10);
        g.drawLine(0+400, 400, 400+400, 400);
        
        g.drawOval(425+400, 250, 250, 250);
       // g.drawString("sda", 425, 250);
        g.drawString("center", 425+125+400, 250+125);      //center: 550,375
        //g.drawOval(410, 235, 280, 280);
	
	
	}
	
	
}
