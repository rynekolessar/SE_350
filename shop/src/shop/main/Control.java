package shop.main;

// TODO: Task 1: Factory Pattern for package UI
// Delete from here
//import shop.ui.UIMenu;
//import shop.ui.UIMenuBuilder;
//import shop.ui.UIError;
//import shop.ui.UIForm;
//import shop.ui.UIFormBuilder;
// to here
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Video;
import shop.data.Record;
import shop.command.Command;
import shop.ui.*;

import java.util.Iterator;
import java.util.Comparator;

public class Control {
    private static final int EXITED = 0;
    private static final int EXIT = 1;
    private static final int START = 2;
    private static final int NUMSTATES = 10;
    private UIMenuInterface[] _menus;
    private int _state;

    private UIFormInterface _getVideoForm;
    private UIFormTest _numberTest;
    private UIFormTest _stringTest;

    private Inventory _inventory;
    private UI _ui;


    Control(Inventory inventory, UI ui) {
        _inventory = inventory;
        _ui = ui;

        _menus = new UIMenuInterface[NUMSTATES];
        _state = START;
        addSTART(START);
        addEXIT(EXIT);

        UIFormTest yearTest = input -> {
            try {
                int i = Integer.parseInt(input);
                return i > 1800 && i < 5000;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        _numberTest = input -> {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };
        _stringTest = input -> ! "".equals(input.trim());

        UIFormBuilderInterface f = UIFactory.newFormBuilder();
        f.add("Title", _stringTest);
        f.add("Year", yearTest);
        f.add("Director", _stringTest);
        _getVideoForm = f.toUIForm("Enter Video");
    }

    void run() {
        try {
            while (_state != EXITED) {
                _ui.processMenu( _menus[_state]);
            }
        } catch (UIError e) {
            _ui.displayError("ui closed");
        }
    }
    enum AddStart {
        DEFAULT("Default"),
        ADDREMOVE("Add/Remove copies of a video"),
        CHECKOUT("Check out a video"),
        CHECKIN("Check in a video"),
        PRINT("Print the inventory"),
        CLEAR("Clear the inventory"),
        UNDO("Undo"),
        REDO("Redo"),
        PRINTTOPTEN("Print top ten all time rentals in order"),
        INITWITHBOGUS("Initialize with bogus contents"),
        EXIT("Exit");

        private String prompt;
        AddStart(String prompt) {
            this.prompt = prompt;
        }
        public String getPrompt() {
            return prompt;
        }
        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }
    }

    private void addSTART(int stateNum) {
        UIMenuBuilderInterface m = UIFactory.newMenuBuilder();

        // TODO: State Pattern (use enums for each menu item)
        for (AddStart toAdd : AddStart.values()){
            switch (toAdd) {
                case DEFAULT:
                    m.add(toAdd.getPrompt(),
                            () -> _ui.displayError("doh!"));
                case ADDREMOVE:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                String[] result1 = _ui.processForm(_getVideoForm);
                                Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

                                UIFormBuilderInterface f = UIFactory.newFormBuilder();
                                f.add("Number of copies to add/remove", _numberTest);
                                String[] result2 = _ui.processForm(f.toUIForm(""));

                                Command c = Data.newAddCmd(_inventory, v, Integer.parseInt(result2[0]));
                                if (! c.run()) {
                                    _ui.displayError("Command failed");
                                }
                            });
                case CHECKIN:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                String[] result1 = _ui.processForm(_getVideoForm);
                                Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

                                Command c = Data.newInCmd(_inventory, v);
                                if (! c.run()) {
                                    _ui.displayError("Command failed");
                                }
                            });
                case CHECKOUT:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                String[] result1 = _ui.processForm(_getVideoForm);
                                Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

                                Command c = Data.newOutCmd(_inventory, v);
                                if (! c.run()) {
                                    _ui.displayError("Command failed");
                                }
                            });
                case PRINT:
                    m.add(toAdd.getPrompt(),
                            () -> _ui.displayMessage(_inventory.toString()));
                case CLEAR:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                if (!Data.newClearCmd(_inventory).run()) {
                                    _ui.displayError("Command failed");
                                }
                            });
                case UNDO:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                if (!Data.newUndoCmd(_inventory).run()) {
                                    _ui.displayError("Command failed");
                                }
                            });
                case REDO:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                if (!Data.newRedoCmd(_inventory).run()) {
                                    _ui.displayError("Command failed");
                                }
                            });
                case PRINTTOPTEN:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                if (_inventory.size() > 0) {
                                    Iterator<Record> it = _inventory.iterator(new Comparator<Record>() {
                                        public int compare(Record r1, Record r2) {
                                            return r2.numOut() - r1.numOut();
                                        }
                                    });
                                    StringBuilder b = new StringBuilder();
                                    int counter = 1;
                                    b.append("top ten all time rentals in order: \n");
                                    while (it.hasNext() && counter < 11) {
                                        Record r = it.next();
                                        b.append(" " + r.video().title() + " [" + r.numOwned() + "]\n");
                                        counter++;
                                    }
                                    _ui.displayMessage(b.toString());
                                } else {
                                    _ui.displayError("Inventory is Empty");
                                }
                            });
                case EXIT:
                    m.add(toAdd.getPrompt(),
                            () -> _state = EXIT);
                case INITWITHBOGUS:
                    m.add(toAdd.getPrompt(),
                            () -> {
                                Data.newAddCmd(_inventory, Data.newVideo("a", 2000, "m"), 1).run();
                                Data.newAddCmd(_inventory, Data.newVideo("b", 2000, "m"), 2).run();
                                Data.newAddCmd(_inventory, Data.newVideo("c", 2000, "m"), 3).run();
                                Data.newAddCmd(_inventory, Data.newVideo("d", 2000, "m"), 4).run();
                                Data.newAddCmd(_inventory, Data.newVideo("e", 2000, "m"), 5).run();
                                Data.newAddCmd(_inventory, Data.newVideo("f", 2000, "m"), 6).run();
                                Data.newAddCmd(_inventory, Data.newVideo("g", 2000, "m"), 7).run();
                                Data.newAddCmd(_inventory, Data.newVideo("h", 2000, "m"), 8).run();
                                Data.newAddCmd(_inventory, Data.newVideo("i", 2000, "m"), 9).run();
                                Data.newAddCmd(_inventory, Data.newVideo("j", 2000, "m"), 10).run();
                                Data.newAddCmd(_inventory, Data.newVideo("k", 2000, "m"), 11).run();
                                Data.newAddCmd(_inventory, Data.newVideo("l", 2000, "m"), 12).run();
                                Data.newAddCmd(_inventory, Data.newVideo("m", 2000, "m"), 13).run();
                                Data.newAddCmd(_inventory, Data.newVideo("n", 2000, "m"), 14).run();
                                Data.newAddCmd(_inventory, Data.newVideo("o", 2000, "m"), 15).run();
                                Data.newAddCmd(_inventory, Data.newVideo("p", 2000, "m"), 16).run();
                                Data.newAddCmd(_inventory, Data.newVideo("q", 2000, "m"), 17).run();
                                Data.newAddCmd(_inventory, Data.newVideo("r", 2000, "m"), 18).run();
                                Data.newAddCmd(_inventory, Data.newVideo("s", 2000, "m"), 19).run();
                                Data.newAddCmd(_inventory, Data.newVideo("t", 2000, "m"), 20).run();
                                Data.newAddCmd(_inventory, Data.newVideo("u", 2000, "m"), 21).run();
                                Data.newAddCmd(_inventory, Data.newVideo("v", 2000, "m"), 22).run();
                                Data.newAddCmd(_inventory, Data.newVideo("w", 2000, "m"), 23).run();
                                Data.newAddCmd(_inventory, Data.newVideo("x", 2000, "m"), 24).run();
                                Data.newAddCmd(_inventory, Data.newVideo("y", 2000, "m"), 25).run();
                                Data.newAddCmd(_inventory, Data.newVideo("z", 2000, "m"), 26).run();
                            });
            }
        }
        _menus[stateNum] = m.toUIMenu("Bob's Video");
    }

    enum AddExit {
        DEFAULT("Default"), YES("Yes"), NO("No");

        private String Prompt;
        AddExit(String Prompt) {
            this.Prompt = Prompt;
        }
        public String getPrompt() {
            return Prompt;
        }
        public void setPrompt(String Prompt) {
            this.Prompt = Prompt;
        }
    }

    private void addEXIT(int stateNum) {
        UIMenuBuilderInterface m = UIFactory.newMenuBuilder();

        for (AddExit toAdd : AddExit.values()) {
            switch (toAdd) {
                case DEFAULT:
                    m.add(toAdd.getPrompt(), () -> {});
                case YES:
                    m.add(toAdd.getPrompt(), () -> _state = EXITED);
                case NO:
                    m.add(toAdd.getPrompt(), () -> _state = START);
            }
        }
        _menus[stateNum] = m.toUIMenu("Are you sure you want to exit?");
    }
}
