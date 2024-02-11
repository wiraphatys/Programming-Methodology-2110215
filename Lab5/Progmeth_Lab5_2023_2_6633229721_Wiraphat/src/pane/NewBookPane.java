package pane;

import item.Book;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;

import java.util.ArrayList;

public class NewBookPane extends GridPane {
    // constructor
    public NewBookPane() {
        setPadding(new Insets(12));
        setVgap(8);

        TextField name = input();
        TextField author = input();
        TextField rating = input();
        TextField image = input();
        TextField description = input();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        col1.setHalignment(HPos.RIGHT);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(75);

        Button btn = new Button("Add");
        btn.setMaxWidth(430);
        btn.setPrefHeight(32);
        btn.setTextFill(Color.WHITE);
        btn.setBackground(Background.fill(Color.DARKCYAN));
        btn.setOnMouseClicked(e -> handleClick(name.getText(), author.getText(), rating.getText(), image.getText(), description.getText()));

        this.getColumnConstraints().addAll(col1, col2);

        this.add(label("Title: "), 0, 0);
        this.add(label("Author: "), 0, 1);
        this.add(label("Rating: "), 0, 2);
        this.add(label("Image: "), 0, 3);
        this.add(label("Description: "), 0, 4);

        this.add(name, 1, 0);
        this.add(author, 1, 1);
        this.add(rating, 1, 2);
        this.add(image, 1, 3);
        this.add(description, 1, 4);

        this.add(btn, 0, 5, 2, 1);
    }

    // method
    private Text label(String s) {
        Text newText = new Text(s);
        newText.setFont(Font.font(16));

        return newText;
    }

    public TextField input() {
        TextField newTextField = new TextField();
        newTextField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(16), null)));
        newTextField.setBorder(new Border(
                new BorderStroke(
                        Color.DARKCYAN,
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(16),
                        null
                )
        ));

        return newTextField;
    }

    public void handleClick(String name, String author, String rating, String image, String description) {
        if (name.isBlank() || author.isBlank() || rating.isBlank() || image.isBlank() || description.isBlank()) {
            return;
        }
        Book newBook = new Book(name, author, rating, image, description);
        ArrayList<Book> bookList = BookListPane.getInstance().getBooks();
        bookList.add(newBook);

        BookListPane.getInstance().setSearchedBooks(bookList);

        Goto.mainPage();
    }
}
