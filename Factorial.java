import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.text.*;
import java.io.*;
import java.util.*;

/*
 * The Factorial class performs three mathematical operations either upon or according to a user-entered integer. The number is prompted for using javafx and is stored as a variable which is then operated upon with different loop methods.
 * The Factorial class extends Application as a javaFX application which utilizes the start() method rather than the main() method.
 * @author Sapper
 * email: email
 * @version 1.0
 * created: 5NOV2017
 */

public class Factorial extends Application {
	/**
	 * The main() method is not used in this Application but exists as a backup call to launch.
	 * @param args Command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	/**
	 * The start() method is the entry point of the application and contains the objects and method calls which read and process the user entry.
	 * The start() method overrides the native start method of the Application class.
	 * @param primaryStage constructs a stage object named primaryStage to run the javaFX interface?
	 */

	@Override
	public void start(Stage primaryStage) {
		GridPane firstPane = new GridPane();
		firstPane.setPadding(new Insets(10, 10, 10, 10));
		firstPane.setHgap(5);
		firstPane.setVgap(5);

		Label textLabel = new Label("Enter a whole number");
		TextField input = new TextField("enter here");
		Button computeButton = new Button("Compute");
		Button cancelButton = new Button("Cancel");

		firstPane.add(textLabel, 0, 0);
		firstPane.add(input, 1, 0);
		firstPane.add(computeButton, 2, 2);
		firstPane.add(cancelButton, 3, 2);

		Scene firstScene = new Scene(firstPane);
		primaryStage.setScene(firstScene);
		primaryStage.show();

		computeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String userInput = input.getText();
				final int n = Integer.parseInt(userInput);
				int nFactorial = 1;
				int i = 1;
				int sum = 0;
				int[] series = new int[n];
				series[0] = 1;
				series[1] = 1;
				while (i <= n) {
					nFactorial = nFactorial * i;
					i++;
				}
				for (i=1; i<=n; i++) {
					sum = 2*i-1;
				}
				for (i=2; i<n; i++) {
					series[i] = series[i-1] + series[i-2];	
				}

				FlowPane resultPane = new FlowPane();
				resultPane.setVgap(5);
				resultPane.setHgap(5);
				TextArea factorialResult = new TextArea("The result of the factorial computation for your number, " + n + " is:\n" + nFactorial);
				resultPane.getChildren().add(factorialResult);
				TextArea oddSum = new TextArea("The sum of the odd numbers leading up to " + n + " is:\n" + sum);
				resultPane.getChildren().add(oddSum);
				TextArea fibber = new TextArea("The first " + n + " numbers of fibonaccis sequence are:\n");
				fibber.appendText(Arrays.toString(series));
				resultPane.getChildren().add(fibber);

				Scene resultScene = new Scene(resultPane);
				Stage resultStage = new Stage();
				resultStage.setScene(resultScene);
				resultStage.show();
			}
		});

		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

	}
}

