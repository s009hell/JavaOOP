package src.ru.academitschool.oop.shelestov.work;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public boolean isInside(double insideNumber) {
        return insideNumber >= from && insideNumber <= to;
    }

    public double calculateLength() {
        return to - from;
    }

    public Range getIntersection(Range range) {
        if (this.to <= range.from || this.from >= range.to) {
            return null;
        }

        double from = Math.max(this.from, range.from);
        double to = Math.min(this.to, range.to);

        return new Range(from, to);
    }

    public Range[] getMerge(Range range) {
        if (this.to < range.from || range.to < this.from) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (this.from < range.from && this.to > range.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (this.from >= range.from && this.to <= range.to) {
            return new Range[0];
        } else if (this.to <= range.from || range.to <= this.from) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (this.from >= range.from && this.to > range.to) {
            return new Range[]{new Range(range.to, this.to)};
        } else {
            return new Range[]{new Range(this.from, range.from)};
        }
    }
}
