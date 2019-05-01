package shooti_shoot;

import javafx.animation.ScaleTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Bullet extends ImageView {
	
	private static final Image IMAGE = new Image(LizardDoggo_Shooter.class.getResourceAsStream("blueberry.png"));
	
	public Bullet() {
			this.setImage(IMAGE);
			ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), this);
			scaleTransition.setFromX(5);
			scaleTransition.setFromY(5);
			scaleTransition.setToX(0.1);
			scaleTransition.setToY(0.1);
			
			scaleTransition.play();
			scaleTransition.setOnFinished(event -> {
				((Group) getParent()).getChildren().remove(this);
			});
	}
}
