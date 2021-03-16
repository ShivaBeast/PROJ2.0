public class Feedback {

        private Integer cijfer1;
        private Integer cijfer2;
        private Integer statistieken;

        public Feedback(Integer cijfer1, Integer cijfer2, Integer statistieken) {
            this.cijfer1 = cijfer1;
            this.cijfer2 = cijfer2;
            this.statistieken = statistieken;

        }

        public Integer getcijfer1() {
            return this.cijfer1;
        }

        public Integer getCijfer2() {
            return this.cijfer2;
        }

        public void vindCijfer1() {
            if (cijfer1 >= 55) {
                System.out.println("U bent geslaagd");
            } else if (cijfer1 < 55) {
                System.out.println("U bent gezakt");
            }
        }
        public void vindCijfer2() {
            if (cijfer2 >= 55) {
                System.out.println("U bent geslaagd");
            } else if (cijfer2 < 55) {
                System.out.println("U bent gezakt");
            }
        }
    }
