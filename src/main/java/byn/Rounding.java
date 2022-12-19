package byn;

//Rounding - создан для умножения Byn на double и округления к "потолку" или "полу" полученного результата
public enum Rounding {
        FLOOR {
            double roundFunction(double value) {
                return Math.floor(value);
            }
        },
        ROUND {
            double roundFunction(double value) {
                return Math.round(value);
            }
        },
        CEIL {
            double roundFunction(double value) {
                return Math.ceil(value);
            }
        };
        abstract double roundFunction(double value);

        private static final int[] tenPowD = {
            1, 10, 100, 1000, 10000, 100_000, 1_000_000, 10_000_000, 100_000_000
        };

        public int getNumberFromEnum(double value, int d) {
            int tenPow = tenPowD[d];
            return (int)roundFunction(value / tenPow) * tenPow;
        }
}