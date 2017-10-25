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

public class Factorial extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

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
					sum += 2*i-1;
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

