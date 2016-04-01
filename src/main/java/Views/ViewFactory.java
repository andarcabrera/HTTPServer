package Views;

/**
 * Created by andacabrera29 on 3/31/16.
 */
public class ViewFactory extends AbstractViewFactory {
    private View index = new TTTHomePage();
    private View gameOverView = new TTTGameOverView();
    private View makeMoveView = new TTTMakeMoveView();

    @Override
    public View createHomePageView() {
        return index;
    }

    @Override
    public View createGameOverView() {
        return gameOverView;
    }

    @Override
    public View createMakeMoveView() {
        return makeMoveView;
    }
}
