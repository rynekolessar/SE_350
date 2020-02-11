package person;

class Person implements Unit {
    private String _name;       // Name
    private String _title;      // Title is "BigBoss" or "Manager" or "Worker"
    private double _basePay;    // Hourly or Weekly Pay
    public Person(String name, String title, double basePay) {
        _name = name; _title = title; _basePay = basePay;
    }

    public double ycomp() {
        switch (_title) {
            case "BigBoss":
                return _basePay * 52 + 5000000;
            case "Manager":
                return _basePay * 52;
            case "Worker":
                return _basePay * 52 * 40;
            default:
                throw new IllegalArgumentException();
        }
    }
    public String toString() {
        switch (_title) {
            case "BigBoss":
                return _name.toUpperCase();
            case "Manager":
                return _name;
            case "Worker":
                return _name.toLowerCase();
            default:
                throw new IllegalArgumentException();
        }
    }

}
