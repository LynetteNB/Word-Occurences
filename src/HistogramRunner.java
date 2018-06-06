import models.ParagraphHistogram;

/**
 * Creates new Paragraph Histogram object.
 */
public class HistogramRunner {
    public static void main(String[] args) {
        ParagraphHistogram ph = new ParagraphHistogram("input.txt", "output.txt");
    }
}
