package pane;

import item.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SearchPane extends HBox {
    // constructor
    public SearchPane() {
        setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setPromptText("Find the book");
        textField.setPrefWidth(250);

        Button btn = new Button("Search");
        btn.setBackground(Background.fill(Color.DARKCYAN));
        btn.setTextFill(Color.WHITE);
        btn.setOnAction(e -> {
            String searchText = textField.getText().trim();
            ArrayList<Book> filteredBooks = new ArrayList<>(BookListPane.getInstance().getBooks());

            if (searchText.isEmpty()) {
                BookListPane.getInstance().setSearchedBooks(filteredBooks);
            } else {
                filteredBooks.removeIf(book -> !book.getName().toLowerCase().contains(searchText.toLowerCase()));
                BookListPane.getInstance().setSearchedBooks(filteredBooks);
            }
        });

        super.getChildren().addAll(textField, btn);
    }
}
