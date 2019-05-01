package shooti_shoot;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LizardDoggo_Shooter extends Application {

	public static Group root_1 = new Group();
	public static Crosshaire crosshair;

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
		
		Image img2 = new Image(LizardDoggo_Shooter.class.getResourceAsStream("blueberry.png"));

		scene.setOnMouseClicked(event -> {
			double x = event.getSceneX();
			double y = event.getSceneY();
			ImageView imageview2 = new ImageView();
			imageview2.setImage(img2);
			root_1.getChildren().add(imageview2);
			imageview2.setFitHeight(50);
			imageview2.setFitWidth(50);
			imageview2.setTranslateX(x - 25);
			imageview2.setTranslateY(y - 25);
			
			crosshair.toFront();
		});

		stage.show();
	}

	public static void startSpawner() {
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {

			@Override
			public void run() {
				Platform.runLater(() -> {
					LizardDoggo ld = new LizardDoggo();
					root_1.getChildren().add(ld);
					crosshair.toFront();
				});

			}
		};
		timer.scheduleAtFixedRate(timertask, 0, 5000);

		
	}
}
