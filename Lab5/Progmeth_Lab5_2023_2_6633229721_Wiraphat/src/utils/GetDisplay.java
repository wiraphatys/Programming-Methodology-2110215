package utils;

import item.Book;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class GetDisplay {
    // method
    public static Text Description(Book book, int fontSize, int wrappingWidth) {
        Text newText = new Text(book.getDescription());
        newText.setFont(Font.font(fontSize));
        newText.setWrappingWidth(wrappingWidth);

        return newText;
    }

    public static ImageView image(Book book, int fitHeight) {
        ImageView newImageView = new ImageView(book.getImage());
        newImageView.setPreserveRatio(true);
        newImageView.setFitHeight(fitHeight);

        return newImageView;
    }

    public static Text name(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment) {
        Text newText = new Text(book.getName());
        newText.setFont(Font.font(fontSize));
        newText.setWrappingWidth(wrappingWidth);
        newText.setTextAlignment(textAlignment);

        return newText;
    }

    public static Text author(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment) {
        Text newText = new Text(book.getAuthor());
        newText.setFill(Color.GREY);
        newText.setFont(Font.font(fontSize));
        newText.setWrappingWidth(wrappingWidth);
        newText.setTextAlignment(textAlignment);

        return newText;
    }

    public static Text stars(Book book, int fontSize) {
        String rating = "";
        int stars = book.getStars();
        for (int i = 0; i < stars; ++i) rating += "\u2605";
        for (int i = 0; i < 5-stars; ++i) rating += "\u2606";

        Text newText = new Text(rating);
        newText.setFill(Color.DARKRED);
        newText.setFont(Font.font(fontSize));

        return newText;
    }
}
