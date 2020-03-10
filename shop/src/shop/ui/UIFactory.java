package shop.ui;

public class UIFactory {
    private UIFactory() {}
    static private UI _UI = new PopupUI();
    // static private UI _UI = new TextUI();
    static public UI ui () {
        return _UI;
    }

    static public UIFormInterface newForm(String heading, Pair[] menu) { return new UIForm(heading, menu); }

    static private UIFormBuilderInterface _UIFormBuilder = new UIFormBuilder();
    static public UIFormBuilderInterface newFormBuilder() { return _UIFormBuilder; }

    static public UIMenuInterface newMenu(String heading, Pair[] menu) { return new UIMenu(heading, menu); }

    static private UIMenuBuilderInterface _UIMenuBuilder = new UIMenuBuilder();
    static public UIMenuBuilderInterface newMenuBuilder() { return _UIMenuBuilder; }
}
