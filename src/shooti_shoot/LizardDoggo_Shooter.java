package shooti_shoot;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LizardDoggo_Shooter extends Application {

	public static Group root_1 = new Group();
	public static Crosshaire crosshair;
	public static LizardDoggo ld;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		crosshair = new Crosshaire();

		Scene scene = new Scene(root_1, 400, 300);

		stage.setTitle("LizardDoggo_ShootiShoot");
		stage.setScene(scene);
		stage.alwaysOnTopProperty();
		stage.setAlwaysOnTop(true);
		stage.setFullScreen(true);

		stage.setOnCloseRequest(exit -> System.exit(0));

		Image img1 = new Image(LizardDoggo_Shooter.class.getResourceAsStream("gameScreenshot.png"));
		ImageView imageview1 = new ImageView();
		imageview1.setImage(img1);
		root_1.getChildren().add(imageview1);

		startSpawner();

		root_1.getChildren().add(crosshair);

		scene.setOnMouseMoved(move -> {
			double x;
			double y;
			x = move.getSceneX();
			y = move.getSceneY();
			crosshair.setTranslateX(x);
			crosshair.setTranslateY(y);
		});

		scene.setOnMouseClicked(event -> {
			Bullet bullet = new Bullet();
			double x = event.getSceneX();
			double y = event.getSceneY();
			bullet.setTranslateX(x - 25);
			bullet.setTranslateY(y - 25);
			bullet.setFitHeight(50);
			bullet.setFitWidth(50);
			root_1.getChildren().add(bullet);

			crosshair.toFront();

			root_1.getChildrenUnmodifiable().forEach(node -> {
				if (node instanceof LizardDoggo) {
					Bounds bounds = node.getBoundsInParent();
					if (bounds.contains(x, y)) {
						((LizardDoggo)node).delete();
					}
				}
			});
		});

		stage.show();
	}

	public static void startSpawner() {
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(() -> {
					ld = new LizardDoggo();
					root_1.getChildren().add(ld);
					crosshair.toFront();
				});

			}
		};
		timer.scheduleAtFixedRate(timertask, 0, 5000);

	}
}
