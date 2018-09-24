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
        double from;
        double to;

        if (this.to < range.from || this.from > range.to) {
            return null;
        }

        if (this.from > range.from) {
            from = this.from;
        } else {
            from = range.from;
        }

        if (this.to < range.to) {
            to = this.to;
        } else {
            to = range.to;
        }

        return (new Range(from, to));
    }

    public Range[] getMerge(Range range) {
        if ((this.from < range.from || this.from == range.from) && this.to > range.to) {
            Range[] rangeArray = new Range[2];
            rangeArray[0] = this;
            rangeArray[1] = null;
            return rangeArray;
        } else if ((this.from > range.from || this.from == range.from) && this.to < range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = range;
            return rangeArray;
        } else if ((this.from < range.from && this.to < range.to && this.to > range.from) || (this.to == range.from - 1)) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(this.from, range.to);
            return rangeArray;
        } else if ((this.from > range.from && this.to > range.to && range.to > this.from) || (range.to == this.from - 1)) {
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
            rangeArray[0] = new Range(this.from, range.from - 1);
            rangeArray[1] = new Range(range.to + 1, this.to);
            return rangeArray;
        } else if (this.from > range.from && this.to < range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(0.0, 0.0);
            return rangeArray;
        } else if (this.from < range.from && this.to < range.to) {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(this.from, range.from - 1);
            return rangeArray;
        } else {
            Range[] rangeArray = new Range[1];
            rangeArray[0] = new Range(range.to + 1, this.to);
            return rangeArray;
        }
    }
}
