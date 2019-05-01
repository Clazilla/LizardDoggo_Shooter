package shooti_shoot;

import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LizardDoggo extends ImageView {

	private static final Image IMAGE = new Image(LizardDoggo_Shooter.class.getResourceAsStream("LizardDoggo.jpg"));
	private static final Random RANDOM = new Random();

	private AnimationTimer animationtimer;

	public LizardDoggo() {
		this.setImage(IMAGE);
		this.setTranslateY(RANDOM.nextInt(900));
		this.animationtimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				setTranslateX(getTranslateX() + RANDOM.nextInt(10));

				if (getTranslateX() > 2000) {
					((Group) getParent()).getChildren().remove(LizardDoggo.this);
					this.stop();
				}
			}
		};

		animationtimer.start();

	}

}
