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
        if (this.to < range.from || this.from > range.to || this.to == range.from || range.to == this.from) {
            return null;
        }

        double from = Math.max(this.from, range.from);
        double to = Math.min(this.to, range.to);

        return (new Range(from, to));
    }

    public Range[] getMerge(Range range) {
        if (this.from <= range.from && this.to >= range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = this;
            return rangeArray;
        } else if (this.from >= range.from && this.to <= range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = range;
            return rangeArray;
        } else if (this.from <= range.from && this.to <= range.to && this.to >= range.from) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(this.from, range.to);
            return rangeArray;
        } else if (this.from >= range.from && this.to >= range.to && range.to >= this.from) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(range.from, this.to);
            return rangeArray;
        } else if (this.to < range.from) {
            Range[] rangeArray = new Range[2];
            rangeArray[0] = this;
            rangeArray[1] = range;
            return rangeArray;
        } else {
            Range[] rangeArray = new Range[2];
            rangeArray[0] = range;
            rangeArray[1] = this;
            return rangeArray;
        }
    }

    public Range[] getDifference(Range range) {
        if (this.from < range.from && this.to > range.to) {
            Range[] rangeArray = new Range[2];
            rangeArray[0] = new Range(this.from, range.from);
            rangeArray[1] = new Range(range.to, this.to);
            return rangeArray;
        } else if (this.from > range.from && this.to < range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(0.0, 0.0);
            return rangeArray;
        } else if (this.from < range.from && this.to < range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(this.from, range.from);
            return rangeArray;
        } else {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(range.to, this.to);
            return rangeArray;
        }
    }
}
