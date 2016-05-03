package TTTApp.Views;

/**
 * Created by andacabrera29 on 3/31/16.
 */
public interface View {
    byte[] generateHtml(int size, String[] markers, String[] board);
    byte[] homePageHtml();
}
