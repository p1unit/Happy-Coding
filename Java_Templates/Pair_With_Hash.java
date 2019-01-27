package Java_Templates;

class Pair_With_Hash{
        int a,b;

        public Pair_With_Hash(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public boolean equals (Object O) {
            if (!(O instanceof Pair_With_Hash)) return false;
            if (((Pair_With_Hash) O).a != a) return false;
            if (((Pair_With_Hash) O).b != b) return false;
            return true;
        }


        public int hashCode() {
            return (a << 16) + b;
        }
    }