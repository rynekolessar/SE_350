package shop.ui;

public class Pair {
    final String prompt;
    final UIMenuAction action;
    final UIFormTest test;

    Pair(String thePrompt, UIMenuAction theAction) {
        prompt = thePrompt;
        action = theAction;
        test = null;
    }

    Pair(String thePrompt, UIFormTest theTest) {
        prompt = thePrompt;
        test = theTest;
        action = null;
    }
}
