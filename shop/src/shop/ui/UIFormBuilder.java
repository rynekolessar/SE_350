package shop.ui;

import java.util.ArrayList;
import java.util.List;

final class UIFormBuilder implements UIFormBuilderInterface{
    private final List<Pair> _menu;
    public UIFormBuilder() {
        _menu = new ArrayList();
    }
    public UIForm toUIForm(String heading) {
        if (null == heading)
            throw new IllegalArgumentException();
        if (_menu.size() < 1)
            throw new IllegalStateException();
        Pair[] array = new Pair[_menu.size()];
        for (int i = 0; i < _menu.size(); i++)
            array[i] = _menu.get(i);
        return new UIForm(heading, array);
    }
    public void add(String prompt, UIFormTest test) {
        _menu.add(new Pair(prompt, test));
    }
}
