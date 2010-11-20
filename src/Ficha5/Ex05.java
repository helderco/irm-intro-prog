
package Ficha5;

import java.util.ArrayList;

/**
 *
 * @author heldercorreia
 */
public class Ex05 {

    private final int OPEN_HOURS = 16;
    private final int MAX_OCCUPATION = 100;
    private int[] entries;
    private int[] exits;

    public Ex05(int[] entries, int[] exits) {
        if (entries.length != OPEN_HOURS || exits.length != OPEN_HOURS) {
            throw new IllegalArgumentException(
                "Fontes de dados devem representar " + OPEN_HOURS +
                " horas de entradas e saídas."
            );
        }
        this.entries = new int[OPEN_HOURS];
        this.exits   = new int[OPEN_HOURS];
        System.arraycopy(entries, 0, this.entries, 0, entries.length);
        System.arraycopy(exits, 0, this.exits, 0, exits.length);
    }

    public int mostTraffic() {
        int dif;
        int max = -1;
        int maxIdx = -1;

        for (int i = 0; i < OPEN_HOURS; i++) {
            dif = Math.abs(exits[i] - entries[i]);
            if (dif > max) {
                max = dif;
                maxIdx = i;
            }
        }

        return fromIndexToHour(maxIdx);
    }

    private int fromIndexToHour(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        return pos+8;
    }

    public int maximumOccupation() {
        int count = 0;
        int previous = entries[0] - exits[0];
        int current;

        for (int i = 1; i < OPEN_HOURS; i++, previous = current) {
            current = entries[i] - exits[i] + previous;
            if (current == MAX_OCCUPATION) {
                count++;
            }
        }

        return count;
    }
    
    public String strictGrowth() {
        Ex05Growth[] intervals = strictGrowthIntervals();
        StringBuilder output   = new StringBuilder();

        if (intervals.length > 0) {
            output.append(Ex05Growth.header());

            for (int i = 0; i < intervals.length; i++) {
                output.append("\n");
                output.append(intervals[i].toString());
            }
        } else {
            output.append(
                "Não houve alturas em que o parque aumentou estritamente."
            );
        }

        return output.toString();
    }

    /**
     * This is an intermediary method to generate Ex05Growth objects.
     * Useful for testing purposes and decoupling presentation.
     *
     * @see Ficha5.Ex05Test.testGrowthIntervals()
     *
     * @return an array with Ex05Growth objects, each representing an
     *         interval of strict growth.
     */
    Ex05Growth[] strictGrowthIntervals() {
        ArrayList<Ex05Growth> growth = new ArrayList<Ex05Growth>();
        int begin = -1;
        int end   = -1;
        int count = 0;

        for (int i = 0; i < OPEN_HOURS; i++) {
            if (entries[i] > exits[i]) {
                if (begin < 0) {
                    begin = i;
                }
                end = i;
                count += entries[i] - exits[i];
            } else {
                if (!(begin < 0)) {
                    growth.add(
                        new Ex05Growth(
                            fromIndexToHour(begin), fromIndexToHour(end), count
                        )
                    );
                    begin = -1;
                    end   = -1;
                    count = 0;
                }
            }
        }

        Ex05Growth[] result = new Ex05Growth[growth.size()];
        for (int j = 0; j < growth.size(); j++) {
            result[j] = growth.get(j);
        }

        return result;
    }
    
}

/**
 * Helper class to help testing the intervals
 * without depending on string output
 * 
 * @author heldercorreia
 * @see Ficha5.Ex05Test.testGrowthIntervals()
 */
class Ex05Growth {
    private int begin;
    private int end;
    private int count;

    Ex05Growth(int begin, int end, int count) {
        this.begin = begin;
        this.end = end;
        this.count = count;
    }

    static String header() {
        return "Início  Fim     Aumento";
    }

    @Override
    public String toString() {
        return String.format("%02dh     %02dh     %-7d", begin, end, count);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ex05Growth other = (Ex05Growth) obj;
        if (this.begin != other.begin) {
            return false;
        }
        if (this.end != other.end) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.begin;
        hash = 47 * hash + this.end;
        hash = 47 * hash + this.count;
        return hash;
    }

}