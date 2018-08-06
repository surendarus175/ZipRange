package com.suren;
/**
 * @author surendar
 *
 * To find out the Zip Ranges to
 */

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ZipRange {

    private static List<Range> zipRangeList = new ArrayList<Range>();

    public static void main(String[] args) {

        Range range1 = new Range(94133, 94133);
        Range range2 = new Range(94200, 94299);
        Range range3 = new Range(94600, 94699);

        ZipRange.addZipRange(range1);
        ZipRange.addZipRange(range2);
        ZipRange.addZipRange(range3);

        showRange();
    }

    public static void addZipRange(Range toAddZipRange) {

        if (zipRangeList.size() == 0)
            zipRangeList.add(toAddZipRange);

        else {
            //Add new Zip Range, if the range overlaps with existing range, merge them
            ListIterator<Range> rangeListIterator = zipRangeList.listIterator();
            boolean addRange = true;

            while (rangeListIterator.hasNext()) {
                Range range = rangeListIterator.next();
                if (range.getLowerZipCode() > range.getLowerZipCode() || range.getUpperZipCode() < range.getUpperZipCode()) {
                    if (range.getLowerZipCode() > range.getUpperZipCode() || range.getUpperZipCode() < range.getLowerZipCode())
                        addRange = true;

                    //Zip Range overlaps, removes existing one and update toAddZipRange
                    else {
                        if (range.getLowerZipCode() < range.getLowerZipCode())
                            range.setLowerZipCode(range.getLowerZipCode());
                        if (range.getUpperZipCode() > range.getUpperZipCode())
                            range.setUpperZipCode(range.getUpperZipCode());
                        rangeListIterator.remove();
                        addRange = true;
                    }
                } else
                    addRange = false;
            }
            if (addRange)
                zipRangeList.add(toAddZipRange);
        }
    }

    public static void showRange() {
        if (zipRangeList.size() > 0)
            zipRangeList.stream().map(Range::toString).forEach(System.out::print);
    }

    public static int size() {
        return zipRangeList.size();
    }

    public static List<Range> getZipRanges() {
        return zipRangeList;
    }

    public static void clear() {
        zipRangeList.clear();
    }

}
