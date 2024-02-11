package pane;

import item.Book;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import utils.GetDisplay;
import utils.Goto;

public class BookPane extends GridPane {
    // constructor
    public BookPane(Book book) {
        super();
        setPrefWidth(428);
        setHgap(8);
        setPadding(new Insets(4));

        ImageView img = GetDisplay.image(book, 160);
        this.add(img, 0, 0, 1, 4);

        Text name = GetDisplay.name(book, 18, 250, TextAlignment.LEFT);
        this.add(name, 1, 0);

        Text author = GetDisplay.author(book, 16, 250, TextAlignment.LEFT);
        this.add(author, 1,1);

        Text stars = GetDisplay.stars(book, 16);
        this.add(stars, 1, 3);

        setOnMouseClicked(e -> Goto.bookPage(book));
    }
}
