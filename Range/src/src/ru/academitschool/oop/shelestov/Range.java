package src.ru.academitschool.oop.shelestov;

class Range {
    private double from;
    private double to;

    Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    Range() {
    }

    void setFrom(double from) {
        this.from = from;
    }

    double getFrom() {
        return from;
    }

    void setTo(double to) {
        this.to = to;
    }

    double getTo() {
        return to;
    }

    boolean isInside(double insideNumber) {
        return insideNumber >= from && insideNumber <= to;
    }

    double calculateLength() {
        return to - from + 1;
    }

    Range getIntersection (Range range) {
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

    Range[] getMerge(Range range) {
        Range[] rangeArray = new Range[2];

        if ((this.from < range.from || this.from == range.from) && this.to > range.to) {
            rangeArray[0] = this;
            rangeArray[1] = null;
            return rangeArray;
        } else if ((this.from > range.from || this.from == range.from) && this.to < range.to) {
            rangeArray[0] = range;
            rangeArray[1] = null;
            return rangeArray;
        } else if ((this.from < range.from && this.to < range.to && this.to > range.from) || (this.to == range.from - 1)) {
            Range newRange = new Range(this.from, range.to);
            rangeArray[0] = newRange;
            rangeArray[1] = null;
            return rangeArray;
        } else if ((this.from > range.from && this.to > range.to && range.to > this.from) || (range.to == this.from - 1)) {
            Range newRange = new Range(range.from, this.to);
            rangeArray[0] = newRange;
            rangeArray[1] = null;
            return rangeArray;
        } else if (this.to < range.from) {
            rangeArray[0] = this;
            rangeArray[1] = range;
            return rangeArray;
        } else {
            rangeArray[0] = range;
            rangeArray[1] = this;
            return rangeArray;
        }
    }

    Range[] getDifference(Range range) {
        Range[] rangeArray = new Range[2];

        if (this.from < range.from && this.to > range.to) {
            rangeArray[0] = new Range(this.from, range.from - 1);
            rangeArray[1] = new Range(range.to + 1, this.to);
            return rangeArray;
        } else if (this.from > range.from && this.to < range.to) {
            rangeArray[0] = new Range(0.0, 0.0);
            rangeArray[1] = null;
            return rangeArray;
        } else if (this.from < range.from && this.to < range.to) {
            rangeArray[0] = new Range(this.from, range.from - 1);
            rangeArray[1] = null;
            return rangeArray;
        } else {
            rangeArray[0] = new Range(range.to + 1, this.to);
            rangeArray[1] = null;
            return rangeArray;
        }
    }
}
