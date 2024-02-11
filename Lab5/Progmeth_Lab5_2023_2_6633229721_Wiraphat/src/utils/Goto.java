package utils;

import item.Book;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.*;

public class Goto {
    // field
    private static RootPane rootPane;

    // method
    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }

    public static void clear() {
        if (rootPane.getChildren().size() > 1) {
//            Node temp = rootPane.getChildren().getFirst();
//            rootPane.getChildren().removeAll();
//            rootPane.getChildren().add(temp);
            rootPane.getChildren().remove(1,rootPane.getChildren().size());
        }
    }

    public static void mainPage() {
        clear();

        ScrollPane newScrollPane = new ScrollPane(BookListPane.getInstance());
        newScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        newScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        rootPane.getChildren().addAll(new SearchPane(),newScrollPane);
    }

    public static Button backToMainPageButton() {
        Button btn = new Button("Back");
        btn.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));

        btn.setBackground(Background.fill(Color.WHITE));
        btn.setTextFill(Color.DARKCYAN);
        btn.setPrefWidth(300);
        btn.setOnAction(e -> mainPage());

        return btn;
    }

    public static void bookPage(Book book) {
        clear();

        Text name = GetDisplay.name(book, 28, 336, TextAlignment.CENTER);
        Text author = GetDisplay.author(book, 24, 336, TextAlignment.CENTER);
        ImageView img = GetDisplay.image(book, 320);
        Text stars = GetDisplay.stars(book, 24);
        Text description = GetDisplay.Description(book, 16, 336);

        author.setText("BY " + book.getAuthor());

        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().addAll(name, author, img, stars, description);
    }

    public static void addNewBookPage() {
        clear();

        rootPane.getChildren().add(backToMainPageButton());
        rootPane.getChildren().add(new NewBookPane());
    }
}
