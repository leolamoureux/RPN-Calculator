package rpncalculate;

public enum Operation {
    PLUS("+") {
        @Override
        public int eval(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int eval(int x, int y) {
            return x - y;
        }
    },
    MULTIPLIED("*") {
        @Override
        public int eval(int x, int y) {
            return x * y;
        }
    },
    DIVIDED("/") {
        @Override
        public int eval(int x, int y) {
            return x / y;
        }
    };
    
    // Abstract method with two integer params
    protected abstract int eval(int x, int y);
    
    // attribute string symbole
    public String symbole;
    
    // Constructor with param strign symbole
    Operation(String symbole) {
        this.symbole = symbole;
    }
}
