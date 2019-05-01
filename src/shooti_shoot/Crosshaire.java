package shooti_shoot;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Crosshaire extends Group {
	
	public Crosshaire() {
		drawCircles(0, 0, 45);
		drawCircles(0, 0, 30);
		drawCircles(0, 0, 15);
		
		drawLines(-45, 0, 45, 0);
		drawLines(0, 45, 0, -45);
	}
	
	public void drawCircles(double x, double y, double z) {
		Circle circle = new Circle(x, y, z);
		circle.setStroke(Color.DARKRED);
		circle.setFill(null);
		circle.setStrokeWidth(3);
		this.getChildren().add(circle);
	}
	
	public void drawLines(double startx, double starty, double endx, double endy) {
		Line line = new Line(startx, starty, endx, endy);
		line.setStroke(Color.DARKRED);
		line.setStrokeWidth(3);
		this.getChildren().add(line);
	}

}
