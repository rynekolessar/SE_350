package shop.ui;

/**
 * @see UIMenuBuilder
 */
final class UIMenu implements UIMenuInterface {
    private final String _heading;
    private final Pair[] _menu;

    UIMenu(String heading, Pair[] menu) {
        _heading = heading;
        _menu = menu;
    }
    public int size() {
        return _menu.length;
    }
    public String getHeading() {
        return _heading;
    }
    public String getPrompt(int i) {
        return _menu[i].prompt;
    }
    public void runAction(int i) {
        _menu[i].action.run();
    }

}
